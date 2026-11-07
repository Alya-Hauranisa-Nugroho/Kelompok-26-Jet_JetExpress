package model;

public class Konter implements BarisTabel {

    private int idKonter;
    private String namaKonter;
    private String alamatKonter;
    private String kecamatan;
    private String callCenter;

    public Konter() {
    }

    public Konter(int idKonter, String namaKonter, String alamatKonter,
            String kecamatan, String callCenter) {
        this.idKonter = idKonter;
        this.namaKonter = namaKonter;
        this.alamatKonter = alamatKonter;
        this.kecamatan = kecamatan;
        this.callCenter = callCenter;
    }

    public int getIdKonter() { return idKonter; }
    public void setIdKonter(int idKonter) { this.idKonter = idKonter; }

    public String getNamaKonter() { return namaKonter; }
    public void setNamaKonter(String namaKonter) {
        this.namaKonter = namaKonter;
    }

    public String getAlamatKonter() { return alamatKonter; }
    public void setAlamatKonter(String alamatKonter) {
        this.alamatKonter = alamatKonter;
    }

    public String getKecamatan() { return kecamatan; }
    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getCallCenter() { return callCenter; }
    public void setCallCenter(String callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public String toString() {
        return idKonter + " - " + namaKonter;
    }

    @Override
    public Object[] sebagaiBaris() {
        return new Object[]{
            idKonter, namaKonter, alamatKonter,
            kecamatan, callCenter
        };
    }
}
