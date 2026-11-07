package util;

import java.awt.Component;
import java.awt.Window;
import javax.swing.SwingUtilities;


public interface NavigasiHalaman {

    void tampilkanHalaman(String namaHalaman);

    static NavigasiHalaman dari(Component komponen) {
        if (komponen == null) {
            return null;
        }
        Window jendela = SwingUtilities.getWindowAncestor(komponen);
        if (jendela instanceof NavigasiHalaman navigasi) {
            return navigasi;
        }
        return null;
    }
}
