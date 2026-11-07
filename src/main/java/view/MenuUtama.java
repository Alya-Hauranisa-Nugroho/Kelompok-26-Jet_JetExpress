/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import util.Sesi;

public class MenuUtama extends javax.swing.JPanel {

    public MenuUtama() {
        initComponents();

        BtnLogin.addActionListener(evt -> {
            util.Sesi sesi = util.Sesi.getSesi();

            if (sesi.sudahLogin()) {
                String tujuan = util.HakAkses
                        .dariRole(sesi.getRole())
                        .halamanBeranda();
                pindahHalaman(tujuan);
            } else {
                pindahHalaman("login");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnKonterKami = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnCekTarif = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnLacakPaket = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        KaliamtLayanan = new javax.swing.JLabel();
        Benner = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlAksenHero = new javax.swing.JPanel();
        Kalimat2 = new javax.swing.JLabel();
        Kalimat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PNavbar = new javax.swing.JPanel();
        BtnKeluar = new javax.swing.JButton();
        BtnLogin = new javax.swing.JButton();
        btnNavKonter = new javax.swing.JButton();
        btnNavTarif = new javax.swing.JButton();
        btnNavLacak = new javax.swing.JButton();
        pnlNavAktif = new javax.swing.JPanel();
        btnNavBeranda = new javax.swing.JButton();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel5.setPreferredSize(new java.awt.Dimension(309, 77));

        jLabel6.setForeground(new java.awt.Color(107, 122, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("<html>Konter tersebar di seluruh kota Samarinda untuk melayani Anda</html>");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnKonterKami.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKonterKami.setForeground(new java.awt.Color(11, 31, 75));
        btnKonterKami.setText("Konter Kami");
        btnKonterKami.setBorderPainted(false);
        btnKonterKami.setContentAreaFilled(false);
        btnKonterKami.setFocusPainted(false);
        btnKonterKami.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKonterKami.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnKonterKami.addActionListener(this::btnKonterKamiActionPerformed);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconKonterKami.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKonterKami, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnKonterKami, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setPreferredSize(new java.awt.Dimension(309, 77));

        jLabel4.setForeground(new java.awt.Color(107, 122, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("<html>Lihat estimasi ongkir untuk paket Anda dengan mudah</html>");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnCekTarif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCekTarif.setForeground(new java.awt.Color(11, 31, 75));
        btnCekTarif.setText("Cek Tarif");
        btnCekTarif.setBorderPainted(false);
        btnCekTarif.setContentAreaFilled(false);
        btnCekTarif.setFocusPainted(false);
        btnCekTarif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCekTarif.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCekTarif.addActionListener(this::btnCekTarifActionPerformed);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCekTarif.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(309, 77));

        jLabel3.setForeground(new java.awt.Color(107, 122, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("<html>Pantau status pengiriman dan riwayat paket Anda<html>");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnLacakPaket.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLacakPaket.setForeground(new java.awt.Color(11, 31, 75));
        btnLacakPaket.setText("Lacak Paket");
        btnLacakPaket.setBorderPainted(false);
        btnLacakPaket.setContentAreaFilled(false);
        btnLacakPaket.setFocusPainted(false);
        btnLacakPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLacakPaket.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLacakPaket.addActionListener(this::btnLacakPaketActionPerformed);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconLacakPaket.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLacakPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLacakPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        KaliamtLayanan.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        KaliamtLayanan.setForeground(new java.awt.Color(11, 31, 75));
        KaliamtLayanan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        KaliamtLayanan.setText("Layanan Kami");
        KaliamtLayanan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Benner.setBackground(new java.awt.Color(11, 31, 75));
        Benner.setPreferredSize(new java.awt.Dimension(1075, 256));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(184, 196, 224));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("di Kota Samarinda");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(184, 196, 224));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Sistem Informasi Pengiriman dan Pelacakan Paket");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pnlAksenHero.setBackground(new java.awt.Color(255, 107, 0));
        pnlAksenHero.setPreferredSize(new java.awt.Dimension(71, 4));

        javax.swing.GroupLayout pnlAksenHeroLayout = new javax.swing.GroupLayout(pnlAksenHero);
        pnlAksenHero.setLayout(pnlAksenHeroLayout);
        pnlAksenHeroLayout.setHorizontalGroup(
            pnlAksenHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );
        pnlAksenHeroLayout.setVerticalGroup(
            pnlAksenHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        Kalimat2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Kalimat2.setForeground(new java.awt.Color(255, 255, 255));
        Kalimat2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Kalimat2.setText("Punya Cerita");
        Kalimat2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Kalimat.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Kalimat.setForeground(new java.awt.Color(255, 255, 255));
        Kalimat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Kalimat.setText("Setiap Paket");
        Kalimat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JetyBahagia.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout BennerLayout = new javax.swing.GroupLayout(Benner);
        Benner.setLayout(BennerLayout);
        BennerLayout.setHorizontalGroup(
            BennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BennerLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kalimat2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kalimat, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
        BennerLayout.setVerticalGroup(
            BennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BennerLayout.createSequentialGroup()
                .addGroup(BennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BennerLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BennerLayout.createSequentialGroup()
                        .addGroup(BennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BennerLayout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BennerLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(Kalimat2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BennerLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(Kalimat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PNavbar.setBackground(new java.awt.Color(255, 255, 255));
        PNavbar.setPreferredSize(new java.awt.Dimension(1075, 51));

        BtnKeluar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnKeluar.setForeground(new java.awt.Color(107, 122, 153));
        BtnKeluar.setText("Keluar");
        BtnKeluar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnKeluar.setFocusPainted(false);
        BtnKeluar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnKeluar.addActionListener(this::BtnKeluarActionPerformed);

        BtnLogin.setBackground(new java.awt.Color(255, 107, 0));
        BtnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnLogin.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogin.setText("Login");
        BtnLogin.setBorderPainted(false);
        BtnLogin.setFocusPainted(false);
        BtnLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnNavKonter.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavKonter.setForeground(new java.awt.Color(11, 31, 75));
        btnNavKonter.setText("Konter Kami");
        btnNavKonter.setBorderPainted(false);
        btnNavKonter.setContentAreaFilled(false);
        btnNavKonter.setFocusPainted(false);
        btnNavKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavKonter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavKonter.addActionListener(this::btnNavKonterActionPerformed);

        btnNavTarif.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavTarif.setForeground(new java.awt.Color(11, 31, 75));
        btnNavTarif.setText("Cek Tarif");
        btnNavTarif.setBorderPainted(false);
        btnNavTarif.setContentAreaFilled(false);
        btnNavTarif.setFocusPainted(false);
        btnNavTarif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTarif.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavTarif.addActionListener(this::btnNavTarifActionPerformed);

        btnNavLacak.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavLacak.setForeground(new java.awt.Color(11, 31, 75));
        btnNavLacak.setText("Lacak Paket");
        btnNavLacak.setBorderPainted(false);
        btnNavLacak.setContentAreaFilled(false);
        btnNavLacak.setFocusPainted(false);
        btnNavLacak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavLacak.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavLacak.addActionListener(this::btnNavLacakActionPerformed);

        pnlNavAktif.setBackground(new java.awt.Color(255, 107, 0));
        pnlNavAktif.setPreferredSize(new java.awt.Dimension(52, 3));

        javax.swing.GroupLayout pnlNavAktifLayout = new javax.swing.GroupLayout(pnlNavAktif);
        pnlNavAktif.setLayout(pnlNavAktifLayout);
        pnlNavAktifLayout.setHorizontalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );
        pnlNavAktifLayout.setVerticalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btnNavBeranda.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavBeranda.setForeground(new java.awt.Color(255, 107, 0));
        btnNavBeranda.setText("Beranda");
        btnNavBeranda.setBorderPainted(false);
        btnNavBeranda.setContentAreaFilled(false);
        btnNavBeranda.setFocusPainted(false);
        btnNavBeranda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavBeranda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavBeranda.addActionListener(this::btnNavBerandaActionPerformed);

        lblLogoExpress.setFont(new java.awt.Font("Segoe UI", 3, 27)); // NOI18N
        lblLogoExpress.setForeground(new java.awt.Color(11, 31, 75));
        lblLogoExpress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoExpress.setText("Express");
        lblLogoExpress.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblLogoJet.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        lblLogoJet.setForeground(new java.awt.Color(255, 107, 0));
        lblLogoJet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoJet.setText("Jet");
        lblLogoJet.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PNavbarLayout = new javax.swing.GroupLayout(PNavbar);
        PNavbar.setLayout(PNavbarLayout);
        PNavbarLayout.setHorizontalGroup(
            PNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(874, 874, 874)
                .addComponent(BtnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(956, 956, 956)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(707, 707, 707)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(615, 615, 615)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(btnNavLacak, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(btnNavBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PNavbarLayout.setVerticalGroup(
            PNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(BtnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavLacak, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(712, 712, 712)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(KaliamtLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Benner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(332, 332, 332)
                            .addComponent(KaliamtLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(Benner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(366, 366, 366)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekTarifActionPerformed
    pindahHalaman("cekTarif");
    }//GEN-LAST:event_btnCekTarifActionPerformed

    private void btnKonterKamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonterKamiActionPerformed
    pindahHalaman("konterKami");
    }//GEN-LAST:event_btnKonterKamiActionPerformed

    private void btnLacakPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLacakPaketActionPerformed
    pindahHalaman("lacakPaket");
    }//GEN-LAST:event_btnLacakPaketActionPerformed
    private void pindahHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame)
            SwingUtilities.getWindowAncestor(this);

        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        } else {
            JOptionPane.showMessageDialog(
                this,
                "MainFrame belum terhubung!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }


    private void btnNavBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavBerandaActionPerformed
        pindahHalaman("menuUtama");
    }//GEN-LAST:event_btnNavBerandaActionPerformed

    private void btnNavLacakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavLacakActionPerformed
        pindahHalaman("lacakPaket");
    }//GEN-LAST:event_btnNavLacakActionPerformed

    private void btnNavTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavTarifActionPerformed
        pindahHalaman("cekTarif");
    }//GEN-LAST:event_btnNavTarifActionPerformed

    private void btnNavKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavKonterActionPerformed
        pindahHalaman("konterKami");
    }//GEN-LAST:event_btnNavKonterActionPerformed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        int pilihan = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Apakah kamu yakin ingin keluar dari program?",
            "Konfirmasi Keluar",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (pilihan == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_BtnKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Benner;
    private javax.swing.JButton BtnKeluar;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JLabel KaliamtLayanan;
    private javax.swing.JLabel Kalimat;
    private javax.swing.JLabel Kalimat2;
    private javax.swing.JPanel PNavbar;
    private javax.swing.JButton btnCekTarif;
    private javax.swing.JButton btnKonterKami;
    private javax.swing.JButton btnLacakPaket;
    private javax.swing.JButton btnNavBeranda;
    private javax.swing.JButton btnNavKonter;
    private javax.swing.JButton btnNavLacak;
    private javax.swing.JButton btnNavTarif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JPanel pnlAksenHero;
    private javax.swing.JPanel pnlNavAktif;
    // End of variables declaration//GEN-END:variables
}
