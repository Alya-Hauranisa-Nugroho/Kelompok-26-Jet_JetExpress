package model;

import java.math.BigDecimal;

public class Paket {

    private int idPaket;
    private String namaBarang;
    private BigDecimal berat;
    private String jenisBarang;
    private String namaPengirim;
    private String noTelpPengirim;
    private String alamatPengirim;
    private String namaPenerima;
    private String noTelpPenerima;
    private String alamatPenerima;
    private Integer idPengiriman;

    public Paket() {
    }

    public int getIdPaket() { return idPaket; }
    public void setIdPaket(int idPaket) { this.idPaket = idPaket; }

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

    public Integer getIdPengiriman() { return idPengiriman; }
    public void setIdPengiriman(Integer idPengiriman) {
        this.idPengiriman = idPengiriman;
    }
}
