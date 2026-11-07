/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.OngkirController;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.InputHelper;
import util.Sesi;

public class KelolaOngkir extends javax.swing.JPanel {

    private final OngkirController ongkirController = new OngkirController();
    private int idOngkirDipilih = -1;
    public KelolaOngkir() {
    initComponents();

    aturTabel();
    tampilkanDataOngkir();
}
    private void aturTabel() {
    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("ID");
    model.addColumn("Jarak Min (km)");
    model.addColumn("Jarak Max (km)");
    model.addColumn("Tarif Dasar (Rp)");

    TDataPengiriman.setModel(model);

    TDataPengiriman.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    TDataPengiriman.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            int baris = TDataPengiriman.getSelectedRow();

            if (baris != -1) {
                idOngkirDipilih = Integer.parseInt(
                    TDataPengiriman.getValueAt(baris, 0).toString()
                );

                FJarakMin.setText(
                    TDataPengiriman.getValueAt(baris, 1).toString()
                );

                FJarakMax.setText(
                    TDataPengiriman.getValueAt(baris, 2).toString()
                );

                jTextField1.setText(
                    TDataPengiriman.getValueAt(baris, 3).toString()
                );
            }
        }
    });
}
    private void tampilkanDataOngkir() {
    DefaultTableModel model =
        (DefaultTableModel) TDataPengiriman.getModel();

    model.setRowCount(0);

    try {
        List<Object[]> daftarOngkir = ongkirController.tampilkan();

        for (Object[] baris : daftarOngkir) {
            model.addRow(baris);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal menampilkan data ongkir: " + e.getMessage()
        );
    }
}
    private void kosongkanForm() {
    FJarakMin.setText("");
    FJarakMax.setText("");
    jTextField1.setText("");

    idOngkirDipilih = -1;

    TDataPengiriman.clearSelection();
}

public void segarkanData() {
    tampilkanDataOngkir();
}
    private void tambahDataOngkir() {
    if (FJarakMin.getText().trim().isEmpty()
            || FJarakMax.getText().trim().isEmpty()
            || jTextField1.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
            this, "Semua data harus diisi!"
        );
        return;
    }

    try {boolean berhasil = ongkirController.tambah(
                FJarakMin.getText().trim(),
                FJarakMax.getText().trim(),
                jTextField1.getText().trim());

        if (berhasil) {
            JOptionPane.showMessageDialog(
                this, "Data ongkir berhasil ditambahkan!"
            );

            kosongkanForm();
            tampilkanDataOngkir();
        } else {
            JOptionPane.showMessageDialog(
                this, "Data ongkir gagal ditambahkan!"
            );
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this, "Gagal menambahkan ongkir: " + e.getMessage()
        );
    }
}
    private void ubahDataOngkir() {
    if (idOngkirDipilih == -1) {
        JOptionPane.showMessageDialog(
            this, "Pilih data ongkir dari tabel terlebih dahulu!"
        );
        return;
    }

    try {boolean berhasil = ongkirController.ubah(
                idOngkirDipilih,
                FJarakMin.getText().trim(),
                FJarakMax.getText().trim(),
                jTextField1.getText().trim());

        if (berhasil) {
            JOptionPane.showMessageDialog(
                this, "Data ongkir berhasil diubah!"
            );

            kosongkanForm();
            tampilkanDataOngkir();
        } else {
            JOptionPane.showMessageDialog(
                this, "Data ongkir tidak ditemukan!"
            );
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this, "Gagal mengubah ongkir: " + e.getMessage()
        );
    }
}
    private void hapusDataOngkir() {
    if (idOngkirDipilih == -1) {
        JOptionPane.showMessageDialog(
            this, "Pilih data ongkir yang ingin dihapus!"
        );
        return;
    }

    int pilihan = JOptionPane.showConfirmDialog(
        this,
        "Yakin ingin menghapus data ongkir ini?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION
    );

    if (pilihan != JOptionPane.YES_OPTION) {
        return;
    }

    try {
        boolean berhasil = ongkirController.hapus(idOngkirDipilih);

        if (berhasil) {
            JOptionPane.showMessageDialog(
                this, "Data ongkir berhasil dihapus!"
            );

            kosongkanForm();
            tampilkanDataOngkir();
        } else {
            JOptionPane.showMessageDialog(
                this, "Data ongkir tidak ditemukan!"
            );
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal menghapus data ongkir. Data mungkin sedang digunakan "
            + "oleh pengiriman.\n" + e.getMessage()
        );
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

        PTabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TDataPengiriman = new javax.swing.JTable();
        POngkir = new javax.swing.JPanel();
        BtnRefresh = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnTambahData = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        LTarifDasar = new javax.swing.JLabel();
        FJarakMax = new javax.swing.JTextField();
        LJarakMax = new javax.swing.JLabel();
        FJarakMin = new javax.swing.JTextField();
        LJarakMin = new javax.swing.JLabel();
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
        PTabel.setPreferredSize(new java.awt.Dimension(820, 301));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TDataPengiriman.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TDataPengiriman.setForeground(new java.awt.Color(11, 31, 75));
        TDataPengiriman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Jarak Min (km)", "Jarak Max (km)", "Tarif Dasar (Rp)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TDataPengiriman.setFillsViewportHeight(true);
        TDataPengiriman.setGridColor(new java.awt.Color(227, 232, 242));
        TDataPengiriman.setRowHeight(23);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        POngkir.setBackground(new java.awt.Color(255, 255, 255));
        POngkir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        POngkir.setPreferredSize(new java.awt.Dimension(820, 106));

        BtnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnRefresh.setForeground(new java.awt.Color(11, 31, 75));
        BtnRefresh.setText("Refresh");
        BtnRefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnRefresh.setFocusPainted(false);
        BtnRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnRefresh.addActionListener(this::BtnRefreshActionPerformed);

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

        BtnTambahData.setBackground(new java.awt.Color(255, 107, 0));
        BtnTambahData.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnTambahData.setForeground(new java.awt.Color(255, 255, 255));
        BtnTambahData.setText("+ Tambah Ongkir");
        BtnTambahData.setBorderPainted(false);
        BtnTambahData.setFocusPainted(false);
        BtnTambahData.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnTambahData.addActionListener(this::BtnTambahDataActionPerformed);

        jTextField1.setForeground(new java.awt.Color(11, 31, 75));
        jTextField1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        LTarifDasar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LTarifDasar.setForeground(new java.awt.Color(11, 31, 75));
        LTarifDasar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LTarifDasar.setText("Tarif Dasar (Rp)");
        LTarifDasar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FJarakMax.setForeground(new java.awt.Color(11, 31, 75));
        FJarakMax.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FJarakMax.addActionListener(this::FJarakMaxActionPerformed);

        LJarakMax.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LJarakMax.setForeground(new java.awt.Color(11, 31, 75));
        LJarakMax.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LJarakMax.setText("Jarak Max (km)");
        LJarakMax.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FJarakMin.setForeground(new java.awt.Color(11, 31, 75));
        FJarakMin.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FJarakMin.addActionListener(this::FJarakMinActionPerformed);

        LJarakMin.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LJarakMin.setForeground(new java.awt.Color(11, 31, 75));
        LJarakMin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LJarakMin.setText("Jarak Min (km)");
        LJarakMin.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout POngkirLayout = new javax.swing.GroupLayout(POngkir);
        POngkir.setLayout(POngkirLayout);
        POngkirLayout.setHorizontalGroup(
            POngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(BtnTambahData, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(551, 551, 551)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(551, 551, 551)
                .addComponent(LTarifDasar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(FJarakMax, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(LJarakMax, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(FJarakMin, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LJarakMin, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        POngkirLayout.setVerticalGroup(
            POngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(BtnTambahData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LTarifDasar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(FJarakMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LJarakMax, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(FJarakMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LJarakMin, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
        lblJudulHalaman.setText("Kelola Ongkir");
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

        BtnMenuOngkir.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuOngkir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuOngkir.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuOngkir.setText("Ongkir");
        BtnMenuOngkir.setBorderPainted(false);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(POngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(POngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
        tampilkanHalaman("menuRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

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

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
        kosongkanForm();
        tampilkanDataOngkir();
    }//GEN-LAST:event_BtnRefreshActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        if (idOngkirDipilih != -1) {
            ubahDataOngkir();
        } else {
            tambahDataOngkir();
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void FJarakMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FJarakMaxActionPerformed
        jTextField1.requestFocus();
    }//GEN-LAST:event_FJarakMaxActionPerformed

    private void FJarakMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FJarakMinActionPerformed
        FJarakMax.requestFocus();
    }//GEN-LAST:event_FJarakMinActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        hapusDataOngkir();
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        ubahDataOngkir();
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void BtnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahDataActionPerformed
        tambahDataOngkir();
    }//GEN-LAST:event_BtnTambahDataActionPerformed

    private void BtnMenuOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuOngkirActionPerformed
        tampilkanDataOngkir();
        tampilkanHalaman("menuOngkir");
    }//GEN-LAST:event_BtnMenuOngkirActionPerformed

    private void BtnMenuPengantaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengantaranActionPerformed
        tampilkanHalaman("menuPengantaran");
    }//GEN-LAST:event_BtnMenuPengantaranActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        tampilkanHalaman("menuPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuKonterActionPerformed
        tampilkanHalaman("menuKonter");
    }//GEN-LAST:event_BtnMenuKonterActionPerformed

    private void BtnMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUserActionPerformed
        tampilkanHalaman("menuUser");
    }//GEN-LAST:event_BtnMenuUserActionPerformed

    private void BtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDashboardActionPerformed
        MainFrame main = (MainFrame) javax.swing.SwingUtilities
        .getWindowAncestor(this);

        main.tampilkanHalaman("menuAdmin");
    }//GEN-LAST:event_BtnDashboardActionPerformed

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
    private javax.swing.JButton BtnTambahData;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JTextField FJarakMax;
    private javax.swing.JTextField FJarakMin;
    private javax.swing.JLabel LJarakMax;
    private javax.swing.JLabel LJarakMin;
    private javax.swing.JLabel LTarifDasar;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenuAdmin;
    private javax.swing.JPanel POngkir;
    private javax.swing.JPanel PTabel;
    private javax.swing.JTable TDataPengiriman;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
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
