package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Konter;


public class KonterDAO extends BaseDAO<Konter> {

    @Override
    public String namaTabel() {
        return "konter";
    }

    @Override
    protected Konter petakanBaris(ResultSet rs) throws SQLException {
        return new Konter(
                rs.getInt("id_konter"),
                rs.getString("nama_konter"),
                rs.getString("alamat_konter"),
                rs.getString("kecamatan"),
                rs.getString("call_center"));
    }

    @Override
    public List<Konter> ambilSemua() throws SQLException {
        return daftarHasil(
                "SELECT id_konter, nama_konter, alamat_konter, kecamatan, "
                + "call_center FROM konter ORDER BY id_konter ASC");
    }

    public List<Object[]> getSemuaKonter() throws SQLException {
        List<Object[]> baris = new ArrayList<>();
        for (Konter konter : ambilSemua()) {
            baris.add(new Object[]{
                konter.getIdKonter(),
                konter.getNamaKonter(),
                konter.getAlamatKonter(),
                konter.getKecamatan(),
                konter.getCallCenter()
            });
        }
        return baris;
    }

    public boolean tambahKonter(Konter konter) throws SQLException {
        int jumlah = perintah(
                "INSERT INTO konter (nama_konter, alamat_konter, kecamatan, "
                + "call_center) VALUES (?, ?, ?, ?)",
                konter.getNamaKonter(),
                konter.getAlamatKonter(),
                konter.getKecamatan(),
                konter.getCallCenter());
        return jumlah > 0;
    }

    public boolean ubahKonter(Konter konter) throws SQLException {
        int jumlah = perintah(
                "UPDATE konter SET nama_konter = ?, alamat_konter = ?, "
                + "kecamatan = ?, call_center = ? WHERE id_konter = ?",
                konter.getNamaKonter(),
                konter.getAlamatKonter(),
                konter.getKecamatan(),
                konter.getCallCenter(),
                konter.getIdKonter());
        return jumlah > 0;
    }

    public boolean hapusKonter(int idKonter) throws SQLException {
        int pemakaiUser = skalarInt(
                "SELECT COUNT(*) FROM user WHERE id_konter = ?", idKonter);
        if (pemakaiUser > 0) {
            throw new SQLException(
                    "Konter masih dipakai " + pemakaiUser
                    + " user dan tidak dapat dihapus!");
        }
        int pemakaiKirim = skalarInt(
                "SELECT COUNT(*) FROM pengiriman WHERE id_konter = ?",
                idKonter);
        if (pemakaiKirim > 0) {
            throw new SQLException(
                    "Konter memiliki riwayat pengiriman "
                    + "dan tidak dapat dihapus!");
        }
        int jumlah = perintah(
                "DELETE FROM konter WHERE id_konter = ?", idKonter);
        return jumlah > 0;
    }

    public boolean adaKonter(int idKonter) throws SQLException {
        return skalarInt("SELECT COUNT(*) FROM konter WHERE id_konter = ?",
                idKonter) > 0;
    }
}
