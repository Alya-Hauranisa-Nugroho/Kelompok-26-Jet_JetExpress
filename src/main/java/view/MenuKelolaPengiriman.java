/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.PengirimanController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import util.InputHelper;
import util.Sesi;

public class MenuKelolaPengiriman extends javax.swing.JPanel {

    private final PengirimanController pengirimanController
            = new PengirimanController();
    public MenuKelolaPengiriman() {
    initComponents();
    aturTabel();
    tampilkanDataPengiriman();


}

public void segarkanData() {
    tampilkanDataPengiriman();
}
private void aturTabel() {
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{
            "No", "No. Resi", "Barang", "Berat (KG)",
            "Pengirim", "Penerima", "Jenis", "Konter",
            "Biaya (Rp)", "Bayar", "COD",
            "Estimasi Kirim", "Status"
        }, 0
    );

    TDataPengiriman.setModel(model);

    TDataPengiriman.setRowHeight(25);

    javax.swing.table.DefaultTableCellRenderer tengah =
        new javax.swing.table.DefaultTableCellRenderer();

    tengah.setHorizontalAlignment(0);

    TDataPengiriman.getColumnModel()
        .getColumn(0).setCellRenderer(tengah);

    javax.swing.table.DefaultTableCellRenderer header =
        (javax.swing.table.DefaultTableCellRenderer)
        TDataPengiriman.getTableHeader().getDefaultRenderer();

    header.setHorizontalAlignment(0);

    // Lebar kolom tetap
    int[] lebarKolom = {
        45, 120, 120, 85, 130, 130, 90,
        210, 110, 80, 80, 180, 170
    };

    for (int i = 0; i < lebarKolom.length; i++) {
        TDataPengiriman.getColumnModel()
            .getColumn(i).setPreferredWidth(lebarKolom[i]);

        TDataPengiriman.getColumnModel()
            .getColumn(i).setMinWidth(lebarKolom[i]);

        TDataPengiriman.getColumnModel()
            .getColumn(i).setMaxWidth(lebarKolom[i]);
    }

    TDataPengiriman.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_OFF
    );

    jScrollPane1.setHorizontalScrollBarPolicy(32);
    jScrollPane1.setVerticalScrollBarPolicy(20);

    TDataPengiriman.getTableHeader().setResizingAllowed(false);
    TDataPengiriman.getTableHeader().setReorderingAllowed(false);
}
private void tampilkanDataPengiriman() {
    DefaultTableModel model =
            (DefaultTableModel) TDataPengiriman.getModel();

    model.setRowCount(0);

    try {
        List<Object[]> data = pengirimanController.tampilkan();

        int no = 1;
        for (Object[] baris : data) {
            model.addRow(new Object[]{
                no++,
                baris[0], baris[1], baris[2],
                baris[3], baris[4], baris[5],
                baris[6], baris[7], baris[8],
                baris[9], baris[10], baris[11]
            });
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Gagal menampilkan data pengiriman: " + e.getMessage());
    }
}

private void cariPengiriman() {
    String keyword = FCari.getText().trim();

    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Masukkan resi, nama barang, pengirim, "
                + "atau penerima yang ingin dicari!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    DefaultTableModel model =
            (DefaultTableModel) TDataPengiriman.getModel();

    model.setRowCount(0);

    try {
        List<Object[]> data = pengirimanController.cari(keyword);

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Data pengiriman dengan kata kunci \""
                    + keyword + "\" tidak ditemukan.",
                    "Hasil Pencarian",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        int no = 1;
        for (Object[] baris : data) {
            model.addRow(new Object[]{
                no++,
                baris[0], baris[1], baris[2],
                baris[3], baris[4], baris[5],
                baris[6], baris[7], baris[8],
                baris[9], baris[10], baris[11]
            });
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Gagal mencari data pengiriman: " + e.getMessage());
    }
}

private void tampilkanHalaman(String namaHalaman) {
    MainFrame main = (MainFrame) javax.swing.SwingUtilities
            .getWindowAncestor(this);

    if (main != null) {
        main.tampilkanHalaman(namaHalaman);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TDataPengiriman = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BtnTambahData = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnRefresh = new javax.swing.JButton();
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
        lblPeranHeader2 = new javax.swing.JLabel();

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
                "No", "No. Resi", "Barang", "Berat (KG)", "Pengirim", "Penerima", "Jenis", "Konter", "Biaya (Rp)", "Bayar", "COD", "Estimasi Kirim", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(437, 28));

        BtnTambahData.setBackground(new java.awt.Color(255, 107, 0));
        BtnTambahData.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnTambahData.setForeground(new java.awt.Color(255, 255, 255));
        BtnTambahData.setText("+ Tambah");
        BtnTambahData.setBorderPainted(false);
        BtnTambahData.setFocusPainted(false);
        BtnTambahData.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnTambahData.addActionListener(this::BtnTambahDataActionPerformed);

        BtnUbah.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnUbah.setForeground(new java.awt.Color(37, 99, 235));
        BtnUbah.setText("Ubah");
        BtnUbah.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnUbah.setFocusPainted(false);
        BtnUbah.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnUbah.addActionListener(this::BtnUbahActionPerformed);

        BtnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnRefresh.setForeground(new java.awt.Color(11, 31, 75));
        BtnRefresh.setText("Refresh");
        BtnRefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnRefresh.setFocusPainted(false);
        BtnRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnRefresh.addActionListener(this::BtnRefreshActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnTambahData, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnTambahData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        BtnCari.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnCari.setForeground(new java.awt.Color(11, 31, 75));
        BtnCari.setText("Cari");
        BtnCari.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnCari.setFocusPainted(false);
        BtnCari.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnCari.addActionListener(this::BtnCariActionPerformed);

        FCari.setForeground(new java.awt.Color(11, 31, 75));
        FCari.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

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
        lblJudulHalaman.setText("Kelola Pengiriman");
        lblJudulHalaman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PHeaderAdminLayout = new javax.swing.GroupLayout(PHeaderAdmin);
        PHeaderAdmin.setLayout(PHeaderAdminLayout);
        PHeaderAdminLayout.setHorizontalGroup(
            PHeaderAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHeaderAdminLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblJudulHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PHeaderAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PHeaderAdminLayout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(lblPeranHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PHeaderAdminLayout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(lblNamaHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PHeaderAdminLayout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(pnlAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
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

        BtnMenuPengiriman.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuPengiriman.setText("Pengiriman");
        BtnMenuPengiriman.setBorderPainted(false);
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

        lblPeranHeader2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblPeranHeader2.setForeground(new java.awt.Color(107, 122, 153));
        lblPeranHeader2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPeranHeader2.setText("Masukkan No Resi");
        lblPeranHeader2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(612, 612, 612)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(489, 489, 489)
                .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPeranHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FCari, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(365, 365, 365)
                    .addComponent(lblPeranHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(366, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPeranHeader2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(276, 276, 276)
                    .addComponent(lblPeranHeader1)
                    .addContainerGap(277, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        cariPengiriman();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
       FCari.setText("");
        tampilkanDataPengiriman();
    }//GEN-LAST:event_BtnRefreshActionPerformed

    private void BtnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahDataActionPerformed
      tampilkanHalaman("menuTambahPengirimanKonter");
    }//GEN-LAST:event_BtnTambahDataActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
    int baris = TDataPengiriman.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
            "Pilih data pengiriman yang ingin diubah!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    String noResi = TDataPengiriman.getValueAt(baris, 1).toString();

    MainFrame main = (MainFrame) javax.swing.SwingUtilities
            .getWindowAncestor(this);

    if (main != null) {
        main.bukaFormUbahPengirimanKonter(noResi);
    }
    }//GEN-LAST:event_BtnUbahActionPerformed

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
        
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
        tampilkanHalaman("menuKelolaRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnLihatDataPengantaranPetugasKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatDataPengantaranPetugasKonterActionPerformed
        tampilkanHalaman("menuKelolaPengantaran");
    }//GEN-LAST:event_BtnLihatDataPengantaranPetugasKonterActionPerformed

    private void BtnMenuCekTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuCekTarifActionPerformed
        tampilkanHalaman("menuCekTarif");
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
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnLihatDafatrKonter;
    private javax.swing.JButton BtnLihatDataPengantaranPetugasKonter;
    private javax.swing.JButton BtnMenuCekTarif;
    private javax.swing.JButton BtnMenuPengiriman;
    private javax.swing.JButton BtnMenuRiwayatPengiriman;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JButton BtnRefresh;
    private javax.swing.JButton BtnTambahData;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JTextField FCari;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenu2;
    private javax.swing.JPanel PTabel;
    private javax.swing.JTable TDataPengiriman;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelRole;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JLabel lblPeranHeader1;
    private javax.swing.JLabel lblPeranHeader2;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}
