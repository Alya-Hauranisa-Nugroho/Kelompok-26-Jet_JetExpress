package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.User;

public class UserDAO extends BaseDAO<User> {

    @Override
    public String namaTabel() {
        return "user";
    }

    @Override
    protected User petakanBaris(ResultSet rs) throws SQLException {
        User user = new User();
        user.setIdUser(rs.getInt("id_user"));
        user.setNama(rs.getString("nama"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setNoHp(rs.getString("no_hp"));
        user.setGaji(rs.getInt("gaji"));
        Date tgl = rs.getDate("tanggal_masuk");
        user.setTanggalMasuk(tgl == null ? null : tgl.toLocalDate());
        user.setRole(rs.getString("role"));
        user.setIdKonter(rs.getInt("id_konter"));
        return user;
    }

    @Override
    public List<User> ambilSemua() throws SQLException {
        return daftarHasil(
                "SELECT * FROM user ORDER BY id_user ASC");
    }

    public Optional<User> ambilById(int idUser) throws SQLException {
        String sql = """
            SELECT
                u.id_user, u.nama, u.email, u.password, u.no_hp,
                u.gaji, u.tanggal_masuk, u.role, u.id_konter,
                kon.nama_konter,
                COALESCE(pk.shift_kerja, '')    AS shift_kerja,
                COALESCE(k.nomor_kendaraan, '') AS nomor_kendaraan
            FROM user u
            LEFT JOIN konter kon ON u.id_konter = kon.id_konter
            LEFT JOIN petugas_konter pk ON u.id_user = pk.id_user
            LEFT JOIN kurir k ON u.id_user = k.id_user
            WHERE u.id_user = ?
            """;
        try (java.sql.Connection conn = bukaKoneksi();
             java.sql.PreparedStatement ps =
                     conn.prepareStatement(sql)) {
            ps.setInt(1, idUser);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(petakanBarisLengkap(rs));
                }
            }
        }
        return Optional.empty();
    }

    private User petakanBarisLengkap(ResultSet rs) throws SQLException {
        User user = petakanBaris(rs);
        user.setNamaKonter(rs.getString("nama_konter"));
        user.setShiftKerja(rs.getString("shift_kerja"));
        user.setNomorKendaraan(rs.getString("nomor_kendaraan"));
        return user;
    }

    public Optional<User> login(String email, String password)
            throws SQLException {
        return satuHasil(
                "SELECT id_user, nama, email, password, no_hp, gaji, "
                + "tanggal_masuk, role, id_konter "
                + "FROM user WHERE email = ? AND password = ? LIMIT 1",
                email, password);
    }

    public boolean emailTerdaftar(String email, int kecualiIdUser)
            throws SQLException {
        int jumlah = skalarInt(
                "SELECT COUNT(*) FROM user "
                + "WHERE email = ? AND id_user <> ?",
                email, kecualiIdUser);
        return jumlah > 0;
    }

    public List<Object[]> getSemuaUser(int idKonter) throws SQLException {
        String sql = """
            SELECT
                u.id_user,
                u.nama,
                u.email,
                u.no_hp,
                u.role,
                COALESCE(pk.shift_kerja, k.nomor_kendaraan, '-') AS keterangan,
                kon.nama_konter,
                u.gaji,
                u.tanggal_masuk
            FROM user u
            LEFT JOIN petugas_konter pk ON u.id_user = pk.id_user
            LEFT JOIN kurir k ON u.id_user = k.id_user
            LEFT JOIN konter kon ON u.id_konter = kon.id_konter
            WHERE u.role IN ('Petugas Konter', 'Kurir')
              AND u.id_konter = ?
            ORDER BY u.role, u.nama
            """;

        List<Object[]> baris = new ArrayList<>();
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idKonter);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    baris.add(new Object[]{
                        rs.getInt("id_user"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("no_hp"),
                        rs.getString("role"),
                        rs.getString("keterangan"),
                        rs.getString("nama_konter"),
                        rs.getInt("gaji"),
                        rs.getDate("tanggal_masuk")
                    });
                }
            }
        }
        return baris;
    }

    public List<Object[]> getDaftarKonter() throws SQLException {
        String sql = "SELECT id_konter, nama_konter FROM konter "
                + "ORDER BY id_konter ASC";
        List<Object[]> baris = new ArrayList<>();
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                baris.add(new Object[]{
                    rs.getInt("id_konter"),
                    rs.getString("nama_konter")
                });
            }
        }
        return baris;
    }

    public boolean tambahUser(User user, String shift, String kendaraan,
            String jobdesk) throws SQLException {

        String sqlUser = """
            INSERT INTO user (nama, email, password, no_hp, gaji,
                              tanggal_masuk, role, id_konter)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        jalankanTransaksi(conn -> {
            long idUser;
            try (PreparedStatement ps =
                    conn.prepareStatement(sqlUser,
                            PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getNama());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getNoHp());
                ps.setInt(5, user.getGaji());
                ps.setDate(6, Date.valueOf(user.getTanggalMasuk()));
                ps.setString(7, user.getRole());
                ps.setInt(8, user.getIdKonter());
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) {
                        throw new SQLException(
                                "Gagal mengambil ID user baru.");
                    }
                    idUser = rs.getLong(1);
                }
            }
            sisipPeran(conn, idUser, user.getRole(), shift, kendaraan,
                    jobdesk);
        });
        return true;
    }

    public boolean ubahUser(int idUser, User user, String passwordBaru,
            String shift, String kendaraan, String jobdesk)
            throws SQLException {

        String sqlDenganPassword = """
            UPDATE user SET nama = ?, email = ?, password = ?, no_hp = ?,
                            gaji = ?, tanggal_masuk = ?, role = ?, id_konter = ?
            WHERE id_user = ?
            """;
        String sqlTanpaPassword = """
            UPDATE user SET nama = ?, email = ?, no_hp = ?, gaji = ?,
                            tanggal_masuk = ?, role = ?, id_konter = ?
            WHERE id_user = ?
            """;

        jalankanTransaksi(conn -> {
            if (passwordBaru != null && !passwordBaru.isBlank()) {
                try (PreparedStatement ps =
                        conn.prepareStatement(sqlDenganPassword)) {
                    ps.setString(1, user.getNama());
                    ps.setString(2, user.getEmail());
                    ps.setString(3, passwordBaru);
                    ps.setString(4, user.getNoHp());
                    ps.setInt(5, user.getGaji());
                    ps.setDate(6, Date.valueOf(user.getTanggalMasuk()));
                    ps.setString(7, user.getRole());
                    ps.setInt(8, user.getIdKonter());
                    ps.setInt(9, idUser);
                    if (ps.executeUpdate() == 0) {
                        throw new SQLException("User tidak ditemukan.");
                    }
                }
            } else {
                try (PreparedStatement ps =
                        conn.prepareStatement(sqlTanpaPassword)) {
                    ps.setString(1, user.getNama());
                    ps.setString(2, user.getEmail());
                    ps.setString(3, user.getNoHp());
                    ps.setInt(4, user.getGaji());
                    ps.setDate(5, Date.valueOf(user.getTanggalMasuk()));
                    ps.setString(6, user.getRole());
                    ps.setInt(7, user.getIdKonter());
                    ps.setInt(8, idUser);
                    if (ps.executeUpdate() == 0) {
                        throw new SQLException("User tidak ditemukan.");
                    }
                }
            }

            hapusPeran(conn, idUser);
            sisipPeran(conn, idUser, user.getRole(), shift, kendaraan,
                    jobdesk);
        });
        return true;
    }


    public boolean hapusUser(int idUser) throws SQLException {
        final int jumlahPengantaran = skalarInt(
                "SELECT COUNT(*) FROM pengantaran WHERE id_user = ?",
                idUser);
        if (jumlahPengantaran > 0) {
            throw new SQLException(
                    "User ini memiliki riwayat pengantaran "
                    + "dan tidak dapat dihapus!");
        }
        jalankanTransaksi(conn -> {
            hapusPeran(conn, idUser);
            try (PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM user WHERE id_user = ?")) {
                ps.setInt(1, idUser);
                if (ps.executeUpdate() == 0) {
                    throw new SQLException("User tidak ditemukan.");
                }
            }
        });
        return true;
    }

    private void hapusPeran(Connection conn, int idUser)
            throws SQLException {
        String[] tabel = {"admin", "petugas_konter", "kurir"};
        for (String t : tabel) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM " + t + " WHERE id_user = ?")) {
                ps.setInt(1, idUser);
                ps.executeUpdate();
            }
        }
    }

    private void sisipPeran(Connection conn, long idUser, String role,
            String shift, String kendaraan, String jobdesk)
            throws SQLException {

        switch (role == null ? "" : role) {
            case "Admin" -> {
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO admin (id_user, jobdesk) VALUES (?, ?)")) {
                    ps.setLong(1, idUser);
                    ps.setString(2,
                            jobdesk == null || jobdesk.isBlank()
                            ? "Administrasi" : jobdesk);
                    ps.executeUpdate();
                }
            }
            case "Petugas Konter" -> {
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO petugas_konter (id_user, shift_kerja) "
                        + "VALUES (?, ?)")) {
                    ps.setLong(1, idUser);
                    ps.setString(2, shift == null ? "Pagi" : shift);
                    ps.executeUpdate();
                }
            }
            case "Kurir" -> {
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO kurir (id_user, nomor_kendaraan) "
                        + "VALUES (?, ?)")) {
                    ps.setLong(1, idUser);
                    ps.setString(2, kendaraan == null ? "-" : kendaraan);
                    ps.executeUpdate();
                }
            }
            default -> throw new SQLException(
                    "Role pengguna tidak dikenal: " + role);
        }
    }
}
