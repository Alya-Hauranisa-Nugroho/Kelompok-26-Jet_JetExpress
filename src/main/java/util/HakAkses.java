package util;

import java.util.Set;

public abstract class HakAkses {


    protected static final Set<String> HALAMAN_PUBLIK = Set.of(
            "menuUtama", "login", "cekTarif", "lacakPaket",
            "konterKami");


    protected abstract Set<String> halamanIzin();
    public abstract String halamanBeranda();
    public abstract String namaRole();

    public final boolean bolehBuka(String namaHalaman) {
        if (namaHalaman == null || namaHalaman.isBlank()) {
            return false;
        }
        if (HALAMAN_PUBLIK.contains(namaHalaman)) {
            return true;
        }
        Set<String> izin = halamanIzin();
        return izin != null && izin.contains(namaHalaman);
    }

    public static HakAkses dariRole(String role) {
        if (role == null) {
            return tanpaIzin();
        }
        switch (role.trim().toLowerCase()) {
            case "admin" -> {
                return new HakAksesAdmin();
            }
            case "petugas konter" -> {
                return new HakAksesKonter();
            }
            case "kurir" -> {
                return new HakAksesKurir();
            }
            default -> {
                return tanpaIzin();
            }
        }
    }

    public static HakAkses tanpaIzin() {
        return new HakAksesTanpaIzin();
    }
}
