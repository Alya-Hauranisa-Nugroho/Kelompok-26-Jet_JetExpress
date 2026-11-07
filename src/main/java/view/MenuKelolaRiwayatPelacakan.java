/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.LacakPaketController;
import controller.RiwayatPelacakanController;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.RiwayatPelacakan;
import util.DatePickerKalender;
import util.InputHelper;
import util.Sesi;

public class MenuKelolaRiwayatPelacakan extends javax.swing.JPanel {
    
 RiwayatPelacakanController riwayatController =
        new RiwayatPelacakanController();
    private final LacakPaketController lacakController =
        new LacakPaketController();

private int idPengiriman = -1;
private int idRiwayat = -1;

private final DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

public MenuKelolaRiwayatPelacakan() {
    initComponents();
    
    DatePickerKalender.pasangWaktu(FWaktu);

jTable1.getSelectionModel().addListSelectionListener(e -> {

    if (!e.getValueIsAdjusting()) {

        int baris = jTable1.getSelectedRow();

        if (baris != -1) {

            idRiwayat = Integer.parseInt(
                    jTable1.getValueAt(baris, 0).toString()
            );

            FWaktu.setText(
                    jTable1.getValueAt(baris, 1).toString()
            );

            FDeskripsi.setText(
                    jTable1.getValueAt(baris, 2).toString()
            );
        }
    }
});
}

public void segarkanData() {
    if (idPengiriman != -1) {
        tampilkanRiwayat();
    } else {
        kosongkanTabel();
    }

    bersihkanForm();
}

private void bersihkanForm() {

    idRiwayat = -1;

    FDeskripsi.setText("");
    FWaktu.setText("");

    jTable1.clearSelection();
}

private void cariPengiriman() {

    String noResi = FCari1.getText().trim();

    if (noResi.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Masukkan nomor resi terlebih dahulu!");
        return;
    }

    try {
        Map<String, Object> data =
                lacakController.lacak(noResi);

        if (data != null) {

            idPengiriman = (int) data.get("id_pengiriman");

            LNilaiNoResi.setText(
                    String.valueOf(data.get("no_resi")));
            LNilaiStatus.setText(
                    String.valueOf(data.get("status")));
            LNilaiPenerima.setText(
                    String.valueOf(data.get("nama_penerima")));
            LNilaiAlamat.setText("-");

            tampilkanRiwayat();

        } else {

            idPengiriman = -1;

            LNilaiNoResi.setText("-");
            LNilaiStatus.setText("-");
            LNilaiPenerima.setText("-");
            LNilaiAlamat.setText("-");

            kosongkanTabel();

            JOptionPane.showMessageDialog(this,
                    "Nomor resi tidak ditemukan!");
        }

    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Gagal mencari pengiriman: " + e.getMessage());
    }
}

private void tampilkanRiwayat() {

    DefaultTableModel model =
            new DefaultTableModel(
                new String[]{"ID Riwayat", "Waktu", "Deskripsi"}, 0
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

    ArrayList<RiwayatPelacakan> daftar = new ArrayList<>(
            riwayatController.riwayatPengiriman(idPengiriman));

    for (RiwayatPelacakan r : daftar) {

        model.addRow(new Object[]{
            r.getIdRiwayat(),
            r.getWaktuRiwayat().format(formatter),
            r.getDeskripsi()
        });
    }

    jTable1.setModel(model);

    // Sembunyikan kolom ID
    jTable1.getColumnModel().getColumn(0).setMinWidth(0);
    jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(0).setWidth(0);
}

private void kosongkanTabel() {

    DefaultTableModel model =
            new DefaultTableModel(
                new String[]{"ID Riwayat", "Waktu", "Deskripsi"}, 0
            );

    jTable1.setModel(model);
}

private void tampilkanHalaman(String namaHalaman) {
    pindahHalaman(namaHalaman);
}

private void pindahHalaman(String namaHalaman) {
    java.awt.Window window =
            javax.swing.SwingUtilities.getWindowAncestor(this);

    if (window instanceof MainFrame) {
        MainFrame frame = (MainFrame) window;
        frame.tampilkanHalaman(namaHalaman);
    } else {
        JOptionPane.showMessageDialog(this,
                "MainFrame tidak ditemukan!");
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BtnUbah = new javax.swing.JButton();
        BtnTambah = new javax.swing.JButton();
        FDeskripsi = new javax.swing.JTextField();
        LDeskripsi = new javax.swing.JLabel();
        FWaktu = new javax.swing.JTextField();
        LWaktu = new javax.swing.JLabel();
        LFormRiwayatPelacakan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LNilaiStatus = new javax.swing.JLabel();
        LStatus = new javax.swing.JLabel();
        LNilaiAlamat = new javax.swing.JLabel();
        LAlamat = new javax.swing.JLabel();
        LNilaiPenerima = new javax.swing.JLabel();
        LPenerima = new javax.swing.JLabel();
        LNilaiNoResi = new javax.swing.JLabel();
        LNoResi = new javax.swing.JLabel();
        BtnRefresh = new javax.swing.JButton();
        BtnCari = new javax.swing.JButton();
        FCari1 = new javax.swing.JTextField();
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
        lblPeranHeader2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));

        PTabel.setBackground(new java.awt.Color(255, 255, 255));
        PTabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PTabel.setPreferredSize(new java.awt.Dimension(820, 196));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Waktu", "Desktipsi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(11, 31, 75));
        jTable1.setGridColor(new java.awt.Color(227, 232, 242));
        jTable1.setRowHeight(21);
        jTable1.setFillsViewportHeight(true);
        jTable1.setSelectionBackground(new java.awt.Color(255, 240, 227));
        jTable1.setSelectionForeground(new java.awt.Color(11, 31, 75));
        jScrollPane1.setViewportView(jTable1);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 91));

        BtnUbah.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnUbah.setForeground(new java.awt.Color(37, 99, 235));
        BtnUbah.setText("Ubah");
        BtnUbah.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnUbah.setFocusPainted(false);
        BtnUbah.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnUbah.addActionListener(this::BtnUbahActionPerformed);

        BtnTambah.setBackground(new java.awt.Color(255, 107, 0));
        BtnTambah.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnTambah.setForeground(new java.awt.Color(255, 255, 255));
        BtnTambah.setText("Tambah");
        BtnTambah.setBorderPainted(false);
        BtnTambah.setFocusPainted(false);
        BtnTambah.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnTambah.addActionListener(this::BtnTambahActionPerformed);

        FDeskripsi.setForeground(new java.awt.Color(11, 31, 75));
        FDeskripsi.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LDeskripsi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LDeskripsi.setForeground(new java.awt.Color(11, 31, 75));
        LDeskripsi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LDeskripsi.setText("Deskripsi Max (50)");
        LDeskripsi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FWaktu.setForeground(new java.awt.Color(11, 31, 75));
        FWaktu.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FWaktu.addActionListener(this::FWaktuActionPerformed);

        LWaktu.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LWaktu.setForeground(new java.awt.Color(11, 31, 75));
        LWaktu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LWaktu.setText("Waktu");
        LWaktu.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LFormRiwayatPelacakan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LFormRiwayatPelacakan.setForeground(new java.awt.Color(11, 31, 75));
        LFormRiwayatPelacakan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LFormRiwayatPelacakan.setText("Form Riwayat Pelacakan");
        LFormRiwayatPelacakan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(665, 665, 665)
                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(591, 591, 591)
                        .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(FDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(LDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(FWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(LWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(LFormRiwayatPelacakan, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(FDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(LDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(FWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(LWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(LFormRiwayatPelacakan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(820, 68));

        LNilaiStatus.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiStatus.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiStatus.setText("-");
        LNilaiStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LStatus.setForeground(new java.awt.Color(107, 122, 153));
        LStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LStatus.setText("Status");
        LStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiAlamat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiAlamat.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiAlamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiAlamat.setText("-");
        LNilaiAlamat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LAlamat.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LAlamat.setForeground(new java.awt.Color(107, 122, 153));
        LAlamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LAlamat.setText("Alamat");
        LAlamat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiPenerima.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiPenerima.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiPenerima.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiPenerima.setText("-");
        LNilaiPenerima.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LPenerima.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LPenerima.setForeground(new java.awt.Color(107, 122, 153));
        LPenerima.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LPenerima.setText("Penerima");
        LPenerima.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiNoResi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiNoResi.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiNoResi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiNoResi.setText("-");
        LNilaiNoResi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNoResi.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LNoResi.setForeground(new java.awt.Color(107, 122, 153));
        LNoResi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNoResi.setText("Nomor Resi");
        LNoResi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(LNilaiStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(LNilaiAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(LAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(LNilaiPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(LNilaiNoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LNoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LNilaiStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(LNilaiAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(LAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LNilaiPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(LNilaiNoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(LNoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BtnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnRefresh.setForeground(new java.awt.Color(11, 31, 75));
        BtnRefresh.setText("Refresh");
        BtnRefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnRefresh.setFocusPainted(false);
        BtnRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnRefresh.addActionListener(this::BtnRefreshActionPerformed);

        BtnCari.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnCari.setForeground(new java.awt.Color(11, 31, 75));
        BtnCari.setText("Cari");
        BtnCari.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnCari.setFocusPainted(false);
        BtnCari.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnCari.addActionListener(this::BtnCariActionPerformed);

        FCari1.setForeground(new java.awt.Color(11, 31, 75));
        FCari1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FCari1.addActionListener(this::FCari1ActionPerformed);

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
        lblJudulHalaman.setText("Kelola Riwayat Pelacakan");
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

        BtnLihatDataPengantaranPetugasKonter.setForeground(new java.awt.Color(184, 196, 224));
        BtnLihatDataPengantaranPetugasKonter.setText("Pengantaran");
        BtnLihatDataPengantaranPetugasKonter.setBorderPainted(false);
        BtnLihatDataPengantaranPetugasKonter.setContentAreaFilled(false);
        BtnLihatDataPengantaranPetugasKonter.setFocusPainted(false);
        BtnLihatDataPengantaranPetugasKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLihatDataPengantaranPetugasKonter.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnLihatDataPengantaranPetugasKonter.addActionListener(this::BtnLihatDataPengantaranPetugasKonterActionPerformed);

        BtnMenuRiwayatPengiriman.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuRiwayatPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuRiwayatPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuRiwayatPengiriman.setText("Riwayat Pelacakan");
        BtnMenuRiwayatPengiriman.setBorderPainted(false);
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
                .addGap(228, 228, 228)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(973, 973, 973)
                .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(FCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPeranHeader2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(PTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        cariPengiriman();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void FCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FCari1ActionPerformed
        cariPengiriman();
    }//GEN-LAST:event_FCari1ActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed

        if (idPengiriman != -1) {
            tampilkanRiwayat();
        } else {
            kosongkanTabel();
        }

        bersihkanForm();
    }//GEN-LAST:event_BtnRefreshActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        if (idRiwayat == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih riwayat yang ingin diubah!");
            return;
        }

        try {
            String deskripsi = InputHelper.ambilTeks(FDeskripsi,
                    "Deskripsi");
            String waktu = InputHelper.ambilTeks(FWaktu, "Waktu");

            if (riwayatController.ubah(idRiwayat, deskripsi, waktu,
                    idPengiriman)) {

                JOptionPane.showMessageDialog(this,
                    "Riwayat berhasil diubah!");

                tampilkanRiwayat();
                bersihkanForm();
            }

        } catch (IllegalArgumentException e) {
            InputHelper.pesanPeringatan(this, e.getMessage());
        } catch (Exception e) {
            InputHelper.pesanError(this,
                "Gagal mengubah riwayat. Format waktu harus "
                + "yyyy-MM-dd HH:mm:ss\nDetail: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        if (idPengiriman == -1) {
            JOptionPane.showMessageDialog(this,
                "Cari nomor resi terlebih dahulu!");
            return;
        }

        try {
            String deskripsi = InputHelper.ambilTeks(FDeskripsi,
                    "Deskripsi");
            String waktu = InputHelper.ambilTeks(FWaktu, "Waktu");

            // Kondisi lengkap diperiksa di dalam controller
            if (riwayatController.tambah(deskripsi, waktu,
                    idPengiriman)) {

                JOptionPane.showMessageDialog(this,
                    "Riwayat berhasil ditambahkan!");

                tampilkanRiwayat();
                bersihkanForm();
            }

        } catch (IllegalArgumentException e) {
            InputHelper.pesanPeringatan(this, e.getMessage());
        } catch (Exception e) {
            InputHelper.pesanError(this,
                "Gagal menambah riwayat. Format waktu harus "
                + "yyyy-MM-dd HH:mm:ss\nDetail: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void FWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FWaktuActionPerformed
        String waktu = util.DatePickerKalender.bukaDialog(this, true);

        if (waktu != null) {
            FWaktu.setText(waktu);
        }
    }//GEN-LAST:event_FWaktuActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        tampilkanHalaman("menuKelolaPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed

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
    private javax.swing.JButton BtnTambah;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JTextField FCari1;
    private javax.swing.JTextField FDeskripsi;
    private javax.swing.JTextField FWaktu;
    private javax.swing.JLabel LAlamat;
    private javax.swing.JLabel LDeskripsi;
    private javax.swing.JLabel LFormRiwayatPelacakan;
    private javax.swing.JLabel LNilaiAlamat;
    private javax.swing.JLabel LNilaiNoResi;
    private javax.swing.JLabel LNilaiPenerima;
    private javax.swing.JLabel LNilaiStatus;
    private javax.swing.JLabel LNoResi;
    private javax.swing.JLabel LPenerima;
    private javax.swing.JLabel LStatus;
    private javax.swing.JLabel LWaktu;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenu2;
    private javax.swing.JPanel PTabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelRole;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JLabel lblPeranHeader2;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}
