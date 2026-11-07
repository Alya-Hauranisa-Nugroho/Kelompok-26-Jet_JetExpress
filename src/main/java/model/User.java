package model;

import java.time.LocalDate;

public class User {

    // ===== Field tabel user =====
    private int idUser;
    private String nama;
    private String email;
    private String password;
    private String noHp;
    private int gaji;
    private LocalDate tanggalMasuk;
    private String role;
    private int idKonter;

    // ===== Field hasil JOIN (opsional, untuk tampilan) =====
    private String namaKonter;
    private String shiftKerja;      // khusus Petugas Konter
    private String nomorKendaraan;  // khusus Kurir
    private String jobdesk;         // khusus Admin

    public User() {
    }

    public User(int idUser, String nama, String email, String password,
            String noHp, int gaji, LocalDate tanggalMasuk,
            String role, int idKonter) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.noHp = noHp;
        this.gaji = gaji;
        this.tanggalMasuk = tanggalMasuk;
        this.role = role;
        this.idKonter = idKonter;
    }

    // ===== Getter & Setter =====
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }

    public int getGaji() { return gaji; }
    public void setGaji(int gaji) { this.gaji = gaji; }

    public LocalDate getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(LocalDate tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getIdKonter() { return idKonter; }
    public void setIdKonter(int idKonter) { this.idKonter = idKonter; }

    public String getNamaKonter() { return namaKonter; }
    public void setNamaKonter(String namaKonter) {
        this.namaKonter = namaKonter;
    }

    public String getShiftKerja() { return shiftKerja; }
    public void setShiftKerja(String shiftKerja) {
        this.shiftKerja = shiftKerja;
    }

    public String getNomorKendaraan() { return nomorKendaraan; }
    public void setNomorKendaraan(String nomorKendaraan) {
        this.nomorKendaraan = nomorKendaraan;
    }

    public String getJobdesk() { return jobdesk; }
    public void setJobdesk(String jobdesk) { this.jobdesk = jobdesk; }

    public String tabelPeran() {
        if (role == null) return null;
        return switch (role) {
            case "Kurir" -> "kurir";
            case "Petugas Konter" -> "petugas_konter";
            case "Admin" -> "admin";
            default -> null;
        };
    }
}
