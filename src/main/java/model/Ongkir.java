package model;

public class Ongkir implements BarisTabel {

    private int idOngkir;
    private int jarakMin;
    private int jarakMax;
    private int tarifDasar;

    public Ongkir() {
    }

    public Ongkir(int idOngkir, int jarakMin, int jarakMax, int tarifDasar) {
        this.idOngkir = idOngkir;
        this.jarakMin = jarakMin;
        this.jarakMax = jarakMax;
        this.tarifDasar = tarifDasar;
    }

    public int getIdOngkir() { return idOngkir; }
    public void setIdOngkir(int idOngkir) { this.idOngkir = idOngkir; }

    public int getJarakMin() { return jarakMin; }
    public void setJarakMin(int jarakMin) { this.jarakMin = jarakMin; }

    public int getJarakMax() { return jarakMax; }
    public void setJarakMax(int jarakMax) { this.jarakMax = jarakMax; }

    public int getTarifDasar() { return tarifDasar; }
    public void setTarifDasar(int tarifDasar) {
        this.tarifDasar = tarifDasar;
    }

    public String teksCombo() {
        return jarakMin + " - " + jarakMax + " KM";
    }

    @Override
    public Object[] sebagaiBaris() {
        return new Object[]{
            idOngkir, jarakMin, jarakMax, tarifDasar
        };
    }
}
