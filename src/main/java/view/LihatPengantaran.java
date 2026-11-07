/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.InputHelper;
import util.Sesi;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.math.BigDecimal;
import javax.swing.JDialog;
import util.ValidasiKoordinat;
import javax.swing.JOptionPane;

public class LihatPengantaran extends javax.swing.JPanel {

    private final controller.PengantaranController pengantaranController =
            new controller.PengantaranController();

    private final List<Object[]> dataTugas = new ArrayList<>();

    public LihatPengantaran() {
        initComponents();
        pasangAksiTombol();
        aturTabel();
        tampilDataPengantaran();
    }

    private void pasangAksiTombol() {
        BtnUbah.addActionListener(evt -> ubahStatusTerpilih());
        BtnMenuKonter.addActionListener(evt ->
                tampilkanHalaman("lihatDaftarKonter"));
        BtnLihatPengantaran.addActionListener(evt ->
                tampilDataPengantaran());
    }

    public void tampilDataPengantaran() {
        DefaultTableModel model =
                (DefaultTableModel) TDataPengiriman.getModel();
        model.setRowCount(0);
        dataTugas.clear();

        try {
            List<Object[]> data = pengantaranController.tampilkan();

            Sesi sesi = Sesi.getSesi();
            boolean saringKurir = sesi.isKurir()
                    && sesi.getNama() != null;

            for (Object[] baris : data) {
                if (saringKurir && !sesi.getNama().equalsIgnoreCase(
                        String.valueOf(baris[2]))) {
                    continue;
                }
                dataTugas.add(baris);
                model.addRow(baris);
            }

        } catch (IllegalArgumentException | IllegalStateException e) {
            InputHelper.pesanPeringatan(this, e.getMessage());
        } catch (Exception e) {
            InputHelper.pesanError(this,
                "Gagal memuat daftar pengantaran: " + e.getMessage());
        }
    }

    
    private void tampilkanPetaTujuan(
        BigDecimal latitude,
        BigDecimal longitude,
        String noResi) {

    PanelPeta peta = new PanelPeta();
    peta.setPreferredSize(new java.awt.Dimension(560, 420));
    peta.setModeLihatSaja(true);
    peta.setPosisi(latitude, longitude);

    java.awt.Window pemilik = SwingUtilities.getWindowAncestor(this);
    JDialog dialog = new JDialog(
            pemilik,
            "Peta Lokasi Tujuan - " + noResi,
            Dialog.ModalityType.APPLICATION_MODAL);

    dialog.setLayout(new BorderLayout());
    dialog.add(peta, BorderLayout.CENTER);
    dialog.pack();
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
}
    


    private boolean mengandung(Object nilai, String keyword) {
        return nilai != null
                && nilai.toString().toLowerCase().contains(keyword);
    }

    private void ubahStatusTerpilih() {
        int baris = TDataPengiriman.getSelectedRow();

        if (baris == -1) {
            InputHelper.pesanPeringatan(this,
                "Pilih tugas pengantaran yang akan diubah statusnya.");
            return;
        }

        int barisModel = TDataPengiriman.convertRowIndexToModel(baris);

        int idPengantaran = Integer.parseInt(
                TDataPengiriman.getModel()
                        .getValueAt(barisModel, 0).toString());

        MainFrame main = (MainFrame)
                SwingUtilities.getWindowAncestor(this);

        if (main != null) {
            main.bukaUbahStatusPengantaran(idPengantaran);
        }
    }

    private void aturTabel() {
        int[] lebarKolom = {
            45,  
            130,
            150, 
            110, 
            150,
            120, 
            120, 
            180, 
            220 
        };

        TDataPengiriman.setAutoResizeMode(
                javax.swing.JTable.AUTO_RESIZE_OFF);
        TDataPengiriman.setDefaultEditor(Object.class, null);

        for (int i = 0; i < lebarKolom.length; i++) {
            TDataPengiriman.getColumnModel()
                    .getColumn(i)
                    .setPreferredWidth(lebarKolom[i]);
        }

        TDataPengiriman.setRowHeight(28);
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

        PTabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TDataPengiriman = new javax.swing.JTable();
        BtnUbah = new javax.swing.JButton();
        BtnLihatPeta = new javax.swing.JButton();
        PHeaderAdmin = new javax.swing.JPanel();
        lblPeranHeader = new javax.swing.JLabel();
        lblNamaHeader = new javax.swing.JLabel();
        pnlAvatar = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblJudulHalaman = new javax.swing.JLabel();
        PMenu2 = new javax.swing.JPanel();
        BtnMenuUtama = new javax.swing.JButton();
        BtnLihatPengantaran = new javax.swing.JButton();
        BtnMenuKonter = new javax.swing.JButton();
        lblPanelRole = new javax.swing.JLabel();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();
        BtnLihatGambar = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 247, 251));

        PTabel.setBackground(new java.awt.Color(255, 255, 255));
        PTabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PTabel.setPreferredSize(new java.awt.Dimension(820, 381));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TDataPengiriman.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TDataPengiriman.setForeground(new java.awt.Color(11, 31, 75));
        TDataPengiriman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No. Resi", "Kurir", "Tgl Tugas", "Status", "Latitude", "Longitude", "Bukti Foto", "Catatan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TDataPengiriman.setFillsViewportHeight(true);
        TDataPengiriman.setGridColor(new java.awt.Color(227, 232, 242));
        TDataPengiriman.setRowHeight(21);
        TDataPengiriman.setSelectionBackground(new java.awt.Color(255, 240, 227));
        TDataPengiriman.setSelectionForeground(new java.awt.Color(11, 31, 75));
        jScrollPane1.setViewportView(TDataPengiriman);

        javax.swing.GroupLayout PTabelLayout = new javax.swing.GroupLayout(PTabel);
        PTabel.setLayout(PTabelLayout);
        PTabelLayout.setHorizontalGroup(
            PTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTabelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PTabelLayout.setVerticalGroup(
            PTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTabelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BtnUbah.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnUbah.setForeground(new java.awt.Color(37, 99, 235));
        BtnUbah.setText("Ubah Status");
        BtnUbah.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnUbah.setFocusPainted(false);
        BtnUbah.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnUbah.addActionListener(this::BtnUbahActionPerformed);

        BtnLihatPeta.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnLihatPeta.setForeground(new java.awt.Color(11, 31, 75));
        BtnLihatPeta.setText("Lihat Peta");
        BtnLihatPeta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnLihatPeta.setFocusPainted(false);
        BtnLihatPeta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnLihatPeta.addActionListener(this::BtnLihatPetaActionPerformed);

        PHeaderAdmin.setBackground(new java.awt.Color(255, 255, 255));
        PHeaderAdmin.setPreferredSize(new java.awt.Dimension(874, 51));

        lblPeranHeader.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblPeranHeader.setForeground(new java.awt.Color(107, 122, 153));
        lblPeranHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPeranHeader.setText("Pengantar");
        lblPeranHeader.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblNamaHeader.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblNamaHeader.setForeground(new java.awt.Color(11, 31, 75));
        lblNamaHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNamaHeader.setText("Kurir");
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
        lblJudulHalaman.setText("Lihat Tugas Pengantaran");
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

        BtnLihatPengantaran.setBackground(new java.awt.Color(255, 107, 0));
        BtnLihatPengantaran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnLihatPengantaran.setForeground(new java.awt.Color(255, 255, 255));
        BtnLihatPengantaran.setText("Tugas Pengantaran");
        BtnLihatPengantaran.setBorderPainted(false);
        BtnLihatPengantaran.setFocusPainted(false);
        BtnLihatPengantaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLihatPengantaran.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnLihatPengantaran.addActionListener(this::BtnLihatPengantaranActionPerformed);

        BtnMenuKonter.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuKonter.setText("Konter Kami");
        BtnMenuKonter.setBorderPainted(false);
        BtnMenuKonter.setContentAreaFilled(false);
        BtnMenuKonter.setFocusPainted(false);
        BtnMenuKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuKonter.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuKonter.addActionListener(this::BtnMenuKonterActionPerformed);

        lblPanelRole.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblPanelRole.setForeground(new java.awt.Color(184, 196, 224));
        lblPanelRole.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPanelRole.setText("Panel Kurir");
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
                .addComponent(BtnLihatPengantaran, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(102, 102, 102)
                .addComponent(BtnLihatPengantaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenu2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(BtnMenuKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        BtnLihatGambar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnLihatGambar.setForeground(new java.awt.Color(11, 31, 75));
        BtnLihatGambar.setText("Lihat Gambar");
        BtnLihatGambar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnLihatGambar.setFocusPainted(false);
        BtnLihatGambar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnLihatGambar.setMinimumSize(new java.awt.Dimension(84, 28));
        BtnLihatGambar.setPreferredSize(new java.awt.Dimension(84, 28));
        BtnLihatGambar.addActionListener(this::BtnLihatGambarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnLihatGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLihatPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PTabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnLihatPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnLihatGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
        // Keluar dari akun (bila sedang login) lalu kembali ke
        // menu utama.
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

    private void BtnMenuKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuKonterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnMenuKonterActionPerformed

    private void BtnLihatPetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatPetaActionPerformed
        int baris = TDataPengiriman.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
                "Pilih data pengantaran terlebih dahulu!");
        return;
    }

    int barisModel =
            TDataPengiriman.convertRowIndexToModel(baris);

    Object latitudeObj = TDataPengiriman.getModel()
            .getValueAt(barisModel, 5);

    Object longitudeObj = TDataPengiriman.getModel()
            .getValueAt(barisModel, 6);

    if (latitudeObj == null || longitudeObj == null
            || latitudeObj.toString().isBlank()
            || longitudeObj.toString().isBlank()) {
        JOptionPane.showMessageDialog(this,
                "Koordinat lokasi belum tersedia!");
        return;
    }

    try {
        BigDecimal latitude =
                ValidasiKoordinat.parseLatitude(
                        latitudeObj.toString());

        BigDecimal longitude =
                ValidasiKoordinat.parseLongitude(
                        longitudeObj.toString());

        ValidasiKoordinat.validasi(latitude, longitude);

        Object resi = TDataPengiriman.getModel()
                .getValueAt(barisModel, 1);

        tampilkanPetaTujuan(
                latitude,
                longitude,
                resi == null ? "-" : resi.toString());

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Gagal membuka peta: " + e.getMessage());
    }
    }//GEN-LAST:event_BtnLihatPetaActionPerformed


    private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }


    private void BtnLihatPengantaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatPengantaranActionPerformed
        bukaHalaman("lihatPengantaran");
    }//GEN-LAST:event_BtnLihatPengantaranActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void BtnLihatGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatGambarActionPerformed
        int baris = TDataPengiriman.getSelectedRow();

        if (baris == -1) {
            InputHelper.pesanPeringatan(this,
                "Pilih data pengantaran terlebih dahulu!");
            return;
        }

        try {
            int barisModel = TDataPengiriman.convertRowIndexToModel(baris);
            Object bukti = TDataPengiriman.getModel()
            .getValueAt(barisModel, 7);

            // Berkas dibaca dari folder package image; pesan khusus
            // tampil bila kosong, hilang, atau rusak.
            image.ImageManager.lihatGambar(this,
                bukti == null ? null : bukti.toString());

        } catch (Exception e) {
            InputHelper.pesanError(this,
                "Gagal membuka gambar: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnLihatGambarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLihatGambar;
    private javax.swing.JButton BtnLihatPengantaran;
    private javax.swing.JButton BtnLihatPeta;
    private javax.swing.JButton BtnMenuKonter;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenu2;
    private javax.swing.JPanel PTabel;
    private javax.swing.JTable TDataPengiriman;
    private javax.swing.JScrollPane jScrollPane1;
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
