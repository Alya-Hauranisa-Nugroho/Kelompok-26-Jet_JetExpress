package main;

import java.sql.SQLException;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatLightLaf;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {


        try {
            FlatLightLaf.setup();

        } catch (Exception e) {
            System.err.println("Gagal menginisialisasi FlatLaf");
        }

        try {
            config.KoneksiDatabase.testConnection();
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    """
                    Tidak dapat terhubung ke database.
                    Pastikan MySQL berjalan, database jetexpress sudah diimpor, dan user/password pada config.KoneksiDatabase sudah benar.
                    
                    Detail: """ + e.getMessage(),
                    "Koneksi Database Gagal",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}