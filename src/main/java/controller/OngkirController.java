package controller;

import dao.OngkirDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import model.Ongkir;
import util.InputHelper;

public class OngkirController {

    private final OngkirDAO ongkirDAO;

    public OngkirController() {
        this.ongkirDAO = new OngkirDAO();
    }

    public List<Object[]> tampilkan() throws SQLException {
        return ongkirDAO.getSemuaOngkir();
    }

    public List<Ongkir> semuaModel() throws SQLException {
        return ongkirDAO.ambilSemua();
    }

    public Integer tarifDasar(int idOngkir) throws SQLException {
        return ongkirDAO.ambilById(idOngkir)
                .map(Ongkir::getTarifDasar)
                .orElse(null);
    }

    public boolean tambah(String jarakMinTeks, String jarakMaxTeks,
            String tarifTeks) throws SQLException {
        InputHelper.validasiFormOngkir(jarakMinTeks, jarakMaxTeks,
                tarifTeks);
        Ongkir ongkir = new Ongkir(0,
                Integer.parseInt(jarakMinTeks.replace(",", "").trim()),
                Integer.parseInt(jarakMaxTeks.replace(",", "").trim()),
                Integer.parseInt(tarifTeks.replace(",", "").trim()));
        return ongkirDAO.tambahOngkir(ongkir);
    }

    public boolean ubah(int idOngkir, String jarakMinTeks,
            String jarakMaxTeks, String tarifTeks) throws SQLException {
        if (idOngkir <= 0) {
            throw new IllegalArgumentException(
                    "Pilih baris ongkir yang akan diubah.");
        }
        InputHelper.validasiFormOngkir(jarakMinTeks, jarakMaxTeks,
                tarifTeks);
        Ongkir ongkir = new Ongkir(idOngkir,
                Integer.parseInt(jarakMinTeks),
                Integer.parseInt(jarakMaxTeks),
                Integer.parseInt(tarifTeks));
        return ongkirDAO.ubahOngkir(ongkir);
    }

    public boolean hapus(int idOngkir) throws SQLException {
        if (idOngkir <= 0) {
            throw new IllegalArgumentException(
                    "Pilih baris ongkir yang akan dihapus.");
        }
        return ongkirDAO.hapusOngkir(idOngkir);
    }

    public Map<String, Object> hitungTarif(String pilihanJarak,
            String beratTeks) throws SQLException {
        InputHelper.validasiCekTarif(beratTeks);
        if (pilihanJarak == null || pilihanJarak.isBlank()) {
            throw new IllegalArgumentException(
                    "Rentang jarak wajib dipilih terlebih dahulu.");
        }
        int jarak;
        try {
            jarak = Integer.parseInt(
                    pilihanJarak.split(" - ")[0].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Rentang jarak tidak valid.");
        }
        BigDecimal berat = new BigDecimal(beratTeks.replace(",", "."));
        return ongkirDAO.hitungTarif(jarak, berat);
    }

    public List<String> daftarPilihanJarak() throws SQLException {
        return ongkirDAO.ambilSemua().stream()
                .map(Ongkir::teksCombo)
                .toList();
    }
}
