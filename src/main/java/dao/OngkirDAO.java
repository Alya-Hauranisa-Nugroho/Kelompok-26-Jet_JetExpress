
package dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Ongkir;


public class OngkirDAO extends BaseDAO<Ongkir> {

    public static final int TARIF_PER_KG = 3000;

    @Override
    public String namaTabel() {
        return "ongkir";
    }

    @Override
    protected Ongkir petakanBaris(ResultSet rs) throws SQLException {
        return new Ongkir(
                rs.getInt("id_ongkir"),
                rs.getInt("jarak_min"),
                rs.getInt("jarak_max"),
                rs.getInt("tarif_dasar"));
    }

    @Override
    public List<Ongkir> ambilSemua() throws SQLException {
        return daftarHasil(
                "SELECT id_ongkir, jarak_min, jarak_max, tarif_dasar "
                + "FROM ongkir ORDER BY jarak_min ASC");
    }

    public java.util.Optional<Ongkir> ambilById(int idOngkir)
            throws SQLException {
        return satuHasil(
                "SELECT id_ongkir, jarak_min, jarak_max, tarif_dasar "
                + "FROM ongkir WHERE id_ongkir = ?", idOngkir);
    }

    public List<Object[]> getSemuaOngkir() throws SQLException {
        List<Object[]> baris = new ArrayList<>();
        for (Ongkir ongkir : ambilSemua()) {
            baris.add(new Object[]{
                ongkir.getIdOngkir(),
                ongkir.getJarakMin(),
                ongkir.getJarakMax(),
                ongkir.getTarifDasar()
            });
        }
        return baris;
    }

    public boolean tambahOngkir(Ongkir ongkir) throws SQLException {
        if (ongkir.getJarakMin() < 0
                || ongkir.getJarakMax() < ongkir.getJarakMin()
                || ongkir.getTarifDasar() < 0) {
            throw new IllegalArgumentException(
                    "Rentang jarak atau tarif tidak valid.");
        }
        int jumlah = perintah(
                "INSERT INTO ongkir (jarak_min, jarak_max, tarif_dasar) "
                + "VALUES (?, ?, ?)",
                ongkir.getJarakMin(),
                ongkir.getJarakMax(),
                ongkir.getTarifDasar());
        return jumlah > 0;
    }

    public boolean ubahOngkir(Ongkir ongkir) throws SQLException {
        if (ongkir.getJarakMin() < 0
                || ongkir.getJarakMax() < ongkir.getJarakMin()
                || ongkir.getTarifDasar() < 0) {
            throw new IllegalArgumentException(
                    "Rentang jarak atau tarif tidak valid.");
        }
        int jumlah = perintah(
                "UPDATE ongkir SET jarak_min = ?, jarak_max = ?, "
                + "tarif_dasar = ? WHERE id_ongkir = ?",
                ongkir.getJarakMin(),
                ongkir.getJarakMax(),
                ongkir.getTarifDasar(),
                ongkir.getIdOngkir());
        return jumlah > 0;
    }

    public boolean hapusOngkir(int idOngkir) throws SQLException {
        int pemakai = skalarInt(
                "SELECT COUNT(*) FROM pengiriman WHERE id_ongkir = ?",
                idOngkir);
        if (pemakai > 0) {
            throw new SQLException(
                    "Tarif ongkir masih dipakai " + pemakai
                    + " data pengiriman dan tidak dapat dihapus!");
        }
        int jumlah = perintah(
                "DELETE FROM ongkir WHERE id_ongkir = ?", idOngkir);
        return jumlah > 0;
    }

    public java.util.Optional<Ongkir> cariByJarak(int jarak)
            throws SQLException {
        if (jarak < 0) {
            throw new IllegalArgumentException(
                    "Jarak tidak boleh bernilai negatif.");
        }
        return satuHasil(
                "SELECT id_ongkir, jarak_min, jarak_max, tarif_dasar "
                + "FROM ongkir WHERE ? BETWEEN jarak_min AND jarak_max "
                + "ORDER BY jarak_min ASC LIMIT 1", jarak);
    }

    public Map<String, Object> hitungTarif(int jarak, BigDecimal berat)
            throws SQLException {
        if (berat == null || berat.signum() <= 0) {
            throw new IllegalArgumentException(
                    "Berat paket harus lebih dari 0 KG.");
        }
        java.util.Optional<Ongkir> hasil = cariByJarak(jarak);
        if (hasil.isEmpty()) {
            throw new IllegalArgumentException(
                    "Jarak " + jarak + " KM belum memiliki tarif. "
                    + "Silakan hubungi konter terdekat.");
        }
        Ongkir ongkir = hasil.get();
        int biayaBerat = (int) Math.ceil(
                berat.doubleValue() * TARIF_PER_KG);
        int totalBiaya = ongkir.getTarifDasar() + biayaBerat;

        Map<String, Object> rincian = new LinkedHashMap<>();
        rincian.put("id_ongkir", ongkir.getIdOngkir());
        rincian.put("jarak_min", ongkir.getJarakMin());
        rincian.put("jarak_max", ongkir.getJarakMax());
        rincian.put("tarif_dasar", ongkir.getTarifDasar());
        rincian.put("berat", berat);
        rincian.put("biaya_berat", biayaBerat);
        rincian.put("total_biaya", totalBiaya);
        return rincian;
    }
}
