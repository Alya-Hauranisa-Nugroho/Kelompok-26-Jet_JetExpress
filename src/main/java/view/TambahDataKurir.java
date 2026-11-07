/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.UserController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import util.DatePickerKalender;
import util.InputHelper;
import util.Sesi;

public class TambahDataKurir extends javax.swing.JPanel {

    private final UserController userController = new UserController();

    public TambahDataKurir() {
    initComponents();
    muatDaftarKonter();

    DatePickerKalender.pasang(FTangglMasuk);
}

private void muatDaftarKonter() {
    try {
        List<Object[]> daftar = userController.daftarKonter();

        CKonter.removeAllItems();
        for (Object[] baris : daftar) {
            CKonter.addItem(baris[0] + " - " + baris[1]);
        }
    } catch (SQLException e) {
        InputHelper.pesanError(this,
                "Gagal memuat daftar konter: " + e.getMessage());
    }
}
private void simpanDataKurir() {
    try {
        String nama = InputHelper.ambilTeks(FNama, "Nama");
        String email = InputHelper.ambilEmail(FEmail);

        String password = InputHelper.ambilTeks(FPassword, "Password");

        String noHp = InputHelper.ambilTelepon(FNomorHp, "Nomor HP");
        String gaji = String.valueOf(
                InputHelper.ambilAngka(FGaji, "Gaji"));
        String tanggalMasuk = InputHelper.ambilTeks(
                FTangglMasuk, "Tanggal Masuk");
        int idKonter = InputHelper.ambilIdCombo(CKonter, "Konter");
        String noKendaraan = InputHelper.ambilTeks(
                FNoKendaraan, "Nomor Kendaraan");

        userController.tambah(nama, email, password, noHp, gaji,
                tanggalMasuk, "Kurir", idKonter, "", noKendaraan);

        JOptionPane.showMessageDialog(
                this,
                "Data kurir berhasil disimpan!"
        );

        kosongkanForm();
        pindahHalaman("menuUser");

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (SQLException e) {
        InputHelper.pesanError(this,
                "Gagal menyimpan data kurir: " + e.getMessage());
    }
}

private void kosongkanForm() {
    FNama.setText("");
    FEmail.setText("");
    FPassword.setText("");
    FNomorHp.setText("");
    FGaji.setText("");
    FTangglMasuk.setText("");
    FNoKendaraan.setText("");

    if (CKonter.getItemCount() > 0) {
        CKonter.setSelectedIndex(0);
    }

    FNama.requestFocus();
}
private void pindahHalaman(String namaHalaman) {
    java.awt.Window window = SwingUtilities.getWindowAncestor(this);

    if (window instanceof MainFrame) {
        MainFrame frame = (MainFrame) window;
        frame.tampilkanHalaman(namaHalaman);
    } else {
        JOptionPane.showMessageDialog(
            this,
            "Jendela utama tidak ditemukan."
        );
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PPerubahan = new javax.swing.JPanel();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        FTangglMasuk = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        FGaji = new javax.swing.JTextField();
        LGaji = new javax.swing.JLabel();
        FNoKendaraan = new javax.swing.JTextField();
        LNoKendaraan = new javax.swing.JLabel();
        CKonter = new javax.swing.JComboBox();
        LKonter = new javax.swing.JLabel();
        FNomorHp = new javax.swing.JTextField();
        LNoHP = new javax.swing.JLabel();
        FPassword = new javax.swing.JTextField();
        LPassword = new javax.swing.JLabel();
        FEmail = new javax.swing.JTextField();
        LEmail = new javax.swing.JLabel();
        FNama = new javax.swing.JTextField();
        LNama = new javax.swing.JLabel();
        LFormKurir = new javax.swing.JLabel();
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

        PPerubahan.setBackground(new java.awt.Color(255, 255, 255));
        PPerubahan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PPerubahan.setPreferredSize(new java.awt.Dimension(820, 395));

        BtnSimpan.setBackground(new java.awt.Color(255, 107, 0));
        BtnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan.setText("Simpan");
        BtnSimpan.setBorderPainted(false);
        BtnSimpan.setFocusPainted(false);
        BtnSimpan.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnSimpan.addActionListener(this::BtnSimpanActionPerformed);

        BtnBatal.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnBatal.setForeground(new java.awt.Color(11, 31, 75));
        BtnBatal.setText("Batal");
        BtnBatal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnBatal.setFocusPainted(false);
        BtnBatal.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnBatal.addActionListener(this::BtnBatalActionPerformed);

        FTangglMasuk.setForeground(new java.awt.Color(11, 31, 75));
        FTangglMasuk.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FTangglMasuk.addActionListener(this::FTangglMasukActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 31, 75));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Tanggal Masuk (yyyy-MM-dd)");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FGaji.setForeground(new java.awt.Color(11, 31, 75));
        FGaji.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FGaji.addActionListener(this::FGajiActionPerformed);

        LGaji.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LGaji.setForeground(new java.awt.Color(11, 31, 75));
        LGaji.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LGaji.setText("Gaji (Rp)");
        LGaji.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNoKendaraan.setForeground(new java.awt.Color(11, 31, 75));
        FNoKendaraan.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LNoKendaraan.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNoKendaraan.setForeground(new java.awt.Color(11, 31, 75));
        LNoKendaraan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNoKendaraan.setText("Nomor Kendaraan");
        LNoKendaraan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        CKonter.setForeground(new java.awt.Color(11, 31, 75));
        CKonter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        CKonter.addActionListener(this::CKonterActionPerformed);

        LKonter.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LKonter.setForeground(new java.awt.Color(11, 31, 75));
        LKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKonter.setText("Pilih Konter");
        LKonter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNomorHp.setForeground(new java.awt.Color(11, 31, 75));
        FNomorHp.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNomorHp.addActionListener(this::FNomorHpActionPerformed);

        LNoHP.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNoHP.setForeground(new java.awt.Color(11, 31, 75));
        LNoHP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNoHP.setText("No. HP");
        LNoHP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FPassword.setForeground(new java.awt.Color(11, 31, 75));
        FPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FPassword.addActionListener(this::FPasswordActionPerformed);

        LPassword.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LPassword.setForeground(new java.awt.Color(11, 31, 75));
        LPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LPassword.setText("Password");
        LPassword.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FEmail.setForeground(new java.awt.Color(11, 31, 75));
        FEmail.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FEmail.addActionListener(this::FEmailActionPerformed);

        LEmail.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LEmail.setForeground(new java.awt.Color(11, 31, 75));
        LEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LEmail.setText("Email");
        LEmail.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNama.setForeground(new java.awt.Color(11, 31, 75));
        FNama.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNama.addActionListener(this::FNamaActionPerformed);

        LNama.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNama.setForeground(new java.awt.Color(11, 31, 75));
        LNama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNama.setText("Nama");
        LNama.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LFormKurir.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        LFormKurir.setForeground(new java.awt.Color(11, 31, 75));
        LFormKurir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LFormKurir.setText("Data Kurir Baru");
        LFormKurir.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PPerubahanLayout = new javax.swing.GroupLayout(PPerubahan);
        PPerubahan.setLayout(PPerubahanLayout);
        PPerubahanLayout.setHorizontalGroup(
            PPerubahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(719, 719, 719)
                .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(644, 644, 644)
                .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FTangglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(FGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(LGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FNoKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LNoKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(CKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(FNomorHp, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(LNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(FEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(LEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FNama, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LNama, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LFormKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PPerubahanLayout.setVerticalGroup(
            PPerubahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(FTangglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(FGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(LGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(FNoKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(LNoKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(CKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(LKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(FNomorHp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(LNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(FPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(LPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(FEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(LEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(FNama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(LNama, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPerubahanLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LFormKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        lblJudulHalaman.setText("Tambah User");
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
                .addComponent(PPerubahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(PPerubahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void FTangglMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FTangglMasukActionPerformed
 
        CKonter.requestFocusInWindow();
    }//GEN-LAST:event_FTangglMasukActionPerformed

    private void FNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNamaActionPerformed

        FEmail.requestFocusInWindow();
    }//GEN-LAST:event_FNamaActionPerformed

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

    private void FEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEmailActionPerformed

        FPassword.requestFocusInWindow();
    }//GEN-LAST:event_FEmailActionPerformed

    private void FPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FPasswordActionPerformed

        FNomorHp.requestFocusInWindow();
    }//GEN-LAST:event_FPasswordActionPerformed

    private void FNomorHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNomorHpActionPerformed

        FGaji.requestFocusInWindow();
    }//GEN-LAST:event_FNomorHpActionPerformed

    private void FGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FGajiActionPerformed

        FTangglMasuk.requestFocusInWindow();
    }//GEN-LAST:event_FGajiActionPerformed

    private void CKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CKonterActionPerformed

    }//GEN-LAST:event_CKonterActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        kosongkanForm();
        pindahHalaman("menuUser");
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        simpanDataKurir();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
        if (Sesi.getSesi().sudahLogin()) {
            boolean ya = InputHelper.konfirmasi(this,
                "Keluar dari area admin dan kembali ke menu utama?");

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
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnDashboard;
    private javax.swing.JButton BtnMenuKonter;
    private javax.swing.JButton BtnMenuOngkir;
    private javax.swing.JButton BtnMenuPengantaran;
    private javax.swing.JButton BtnMenuPengiriman;
    private javax.swing.JButton BtnMenuRiwayatPengiriman;
    private javax.swing.JButton BtnMenuUser;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JComboBox CKonter;
    private javax.swing.JTextField FEmail;
    private javax.swing.JTextField FGaji;
    private javax.swing.JTextField FNama;
    private javax.swing.JTextField FNoKendaraan;
    private javax.swing.JTextField FNomorHp;
    private javax.swing.JTextField FPassword;
    private javax.swing.JTextField FTangglMasuk;
    private javax.swing.JLabel LEmail;
    private javax.swing.JLabel LFormKurir;
    private javax.swing.JLabel LGaji;
    private javax.swing.JLabel LKonter;
    private javax.swing.JLabel LNama;
    private javax.swing.JLabel LNoHP;
    private javax.swing.JLabel LNoKendaraan;
    private javax.swing.JLabel LPassword;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenuAdmin;
    private javax.swing.JPanel PPerubahan;
    private javax.swing.JLabel jLabel1;
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
