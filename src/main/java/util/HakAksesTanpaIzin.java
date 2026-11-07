package util;

import java.util.Set;

class HakAksesTanpaIzin extends HakAkses {

    @Override
    protected Set<String> halamanIzin() {
        return Set.of();
    }

    @Override
    public String halamanBeranda() {
        return "menuUtama";
    }

    @Override
    public String namaRole() {
        return "Tidak Dikenal";
    }
}
