package model;

import java.time.LocalDateTime;


public class RiwayatPelacakan {

    private int idRiwayat;
    private String deskripsi;
    private LocalDateTime waktuRiwayat;
    private int idPengiriman;

    private String noResi;
    private String namaPenerima;
    private String alamatPenerima;
    private String statusPengiriman;

    public RiwayatPelacakan() {
    }

    public RiwayatPelacakan(int idRiwayat, String deskripsi,
            LocalDateTime waktuRiwayat, int idPengiriman) {
        this.idRiwayat = idRiwayat;
        this.deskripsi = deskripsi;
        this.waktuRiwayat = waktuRiwayat;
        this.idPengiriman = idPengiriman;
    }

    public RiwayatPelacakan(String deskripsi, LocalDateTime waktuRiwayat,
            int idPengiriman) {
        this(0, deskripsi, waktuRiwayat, idPengiriman);
    }

    public int getIdRiwayat() {
        return idRiwayat;
    }

    public void setIdRiwayat(int idRiwayat) {
        this.idRiwayat = idRiwayat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public LocalDateTime getWaktuRiwayat() {
        return waktuRiwayat;
    }

    public void setWaktuRiwayat(LocalDateTime waktuRiwayat) {
        this.waktuRiwayat = waktuRiwayat;
    }

    public int getIdPengiriman() {
        return idPengiriman;
    }

    public void setIdPengiriman(int idPengiriman) {
        this.idPengiriman = idPengiriman;
    }

    public String getNoResi() {
        return noResi;
    }

    public void setNoResi(String noResi) {
        this.noResi = noResi;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }
}
