/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.LoginController;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.User;
import util.InputHelper;
import util.Sesi;

public class Login extends javax.swing.JPanel {

    private final LoginController loginController = new LoginController();
    public Login() {
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormLogin = new javax.swing.JPanel();
        btnKembali = new javax.swing.JButton();
        TextKembali = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        ShowPassword = new javax.swing.JCheckBox();
        InputPassword = new javax.swing.JPasswordField();
        Password = new javax.swing.JLabel();
        InputEmail = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        lblSubJudul = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();
        panelLogo = new javax.swing.JPanel();
        lblSloganIsi2 = new javax.swing.JLabel();
        lblSloganIsi1 = new javax.swing.JLabel();
        lblSloganDua = new javax.swing.JLabel();
        lblSloganSatu = new javax.swing.JLabel();
        lblMaskotTeks = new javax.swing.JLabel();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));

        panelFormLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelFormLogin.setPreferredSize(new java.awt.Dimension(463, 568));

        btnKembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(255, 107, 0));
        btnKembali.setText("Kembali");
        btnKembali.setBorderPainted(false);
        btnKembali.setContentAreaFilled(false);
        btnKembali.setFocusPainted(false);
        btnKembali.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKembali.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnKembali.addActionListener(this::btnKembaliActionPerformed);

        TextKembali.setForeground(new java.awt.Color(107, 122, 153));
        TextKembali.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TextKembali.setText("Pengguna umum?");
        TextKembali.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnLogin.setBackground(new java.awt.Color(255, 107, 0));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        ShowPassword.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ShowPassword.setForeground(new java.awt.Color(107, 122, 153));
        ShowPassword.setText("Show Password");
        ShowPassword.setFocusPainted(false);
        ShowPassword.addActionListener(this::ShowPasswordActionPerformed);

        InputPassword.setForeground(new java.awt.Color(11, 31, 75));
        InputPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        InputPassword.addActionListener(this::InputPasswordActionPerformed);

        Password.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Password.setForeground(new java.awt.Color(11, 31, 75));
        Password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Password.setText("Password");
        Password.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        InputEmail.setForeground(new java.awt.Color(11, 31, 75));
        InputEmail.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        InputEmail.addActionListener(this::InputEmailActionPerformed);

        Email.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Email.setForeground(new java.awt.Color(11, 31, 75));
        Email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email.setText("Email");
        Email.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblSubJudul.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubJudul.setForeground(new java.awt.Color(107, 122, 153));
        lblSubJudul.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSubJudul.setText("Masukkan email dan password Anda");
        lblSubJudul.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Login.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        Login.setForeground(new java.awt.Color(11, 31, 75));
        Login.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Login.setText("Masuk ke Akun Anda");
        Login.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelFormLoginLayout = new javax.swing.GroupLayout(panelFormLogin);
        panelFormLogin.setLayout(panelFormLoginLayout);
        panelFormLoginLayout.setHorizontalGroup(
            panelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(TextKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(ShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(InputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblSubJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelFormLoginLayout.setVerticalGroup(
            panelFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(TextKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(ShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(InputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(lblSubJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelFormLoginLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelLogo.setBackground(new java.awt.Color(11, 31, 75));
        panelLogo.setPreferredSize(new java.awt.Dimension(612, 568));

        lblSloganIsi2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblSloganIsi2.setForeground(new java.awt.Color(184, 196, 224));
        lblSloganIsi2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSloganIsi2.setText("Paket di Kota Samarinda");
        lblSloganIsi2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblSloganIsi1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblSloganIsi1.setForeground(new java.awt.Color(184, 196, 224));
        lblSloganIsi1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSloganIsi1.setText("Sistem Informasi Pengiriman dan Pelacakan");
        lblSloganIsi1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblSloganDua.setFont(new java.awt.Font("Segoe UI", 1, 44)); // NOI18N
        lblSloganDua.setForeground(new java.awt.Color(255, 255, 255));
        lblSloganDua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSloganDua.setText("Lebih Dekat");
        lblSloganDua.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblSloganSatu.setFont(new java.awt.Font("Segoe UI", 1, 44)); // NOI18N
        lblSloganSatu.setForeground(new java.awt.Color(255, 255, 255));
        lblSloganSatu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSloganSatu.setText("Lebih Cepat,");
        lblSloganSatu.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblMaskotTeks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaskotTeks.setForeground(new java.awt.Color(255, 255, 255));
        lblMaskotTeks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaskotTeks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JetyBahagiaLogin.png"))); // NOI18N
        lblMaskotTeks.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblLogoExpress.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        lblLogoExpress.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoExpress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoExpress.setText("Express");
        lblLogoExpress.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblLogoJet.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        lblLogoJet.setForeground(new java.awt.Color(255, 107, 0));
        lblLogoJet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoJet.setText("Jet");
        lblLogoJet.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblSloganIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblSloganIsi1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblSloganDua, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblSloganSatu, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogoLayout.createSequentialGroup()
                .addComponent(lblMaskotTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lblMaskotTeks)
                        .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLogoLayout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(lblSloganIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLogoLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(lblSloganIsi1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLogoLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(lblSloganDua, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLogoLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblSloganSatu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(612, 612, 612)
                .addComponent(panelFormLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFormLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputEmailActionPerformed
    InputPassword.requestFocus();
    }//GEN-LAST:event_InputEmailActionPerformed

    private void InputPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPasswordActionPerformed
        btnLogin.doClick();
    }//GEN-LAST:event_InputPasswordActionPerformed

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        if (ShowPassword.isSelected()) {
        InputPassword.setEchoChar((char) 0);
    } else {
        InputPassword.setEchoChar('•');
    }
    }//GEN-LAST:event_ShowPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    String email = InputEmail.getText().trim();
    String password = new String(InputPassword.getPassword());

    try {
        User user = loginController.login(email, password);

        MainFrame frame = (MainFrame)
                SwingUtilities.getWindowAncestor(this);

        if (frame == null) {
            return;
        }

        frame.setHakAkses(util.HakAkses.dariRole(user.getRole()));

        if (Sesi.getSesi().isAdmin()) {

            // Admin memegang satu konter utama
            frame.setIdKonterLogin(user.getIdKonter());

            frame.setNamaAdmin(user.getNama());
            frame.tampilkanHalaman("menuAdmin");

        } else if (Sesi.getSesi().isPetugasKonter()) {

            frame.setIdKonterLogin(user.getIdKonter());
            frame.tampilkanHalaman("menuKelolaPengiriman");

        } else if (Sesi.getSesi().isKurir()) {

            frame.tampilkanHalaman("lihatPengantaran");

        } else {

            // Role tidak dikenal: sesi dibatalkan agar tidak
            // ada halaman yang bisa dibuka.
            loginController.logout();
            frame.resetHakAkses();

            JOptionPane.showMessageDialog(
                this,
                "Role akun tidak dikenali: " + user.getRole()
                + "\nSilakan hubungi administrator.",
                "Login Gagal",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
            this,
            "Login berhasil. Selamat datang, " + user.getNama()
        );

        InputEmail.setText("");
        InputPassword.setText("");
        ShowPassword.setSelected(false);
        InputPassword.setEchoChar('•');

    } catch (IllegalArgumentException e) {

        JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );

    } catch (IllegalStateException e) {

        JOptionPane.showMessageDialog(
            this,
            e.getMessage()
            + "\nPastikan email dan password benar, atau akun "
            + "Anda sudah terdaftar.",
            "Login Gagal",
            JOptionPane.ERROR_MESSAGE
        );

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            this,
            "Terjadi kesalahan: " + e.getMessage(),
            "Kesalahan",
            JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);

    if (frame != null) {
        frame.tampilkanHalaman("menuUtama");
    }
    }//GEN-LAST:event_btnKembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JTextField InputEmail;
    private javax.swing.JPasswordField InputPassword;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Password;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JLabel TextKembali;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblMaskotTeks;
    private javax.swing.JLabel lblSloganDua;
    private javax.swing.JLabel lblSloganIsi1;
    private javax.swing.JLabel lblSloganIsi2;
    private javax.swing.JLabel lblSloganSatu;
    private javax.swing.JLabel lblSubJudul;
    private javax.swing.JPanel panelFormLogin;
    private javax.swing.JPanel panelLogo;
    // End of variables declaration//GEN-END:variables
}
