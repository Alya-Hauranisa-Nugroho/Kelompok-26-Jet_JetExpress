package controller;

import dao.PengantaranDAO;
import image.ImageManager;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import model.Pengantaran;
import util.InputHelper;
import util.ValidasiKoordinat;

public class PengantaranController {

    private final PengantaranDAO pengantaranDAO;

    public PengantaranController() {
        this.pengantaranDAO = new PengantaranDAO();
    }

    public List<Object[]> tampilkan() throws SQLException {
        return pengantaranDAO.getSemuaPengantaran();
    }

    public List<Object[]> cari(String keyword) throws SQLException {
        if (keyword == null || keyword.isBlank()) {
            return pengantaranDAO.getSemuaPengantaran();
        }
        return pengantaranDAO.cariPengantaran(keyword);
    }

    public List<Object[]> daftarKurir() throws SQLException {
        return pengantaranDAO.getDaftarKurir();
    }

    public List<Object[]> pengirimanTersedia() throws SQLException {
        return pengantaranDAO.getPengirimanTersedia();
    }

    public Optional<Pengantaran> detail(int idPengantaran)
            throws SQLException {
        if (idPengantaran <= 0) {
            throw new IllegalArgumentException(
                    "ID pengantaran tidak valid.");
        }
        return pengantaranDAO.ambilById(idPengantaran);
    }

    public boolean tambah(int idPengiriman, int idKurir,
            String tanggalTeks, BigDecimal latitude,
            BigDecimal longitude, String status, File fotoBaru,
            String catatan) throws SQLException {

        InputHelper.validasiFormPengantaran(idPengiriman, idKurir,
                tanggalTeks, latitude, longitude, status);
        InputHelper.validasiBuktiFoto(status, fotoBaru != null);

        String pathBaru = salinFotoBila(fotoBaru);
        try {
            return pengantaranDAO.tambahPengantaran(idPengiriman,
                    idKurir, java.time.LocalDate.parse(tanggalTeks.trim()),
                    latitude, longitude, status, pathBaru, catatan);
        } catch (SQLException | RuntimeException e) {
            ImageManager.hapusFoto(pathBaru);
            throw e;
        }
    }

    public boolean ubah(int idPengantaran, int idKurir,
            String tanggalTeks, BigDecimal latitude,
            BigDecimal longitude, String status, String buktiLama,
            File fotoBaru, String catatan) throws SQLException {

        if (idPengantaran <= 0) {
            throw new IllegalArgumentException(
                    "ID pengantaran tidak terdeteksi.");
        }
        InputHelper.validasiFormPengantaran(1, idKurir, tanggalTeks,
                latitude, longitude, status);
        ValidasiKoordinat.validasi(latitude, longitude);
        InputHelper.validasiBuktiFoto(status,
                fotoBaru != null || ada(buktiLama));

        String pathBaru = salinFotoBila(fotoBaru);
        String pathAkhir = pathBaru != null ? pathBaru : kosongJadiNull(buktiLama);
        try {
            boolean berhasil = pengantaranDAO.ubahPengantaran(
                    idPengantaran, idKurir,
                    java.time.LocalDate.parse(tanggalTeks.trim()),
                    latitude, longitude, status, pathAkhir, catatan);
            if (berhasil && pathBaru != null) {
                ImageManager.hapusFoto(buktiLama);
            }
            return berhasil;
        } catch (SQLException | RuntimeException e) {
            ImageManager.hapusFoto(pathBaru);
            throw e;
        }
    }

    public boolean ubahStatus(int idPengantaran, String status,
            String buktiLama, File fotoBaru, String catatan)
            throws SQLException {

        if (idPengantaran <= 0) {
            throw new IllegalArgumentException(
                    "Belum ada pengantaran yang dipilih.");
        }
        InputHelper.validasiFormUbahStatusPengantaran(status,
                fotoBaru != null || ada(buktiLama), catatan);

        String pathBaru = salinFotoBila(fotoBaru);
        String pathAkhir = pathBaru != null ? pathBaru : kosongJadiNull(buktiLama);
        try {
            boolean berhasil = pengantaranDAO.ubahStatus(idPengantaran,
                    status, pathAkhir, catatan);
            if (berhasil && pathBaru != null) {
                ImageManager.hapusFoto(buktiLama);
            }
            return berhasil;
        } catch (SQLException | RuntimeException e) {
            ImageManager.hapusFoto(pathBaru);
            throw e;
        }
    }

    public boolean hapus(int idPengantaran) throws SQLException {
        if (idPengantaran <= 0) {
            throw new IllegalArgumentException(
                    "Pilih pengantaran yang akan dihapus.");
        }
        String foto = pengantaranDAO.ambilById(idPengantaran)
                .map(Pengantaran::getBuktiFoto).orElse(null);

        boolean berhasil = pengantaranDAO.hapusPengantaran(idPengantaran);
        if (berhasil) {
            ImageManager.hapusFoto(foto);
        }
        return berhasil;
    }

    private String salinFotoBila(File fotoBaru) {
        if (fotoBaru == null) {
            return null;
        }
        ImageManager.validasiBerkas(fotoBaru);
        try {
            return ImageManager.salinKeFolderImage(fotoBaru);
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Gagal menyimpan foto ke folder image: "
                    + e.getMessage(), e);
        }
    }

    private static boolean ada(String teks) {
        return teks != null && !teks.isBlank();
    }

    private static String kosongJadiNull(String teks) {
        return ada(teks) ? teks.trim() : null;
    }
}
