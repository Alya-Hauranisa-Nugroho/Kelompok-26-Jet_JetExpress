package model;

public class Kurir {

    private int idUser;
    private String nomorKendaraan;

    private User user;

    public Kurir() {
    }

    public Kurir(int idUser, String nomorKendaraan) {
        this.idUser = idUser;
        this.nomorKendaraan = nomorKendaraan;
    }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNomorKendaraan() { return nomorKendaraan; }
    public void setNomorKendaraan(String nomorKendaraan) {
        this.nomorKendaraan = nomorKendaraan;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
