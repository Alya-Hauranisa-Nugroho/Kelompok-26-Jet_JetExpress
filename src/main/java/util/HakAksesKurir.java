package util;

import java.util.Set;


public class HakAksesKurir extends HakAkses {

    @Override
    protected Set<String> halamanIzin() {
        return Set.of(
                "lihatPengantaran",
                "ubahStatusPengantaran",
                "lihatDaftarKonter",
                "menuKelolaPengantaran");
    }

    @Override
    public String halamanBeranda() {
        return "lihatPengantaran";
    }

    @Override
    public String namaRole() {
        return "Kurir";
    }
}
