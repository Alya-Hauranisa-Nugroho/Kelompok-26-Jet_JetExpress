package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.RiwayatPelacakan;

public class RiwayatPelacakanDAO extends BaseDAO<RiwayatPelacakan> {

    private static final String SQL_DAFTAR = """
        SELECT
            r.id_riwayat, r.deskripsi, r.waktu_riwayat,
            r.id_pengiriman, p.no_resi,
            pk.nama_penerima, pk.alamat_penerima,
            p.status_pengiriman
        FROM riwayat_pelacakan r
        JOIN pengiriman p ON r.id_pengiriman = p.id_pengiriman
        JOIN paket pk ON pk.id_paket = p.id_paket
        """;

    @Override
    public String namaTabel() {
        return "riwayat_pelacakan";
    }

    @Override
    protected RiwayatPelacakan petakanBaris(ResultSet rs)
            throws SQLException {
        RiwayatPelacakan riwayat = new RiwayatPelacakan();
        riwayat.setIdRiwayat(rs.getInt("id_riwayat"));
        riwayat.setDeskripsi(rs.getString("deskripsi"));
        Timestamp waktu = rs.getTimestamp("waktu_riwayat");
        riwayat.setWaktuRiwayat(waktu == null
                ? null : waktu.toLocalDateTime());
        riwayat.setIdPengiriman(rs.getInt("id_pengiriman"));
        riwayat.setNoResi(kolomString(rs, "no_resi"));
        riwayat.setNamaPenerima(kolomString(rs, "nama_penerima"));
        riwayat.setAlamatPenerima(kolomString(rs, "alamat_penerima"));
        riwayat.setStatusPengiriman(kolomString(rs, "status_pengiriman"));
        return riwayat;
    }

    @Override
    public List<RiwayatPelacakan> ambilSemua() throws SQLException {
        return daftarHasil(SQL_DAFTAR
                + " ORDER BY r.waktu_riwayat DESC, r.id_riwayat DESC");
    }

    public List<Object[]> getSemuaRiwayat() throws SQLException {
        List<Object[]> baris = new ArrayList<>();
        for (RiwayatPelacakan r : ambilSemua()) {
            baris.add(new Object[]{
                r.getIdRiwayat(),
                r.getDeskripsi(),
                r.getWaktuRiwayat(),
                r.getIdPengiriman(),
                r.getNoResi(),
                r.getNamaPenerima(),
                r.getAlamatPenerima(),
                r.getStatusPengiriman()
            });
        }
        return baris;
    }

    public List<Object[]> cariRiwayat(String keyword) throws SQLException {
        String cari = "%" + keyword.trim() + "%";
        String sql = SQL_DAFTAR
                + " WHERE p.no_resi LIKE ? OR r.deskripsi LIKE ? "
                + "OR pk.nama_penerima LIKE ? "
                + "ORDER BY r.waktu_riwayat DESC, r.id_riwayat DESC";
        List<Object[]> baris = new ArrayList<>();
        try (var conn = bukaKoneksi();
             var ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 3; i++) {
                ps.setString(i, cari);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    baris.add(new Object[]{
                        rs.getInt("id_riwayat"),
                        rs.getString("deskripsi"),
                        rs.getTimestamp("waktu_riwayat"),
                        rs.getInt("id_pengiriman"),
                        rs.getString("no_resi"),
                        rs.getString("nama_penerima"),
                        rs.getString("alamat_penerima"),
                        rs.getString("status_pengiriman")
                    });
                }
            }
        }
        return baris;
    }

    public ArrayList<RiwayatPelacakan> getByPengiriman(int idPengiriman) {
        ArrayList<RiwayatPelacakan> daftar = new ArrayList<>();
        String sql = """
            SELECT id_riwayat, deskripsi, waktu_riwayat, id_pengiriman
            FROM riwayat_pelacakan
            WHERE id_pengiriman = ?
            ORDER BY waktu_riwayat ASC
            """;
        try (var conn = bukaKoneksi();
             var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPengiriman);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RiwayatPelacakan r = new RiwayatPelacakan(
                            rs.getInt("id_riwayat"),
                            rs.getString("deskripsi"),
                            rs.getTimestamp("waktu_riwayat")
                                    .toLocalDateTime(),
                            rs.getInt("id_pengiriman"));
                    daftar.add(r);
                }
            }
        } catch (SQLException e) {
            System.err.println(
                    "Gagal memuat riwayat pelacakan: " + e.getMessage());
        }
        return daftar;
    }
    
    public boolean tambah(RiwayatPelacakan r) throws SQLException {
        int jumlah = perintah(
                "INSERT INTO riwayat_pelacakan (id_pengiriman, "
                + "waktu_riwayat, deskripsi) VALUES (?, ?, ?)",
                r.getIdPengiriman(),
                Timestamp.valueOf(r.getWaktuRiwayat()),
                r.getDeskripsi());
        return jumlah > 0;
    }

    public boolean ubah(RiwayatPelacakan r) throws SQLException {
        int jumlah = perintah(
                "UPDATE riwayat_pelacakan SET deskripsi = ?, "
                + "waktu_riwayat = ? WHERE id_riwayat = ?",
                r.getDeskripsi(),
                Timestamp.valueOf(r.getWaktuRiwayat()),
                r.getIdRiwayat());
        return jumlah > 0;
    }

    public boolean hapus(int idRiwayat) throws SQLException {
        int jumlah = perintah(
                "DELETE FROM riwayat_pelacakan WHERE id_riwayat = ?",
                idRiwayat);
        return jumlah > 0;
    }

    private String kolomString(ResultSet rs, String kolom) {
        try {
            return rs.getString(kolom);
        } catch (SQLException e) {
            return null;
        }
    }
}
