package controller;

import dao.RiwayatPelacakanDAO;
import java.sql.SQLException;
import java.util.List;
import model.RiwayatPelacakan;
import util.InputHelper;
import util.KonversiWaktu;

public class RiwayatPelacakanController {

    private final RiwayatPelacakanDAO riwayatDAO;

    public RiwayatPelacakanController() {
        this.riwayatDAO = new RiwayatPelacakanDAO();
    }

    public List<Object[]> tampilkan() throws SQLException {
        return riwayatDAO.getSemuaRiwayat();
    }

    public List<Object[]> cari(String keyword) throws SQLException {
        if (keyword == null || keyword.isBlank()) {
            return riwayatDAO.getSemuaRiwayat();
        }
        return riwayatDAO.cariRiwayat(keyword);
    }

    public List<RiwayatPelacakan> riwayatPengiriman(int idPengiriman) {
        return riwayatDAO.getByPengiriman(idPengiriman);
    }

    public boolean tambah(String deskripsi, String waktuTeks,
            int idPengiriman) throws SQLException {
        InputHelper.validasiFormRiwayat(deskripsi, waktuTeks,
                idPengiriman);
        RiwayatPelacakan riwayat = new RiwayatPelacakan(deskripsi.trim(),
                KonversiWaktu.keWaktu(waktuTeks), idPengiriman);
        return riwayatDAO.tambah(riwayat);
    }

    public boolean ubah(int idRiwayat, String deskripsi,
            String waktuTeks, int idPengiriman) throws SQLException {
        if (idRiwayat <= 0) {
            throw new IllegalArgumentException(
                    "Pilih riwayat yang akan diubah.");
        }
        InputHelper.validasiFormRiwayat(deskripsi, waktuTeks,
                idPengiriman);
        RiwayatPelacakan riwayat = new RiwayatPelacakan(idRiwayat,
                deskripsi.trim(), KonversiWaktu.keWaktu(waktuTeks),
                idPengiriman);
        return riwayatDAO.ubah(riwayat);
    }

    public boolean hapus(int idRiwayat) throws SQLException {
        if (idRiwayat <= 0) {
            throw new IllegalArgumentException(
                    "Pilih riwayat yang akan dihapus.");
        }
        return riwayatDAO.hapus(idRiwayat);
    }
}
