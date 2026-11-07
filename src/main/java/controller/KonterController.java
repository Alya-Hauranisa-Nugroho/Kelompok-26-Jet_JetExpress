package controller;

import dao.KonterDAO;
import java.sql.SQLException;
import java.util.List;
import model.Konter;
import util.InputHelper;

public class KonterController {

    private final KonterDAO konterDAO;

    public KonterController() {
        this.konterDAO = new KonterDAO();
    }

    public List<Object[]> tampilkan() throws SQLException {
        return konterDAO.getSemuaKonter();
    }

    public List<Konter> semuaModel() throws SQLException {
        return konterDAO.ambilSemua();
    }

    public boolean tambah(String nama, String alamat, String kecamatan,
            String callCenter) throws SQLException {
        InputHelper.validasiFormKonter(nama, alamat, kecamatan,
                callCenter);
        Konter konter = new Konter(0, nama, alamat, kecamatan,
                callCenter);
        return konterDAO.tambahKonter(konter);
    }

    public boolean ubah(int idKonter, String nama, String alamat,
            String kecamatan, String callCenter) throws SQLException {
        if (idKonter <= 0) {
            throw new IllegalArgumentException(
                    "Pilih konter yang akan diubah terlebih dahulu.");
        }
        InputHelper.validasiFormKonter(nama, alamat, kecamatan,
                callCenter);
        Konter konter = new Konter(idKonter, nama, alamat, kecamatan,
                callCenter);
        return konterDAO.ubahKonter(konter);
    }

    public boolean hapus(int idKonter) throws SQLException {
        if (idKonter <= 0) {
            throw new IllegalArgumentException(
                    "Pilih konter yang akan dihapus terlebih dahulu.");
        }
        return konterDAO.hapusKonter(idKonter);
    }
}
