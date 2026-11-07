/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.UserController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;
import java.awt.Window;
import util.InputHelper;
import util.Sesi;

public class KelolaUser extends javax.swing.JPanel {

    private final UserController userController = new UserController();

    private int idUserTerpilih = -1;
    private int idKonterLogin = -1;

    public void setIdKonterLogin(int idKonter) {
    this.idKonterLogin = idKonter;

    System.out.println("ID Konter Login: " + idKonterLogin);

    tampilkanDataUser();
    aturLebarKolom();
}

    public KelolaUser() {
        initComponents();
        tampilkanDataUser();
        aturLebarKolom();

        TLihatDataUser.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                pilihDataUser();
            }
        });
    }
public void refreshDataUser() {
    tampilkanDataUser();
    aturLebarKolom();
}
private void tampilkanDataUser() {

    try {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{
                "ID", "Nama", "Email", "No HP", "Role",
                "Shift/No. Kendaraan", "Konter", "Gaji", "Tanggal Msk"
            }, 0
        );

        List<Object[]> data = userController.tampilkan(idKonterLogin);

        for (Object[] baris : data) {
            model.addRow(baris);
        }

        TLihatDataUser.setModel(model);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal menampilkan data user: " + e.getMessage()
        );
    }
}

private void pilihDataUser() {

    int baris = TLihatDataUser.getSelectedRow();

    if (baris != -1) {
        idUserTerpilih = Integer.parseInt(
            TLihatDataUser.getValueAt(baris, 0).toString()
        );
    }
}

private void pindahHalaman(String namaHalaman) {
    Window window = SwingUtilities.getWindowAncestor(this);

    if (window instanceof MainFrame) {
        MainFrame frame = (MainFrame) window;
        frame.tampilkanHalaman(namaHalaman);
    } else {
        JOptionPane.showMessageDialog(
            this,
            "MainFrame tidak ditemukan!"
        );
    }
}
private void aturLebarKolom() {
    javax.swing.table.TableColumnModel kolom =
            TLihatDataUser.getColumnModel();

    int[] lebar = {
        60, 180, 200, 140, 150, 180, 180, 130, 150
    };

    for (int i = 0; i < lebar.length; i++) {
        kolom.getColumn(i).setPreferredWidth(lebar[i]);
        kolom.getColumn(i).setMinWidth(lebar[i]);
        kolom.getColumn(i).setMaxWidth(lebar[i]);
        kolom.getColumn(i).setResizable(false);
    }

    TLihatDataUser.setAutoResizeMode(
            javax.swing.JTable.AUTO_RESIZE_OFF
    );

    TLihatDataUser.setRowHeight(25);

    TLihatDataUser.getTableHeader()
            .setReorderingAllowed(false);
javax.swing.table.DefaultTableCellRenderer rendererID =
        new javax.swing.table.DefaultTableCellRenderer();

rendererID.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
);

TLihatDataUser.getColumnModel()
        .getColumn(0)
        .setCellRenderer(rendererID);
}
private void muatDataUser() {
    DefaultTableModel model =
        (DefaultTableModel) TLihatDataUser.getModel();

    model.setRowCount(0);

    try {
        List<Object[]> daftarUser =
            userController.tampilkan(idKonterLogin);

        for (Object[] baris : daftarUser) {
            model.addRow(baris);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Gagal memuat data user: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTabel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TLihatDataUser = new javax.swing.JTable();
        BtnTambah = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnRefresh = new javax.swing.JButton();
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

        setBackground(new java.awt.Color(245, 247, 251));

        PTabel.setBackground(new java.awt.Color(255, 255, 255));
        PTabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PTabel.setPreferredSize(new java.awt.Dimension(820, 381));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TLihatDataUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Email", "No HP", "Role", "Shift/No. Kendaraan", "Konter", "Gaji", "Tanggal Msk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TLihatDataUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TLihatDataUser.setForeground(new java.awt.Color(11, 31, 75));
        TLihatDataUser.setGridColor(new java.awt.Color(227, 232, 242));
        TLihatDataUser.setRowHeight(21);
        TLihatDataUser.setFillsViewportHeight(true);
        TLihatDataUser.setSelectionBackground(new java.awt.Color(255, 240, 227));
        TLihatDataUser.setSelectionForeground(new java.awt.Color(11, 31, 75));
        jScrollPane2.setViewportView(TLihatDataUser);

        javax.swing.GroupLayout PTabelLayout = new javax.swing.GroupLayout(PTabel);
        PTabel.setLayout(PTabelLayout);
        PTabelLayout.setHorizontalGroup(
            PTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTabelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PTabelLayout.setVerticalGroup(
            PTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTabelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BtnTambah.setBackground(new java.awt.Color(255, 107, 0));
        BtnTambah.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnTambah.setForeground(new java.awt.Color(255, 255, 255));
        BtnTambah.setText("+ Tambah User");
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
        lblJudulHalaman.setText("Kelola User");
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

        BtnMenuPengantaran.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuPengantaran.setText("Pengantaran");
        BtnMenuPengantaran.setBorderPainted(false);
        BtnMenuPengantaran.setContentAreaFilled(false);
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

        BtnMenuUser.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuUser.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuUser.setText("User");
        BtnMenuUser.setBorderPainted(false);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(922, 922, 922)
                .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(838, 838, 838)
                .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(754, 754, 754)
                .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(670, 670, 670)
                .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDashboardActionPerformed
            pindahHalaman("menuAdmin");

    }//GEN-LAST:event_BtnDashboardActionPerformed

    private void BtnMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUserActionPerformed
    pindahHalaman("menuUser");
    }//GEN-LAST:event_BtnMenuUserActionPerformed

    private void BtnMenuKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuKonterActionPerformed
    pindahHalaman("menuKonter");
    }//GEN-LAST:event_BtnMenuKonterActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
    pindahHalaman("menuPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuPengantaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengantaranActionPerformed
    pindahHalaman("menuPengantaran");
    }//GEN-LAST:event_BtnMenuPengantaranActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
    pindahHalaman("menuRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
    String[] pilihan = {
        "Kurir",
        "Petugas Konter",
        "Batal"
    };

    int hasil = JOptionPane.showOptionDialog(
        this,
        "Pilih jenis user yang ingin ditambahkan:",
        "Tambah Data User",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        pilihan,
        pilihan[0]
    );

    if (hasil == 0) {
        pindahHalaman("tambahKurir");
    } else if (hasil == 1) {
        pindahHalaman("tambahPetugasKonter");
    }
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
     int baris = TLihatDataUser.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(
            this,
            "Pilih data user yang ingin diubah terlebih dahulu!"
        );
        return;
    }

    baris = TLihatDataUser.convertRowIndexToModel(baris);

    int idUser = Integer.parseInt(
            TLihatDataUser.getModel()
                    .getValueAt(baris, 0).toString());

    String role = String.valueOf(
            TLihatDataUser.getModel().getValueAt(baris, 4));

    Window window = SwingUtilities.getWindowAncestor(this);

    if (!(window instanceof MainFrame)) {
        JOptionPane.showMessageDialog(
            this,
            "MainFrame tidak ditemukan!"
        );
        return;
    }

    MainFrame frame = (MainFrame) window;

    if ("Kurir".equalsIgnoreCase(role)) {
        frame.bukaUbahKurir(idUser);
    } else if ("Petugas Konter".equalsIgnoreCase(role)) {
        frame.bukaUbahPetugas(idUser);
    } else {
        JOptionPane.showMessageDialog(
            this,
            "Role user tidak dikenali: " + role
        );}
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
    int baris = TLihatDataUser.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
            "Pilih data user yang ingin dihapus terlebih dahulu!");
        return;
    }

    baris = TLihatDataUser.convertRowIndexToModel(baris);

    int idUser = Integer.parseInt(
        TLihatDataUser.getModel().getValueAt(baris, 0).toString()
    );

    int konfirmasi = JOptionPane.showConfirmDialog(
        this,
        "Apakah kamu yakin ingin menghapus user dengan ID " + idUser + "?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION
    );

    if (konfirmasi == JOptionPane.YES_OPTION) {
        try {
            boolean berhasil = userController.hapus(idUser);

            if (berhasil) {
                JOptionPane.showMessageDialog(this,
                    "Data user berhasil dihapus!");
                tampilkanDataUser();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Data user tidak ditemukan!");
            }

        } catch (IllegalArgumentException e) {
            InputHelper.pesanPeringatan(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal menghapus data user: " + e.getMessage(),
                "Kesalahan Database",
                JOptionPane.ERROR_MESSAGE);
        }
    }    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
    tampilkanDataUser();
    aturLebarKolom(); 
    JOptionPane.showMessageDialog(this,
    "Data user berhasil diperbarui!");
    }//GEN-LAST:event_BtnRefreshActionPerformed

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
        if (Sesi.getSesi().sudahLogin()) {
            boolean ya = InputHelper.konfirmasi(this,
                "Keluar dari akun dan kembali ke menu utama?");

            if (!ya) {
                return;
            }

            Sesi.logout();
        }

        pindahHalaman("menuUtama");
    }//GEN-LAST:event_BtnMenuUtamaActionPerformed

    private void BtnMenuOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuOngkirActionPerformed
        pindahHalaman("menuOngkir");
    }//GEN-LAST:event_BtnMenuOngkirActionPerformed


    private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDashboard;
    private javax.swing.JButton BtnHapus;
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
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenuAdmin;
    private javax.swing.JPanel PTabel;
    private javax.swing.JTable TLihatDataUser;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelAdmin;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}
