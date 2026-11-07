package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Paket;

public class PaketDAO extends BaseDAO<Paket> {

    @Override
    public String namaTabel() {
        return "paket";
    }

    @Override
    protected Paket petakanBaris(ResultSet rs) throws SQLException {
        Paket paket = new Paket();
        paket.setIdPaket(rs.getInt("id_paket"));
        paket.setNamaBarang(rs.getString("nama_barang"));
        paket.setBerat(rs.getBigDecimal("berat"));
        paket.setJenisBarang(rs.getString("jenis_barang"));
        paket.setNamaPengirim(rs.getString("nama_pengirim"));
        paket.setNoTelpPengirim(rs.getString("no_telp_pengirim"));
        paket.setAlamatPengirim(rs.getString("alamat_pengirim"));
        paket.setNamaPenerima(rs.getString("nama_penerima"));
        paket.setNoTelpPenerima(rs.getString("no_telp_penerima"));
        paket.setAlamatPenerima(rs.getString("alamat_penerima"));
        int idKirim = rs.getInt("id_pengiriman");
        paket.setIdPengiriman(rs.wasNull() ? null : idKirim);
        return paket;
    }

    @Override
    public List<Paket> ambilSemua() throws SQLException {
        return daftarHasil("SELECT * FROM paket ORDER BY id_paket ASC");
    }

    public java.util.Optional<Paket> ambilById(int idPaket)
            throws SQLException {
        return satuHasil("SELECT * FROM paket WHERE id_paket = ?", idPaket);
    }

    public long sisip(Connection conn, Paket paket,
            long idPengirimanSementara) throws SQLException {
        String sql = """
            INSERT INTO paket (nama_barang, berat, jenis_barang,
                               nama_pengirim, no_telp_pengirim,
                               alamat_pengirim, nama_penerima,
                               no_telp_penerima, alamat_penerima,
                               id_pengiriman)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        try (PreparedStatement ps =
                conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, paket.getNamaBarang());
            ps.setBigDecimal(2, paket.getBerat());
            ps.setString(3, paket.getJenisBarang());
            ps.setString(4, paket.getNamaPengirim());
            ps.setString(5, paket.getNoTelpPengirim());
            ps.setString(6, paket.getAlamatPengirim());
            ps.setString(7, paket.getNamaPenerima());
            ps.setString(8, paket.getNoTelpPenerima());
            ps.setString(9, paket.getAlamatPenerima());
            ps.setLong(10, idPengirimanSementara);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        throw new SQLException("Gagal menyimpan data paket.");
    }

    public void hubungkanKePengiriman(Connection conn, long idPaket,
            long idPengiriman) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE paket SET id_pengiriman = ? WHERE id_paket = ?")) {
            ps.setLong(1, idPengiriman);
            ps.setLong(2, idPaket);
            ps.executeUpdate();
        }
    }
}
