package controller;

import dao.PaketDAO;
import dao.PengirimanDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import model.Paket;
import model.Pengiriman;
import util.InputHelper;

public class PengirimanController {

    private final PengirimanDAO pengirimanDAO;

    public PengirimanController() {
        this.pengirimanDAO = new PengirimanDAO();
    }

    public List<Object[]> tampilkan() throws SQLException {
        return pengirimanDAO.getSemuaPengiriman();
    }

    public List<Object[]> cari(String keyword) throws SQLException {
        if (keyword == null || keyword.isBlank()) {
            return pengirimanDAO.getSemuaPengiriman();
        }
        return pengirimanDAO.cariPengiriman(keyword);
    }

    public Optional<Pengiriman> detailByResi(String noResi)
            throws SQLException {
        if (noResi == null || noResi.isBlank()) {
            throw new IllegalArgumentException(
                    "Nomor resi tidak boleh kosong.");
        }
        return pengirimanDAO.ambilByResi(noResi);
    }

    public boolean resiTerdaftar(String noResi) throws SQLException {
        if (noResi == null || noResi.isBlank()) {
            return true; // resi kosong dianggap selalu "terpakai"
        }
        return pengirimanDAO.resiTerdaftar(noResi.trim().toUpperCase());
    }

    public List<Object[]> pengirimanTersedia() throws SQLException {
        return pengirimanDAO.getPengirimanTersedia();
    }

    public List<Object[]> ringkasan() throws SQLException {
        return pengirimanDAO.getPengirimanRingkas();
    }

    public String tambah(String jenisPengiriman, int totalBiaya,
            String metodeBayar, int cod, String batasKirim, String status,
            int idKonter, int idOngkir, String namaBarang,
            BigDecimal berat, String jenisBarang, String namaPengirim,
            String hpPengirim, String alamatPengirim, String namaPenerima,
            String hpPenerima, String alamatPenerima) throws SQLException {

        InputHelper.validasiFormPengiriman(namaBarang,
                berat == null ? "" : berat.toPlainString(), jenisBarang,
                namaPengirim, hpPengirim, alamatPengirim, namaPenerima,
                hpPenerima, alamatPenerima, jenisPengiriman, metodeBayar,
                "COD".equals(metodeBayar) ? String.valueOf(cod) : "0",
                batasKirim, idKonter, idOngkir);

        Pengiriman kirim = new Pengiriman();
        kirim.setJenisPengiriman(jenisPengiriman);
        kirim.setTotalBiaya(totalBiaya);
        kirim.setMetodeBayar(metodeBayar);
        kirim.setCod(cod);
        kirim.setBatasKirim(java.time.LocalDate.parse(batasKirim.trim()));
        kirim.setStatusPengiriman(status);
        kirim.setIdKonter(idKonter);
        kirim.setIdOngkir(idOngkir);

        Paket paket = susunPaket(namaBarang, berat, jenisBarang,
                namaPengirim, hpPengirim, alamatPengirim, namaPenerima,
                hpPenerima, alamatPenerima);

        return pengirimanDAO.tambahPengiriman(kirim, paket);
    }

    public boolean ubah(String noResi, String jenisPengiriman,
            int totalBiaya, String metodeBayar, int cod,
            String batasKirim, String status, int idKonter,
            String idOngkir, String namaBarang, BigDecimal berat,
            String jenisBarang, String namaPengirim, String hpPengirim,
            String alamatPengirim, String namaPenerima, String hpPenerima,
            String alamatPenerima) throws SQLException {

        if (noResi == null || noResi.isBlank()) {
            throw new IllegalArgumentException(
                    "Nomor resi pengiriman tidak terdeteksi.");
        }
        InputHelper.validasiFormPengiriman(namaBarang,
                berat == null ? "" : berat.toPlainString(), jenisBarang,
                namaPengirim, hpPengirim, alamatPengirim, namaPenerima,
                hpPenerima, alamatPenerima, jenisPengiriman, metodeBayar,
                "COD".equals(metodeBayar) ? String.valueOf(cod) : "0",
                batasKirim, idKonter,
                idOngkir == null || idOngkir.isBlank()
                ? 1 : Integer.parseInt(idOngkir));

        Pengiriman kirim = new Pengiriman();
        kirim.setJenisPengiriman(jenisPengiriman);
        kirim.setTotalBiaya(totalBiaya);
        kirim.setMetodeBayar(metodeBayar);
        kirim.setCod(cod);
        kirim.setBatasKirim(java.time.LocalDate.parse(batasKirim.trim()));
        kirim.setStatusPengiriman(status);
        kirim.setIdKonter(idKonter);

        Paket paket = susunPaket(namaBarang, berat, jenisBarang,
                namaPengirim, hpPengirim, alamatPengirim, namaPenerima,
                hpPenerima, alamatPenerima);

        return pengirimanDAO.ubahPengiriman(noResi, kirim, paket,
                idOngkir);
    }

    public boolean ubahStatus(String noResi, String status)
            throws SQLException {
        if (noResi == null || noResi.isBlank()) {
            throw new IllegalArgumentException(
                    "Pilih pengiriman yang statusnya akan diubah.");
        }
        return pengirimanDAO.ubahStatusPengiriman(noResi, status);
    }
    public boolean hapus(String noResi) throws SQLException {
        if (noResi == null || noResi.isBlank()) {
            throw new IllegalArgumentException(
                    "Pilih pengiriman yang akan dihapus.");
        }
        return pengirimanDAO.hapusPengiriman(noResi);
    }

    private Paket susunPaket(String namaBarang, BigDecimal berat,
            String jenisBarang, String namaPengirim, String hpPengirim,
            String alamatPengirim, String namaPenerima, String hpPenerima,
            String alamatPenerima) {
        Paket paket = new Paket();
        paket.setNamaBarang(namaBarang);
        paket.setBerat(berat);
        paket.setJenisBarang(jenisBarang);
        paket.setNamaPengirim(namaPengirim);
        paket.setNoTelpPengirim(hpPengirim);
        paket.setAlamatPengirim(alamatPengirim);
        paket.setNamaPenerima(namaPenerima);
        paket.setNoTelpPenerima(hpPenerima);
        paket.setAlamatPenerima(alamatPenerima);
        return paket;
    }
}
