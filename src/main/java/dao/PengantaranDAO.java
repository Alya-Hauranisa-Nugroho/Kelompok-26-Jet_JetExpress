package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Pengantaran;

public class PengantaranDAO extends BaseDAO<Pengantaran> {

    private static final String SQL_DAFTAR = """
        SELECT
            a.id_pengantaran, pg.no_resi, u.nama AS nama_kurir,
            a.waktu_penugasan, a.status_pengantaran,
            a.latitude_tujuan, a.longitude_tujuan,
            a.bukti_foto, a.catatan_kurir
        FROM pengantaran a
        JOIN kurir k ON a.id_user = k.id_user
        JOIN user u ON k.id_user = u.id_user
        JOIN pengiriman pg ON a.id_pengiriman = pg.id_pengiriman
        """;

    @Override
    public String namaTabel() {
        return "pengantaran";
    }

    @Override
    protected Pengantaran petakanBaris(ResultSet rs) throws SQLException {
        Pengantaran antar = new Pengantaran();
        antar.setIdPengantaran(rs.getInt("id_pengantaran"));
        antar.setLongitudeTujuan(rs.getBigDecimal("longitude_tujuan"));
        antar.setLatitudeTujuan(rs.getBigDecimal("latitude_tujuan"));
        Date tgl = rs.getDate("waktu_penugasan");
        antar.setWaktuPenugasan(tgl == null ? null : tgl.toLocalDate());
        antar.setStatusPengantaran(rs.getString("status_pengantaran"));
        antar.setBuktiFoto(rs.getString("bukti_foto"));
        antar.setCatatanKurir(rs.getString("catatan_kurir"));
        antar.setIdUser(rs.getInt("id_user"));
        antar.setIdPengiriman(rs.getInt("id_pengiriman"));
        antar.setNoResi(kolomString(rs, "no_resi"));
        antar.setNamaKurir(kolomString(rs, "nama_kurir"));
        antar.setNamaPenerima(kolomString(rs, "nama_penerima"));
        antar.setAlamatPenerima(kolomString(rs, "alamat_penerima"));
        antar.setNoTelpPenerima(kolomString(rs, "no_telp_penerima"));
        return antar;
    }

    @Override
    public List<Pengantaran> ambilSemua() throws SQLException {
        return daftarHasil(SQL_DAFTAR
                + " ORDER BY a.id_pengantaran DESC");
    }

    public List<Object[]> getSemuaPengantaran() throws SQLException {
        return ambilBaris(SQL_DAFTAR + " ORDER BY a.id_pengantaran DESC");
    }

    public List<Object[]> cariPengantaran(String keyword)
            throws SQLException {
        String cari = "%" + keyword.trim() + "%";
        String sql = SQL_DAFTAR
                + " WHERE pg.no_resi LIKE ? OR u.nama LIKE ? "
                + "OR a.status_pengantaran LIKE ? "
                + "ORDER BY a.id_pengantaran DESC";
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 3; i++) {
                ps.setString(i, cari);
            }
            try (ResultSet rs = ps.executeQuery()) {
                return bacaBaris(rs);
            }
        }
    }

    public List<Object[]> getDaftarKurir() throws SQLException {
        String sql = """
            SELECT u.id_user, u.nama, k.nomor_kendaraan
            FROM kurir k
            JOIN user u ON u.id_user = k.id_user
            WHERE u.role = 'Kurir'
            ORDER BY u.nama
            """;
        List<Object[]> baris = new ArrayList<>();
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                baris.add(new Object[]{
                    rs.getInt("id_user"),
                    rs.getString("nama"),
                    rs.getString("nomor_kendaraan")
                });
            }
        }
        return baris;
    }

    public List<Object[]> getPengirimanTersedia() throws SQLException {
        return new PengirimanDAO().getPengirimanTersedia();
    }

    public Optional<Pengantaran> ambilById(int idPengantaran)
            throws SQLException {
        String sql = """
            SELECT a.*, pg.no_resi, pk.nama_penerima,
                   pk.alamat_penerima, pk.no_telp_penerima
            FROM pengantaran a
            JOIN pengiriman pg ON a.id_pengiriman = pg.id_pengiriman
            JOIN paket pk ON pk.id_paket = pg.id_paket
            WHERE a.id_pengantaran = ?
            """;
        return satuHasil(sql, idPengantaran);
    }

    public boolean tambahPengantaran(int idPengiriman, int idKurir,
            java.time.LocalDate tanggal, BigDecimal latitude,
            BigDecimal longitude, String status, String bukti,
            String catatan) throws SQLException {

        validasiKoordinat(latitude, longitude);
        validasiStatus(status, bukti);

        jalankanTransaksi(conn -> {
            String statusPengiriman = ambilStatusPengiriman(conn,
                    idPengiriman);
            if (!"Diterima Konter".equals(statusPengiriman)
                    && !"Gagal".equals(statusPengiriman)) {
                throw new SQLException(
                        "Pengiriman belum siap untuk ditugaskan "
                        + "(status saat ini: " + statusPengiriman + ").");
            }

            int penugasanAktif = hitungAktif(conn, idPengiriman);
            if (penugasanAktif > 0) {
                throw new SQLException(
                        "Pengiriman sudah memiliki penugasan aktif "
                        + "atau sudah berhasil.");
            }

            String sql = """
                INSERT INTO pengantaran (longitude_tujuan,
                    latitude_tujuan, waktu_penugasan,
                    status_pengantaran, bukti_foto, catatan_kurir,
                    id_user, id_pengiriman)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setBigDecimal(1, longitude);
                ps.setBigDecimal(2, latitude);
                ps.setDate(3, Date.valueOf(tanggal));
                ps.setString(4, status);
                ps.setString(5,
                        bukti == null || bukti.isBlank() ? null : bukti);
                ps.setString(6,
                        catatan == null || catatan.isBlank()
                        ? null : catatan);
                ps.setInt(7, idKurir);
                ps.setInt(8, idPengiriman);
                ps.executeUpdate();
            }

            sinkronkanStatusPengiriman(conn, idPengiriman, status);
            sisipRiwayat(conn, idPengiriman,
                    Pengantaran.STATUS_DITUGASKAN.equals(status)
                    ? "Paket dibawa kurir menuju alamat penerima"
                    : "Pengantaran ditambahkan: " + status);
        });
        return true;
    }

    public boolean ubahPengantaran(int idPengantaran, int idKurir,
            java.time.LocalDate tanggal, BigDecimal latitude,
            BigDecimal longitude, String status, String bukti,
            String catatan) throws SQLException {

        validasiKoordinat(latitude, longitude);
        validasiStatus(status, bukti);

        jalankanTransaksi(conn -> {
            long idPengiriman = ambilIdPengiriman(conn, idPengantaran);

            String sql = """
                UPDATE pengantaran SET
                    longitude_tujuan = ?, latitude_tujuan = ?,
                    waktu_penugasan = ?, status_pengantaran = ?,
                    bukti_foto = ?, catatan_kurir = ?, id_user = ?
                WHERE id_pengantaran = ?
                """;
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setBigDecimal(1, longitude);
                ps.setBigDecimal(2, latitude);
                ps.setDate(3, Date.valueOf(tanggal));
                ps.setString(4, status);
                ps.setString(5,
                        bukti == null || bukti.isBlank() ? null : bukti);
                ps.setString(6,
                        catatan == null || catatan.isBlank()
                        ? null : catatan);
                ps.setInt(7, idKurir);
                ps.setInt(8, idPengantaran);
                if (ps.executeUpdate() == 0) {
                    throw new SQLException(
                            "Data pengantaran tidak ditemukan.");
                }
            }

            sinkronkanStatusPengiriman(conn, idPengiriman, status);
            sisipRiwayat(conn, idPengiriman,
                    "Pengantaran diperbarui: " + status);
        });
        return true;
    }

    public boolean ubahStatus(int idPengantaran, String status,
            String bukti, String catatan) throws SQLException {
        validasiStatus(status, bukti);
        jalankanTransaksi(conn -> {
            long idPengiriman = ambilIdPengiriman(conn, idPengantaran);
            int jumlah;
            try (PreparedStatement ps = conn.prepareStatement(
                    "UPDATE pengantaran SET status_pengantaran = ?, "
                    + "bukti_foto = ?, catatan_kurir = ? "
                    + "WHERE id_pengantaran = ?")) {
                ps.setString(1, status);
                ps.setString(2,
                        bukti == null || bukti.isBlank() ? null : bukti);
                ps.setString(3,
                        catatan == null || catatan.isBlank()
                        ? null : catatan);
                ps.setInt(4, idPengantaran);
                jumlah = ps.executeUpdate();
            }
            if (jumlah == 0) {
                throw new SQLException("Tugas tidak ditemukan.");
            }
            sinkronkanStatusPengiriman(conn, idPengiriman, status);
            sisipRiwayat(conn, idPengiriman,
                    "Status pengantaran: " + status);
        });
        return true;
    }

    public boolean hapusPengantaran(int idPengantaran) throws SQLException {
        int jumlah = perintah(
                "DELETE FROM pengantaran WHERE id_pengantaran = ?",
                idPengantaran);
        return jumlah > 0;
    }

    private void validasiKoordinat(BigDecimal latitude,
            BigDecimal longitude) {
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException(
                    "Lokasi tujuan harus dipilih melalui peta.");
        }
        if (latitude.compareTo(new BigDecimal("-90")) < 0
                || latitude.compareTo(new BigDecimal("90")) > 0) {
            throw new IllegalArgumentException(
                    "Latitude harus berada antara -90 sampai 90.");
        }
        if (longitude.compareTo(new BigDecimal("-180")) < 0
                || longitude.compareTo(new BigDecimal("180")) > 0) {
            throw new IllegalArgumentException(
                    "Longitude harus berada antara -180 sampai 180.");
        }
    }

    private void validasiStatus(String status, String bukti) {
        if (!List.of(Pengantaran.STATUS_DITUGASKAN,
                Pengantaran.STATUS_DALAM_PERJALANAN,
                Pengantaran.STATUS_BERHASIL,
                Pengantaran.STATUS_GAGAL).contains(status)) {
            throw new IllegalArgumentException(
                    "Status pengantaran tidak valid.");
        }
        if (Pengantaran.STATUS_GAGAL.equals(status)
                && (bukti == null || bukti.isBlank())) {
            throw new IllegalArgumentException(
                    "Bukti foto wajib diisi jika pengantaran gagal.");
        }
    }

    private List<Object[]> ambilBaris(String sql) throws SQLException {
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return bacaBaris(rs);
        }
    }

    private List<Object[]> bacaBaris(ResultSet rs) throws SQLException {
        List<Object[]> baris = new ArrayList<>();
        while (rs.next()) {
            baris.add(new Object[]{
                rs.getInt("id_pengantaran"),
                rs.getString("no_resi"),
                rs.getString("nama_kurir"),
                rs.getDate("waktu_penugasan"),
                rs.getString("status_pengantaran"),
                rs.getBigDecimal("latitude_tujuan"),
                rs.getBigDecimal("longitude_tujuan"),
                rs.getString("bukti_foto"),
                rs.getString("catatan_kurir")
            });
        }
        return baris;
    }

    private String ambilStatusPengiriman(Connection conn,
            int idPengiriman) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT status_pengiriman FROM pengiriman "
                + "WHERE id_pengiriman = ? FOR UPDATE")) {
            ps.setInt(1, idPengiriman);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                }
            }
        }
        throw new SQLException("Data pengiriman tidak ditemukan.");
    }

    private int hitungAktif(Connection conn, int idPengiriman)
            throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT COUNT(*) FROM pengantaran "
                + "WHERE id_pengiriman = ? AND status_pengantaran IN "
                + "('Ditugaskan', 'Dalam Perjalanan', 'Berhasil')")) {
            ps.setInt(1, idPengiriman);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    private long ambilIdPengiriman(Connection conn, int idPengantaran)
            throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT id_pengiriman FROM pengantaran "
                + "WHERE id_pengantaran = ?")) {
            ps.setInt(1, idPengantaran);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        throw new SQLException("Data pengantaran tidak ditemukan.");
    }

    private void aturStatusPengiriman(Connection conn,
            long idPengiriman, String status) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE pengiriman SET status_pengiriman = ? "
                + "WHERE id_pengiriman = ?")) {
            ps.setString(1, status);
            ps.setLong(2, idPengiriman);
            ps.executeUpdate();
        }
    }

    private void sinkronkanStatusPengiriman(Connection conn,
            long idPengiriman, String statusAntar) throws SQLException {
        String statusKirim;
        switch (statusAntar) {
            case Pengantaran.STATUS_BERHASIL -> statusKirim = "Terkirim";
            case Pengantaran.STATUS_GAGAL -> statusKirim = "Gagal";
            default -> statusKirim = "Dalam Pengiriman";
        }
        aturStatusPengiriman(conn, idPengiriman, statusKirim);
    }

    private void sisipRiwayat(Connection conn, long idPengiriman,
            String deskripsi) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO riwayat_pelacakan (deskripsi, waktu_riwayat, "
                + "id_pengiriman) VALUES (?, NOW(), ?)")) {
            ps.setString(1, deskripsi);
            ps.setLong(2, idPengiriman);
            ps.executeUpdate();
        }
    }

    private String kolomString(ResultSet rs, String kolom) {
        try {
            return rs.getString(kolom);
        } catch (SQLException e) {
            return null;
        }
    }
}
