
package view;

import controller.PengantaranController;
import java.awt.Dialog;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import util.InputHelper;
import util.Sesi;
import util.ValidasiKoordinat;

public class KelolaPengantaran extends javax.swing.JPanel {

    private final PengantaranController pengantaranController
            = new PengantaranController();

    
public KelolaPengantaran() {
    initComponents();
    aturTabel();
    tampilDataPengantaran();
}

public void tampilDataPengantaran() {
    DefaultTableModel model = (DefaultTableModel) TDataPengiriman.getModel();
    model.setRowCount(0);

    try {
        List<Object[]> daftar = pengantaranController.tampilkan();

        for (Object[] baris : daftar) {
            model.addRow(baris);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Gagal menampilkan data: " + e.getMessage());
    }
}

public void segarkanData() {
    tampilDataPengantaran();
}

private void cariDataPengantaran() {
    String keyword = FCari.getText().trim();

    DefaultTableModel model = (DefaultTableModel) TDataPengiriman.getModel();
    model.setRowCount(0);

    try {
        List<Object[]> daftar = pengantaranController.cari(keyword);

        for (Object[] baris : daftar) {
            model.addRow(baris);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Gagal mencari data: " + e.getMessage());
    }
}

private void hapusDataPengantaran(int idPengantaran) {
    try {
        boolean berhasil = pengantaranController.hapus(idPengantaran);

        if (berhasil) {
            JOptionPane.showMessageDialog(this,
                    "Data pengantaran berhasil dihapus!");

            tampilDataPengantaran();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Data pengantaran tidak ditemukan!");
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Gagal menghapus data: " + e.getMessage());
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

private void tampilkanHalaman(String namaHalaman) {
    MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);

    if (frame != null) {
        frame.tampilkanHalaman(namaHalaman);
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

    for (int i = 0; i < lebarKolom.length; i++) {
        TDataPengiriman.getColumnModel()
                .getColumn(i)
                .setPreferredWidth(lebarKolom[i]);
    }

    DefaultTableCellRenderer tengah =
            new DefaultTableCellRenderer();
    tengah.setHorizontalAlignment(SwingConstants.CENTER);

    TDataPengiriman.getColumnModel()
            .getColumn(0)
            .setCellRenderer(tengah);

    DefaultTableCellRenderer kiri =
            new DefaultTableCellRenderer();
    kiri.setHorizontalAlignment(SwingConstants.LEFT);

    for (int i = 1; i < TDataPengiriman.getColumnCount(); i++) {
        TDataPengiriman.getColumnModel()
                .getColumn(i)
                .setCellRenderer(kiri);
    }

    TDataPengiriman.setRowHeight(28);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TDataPengiriman = new javax.swing.JTable();
        BtnTambah = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnRefresh = new javax.swing.JButton();
        BtnLihatPeta = new javax.swing.JButton();
        BtnCari = new javax.swing.JButton();
        FCari = new javax.swing.JTextField();
        PHeaderAdmin = new javax.swing.JPanel();
        lblPeranHeader = new javax.swing.JLabel();
        lblNamaHeader = new javax.swing.JLabel();
        pnlAvatar = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblJudulHalaman = new javax.swing.JLabel();
        PMenuAdmin = new javax.swing.JPanel();
        BtnMenuUtama = new javax.swing.JButton();
        BtnMenuPengantaran = new javax.swing.JButton();
        BtnMenuRiwayatPengiriman = new javax.swing.JButton();
        BtnMenuOngkir = new javax.swing.JButton();
        BtnMenuPengiriman = new javax.swing.JButton();
        BtnMenuKonter = new javax.swing.JButton();
        BtnMenuUser = new javax.swing.JButton();
        BtnDashboard = new javax.swing.JButton();
        lblPanelAdmin = new javax.swing.JLabel();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();
        lblPeranHeader1 = new javax.swing.JLabel();
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

        BtnTambah.setBackground(new java.awt.Color(255, 107, 0));
        BtnTambah.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnTambah.setForeground(new java.awt.Color(255, 255, 255));
        BtnTambah.setText("+ Tambah");
        BtnTambah.setBorderPainted(false);
        BtnTambah.setFocusPainted(false);
        BtnTambah.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnTambah.addActionListener(this::BtnTambahActionPerformed);

        BtnHapus.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnHapus.setForeground(new java.awt.Color(220, 38, 38));
        BtnHapus.setText("Hapus");
        BtnHapus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnHapus.setFocusPainted(false);
        BtnHapus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnHapus.addActionListener(this::BtnHapusActionPerformed);

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
        lblPeranHeader.setText("Admin");
        lblPeranHeader.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblNamaHeader.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblNamaHeader.setForeground(new java.awt.Color(11, 31, 75));
        lblNamaHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNamaHeader.setText("Administrator");
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
        lblJudulHalaman.setText("Kelola Pengantaran");
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

        PMenuAdmin.setBackground(new java.awt.Color(11, 31, 75));
        PMenuAdmin.setPreferredSize(new java.awt.Dimension(202, 568));

        BtnMenuUtama.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuUtama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconKeluar.png"))); // NOI18N
        BtnMenuUtama.setText("Keluar");
        BtnMenuUtama.setBorderPainted(false);
        BtnMenuUtama.setContentAreaFilled(false);
        BtnMenuUtama.setFocusPainted(false);
        BtnMenuUtama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuUtama.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuUtama.addActionListener(this::BtnMenuUtamaActionPerformed);

        BtnMenuPengantaran.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuPengantaran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuPengantaran.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuPengantaran.setText("Pengantaran");
        BtnMenuPengantaran.setBorderPainted(false);
        BtnMenuPengantaran.setFocusPainted(false);
        BtnMenuPengantaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuPengantaran.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuPengantaran.addActionListener(this::BtnMenuPengantaranActionPerformed);

        BtnMenuRiwayatPengiriman.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuRiwayatPengiriman.setText("Riwayat Pelacakan");
        BtnMenuRiwayatPengiriman.setBorderPainted(false);
        BtnMenuRiwayatPengiriman.setContentAreaFilled(false);
        BtnMenuRiwayatPengiriman.setFocusPainted(false);
        BtnMenuRiwayatPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuRiwayatPengiriman.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuRiwayatPengiriman.addActionListener(this::BtnMenuRiwayatPengirimanActionPerformed);

        BtnMenuOngkir.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuOngkir.setText("Ongkir");
        BtnMenuOngkir.setBorderPainted(false);
        BtnMenuOngkir.setContentAreaFilled(false);
        BtnMenuOngkir.setFocusPainted(false);
        BtnMenuOngkir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuOngkir.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuOngkir.addActionListener(this::BtnMenuOngkirActionPerformed);

        BtnMenuPengiriman.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuPengiriman.setText("Pengiriman");
        BtnMenuPengiriman.setBorderPainted(false);
        BtnMenuPengiriman.setContentAreaFilled(false);
        BtnMenuPengiriman.setFocusPainted(false);
        BtnMenuPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuPengiriman.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuPengiriman.addActionListener(this::BtnMenuPengirimanActionPerformed);

        BtnMenuKonter.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuKonter.setText("Konter");
        BtnMenuKonter.setBorderPainted(false);
        BtnMenuKonter.setContentAreaFilled(false);
        BtnMenuKonter.setFocusPainted(false);
        BtnMenuKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuKonter.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuKonter.addActionListener(this::BtnMenuKonterActionPerformed);

        BtnMenuUser.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuUser.setText("User");
        BtnMenuUser.setBorderPainted(false);
        BtnMenuUser.setContentAreaFilled(false);
        BtnMenuUser.setFocusPainted(false);
        BtnMenuUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuUser.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuUser.addActionListener(this::BtnMenuUserActionPerformed);

        BtnDashboard.setForeground(new java.awt.Color(184, 196, 224));
        BtnDashboard.setText("Dashboard");
        BtnDashboard.setBorderPainted(false);
        BtnDashboard.setContentAreaFilled(false);
        BtnDashboard.setFocusPainted(false);
        BtnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnDashboard.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnDashboard.addActionListener(this::BtnDashboardActionPerformed);

        lblPanelAdmin.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblPanelAdmin.setForeground(new java.awt.Color(184, 196, 224));
        lblPanelAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPanelAdmin.setText("Panel Admin");
        lblPanelAdmin.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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

        javax.swing.GroupLayout PMenuAdminLayout = new javax.swing.GroupLayout(PMenuAdmin);
        PMenuAdmin.setLayout(PMenuAdminLayout);
        PMenuAdminLayout.setHorizontalGroup(
            PMenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuPengantaran, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuRiwayatPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnMenuUser, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PMenuAdminLayout.setVerticalGroup(
            PMenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(BtnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(BtnMenuPengantaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(BtnMenuRiwayatPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(BtnMenuOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(BtnMenuPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(BtnMenuKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(BtnMenuUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(BtnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PMenuAdminLayout.createSequentialGroup()
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(430, 430, 430)
                            .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(FCari, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addComponent(lblPeranHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLihatGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BtnLihatPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(228, 228, 228)
                    .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPeranHeader1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnLihatPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnLihatGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        cariDataPengantaran();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDashboardActionPerformed
        MainFrame main = (MainFrame) javax.swing.SwingUtilities
            .getWindowAncestor(this);

    main.tampilkanHalaman("menuAdmin");
    }//GEN-LAST:event_BtnDashboardActionPerformed

    private void BtnMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUserActionPerformed
        tampilkanHalaman("menuUser");
    }//GEN-LAST:event_BtnMenuUserActionPerformed

    private void BtnMenuKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuKonterActionPerformed
       tampilkanHalaman("menuKonter");
    }//GEN-LAST:event_BtnMenuKonterActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        tampilkanHalaman("menuPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuPengantaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengantaranActionPerformed
        tampilDataPengantaran();
        tampilkanHalaman("menuPengantaran");
    }//GEN-LAST:event_BtnMenuPengantaranActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
       tampilkanHalaman("menuRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
    MainFrame main = (MainFrame)
        SwingUtilities.getWindowAncestor(this);

    if (main != null) {
        main.bukaFormTambahPengantaran();
    } else {
        JOptionPane.showMessageDialog(this,
            "MainFrame tidak ditemukan!");
    }
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
    int baris = TDataPengiriman.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
            "Pilih data pengantaran yang ingin diubah!");
        return;
    }

    int barisModel = TDataPengiriman.convertRowIndexToModel(baris);

    int idPengantaran = Integer.parseInt(
        TDataPengiriman.getModel()
            .getValueAt(barisModel, 0).toString()
    );

    MainFrame main = (MainFrame)
        javax.swing.SwingUtilities.getWindowAncestor(this);

    main.bukaFormUbahPengantaran(idPengantaran);
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        int baris = TDataPengiriman.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
                "Pilih data yang ingin dihapus!");
        return;
    }

    int barisModel = TDataPengiriman.convertRowIndexToModel(baris);
    int id = Integer.parseInt(
            TDataPengiriman.getModel().getValueAt(barisModel, 0).toString()
    );

    int konfirmasi = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus data pengantaran ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);

    if (konfirmasi != JOptionPane.YES_OPTION) {
        return;
    }

    hapusDataPengantaran(id);
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void FCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FCariActionPerformed
        cariDataPengantaran();
    }//GEN-LAST:event_FCariActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
        FCari.setText("");
    tampilDataPengantaran();

    }//GEN-LAST:event_BtnRefreshActionPerformed

    private void BtnLihatPetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatPetaActionPerformed
        int baris = TDataPengiriman.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
                "Pilih data pengantaran terlebih dahulu!");
        return;
    }

    int barisModel = TDataPengiriman.convertRowIndexToModel(baris);

    Object latitudeObj = TDataPengiriman.getModel()
            .getValueAt(barisModel, 5);

    Object longitudeObj = TDataPengiriman.getModel()
            .getValueAt(barisModel, 6);

    if (latitudeObj == null || longitudeObj == null) {
        JOptionPane.showMessageDialog(this,
                "Koordinat lokasi belum tersedia!");
        return;
    }

    try {
        BigDecimal latitude = ValidasiKoordinat.parseLatitude(
                latitudeObj.toString());
        BigDecimal longitude = ValidasiKoordinat.parseLongitude(
                longitudeObj.toString());
        ValidasiKoordinat.validasi(latitude, longitude);

        Object resi = TDataPengiriman.getModel()
                .getValueAt(barisModel, 1);

        // Peta in-app: pin pada titik tujuan + zoom + geser
        tampilkanPetaTujuan(latitude, longitude,
                resi == null ? "-" : resi.toString());

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Gagal membuka peta: " + e.getMessage());
    }
    }//GEN-LAST:event_BtnLihatPetaActionPerformed

    private void BtnMenuOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuOngkirActionPerformed
        tampilkanHalaman("menuOngkir");
    }//GEN-LAST:event_BtnMenuOngkirActionPerformed

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
        if (Sesi.getSesi().sudahLogin()) {
            boolean ya = InputHelper.konfirmasi(this,
                "Keluar dari area admin dan kembali ke menu utama?");

            if (!ya) {
                return;
            }

            Sesi.logout();
        }

        tampilkanHalaman("menuUtama");
    }//GEN-LAST:event_BtnMenuUtamaActionPerformed

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

    private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnDashboard;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnLihatGambar;
    private javax.swing.JButton BtnLihatPeta;
    private javax.swing.JButton BtnMenuKonter;
    private javax.swing.JButton BtnMenuOngkir;
    private javax.swing.JButton BtnMenuPengantaran;
    private javax.swing.JButton BtnMenuPengiriman;
    private javax.swing.JButton BtnMenuRiwayatPengiriman;
    private javax.swing.JButton BtnMenuUser;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JButton BtnRefresh;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JTextField FCari;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenuAdmin;
    private javax.swing.JPanel PTabel;
    private javax.swing.JTable TDataPengiriman;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelAdmin;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JLabel lblPeranHeader1;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}