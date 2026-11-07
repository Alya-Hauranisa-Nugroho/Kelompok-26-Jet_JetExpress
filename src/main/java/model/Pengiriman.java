package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pengiriman {

    public static final String STATUS_TERKIRIM = "Terkirim";
    public static final String STATUS_GAGAL = "Gagal";
    public static final String STATUS_DALAM_PENGIRIMAN = "Dalam Pengiriman";
    public static final String STATUS_DITERIMA_KONTER = "Diterima Konter";

    private int idPengiriman;
    private String noResi;
    private String jenisPengiriman;   // Intracity / Outbound / Inbound
    private int totalBiaya;
    private String metodeBayar;       // Cash / Cashless / COD
    private int cod;                  // nilai tagihan COD (0 bila bukan COD)
    private LocalDate batasKirim;
    private String statusPengiriman;
    private int idKonter;
    private int idPaket;
    private int idOngkir;

    // ===== Field paket (JOIN) =====
    private String namaBarang;
    private BigDecimal berat;
    private String jenisBarang;
    private String namaPengirim;
    private String noTelpPengirim;
    private String alamatPengirim;
    private String namaPenerima;
    private String noTelpPenerima;
    private String alamatPenerima;

    // ===== Field relasi lain (JOIN) =====
    private String namaKonter;
    private int jarakMin;
    private int jarakMax;

    public Pengiriman() {
    }

    public int getIdPengiriman() { return idPengiriman; }
    public void setIdPengiriman(int idPengiriman) {
        this.idPengiriman = idPengiriman;
    }

    public String getNoResi() { return noResi; }
    public void setNoResi(String noResi) { this.noResi = noResi; }

    public String getJenisPengiriman() { return jenisPengiriman; }
    public void setJenisPengiriman(String jenisPengiriman) {
        this.jenisPengiriman = jenisPengiriman;
    }

    public int getTotalBiaya() { return totalBiaya; }
    public void setTotalBiaya(int totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public String getMetodeBayar() { return metodeBayar; }
    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public int getCod() { return cod; }
    public void setCod(int cod) { this.cod = cod; }

    public LocalDate getBatasKirim() { return batasKirim; }
    public void setBatasKirim(LocalDate batasKirim) {
        this.batasKirim = batasKirim;
    }

    public String getStatusPengiriman() { return statusPengiriman; }
    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }

    public int getIdKonter() { return idKonter; }
    public void setIdKonter(int idKonter) { this.idKonter = idKonter; }

    public int getIdPaket() { return idPaket; }
    public void setIdPaket(int idPaket) { this.idPaket = idPaket; }

    public int getIdOngkir() { return idOngkir; }
    public void setIdOngkir(int idOngkir) { this.idOngkir = idOngkir; }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public BigDecimal getBerat() { return berat; }
    public void setBerat(BigDecimal berat) { this.berat = berat; }

    public String getJenisBarang() { return jenisBarang; }
    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getNamaPengirim() { return namaPengirim; }
    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public String getNoTelpPengirim() { return noTelpPengirim; }
    public void setNoTelpPengirim(String noTelpPengirim) {
        this.noTelpPengirim = noTelpPengirim;
    }

    public String getAlamatPengirim() { return alamatPengirim; }
    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    public String getNamaPenerima() { return namaPenerima; }
    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getNoTelpPenerima() { return noTelpPenerima; }
    public void setNoTelpPenerima(String noTelpPenerima) {
        this.noTelpPenerima = noTelpPenerima;
    }

    public String getAlamatPenerima() { return alamatPenerima; }
    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public String getNamaKonter() { return namaKonter; }
    public void setNamaKonter(String namaKonter) {
        this.namaKonter = namaKonter;
    }

    public int getJarakMin() { return jarakMin; }
    public void setJarakMin(int jarakMin) { this.jarakMin = jarakMin; }

    public int getJarakMax() { return jarakMax; }
    public void setJarakMax(int jarakMax) { this.jarakMax = jarakMax; }
}
