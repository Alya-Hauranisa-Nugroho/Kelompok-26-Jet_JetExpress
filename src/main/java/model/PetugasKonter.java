package model;

public class PetugasKonter {

    private int idUser;
    private String shiftKerja;   // Pagi / Siang / Malam

    // Data induk user (hasil JOIN)
    private User user;

    public PetugasKonter() {
    }

    public PetugasKonter(int idUser, String shiftKerja) {
        this.idUser = idUser;
        this.shiftKerja = shiftKerja;
    }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getShiftKerja() { return shiftKerja; }
    public void setShiftKerja(String shiftKerja) {
        this.shiftKerja = shiftKerja;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
