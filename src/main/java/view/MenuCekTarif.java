/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.OngkirController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.InputHelper;
import util.Sesi;

public class MenuCekTarif extends javax.swing.JPanel {

    private final OngkirController ongkirController
            = new OngkirController();

public MenuCekTarif() {
    initComponents();
    aturTabel();
    tampilkanDataOngkir();
}

public void segarkanData() {
    tampilkanDataOngkir();
}
private void aturTabel() {
    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("ID Ongkir");
    model.addColumn("Jarak Min (km)");
    model.addColumn("Jarak Max (km)");
    model.addColumn("Tarif Dasar (Rp)");

    TCektarif.setModel(model);

    // Pengaturan tampilan tabel
    TCektarif.setRowHeight(30);
    TCektarif.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));

    TCektarif.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)
    );

    TCektarif.getTableHeader().setReorderingAllowed(false);
    TCektarif.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

    // Lebar kolom
    TCektarif.getColumnModel().getColumn(0).setPreferredWidth(70);
    TCektarif.getColumnModel().getColumn(1).setPreferredWidth(120);
    TCektarif.getColumnModel().getColumn(2).setPreferredWidth(120);
    TCektarif.getColumnModel().getColumn(3).setPreferredWidth(150);
}
private void tampilkanDataOngkir() {
    DefaultTableModel model = (DefaultTableModel) TCektarif.getModel();
    model.setRowCount(0);

    try {
        java.util.List<model.Ongkir> daftarOngkir =
                ongkirController.semuaModel();

        for (model.Ongkir ongkir : daftarOngkir) {
            model.addRow(ongkir.sebagaiBaris());
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal menampilkan data ongkir: " + e.getMessage()
        );
    }
}
private void tampilkanHalaman(String namaHalaman) {
    java.awt.Window window = SwingUtilities.getWindowAncestor(this);

    if (window instanceof MainFrame) {
        ((MainFrame) window).tampilkanHalaman(namaHalaman);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCekTarif = new javax.swing.JPanel();
        SCekTarif = new javax.swing.JScrollPane();
        TCektarif = new javax.swing.JTable();
        PHeaderAdmin = new javax.swing.JPanel();
        lblPeranHeader = new javax.swing.JLabel();
        lblNamaHeader = new javax.swing.JLabel();
        pnlAvatar = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblJudulHalaman = new javax.swing.JLabel();
        PMenu2 = new javax.swing.JPanel();
        BtnMenuUtama = new javax.swing.JButton();
        BtnLihatDafatrKonter = new javax.swing.JButton();
        BtnMenuCekTarif = new javax.swing.JButton();
        BtnLihatDataPengantaranPetugasKonter = new javax.swing.JButton();
        BtnMenuRiwayatPengiriman = new javax.swing.JButton();
        BtnMenuPengiriman = new javax.swing.JButton();
        lblPanelRole = new javax.swing.JLabel();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));

        PanelCekTarif.setBackground(new java.awt.Color(255, 255, 255));
        PanelCekTarif.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PanelCekTarif.setPreferredSize(new java.awt.Dimension(820, 415));
        PanelCekTarif.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                PanelCekTarifAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        SCekTarif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TCektarif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TCektarif.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TCektarif.setForeground(new java.awt.Color(11, 31, 75));
        TCektarif.setGridColor(new java.awt.Color(227, 232, 242));
        TCektarif.setRowHeight(24);
        TCektarif.setFillsViewportHeight(true);
        TCektarif.setSelectionBackground(new java.awt.Color(255, 240, 227));
        TCektarif.setSelectionForeground(new java.awt.Color(11, 31, 75));
        SCekTarif.setViewportView(TCektarif);

        javax.swing.GroupLayout PanelCekTarifLayout = new javax.swing.GroupLayout(PanelCekTarif);
        PanelCekTarif.setLayout(PanelCekTarifLayout);
        PanelCekTarifLayout.setHorizontalGroup(
            PanelCekTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(SCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelCekTarifLayout.setVerticalGroup(
            PanelCekTarifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCekTarifLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(SCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PHeaderAdmin.setBackground(new java.awt.Color(255, 255, 255));
        PHeaderAdmin.setPreferredSize(new java.awt.Dimension(874, 51));

        lblPeranHeader.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblPeranHeader.setForeground(new java.awt.Color(107, 122, 153));
        lblPeranHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPeranHeader.setText("Konter");
        lblPeranHeader.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblNamaHeader.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblNamaHeader.setForeground(new java.awt.Color(11, 31, 75));
        lblNamaHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNamaHeader.setText("Petugas Konter");
        lblNamaHeader.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pnlAvatar.setBackground(new java.awt.Color(255, 107, 0));
        pnlAvatar.setPreferredSize(new java.awt.Dimension(30, 26));

        lblAvatar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblAvatar.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatar.setText("A");
        lblAvatar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlAvatarLayout = new javax.swing.GroupLayout(pnlAvatar);
        pnlAvatar.setLayout(pnlAvatarLayout);
        pnlAvatarLayout.setHorizontalGroup(
            pnlAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlAvatarLayout.setVerticalGroup(
            pnlAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAvatarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblJudulHalaman.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblJudulHalaman.setForeground(new java.awt.Color(11, 31, 75));
        lblJudulHalaman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJudulHalaman.setText("Daftar Tarif Ongkir");
        lblJudulHalaman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PHeaderAdminLayout = new javax.swing.GroupLayout(PHeaderAdmin);
        PHeaderAdmin.setLayout(PHeaderAdminLayout);
        PHeaderAdminLayout.setHorizontalGroup(
            PHeaderAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(772, 772, 772)
                .addComponent(lblPeranHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(772, 772, 772)
                .addComponent(lblNamaHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(733, 733, 733)
                .addComponent(pnlAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblJudulHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PHeaderAdminLayout.setVerticalGroup(
            PHeaderAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblPeranHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblNamaHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblJudulHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PMenu2.setBackground(new java.awt.Color(11, 31, 75));
        PMenu2.setPreferredSize(new java.awt.Dimension(202, 568));

        BtnMenuUtama.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuUtama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconKeluar.png"))); // NOI18N
        BtnMenuUtama.setText("Keluar");
        BtnMenuUtama.setBorderPainted(false);
        BtnMenuUtama.setContentAreaFilled(false);
        BtnMenuUtama.setFocusPainted(false);
        BtnMenuUtama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuUtama.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuUtama.addActionListener(this::BtnMenuUtamaActionPerformed);

        BtnLihatDafatrKonter.setForeground(new java.awt.Color(184, 196, 224));
        BtnLihatDafatrKonter.setText("Konter");
        BtnLihatDafatrKonter.setBorderPainted(false);
        BtnLihatDafatrKonter.setContentAreaFilled(false);
        BtnLihatDafatrKonter.setFocusPainted(false);
        BtnLihatDafatrKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLihatDafatrKonter.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnLihatDafatrKonter.addActionListener(this::BtnLihatDafatrKonterActionPerformed);

        BtnMenuCekTarif.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuCekTarif.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuCekTarif.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuCekTarif.setText("Ongkir");
        BtnMenuCekTarif.setBorderPainted(false);
        BtnMenuCekTarif.setFocusPainted(false);
        BtnMenuCekTarif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuCekTarif.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuCekTarif.addActionListener(this::BtnMenuCekTarifActionPerformed);

        BtnLihatDataPengantaranPetugasKonter.setForeground(new java.awt.Color(184, 196, 224));
        BtnLihatDataPengantaranPetugasKonter.setText("Pengantaran");
        BtnLihatDataPengantaranPetugasKonter.setBorderPainted(false);
        BtnLihatDataPengantaranPetugasKonter.setContentAreaFilled(false);
        BtnLihatDataPengantaranPetugasKonter.setFocusPainted(false);
        BtnLihatDataPengantaranPetugasKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLihatDataPengantaranPetugasKonter.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnLihatDataPengantaranPetugasKonter.addActionListener(this::BtnLihatDataPengantaranPetugasKonterActionPerformed);

        BtnMenuRiwayatPengiriman.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuRiwayatPengiriman.setText("Riwayat Pelacakan");
        BtnMenuRiwayatPengiriman.setBorderPainted(false);
        BtnMenuRiwayatPengiriman.setContentAreaFilled(false);
        BtnMenuRiwayatPengiriman.setFocusPainted(false);
        BtnMenuRiwayatPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuRiwayatPengiriman.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuRiwayatPengiriman.addActionListener(this::BtnMenuRiwayatPengirimanActionPerformed);

        BtnMenuPengiriman.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuPengiriman.setText("Pengiriman");
        BtnMenuPengiriman.setBorderPainted(false);
        BtnMenuPengiriman.setContentAreaFilled(false);
        BtnMenuPengiriman.setFocusPainted(false);
        BtnMenuPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuPengiriman.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuPengiriman.addActionListener(this::BtnMenuPengirimanActionPerformed);

        lblPanelRole.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblPanelRole.setForeground(new java.awt.Color(184, 196, 224));
        lblPanelRole.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPanelRole.setText("Panel Petugas Konter");
        lblPanelRole.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblLogoExpress.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogoExpress.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoExpress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoExpress.setText("Express");
        lblLogoExpress.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblLogoJet.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogoJet.setForeground(new java.awt.Color(255, 107, 0));
        lblLogoJet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoJet.setText("Jet");
        lblLogoJet.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PMenu2Layout = new javax.swing.GroupLayout(PMenu2);
        PMenu2.setLayout(PMenu2Layout);
        PMenu2Layout.setHorizontalGroup(
            PMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnLihatDafatrKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnLihatDataPengantaranPetugasKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuRiwayatPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblPanelRole, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PMenu2Layout.setVerticalGroup(
            PMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(BtnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(BtnLihatDafatrKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(BtnMenuCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(BtnLihatDataPengantaranPetugasKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(BtnMenuRiwayatPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(BtnMenuPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblPanelRole, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(PanelCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(PanelCekTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PanelCekTarifAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_PanelCekTarifAncestorAdded
        
    }//GEN-LAST:event_PanelCekTarifAncestorAdded

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
            if (Sesi.getSesi().sudahLogin()) {
            boolean ya = InputHelper.konfirmasi(this,
                "Keluar dari akun dan kembali ke menu utama?");

            if (!ya) {
                return;
            }

            Sesi.logout();
        }

        tampilkanHalaman("menuUtama");
    }//GEN-LAST:event_BtnMenuUtamaActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        tampilkanHalaman("menuKelolaPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
        tampilkanHalaman("menuKelolaRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnLihatDataPengantaranPetugasKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatDataPengantaranPetugasKonterActionPerformed
         tampilkanHalaman("menuKelolaPengantaran");
    }//GEN-LAST:event_BtnLihatDataPengantaranPetugasKonterActionPerformed

    private void BtnMenuCekTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuCekTarifActionPerformed
    
    }//GEN-LAST:event_BtnMenuCekTarifActionPerformed

    private void BtnLihatDafatrKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatDafatrKonterActionPerformed
        tampilkanHalaman("menuKelolaKonter");
    }//GEN-LAST:event_BtnLihatDafatrKonterActionPerformed


    private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLihatDafatrKonter;
    private javax.swing.JButton BtnLihatDataPengantaranPetugasKonter;
    private javax.swing.JButton BtnMenuCekTarif;
    private javax.swing.JButton BtnMenuPengiriman;
    private javax.swing.JButton BtnMenuRiwayatPengiriman;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenu2;
    private javax.swing.JPanel PanelCekTarif;
    private javax.swing.JScrollPane SCekTarif;
    private javax.swing.JTable TCektarif;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelRole;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}
