/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.OngkirController;
import java.util.List;
import java.util.Map;
import javax.swing.SwingUtilities;
import util.InputHelper;
import util.KonversiWaktu;

public class CekTarif extends javax.swing.JPanel {

    private final OngkirController ongkirController = new OngkirController();
    private String pilihanJarak;

public CekTarif() {
    initComponents();
    muatPilihanJarak();
}
private void muatPilihanJarak() {
    try {
        List<String> daftarJarak = ongkirController.daftarPilihanJarak();

        if (daftarJarak == null || daftarJarak.isEmpty()) {
            InputHelper.pesanPeringatan(this,
                    "Belum ada data rentang jarak yang tersedia.");
            return;
        }

        BtnPilihJarak.removeAllItems();

        for (String jarak : daftarJarak) {
            BtnPilihJarak.addItem(jarak);
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
        InputHelper.pesanError(this,
                "Gagal memuat pilihan jarak: " + e.getMessage());
    }
}
private void hitungTarif() {
    if (pilihanJarak == null || pilihanJarak.isBlank()) {
        InputHelper.pesanPeringatan(this,
                "Pilih rentang jarak terlebih dahulu (tombol Pilih Jarak).");
        return;
    }

    try {
        Map<String, Object> hasil = ongkirController.hitungTarif(
                pilihanJarak, InputKG.getText());

        int jarakMin = ((Number) hasil.get("jarak_min")).intValue();
        int jarakMaks = ((Number) hasil.get("jarak_max")).intValue();
        int totalBiaya = ((Number) hasil.get("total_biaya")).intValue();

        lblNilaiJarak.setText(jarakMin + " - " + jarakMaks + " KM");
        lblNilaiBerat.setText(String.valueOf(hasil.get("berat")) + " KG");
        lblNilaiTotalBiaya.setText(KonversiWaktu.rupiah(totalBiaya));

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
        InputHelper.pesanError(this,
                "Gagal menghitung tarif: " + e.getMessage());
    }
}
private void tampilkanHalaman(String namaHalaman) {
    MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);

    if (frame != null) {
        frame.tampilkanHalaman(namaHalaman);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblAjak1 = new javax.swing.JLabel();
        lblMaskotTeks2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNilaiTotalBiaya = new javax.swing.JLabel();
        lblTotalBiaya = new javax.swing.JLabel();
        pnlGarisHasil = new javax.swing.JPanel();
        lblNilaiBerat = new javax.swing.JLabel();
        lblBeratPaket = new javax.swing.JLabel();
        lblNilaiJarak = new javax.swing.JLabel();
        lblJarakPengiriman = new javax.swing.JLabel();
        lblJudulHasil = new javax.swing.JLabel();
        PanelCekTarif = new javax.swing.JPanel();
        BtnHitungTarif = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        InputKG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BtnPilihJarak = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PBenner = new javax.swing.JPanel();
        lblMaskotTeks = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlAksenHero = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PNavbar = new javax.swing.JPanel();
        btnNavLogin = new javax.swing.JButton();
        btnNavKonter = new javax.swing.JButton();
        pnlNavAktif = new javax.swing.JPanel();
        btnNavTarif = new javax.swing.JButton();
        btnNavLacak = new javax.swing.JButton();
        btnNavBeranda = new javax.swing.JButton();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));
        setPreferredSize(new java.awt.Dimension(1100, 620));

        jPanel2.setBackground(new java.awt.Color(255, 240, 227));
        jPanel2.setPreferredSize(new java.awt.Dimension(222, 241));

        lblAjak1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAjak1.setForeground(new java.awt.Color(11, 31, 75));
        lblAjak1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAjak1.setText("<html><center>Kirim lebih hemat bersama JetExpress!<<html>");
        lblAjak1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblMaskotTeks2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaskotTeks2.setForeground(new java.awt.Color(255, 255, 255));
        lblMaskotTeks2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaskotTeks2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JetyBahagiaSmall.png"))); // NOI18N
        lblMaskotTeks2.setText("Maskot");
        lblMaskotTeks2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblMaskotTeks2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblAjak1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblMaskotTeks2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblAjak1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(353, 241));

        lblNilaiTotalBiaya.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        lblNilaiTotalBiaya.setForeground(new java.awt.Color(255, 107, 0));
        lblNilaiTotalBiaya.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNilaiTotalBiaya.setText("Rp0");
        lblNilaiTotalBiaya.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTotalBiaya.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTotalBiaya.setForeground(new java.awt.Color(11, 31, 75));
        lblTotalBiaya.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalBiaya.setText("Total Ongkir");
        lblTotalBiaya.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pnlGarisHasil.setBackground(new java.awt.Color(227, 232, 242));
        pnlGarisHasil.setPreferredSize(new java.awt.Dimension(306, 1));

        javax.swing.GroupLayout pnlGarisHasilLayout = new javax.swing.GroupLayout(pnlGarisHasil);
        pnlGarisHasil.setLayout(pnlGarisHasilLayout);
        pnlGarisHasilLayout.setHorizontalGroup(
            pnlGarisHasilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        pnlGarisHasilLayout.setVerticalGroup(
            pnlGarisHasilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblNilaiBerat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblNilaiBerat.setForeground(new java.awt.Color(11, 31, 75));
        lblNilaiBerat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNilaiBerat.setText("-");
        lblNilaiBerat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblBeratPaket.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblBeratPaket.setForeground(new java.awt.Color(107, 122, 153));
        lblBeratPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBeratPaket.setText("Berat Paket");
        lblBeratPaket.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblNilaiJarak.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblNilaiJarak.setForeground(new java.awt.Color(11, 31, 75));
        lblNilaiJarak.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNilaiJarak.setText("-");
        lblNilaiJarak.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblJarakPengiriman.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblJarakPengiriman.setForeground(new java.awt.Color(107, 122, 153));
        lblJarakPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJarakPengiriman.setText("Jarak");
        lblJarakPengiriman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblJudulHasil.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblJudulHasil.setForeground(new java.awt.Color(11, 31, 75));
        lblJudulHasil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJudulHasil.setText("Estimasi Ongkir");
        lblJudulHasil.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(lblNilaiTotalBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTotalBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pnlGarisHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(lblNilaiBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblBeratPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(lblNilaiJarak, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblJarakPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblJudulHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(pnlGarisHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblNilaiBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblBeratPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblNilaiJarak, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblJarakPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblJudulHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNilaiTotalBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblTotalBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        PanelCekTarif.setBackground(new java.awt.Color(255, 255, 255));
        PanelCekTarif.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PanelCekTarif.setPreferredSize(new java.awt.Dimension(353, 241));

        BtnHitungTarif.setBackground(new java.awt.Color(255, 107, 0));
        BtnHitungTarif.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        BtnHitungTarif.setForeground(new java.awt.Color(255, 255, 255));
        BtnHitungTarif.setText("Hitung Ongkir");
        BtnHitungTarif.setBorderPainted(false);
        BtnHitungTarif.setFocusPainted(false);
        BtnHitungTarif.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnHitungTarif.addActionListener(this::BtnHitungTarifActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(107, 122, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Berat harus lebih dari 0 kg dan maksimal 50 kg");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        InputKG.setForeground(new java.awt.Color(11, 31, 75));
        InputKG.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        InputKG.addActionListener(this::InputKGActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(11, 31, 75));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Berat Paket (kg)");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        BtnPilihJarak.setForeground(new java.awt.Color(11, 31, 75));
        BtnPilihJarak.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5 - 10 KM" }));
        BtnPilihJarak.addActionListener(this::BtnPilihJarakActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(11, 31, 75));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Pilih Jarak");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 31, 75));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Hitung Estimasi Ongkir");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PanelCekTarifLayout = new javax.swing.GroupLayout(PanelCekTarif);
        PanelCekTarif.setLayout(PanelCekTarifLayout);
        PanelCekTarifLayout.setHorizontalGroup(
            PanelCekTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelCekTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnHitungTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputKG, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPilihJarak, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PanelCekTarifLayout.setVerticalGroup(
            PanelCekTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(BtnHitungTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(InputKG, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(BtnPilihJarak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PBenner.setBackground(new java.awt.Color(11, 31, 75));
        PBenner.setPreferredSize(new java.awt.Dimension(1075, 142));

        lblMaskotTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaskotTeks.setForeground(new java.awt.Color(255, 255, 255));
        lblMaskotTeks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaskotTeks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JetySenyum.png"))); // NOI18N
        lblMaskotTeks.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(184, 196, 224));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Lihat estimasi ongkir untuk paket Anda dengan mudah");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pnlAksenHero.setBackground(new java.awt.Color(255, 107, 0));
        pnlAksenHero.setPreferredSize(new java.awt.Dimension(59, 3));

        javax.swing.GroupLayout pnlAksenHeroLayout = new javax.swing.GroupLayout(pnlAksenHero);
        pnlAksenHero.setLayout(pnlAksenHeroLayout);
        pnlAksenHeroLayout.setHorizontalGroup(
            pnlAksenHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        pnlAksenHeroLayout.setVerticalGroup(
            pnlAksenHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Cek Tarif");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PBennerLayout = new javax.swing.GroupLayout(PBenner);
        PBenner.setLayout(PBennerLayout);
        PBennerLayout.setHorizontalGroup(
            PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBennerLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(lblMaskotTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        PBennerLayout.setVerticalGroup(
            PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBennerLayout.createSequentialGroup()
                .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaskotTeks, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );

        PNavbar.setBackground(new java.awt.Color(255, 255, 255));
        PNavbar.setPreferredSize(new java.awt.Dimension(1075, 51));

        btnNavLogin.setBackground(new java.awt.Color(255, 107, 0));
        btnNavLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNavLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnNavLogin.setText("Login");
        btnNavLogin.setBorderPainted(false);
        btnNavLogin.setFocusPainted(false);
        btnNavLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavLogin.addActionListener(this::btnNavLoginActionPerformed);

        btnNavKonter.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavKonter.setForeground(new java.awt.Color(11, 31, 75));
        btnNavKonter.setText("Konter Kami");
        btnNavKonter.setBorderPainted(false);
        btnNavKonter.setContentAreaFilled(false);
        btnNavKonter.setFocusPainted(false);
        btnNavKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavKonter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavKonter.addActionListener(this::btnNavKonterActionPerformed);

        pnlNavAktif.setBackground(new java.awt.Color(255, 107, 0));
        pnlNavAktif.setPreferredSize(new java.awt.Dimension(57, 3));

        javax.swing.GroupLayout pnlNavAktifLayout = new javax.swing.GroupLayout(pnlNavAktif);
        pnlNavAktif.setLayout(pnlNavAktifLayout);
        pnlNavAktifLayout.setHorizontalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        pnlNavAktifLayout.setVerticalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btnNavTarif.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavTarif.setForeground(new java.awt.Color(255, 107, 0));
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

        btnNavBeranda.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavBeranda.setForeground(new java.awt.Color(11, 31, 75));
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
                .addGap(956, 956, 956)
                .addComponent(btnNavLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(707, 707, 707)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(620, 620, 620)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(615, 615, 615)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(btnNavLacak, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(11, 11, 11)
                .addComponent(btnNavLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavLacak, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(746, 746, 746)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPilihJarakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPilihJarakActionPerformed
        Object dipilih = BtnPilihJarak.getSelectedItem();

        if (dipilih != null) {
            pilihanJarak = dipilih.toString();
            lblJudulHasil.setText("Rentang jarak: " + pilihanJarak);
        }
    }//GEN-LAST:event_BtnPilihJarakActionPerformed

    private void InputKGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputKGActionPerformed
    BtnHitungTarifActionPerformed(evt);
    }//GEN-LAST:event_InputKGActionPerformed

    private void BtnHitungTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHitungTarifActionPerformed
    hitungTarif();
    }//GEN-LAST:event_BtnHitungTarifActionPerformed

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {
        tampilkanHalaman("menuUtama");
    }


    private void pindahHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
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

    private void btnNavLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavLoginActionPerformed
        pindahHalaman("login");
    }//GEN-LAST:event_btnNavLoginActionPerformed

        private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnHitungTarif;
    private javax.swing.JComboBox BtnPilihJarak;
    private javax.swing.JTextField InputKG;
    private javax.swing.JPanel PBenner;
    private javax.swing.JPanel PNavbar;
    private javax.swing.JPanel PanelCekTarif;
    private javax.swing.JButton btnNavBeranda;
    private javax.swing.JButton btnNavKonter;
    private javax.swing.JButton btnNavLacak;
    private javax.swing.JButton btnNavLogin;
    private javax.swing.JButton btnNavTarif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAjak1;
    private javax.swing.JLabel lblBeratPaket;
    private javax.swing.JLabel lblJarakPengiriman;
    private javax.swing.JLabel lblJudulHasil;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblMaskotTeks;
    private javax.swing.JLabel lblMaskotTeks2;
    private javax.swing.JLabel lblNilaiBerat;
    private javax.swing.JLabel lblNilaiJarak;
    private javax.swing.JLabel lblNilaiTotalBiaya;
    private javax.swing.JLabel lblTotalBiaya;
    private javax.swing.JPanel pnlAksenHero;
    private javax.swing.JPanel pnlGarisHasil;
    private javax.swing.JPanel pnlNavAktif;
    // End of variables declaration//GEN-END:variables
}
