package util;

import java.util.Set;

public class HakAksesAdmin extends HakAkses {

    @Override
    protected Set<String> halamanIzin() {
        return Set.of(
                "menuAdmin", "menuUser", "menuKonter", "menuOngkir",
                "menuPengiriman", "menuRiwayat", "menuPengantaran",
                "menuTambahPengiriman", "menuUbahPengiriman",
                "menuTambahPengantaran", "menuUbahPengantaran",
                "tambahKurir", "tambahPetugasKonter",
                "ubahKurir", "ubahPetugas",
                "menuCekTarif", "menuKelolaKonter",
                "menuKelolaRiwayat", "menuKelolaPengantaran");
    }

    @Override
    public String halamanBeranda() {
        return "menuAdmin";
    }

    @Override
    public String namaRole() {
        return "Admin";
    }
}
