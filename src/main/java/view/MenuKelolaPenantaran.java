/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.PengantaranController;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.InputHelper;
import util.Sesi;
import util.ValidasiKoordinat;

public class MenuKelolaPenantaran extends javax.swing.JPanel {

    private final PengantaranController pengantaranController
            = new PengantaranController();

    public MenuKelolaPenantaran() {
        initComponents();

        aturTabel();
        tampilkanDataPengantaran();

    }

    public void segarkanData() {
        tampilkanDataPengantaran();
    }

    private void aturTabel() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{
                    "ID", "No. Resi", "Kurir",
                    "Tanggal Tugas", "Status",
                    "Latitude", "Longitude",
                    "Bukti Foto", "Catatan Kurir"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TDataPengantaran.setModel(model);
        TDataPengantaran.setRowHeight(25);
    }

    private void tampilkanDataPengantaran() {
        DefaultTableModel model = (DefaultTableModel)
                TDataPengantaran.getModel();

        model.setRowCount(0);

        try {
            List<Object[]> daftar =
                    pengantaranController.tampilkan();

            for (Object[] baris : daftar) {
                model.addRow(baris);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal menampilkan data pengantaran: "
                    + e.getMessage(),
                    "Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanPetaTujuan(BigDecimal latitude,
        BigDecimal longitude, String noResi) {
    PanelPeta peta = new PanelPeta();
    peta.setPreferredSize(new java.awt.Dimension(560, 420));
    peta.setModeLihatSaja(true);

    peta.setPosisi(latitude, longitude);

    java.awt.Window pemilik = SwingUtilities.getWindowAncestor(this);
    JDialog dialog = new JDialog(pemilik,
            "Peta Lokasi Tujuan - " + noResi,
            Dialog.ModalityType.APPLICATION_MODAL);
    dialog.setLayout(new BorderLayout());
    dialog.add(peta, BorderLayout.CENTER);
    dialog.pack();
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
}
    private void cariPengantaran() {
        String keyword = FCari.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Masukkan resi, nama kurir, atau status "
                    + "yang ingin dicari!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel)
                TDataPengantaran.getModel();

        model.setRowCount(0);

        try {
            List<Object[]> daftar =
                    pengantaranController.cari(keyword);

            if (daftar.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Data pengantaran dengan kata kunci \""
                        + keyword + "\" tidak ditemukan.",
                        "Hasil Pencarian",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            for (Object[] baris : daftar) {
                model.addRow(baris);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal mencari data pengantaran: "
                    + e.getMessage(),
                    "Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanHalaman(String namaHalaman) {
        java.awt.Window window =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        if (window instanceof MainFrame) {
            ((MainFrame) window).tampilkanHalaman(namaHalaman);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TDataPengantaran = new javax.swing.JTable();
        BtnLihatPeta = new javax.swing.JButton();
        BtnCari = new javax.swing.JButton();
        FCari = new javax.swing.JTextField();
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
        lblPeranHeader1 = new javax.swing.JLabel();
        BtnLihatGambar = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 247, 251));

        PTabel.setBackground(new java.awt.Color(255, 255, 255));
        PTabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PTabel.setPreferredSize(new java.awt.Dimension(820, 381));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TDataPengantaran.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TDataPengantaran.setForeground(new java.awt.Color(11, 31, 75));
        TDataPengantaran.setModel(new javax.swing.table.DefaultTableModel(
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
        TDataPengantaran.setFillsViewportHeight(true);
        TDataPengantaran.setGridColor(new java.awt.Color(227, 232, 242));
        TDataPengantaran.setRowHeight(21);
        TDataPengantaran.setSelectionBackground(new java.awt.Color(255, 240, 227));
        TDataPengantaran.setSelectionForeground(new java.awt.Color(11, 31, 75));
        jScrollPane1.setViewportView(TDataPengantaran);

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

        BtnLihatPeta.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnLihatPeta.setForeground(new java.awt.Color(11, 31, 75));
        BtnLihatPeta.setText("Lihat Peta");
        BtnLihatPeta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnLihatPeta.setFocusPainted(false);
        BtnLihatPeta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnLihatPeta.addActionListener(this::BtnLihatPetaActionPerformed);

        BtnCari.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnCari.setForeground(new java.awt.Color(11, 31, 75));
        BtnCari.setText("Cari");
        BtnCari.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnCari.setFocusPainted(false);
        BtnCari.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnCari.addActionListener(this::BtnCariActionPerformed);

        FCari.setForeground(new java.awt.Color(11, 31, 75));
        FCari.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FCari.addActionListener(this::FCariActionPerformed);

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
        lblJudulHalaman.setText("Daftar Pengantaran");
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

        BtnMenuCekTarif.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuCekTarif.setText("Ongkir");
        BtnMenuCekTarif.setBorderPainted(false);
        BtnMenuCekTarif.setContentAreaFilled(false);
        BtnMenuCekTarif.setFocusPainted(false);
        BtnMenuCekTarif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuCekTarif.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuCekTarif.addActionListener(this::BtnMenuCekTarifActionPerformed);

        BtnLihatDataPengantaranPetugasKonter.setBackground(new java.awt.Color(255, 107, 0));
        BtnLihatDataPengantaranPetugasKonter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnLihatDataPengantaranPetugasKonter.setForeground(new java.awt.Color(255, 255, 255));
        BtnLihatDataPengantaranPetugasKonter.setText("Pengantaran");
        BtnLihatDataPengantaranPetugasKonter.setBorderPainted(false);
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

        lblPeranHeader1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblPeranHeader1.setForeground(new java.awt.Color(107, 122, 153));
        lblPeranHeader1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPeranHeader1.setText("Masukkan No Resi");
        lblPeranHeader1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        BtnLihatGambar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnLihatGambar.setForeground(new java.awt.Color(11, 31, 75));
        BtnLihatGambar.setText("Lihat Gambar");
        BtnLihatGambar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnLihatGambar.setFocusPainted(false);
        BtnLihatGambar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnLihatGambar.addActionListener(this::BtnLihatGambarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblPeranHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(202, 202, 202)
                                    .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(FCari, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnLihatGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnLihatPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29))))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(228, 228, 228)
                    .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPeranHeader1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnLihatGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnLihatPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        cariPengantaran();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void FCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FCariActionPerformed
        cariPengantaran();
    }//GEN-LAST:event_FCariActionPerformed

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

    }//GEN-LAST:event_BtnLihatDataPengantaranPetugasKonterActionPerformed

    private void BtnMenuCekTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuCekTarifActionPerformed
        tampilkanHalaman("menuCekTarif");
    }//GEN-LAST:event_BtnMenuCekTarifActionPerformed

    private void BtnLihatDafatrKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatDafatrKonterActionPerformed
        tampilkanHalaman("menuKelolaKonter");
    }//GEN-LAST:event_BtnLihatDafatrKonterActionPerformed

    private void BtnLihatPetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatPetaActionPerformed
        int baris = TDataPengantaran.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
                "Pilih data pengantaran terlebih dahulu!");
        return;
    }

    int barisModel =
            TDataPengantaran.convertRowIndexToModel(baris);

    Object latitudeObj = TDataPengantaran.getModel()
            .getValueAt(barisModel, 5);

    Object longitudeObj = TDataPengantaran.getModel()
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

        Object resi = TDataPengantaran.getModel()
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

    private void BtnLihatGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatGambarActionPerformed
    int baris = TDataPengantaran.getSelectedRow();

    if (baris == -1) {
        InputHelper.pesanPeringatan(this,
                "Pilih data pengantaran terlebih dahulu!");
        return;
    }

    try {
        int barisModel =
                TDataPengantaran.convertRowIndexToModel(baris);

        Object bukti = TDataPengantaran.getModel()
                .getValueAt(barisModel, 7);

        if (bukti == null
                || bukti.toString().trim().isEmpty()
                || "null".equalsIgnoreCase(bukti.toString().trim())) {

            InputHelper.pesanPeringatan(this,
                    "Bukti foto pengantaran belum tersedia!");
            return;
        }

        image.ImageManager.lihatGambar(
                this, bukti.toString().trim());

    } catch (Exception e) {
        InputHelper.pesanError(this,
                "Gagal membuka gambar: " + e.getMessage());
    }
    }//GEN-LAST:event_BtnLihatGambarActionPerformed


    private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnLihatDafatrKonter;
    private javax.swing.JButton BtnLihatDataPengantaranPetugasKonter;
    private javax.swing.JButton BtnLihatGambar;
    private javax.swing.JButton BtnLihatPeta;
    private javax.swing.JButton BtnMenuCekTarif;
    private javax.swing.JButton BtnMenuPengiriman;
    private javax.swing.JButton BtnMenuRiwayatPengiriman;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JTextField FCari;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenu2;
    private javax.swing.JPanel PTabel;
    private javax.swing.JTable TDataPengantaran;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelRole;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JLabel lblPeranHeader1;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}
