
package util;

import java.util.Set;

public class HakAksesKonter extends HakAkses {

    @Override
    protected Set<String> halamanIzin() {
        return Set.of(
                "menuKelolaPengiriman",
                "menuTambahPengirimanKonter",
                "menuUbahPengirimanKonter",

                "menuPengantaran",
                "menuKelolaPengantaran",
                "menuTambahPengantaran",
                "menuUbahPengantaran",

                "menuKelolaRiwayat",
                "menuCekTarif",

                "menuKelolaKonter",
                "lihatDaftarKonter"
        );
    }

    @Override
    public String halamanBeranda() {
        return "menuKelolaPengiriman";
    }

    @Override
    public String namaRole() {
        return "Petugas Konter";
    }
}
