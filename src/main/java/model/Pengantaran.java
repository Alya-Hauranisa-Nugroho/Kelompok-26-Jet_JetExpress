package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pengantaran {

    public static final String STATUS_DITUGASKAN = "Ditugaskan";
    public static final String STATUS_DALAM_PERJALANAN = "Dalam Perjalanan";
    public static final String STATUS_BERHASIL = "Berhasil";
    public static final String STATUS_GAGAL = "Gagal";

    // ===== Field tabel pengantaran =====
    private int idPengantaran;
    private BigDecimal longitudeTujuan;
    private BigDecimal latitudeTujuan;
    private LocalDate waktuPenugasan;
    private String statusPengantaran;
    private String buktiFoto;
    private String catatanKurir;
    private int idUser;
    private int idPengiriman;

    private String namaKurir;
    private String noResi;
    private String namaPenerima;
    private String alamatPenerima;
    private String noTelpPenerima;

    public Pengantaran() {
    }

    public int getIdPengantaran() { return idPengantaran; }
    public void setIdPengantaran(int idPengantaran) {
        this.idPengantaran = idPengantaran;
    }

    public BigDecimal getLongitudeTujuan() { return longitudeTujuan; }
    public void setLongitudeTujuan(BigDecimal longitudeTujuan) {
        this.longitudeTujuan = longitudeTujuan;
    }

    public BigDecimal getLatitudeTujuan() { return latitudeTujuan; }
    public void setLatitudeTujuan(BigDecimal latitudeTujuan) {
        this.latitudeTujuan = latitudeTujuan;
    }

    public LocalDate getWaktuPenugasan() { return waktuPenugasan; }
    public void setWaktuPenugasan(LocalDate waktuPenugasan) {
        this.waktuPenugasan = waktuPenugasan;
    }

    public String getStatusPengantaran() { return statusPengantaran; }
    public void setStatusPengantaran(String statusPengantaran) {
        this.statusPengantaran = statusPengantaran;
    }

    public String getBuktiFoto() { return buktiFoto; }
    public void setBuktiFoto(String buktiFoto) {
        this.buktiFoto = buktiFoto;
    }

    public String getCatatanKurir() { return catatanKurir; }
    public void setCatatanKurir(String catatanKurir) {
        this.catatanKurir = catatanKurir;
    }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public int getIdPengiriman() { return idPengiriman; }
    public void setIdPengiriman(int idPengiriman) {
        this.idPengiriman = idPengiriman;
    }

    public String getNamaKurir() { return namaKurir; }
    public void setNamaKurir(String namaKurir) {
        this.namaKurir = namaKurir;
    }

    public String getNoResi() { return noResi; }
    public void setNoResi(String noResi) { this.noResi = noResi; }

    public String getNamaPenerima() { return namaPenerima; }
    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getAlamatPenerima() { return alamatPenerima; }
    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public String getNoTelpPenerima() { return noTelpPenerima; }
    public void setNoTelpPenerima(String noTelpPenerima) {
        this.noTelpPenerima = noTelpPenerima;
    }
}
