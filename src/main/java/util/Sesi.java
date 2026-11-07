package util;

public final class Sesi {

    private static Sesi instance;

    private int idUser;
    private String nama;
    private String email;
    private String role;
    private int idKonter;

    private Sesi() {
    }

    public static Sesi getSesi() {
        if (instance == null) {
            instance = new Sesi();
        }
        return instance;
    }

    public static void login(int idUser, String nama, String email,
            String role, int idKonter) {
        Sesi sesi = getSesi();
        sesi.idUser = idUser;
        sesi.nama = nama;
        sesi.email = email;
        sesi.role = role;
        sesi.idKonter = idKonter;
    }

    public static void logout() {
        if (instance != null) {
            instance.idUser = 0;
            instance.nama = null;
            instance.email = null;
            instance.role = null;
            instance.idKonter = 0;
        }
    }

    public int getIdUser() { return idUser; }

    public String getNama() { return nama; }

    public String getEmail() { return email; }

    public String getRole() { return role; }

    public int getIdKonter() { return idKonter; }

    private boolean peran(String peranDicari) {
        return role != null
                && role.trim().equalsIgnoreCase(peranDicari);
    }

    public boolean isAdmin() { return peran("Admin"); }

    public boolean isPetugasKonter() { return peran("Petugas Konter"); }

    public boolean isKurir() { return peran("Kurir"); }

    public boolean sudahLogin() { return idUser > 0; }
}
