package dao;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Paket;
import model.Pengiriman;

public class PengirimanDAO extends BaseDAO<Pengiriman> {

    private static final String ABJAD_RESI = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private static final SecureRandom ACAK = new SecureRandom();

    private static final String SQL_DAFTAR = """
        SELECT
            p.id_pengiriman, p.no_resi, pk.nama_barang, pk.berat,
            pk.nama_pengirim, pk.nama_penerima,
            p.jenis_pengiriman, k.nama_konter,
            p.total_biaya, p.metode_bayar, p.cod,
            p.batas_kirim, p.status_pengiriman,
            p.id_konter, p.id_paket, p.id_ongkir
        FROM pengiriman p
        JOIN paket pk ON p.id_paket = pk.id_paket
        JOIN konter k ON p.id_konter = k.id_konter
        """;

    @Override
    public String namaTabel() {
        return "pengiriman";
    }

    @Override
    protected Pengiriman petakanBaris(ResultSet rs) throws SQLException {
        Pengiriman kirim = new Pengiriman();
        kirim.setIdPengiriman(rs.getInt("id_pengiriman"));
        kirim.setNoResi(rs.getString("no_resi"));
        kirim.setJenisPengiriman(rs.getString("jenis_pengiriman"));
        kirim.setTotalBiaya(rs.getInt("total_biaya"));
        kirim.setMetodeBayar(rs.getString("metode_bayar"));
        kirim.setCod(rs.getInt("cod"));
        Date batas = rs.getDate("batas_kirim");
        kirim.setBatasKirim(batas == null ? null : batas.toLocalDate());
        kirim.setStatusPengiriman(rs.getString("status_pengiriman"));
        kirim.setIdKonter(rs.getInt("id_konter"));
        kirim.setIdPaket(rs.getInt("id_paket"));
        kirim.setIdOngkir(rs.getInt("id_ongkir"));
        kirim.setNamaBarang(kolomString(rs, "nama_barang"));
        kirim.setBerat(kolomBigDecimal(rs, "berat"));
        kirim.setJenisBarang(kolomString(rs, "jenis_barang"));
        kirim.setNamaPengirim(kolomString(rs, "nama_pengirim"));
        kirim.setNoTelpPengirim(kolomString(rs, "no_telp_pengirim"));
        kirim.setAlamatPengirim(kolomString(rs, "alamat_pengirim"));
        kirim.setNamaPenerima(kolomString(rs, "nama_penerima"));
        kirim.setNoTelpPenerima(kolomString(rs, "no_telp_penerima"));
        kirim.setAlamatPenerima(kolomString(rs, "alamat_penerima"));
        kirim.setNamaKonter(kolomString(rs, "nama_konter"));
        return kirim;
    }

    @Override
    public List<Pengiriman> ambilSemua() throws SQLException {
        return daftarHasil(SQL_DAFTAR
                + " ORDER BY p.id_pengiriman DESC");
    }

    public List<Object[]> getSemuaPengiriman() throws SQLException {
        return ambilBaris(SQL_DAFTAR + " ORDER BY p.id_pengiriman DESC");
    }

    public List<Object[]> cariPengiriman(String keyword)
            throws SQLException {
        String cari = "%" + keyword.trim() + "%";
        String sql = SQL_DAFTAR
                + " WHERE p.no_resi LIKE ? OR pk.nama_barang LIKE ? "
                + "OR pk.nama_pengirim LIKE ? OR pk.nama_penerima LIKE ? "
                + "ORDER BY p.id_pengiriman DESC";
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 4; i++) {
                ps.setString(i, cari);
            }
            try (ResultSet rs = ps.executeQuery()) {
                return bacaBaris(rs);
            }
        }
    }

    public List<Object[]> getPengirimanRingkas() throws SQLException {
        String sql = """
            SELECT p.id_pengiriman, p.no_resi, p.status_pengiriman,
                   pk.nama_penerima
            FROM pengiriman p
            JOIN paket pk ON p.id_paket = pk.id_paket
            ORDER BY p.id_pengiriman DESC
            """;
        List<Object[]> baris = new ArrayList<>();
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                baris.add(new Object[]{
                    rs.getInt("id_pengiriman"),
                    rs.getString("no_resi"),
                    rs.getString("status_pengiriman"),
                    rs.getString("nama_penerima")
                });
            }
        }
        return baris;
    }

    public List<Object[]> getPengirimanTersedia() throws SQLException {
        String sql = """
            SELECT p.id_pengiriman, p.no_resi,
                   pk.nama_penerima, pk.alamat_penerima
            FROM pengiriman p
            JOIN paket pk ON pk.id_paket = p.id_paket
            WHERE p.status_pengiriman IN ('Diterima Konter', 'Gagal')
              AND NOT EXISTS (
                  SELECT 1 FROM pengantaran a
                  WHERE a.id_pengiriman = p.id_pengiriman
                    AND a.status_pengantaran IN
                        ('Ditugaskan', 'Dalam Perjalanan', 'Berhasil'))
            ORDER BY p.id_pengiriman DESC
            """;
        List<Object[]> baris = new ArrayList<>();
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                baris.add(new Object[]{
                    rs.getInt("id_pengiriman"),
                    rs.getString("no_resi"),
                    rs.getString("nama_penerima"),
                    rs.getString("alamat_penerima")
                });
            }
        }
        return baris;
    }

    public Optional<Pengiriman> ambilByResi(String noResi)
            throws SQLException {
        return satuHasil(SQL_DAFTAR + " WHERE p.no_resi = ?", noResi);
    }

    public boolean resiTerdaftar(String noResi) throws SQLException {
        return skalarInt(
                "SELECT COUNT(*) FROM pengiriman WHERE no_resi = ?",
                noResi) > 0;
    }

    public String tambahPengiriman(Pengiriman kirim, Paket paket)
            throws SQLException {

        final String[] resiHasil = new String[1];

        jalankanTransaksi(conn -> {
            try (var st = conn.createStatement()) {
                st.execute("SET FOREIGN_KEY_CHECKS=0");
            }

            long idPaket = new PaketDAO().sisip(conn, paket, 0L);

            String resi = buatNomorResi(conn);
            String sql = """
                INSERT INTO pengiriman (no_resi, jenis_pengiriman,
                    total_biaya, metode_bayar, cod, batas_kirim,
                    status_pengiriman, id_konter, id_paket, id_ongkir)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
            long idPengiriman;
            try (PreparedStatement ps = conn.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, resi);
                ps.setString(2, kirim.getJenisPengiriman());
                ps.setInt(3, kirim.getTotalBiaya());
                ps.setString(4, kirim.getMetodeBayar());
                ps.setInt(5, kirim.getCod());
                ps.setDate(6, Date.valueOf(kirim.getBatasKirim()));
                ps.setString(7, kirim.getStatusPengiriman());
                ps.setInt(8, kirim.getIdKonter());
                ps.setLong(9, idPaket);
                ps.setInt(10, kirim.getIdOngkir());
                ps.executeUpdate();
                try (ResultSet kunci = ps.getGeneratedKeys()) {
                    if (!kunci.next()) {
                        throw new SQLException(
                                "Gagal mengambil ID pengiriman baru.");
                    }
                    idPengiriman = kunci.getLong(1);
                }
            }

            new PaketDAO().hubungkanKePengiriman(conn, idPaket,
                    idPengiriman);

            sisipRiwayat(conn, idPengiriman,
                    "Paket diterima di konter");

            try (var st = conn.createStatement()) {
                st.execute("SET FOREIGN_KEY_CHECKS=1");
            }
            resiHasil[0] = resi;
        });

        return resiHasil[0];
    }

    public boolean ubahPengiriman(String noResi, Pengiriman kirim,
            Paket paket, String idOngkir) throws SQLException {

        jalankanTransaksi(conn -> {
            String sqlPaket = """
                UPDATE paket SET
                    nama_barang = ?, berat = ?, jenis_barang = ?,
                    nama_pengirim = ?, no_telp_pengirim = ?,
                    alamat_pengirim = ?, nama_penerima = ?,
                    no_telp_penerima = ?, alamat_penerima = ?
                WHERE id_paket = (
                    SELECT id_paket FROM pengiriman WHERE no_resi = ?)
                """;
            try (PreparedStatement ps =
                    conn.prepareStatement(sqlPaket)) {
                ps.setString(1, paket.getNamaBarang());
                ps.setBigDecimal(2, paket.getBerat());
                ps.setString(3, paket.getJenisBarang());
                ps.setString(4, paket.getNamaPengirim());
                ps.setString(5, paket.getNoTelpPengirim());
                ps.setString(6, paket.getAlamatPengirim());
                ps.setString(7, paket.getNamaPenerima());
                ps.setString(8, paket.getNoTelpPenerima());
                ps.setString(9, paket.getAlamatPenerima());
                ps.setString(10, noResi);
                ps.executeUpdate();
            }

            String sqlKirim;
            if (idOngkir == null || idOngkir.isBlank()) {
                sqlKirim = """
                    UPDATE pengiriman SET
                        jenis_pengiriman = ?, total_biaya = ?,
                        metode_bayar = ?, cod = ?, batas_kirim = ?,
                        status_pengiriman = ?, id_konter = ?
                    WHERE no_resi = ?
                    """;
                try (PreparedStatement ps =
                        conn.prepareStatement(sqlKirim)) {
                    ps.setString(1, kirim.getJenisPengiriman());
                    ps.setInt(2, kirim.getTotalBiaya());
                    ps.setString(3, kirim.getMetodeBayar());
                    ps.setInt(4, kirim.getCod());
                    ps.setDate(5, Date.valueOf(kirim.getBatasKirim()));
                    ps.setString(6, kirim.getStatusPengiriman());
                    ps.setInt(7, kirim.getIdKonter());
                    ps.setString(8, noResi);
                    if (ps.executeUpdate() == 0) {
                        throw new SQLException(
                                "Pengiriman tidak ditemukan.");
                    }
                }
            } else {
                sqlKirim = """
                    UPDATE pengiriman SET
                        jenis_pengiriman = ?, total_biaya = ?,
                        metode_bayar = ?, cod = ?, batas_kirim = ?,
                        status_pengiriman = ?, id_konter = ?, id_ongkir = ?
                    WHERE no_resi = ?
                    """;
                try (PreparedStatement ps =
                        conn.prepareStatement(sqlKirim)) {
                    ps.setString(1, kirim.getJenisPengiriman());
                    ps.setInt(2, kirim.getTotalBiaya());
                    ps.setString(3, kirim.getMetodeBayar());
                    ps.setInt(4, kirim.getCod());
                    ps.setDate(5, Date.valueOf(kirim.getBatasKirim()));
                    ps.setString(6, kirim.getStatusPengiriman());
                    ps.setInt(7, kirim.getIdKonter());
                    ps.setInt(8, Integer.parseInt(idOngkir));
                    ps.setString(9, noResi);
                    if (ps.executeUpdate() == 0) {
                        throw new SQLException(
                                "Pengiriman tidak ditemukan.");
                    }
                }
            }

            sisipRiwayat(conn, ambilIdPengiriman(conn, noResi),
                    "Data pengiriman diperbarui");
        });
        return true;
    }

    public boolean ubahStatusPengiriman(String noResi, String status)
            throws SQLException {
        if (!List.of(Pengiriman.STATUS_TERKIRIM,
                Pengiriman.STATUS_GAGAL,
                Pengiriman.STATUS_DALAM_PENGIRIMAN,
                Pengiriman.STATUS_DITERIMA_KONTER).contains(status)) {
            throw new IllegalArgumentException(
                    "Status pengiriman tidak valid: " + status);
        }
        jalankanTransaksi(conn -> {
            int jumlah;
            try (PreparedStatement ps = conn.prepareStatement(
                    "UPDATE pengiriman SET status_pengiriman = ? "
                    + "WHERE no_resi = ?")) {
                ps.setString(1, status);
                ps.setString(2, noResi);
                jumlah = ps.executeUpdate();
            }
            if (jumlah == 0) {
                throw new SQLException("Pengiriman tidak ditemukan.");
            }
            sisipRiwayat(conn, ambilIdPengiriman(conn, noResi),
                    "Status pengiriman diperbarui: " + status);
        });
        return true;
    }

    public boolean hapusPengiriman(String noResi) throws SQLException {
        jalankanTransaksi(conn -> {
            try (var st = conn.createStatement()) {
                st.execute("SET FOREIGN_KEY_CHECKS=0");
            }
            long idKirim = ambilIdPengiriman(conn, noResi);
            long idPaket = ambilIdPaket(conn, noResi);

            hapus(conn, "DELETE FROM riwayat_pelacakan "
                    + "WHERE id_pengiriman = ?", idKirim);
            hapus(conn, "DELETE FROM pengantaran "
                    + "WHERE id_pengiriman = ?", idKirim);
            hapus(conn, "DELETE FROM pengiriman "
                    + "WHERE id_pengiriman = ?", idKirim);
            hapus(conn, "DELETE FROM paket WHERE id_paket = ?", idPaket);

            try (var st = conn.createStatement()) {
                st.execute("SET FOREIGN_KEY_CHECKS=1");
            }
        });
        return true;
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
                rs.getString("no_resi"),
                rs.getString("nama_barang"),
                rs.getBigDecimal("berat"),
                rs.getString("nama_pengirim"),
                rs.getString("nama_penerima"),
                rs.getString("jenis_pengiriman"),
                rs.getString("nama_konter"),
                rs.getInt("total_biaya"),
                rs.getString("metode_bayar"),
                rs.getInt("cod"),
                rs.getDate("batas_kirim"),
                rs.getString("status_pengiriman")
            });
        }
        return baris;
    }

    private void hapus(Connection conn, String sql, Object... parameter)
            throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ikatParameter(ps, parameter);
            ps.executeUpdate();
        }
    }

    long ambilIdPengiriman(Connection conn, String noResi)
            throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT id_pengiriman FROM pengiriman WHERE no_resi = ?")) {
            ps.setString(1, noResi);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        throw new SQLException(
                "Pengiriman dengan resi " + noResi + " tidak ditemukan.");
    }

    private long ambilIdPaket(Connection conn, String noResi)
            throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT id_paket FROM pengiriman WHERE no_resi = ?")) {
            ps.setString(1, noResi);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        throw new SQLException("Paket tidak ditemukan.");
    }

    void sisipRiwayat(Connection conn, long idPengiriman,
            String deskripsi) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO riwayat_pelacakan (deskripsi, waktu_riwayat, "
                + "id_pengiriman) VALUES (?, NOW(), ?)")) {
            ps.setString(1, deskripsi);
            ps.setLong(2, idPengiriman);
            ps.executeUpdate();
        }
    }

    private String buatNomorResi(Connection conn) throws SQLException {
        for (int percobaan = 0; percobaan < 30; percobaan++) {
            StringBuilder resi = new StringBuilder("JE");
            for (int i = 0; i < 8; i++) {
                resi.append(ABJAD_RESI.charAt(
                        ACAK.nextInt(ABJAD_RESI.length())));
            }
            String kandidat = resi.toString();
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT 1 FROM pengiriman WHERE no_resi = ?")) {
                ps.setString(1, kandidat);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        return kandidat;
                    }
                }
            }
        }
        throw new SQLException(
                "Gagal membuat nomor resi unik. Silakan coba lagi.");
    }

    private String kolomString(ResultSet rs, String kolom) {
        try {
            return rs.getString(kolom);
        } catch (SQLException e) {
            return null;
        }
    }

    private BigDecimal kolomBigDecimal(ResultSet rs, String kolom) {
        try {
            return rs.getBigDecimal(kolom);
        } catch (SQLException e) {
            return null;
        }
    }
}
