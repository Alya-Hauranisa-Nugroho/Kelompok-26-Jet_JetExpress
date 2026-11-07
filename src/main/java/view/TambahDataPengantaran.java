/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.PengantaranController;
import controller.PengirimanController;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Pengiriman;
import util.DatePickerKalender;
import util.InputHelper;
import util.ValidasiKoordinat;

public class TambahDataPengantaran extends javax.swing.JPanel {

    private final PengantaranController pengantaranController
            = new PengantaranController();
    private final PengirimanController pengirimanController
            = new PengirimanController();
    private final PanelPeta peta = new PanelPeta();
    private boolean sedangIsiCombo = false;
    private java.io.File fotoBaru = null;

    public TambahDataPengantaran() {
    initComponents();
    aturKolomBuktiFoto();
    isiComboKurir();
    isiComboStatus();

    DatePickerKalender.pasang(FTgglTugas);

    PTampilankanMap.setLayout(new BorderLayout());
    PTampilankanMap.add(peta, BorderLayout.CENTER);
    peta.setModeLihatSaja(false);

    peta.saatKoordinatBerubah((latitude, longitude) -> {
        FLatitudeTujuan.setText(latitude == null
                ? "" : latitude.toPlainString());
        LLongitude.setText(longitude == null
                ? "" : longitude.toPlainString());
    });
}

public void persiapkanFormBaru() {
    kosongkanForm();
    isiComboKurir();
}

private void kosongkanForm() {
    FNomorResi.setText("");
    CKurir.setSelectedIndex(-1);
    FTgglTugas.setText("");
    FLatitudeTujuan.setText("");
    LLongitude.setText("");
    FBuktiFoto.setText("");
    fotoBaru = null;
    CCatatanKurir.setText("");
    CStatus.setSelectedItem("Ditugaskan");
    peta.resetKeSamarinda();
}

private void isiComboKurir() {
    sedangIsiCombo = true;
    CKurir.removeAllItems();

    try {
        List<Object[]> daftarKurir = pengantaranController.daftarKurir();

        for (Object[] baris : daftarKurir) {
            CKurir.addItem(baris[0] + " - " + baris[1]);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Gagal memuat data kurir: " + e.getMessage());
    } finally {
        sedangIsiCombo = false;
    }
}

private void isiComboStatus() {
    sedangIsiCombo = true;
    CStatus.removeAllItems();
    CStatus.addItem("Ditugaskan");
    CStatus.addItem("Dalam Perjalanan");
    CStatus.addItem("Berhasil");
    CStatus.addItem("Gagal");
    sedangIsiCombo = false;
}

private int ambilIdPengiriman() {
    String noResi = InputHelper.ambilTeks(FNomorResi, "Nomor resi");
    InputHelper.validasiNomorResi(noResi);

    try {
        Pengiriman pengiriman = pengirimanController
                .detailByResi(noResi.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Nomor resi " + noResi.toUpperCase()
                        + " tidak terdaftar."));
        return pengiriman.getIdPengiriman();

    } catch (java.sql.SQLException e) {
        throw new IllegalArgumentException(
                "Gagal memeriksa nomor resi: " + e.getMessage());
    }
}

private void pindahkanPetaKeKoordinat() {
    try {
        BigDecimal latitude = ValidasiKoordinat.parseLatitude(
                FLatitudeTujuan.getText());
        BigDecimal longitude = ValidasiKoordinat.parseLongitude(
                LLongitude.getText());
        ValidasiKoordinat.validasi(latitude, longitude);

        peta.setPosisi(latitude, longitude);

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    }
}

private void pilihFotoBukti() {
    java.io.File dipilih = image.ImageManager.pilihFoto(this);
    if (dipilih != null) {
        fotoBaru = dipilih;
        FBuktiFoto.setText(dipilih.getName());
        FBuktiFoto.setToolTipText(dipilih.getAbsolutePath());
    }
}

/** Mengatur kolom Bukti Foto: hanya klik, tidak diketik. */
private void aturKolomBuktiFoto() {
    FBuktiFoto.setEditable(false);
    FBuktiFoto.setBackground(java.awt.Color.WHITE);
    FBuktiFoto.setCursor(java.awt.Cursor.getPredefinedCursor(
            java.awt.Cursor.HAND_CURSOR));
    FBuktiFoto.setToolTipText(
            "Klik untuk memilih foto bukti dari penyimpanan laptop "
            + "(JPG/PNG, maks 2 MB)");
}

private void simpanDataPengantaran() {
    try {
        int idPengiriman = ambilIdPengiriman();
        int idKurir = InputHelper.ambilIdCombo(CKurir, "Kurir");
        String tanggal = InputHelper.ambilTeks(FTgglTugas,
                "Tanggal penugasan");

        // Koordinat wajib berasal dari peta / titik yang dipilih
        BigDecimal latitude = ValidasiKoordinat.parseLatitude(
                FLatitudeTujuan.getText());
        BigDecimal longitude = ValidasiKoordinat.parseLongitude(
                LLongitude.getText());
        ValidasiKoordinat.validasi(latitude, longitude);

        String status = InputHelper.ambilDipilih(CStatus, "Status");
        String catatan = CCatatanKurir.getText().trim();

        // Kondisi lengkap diperiksa InputHelper di dalam controller
        boolean berhasil = pengantaranController.tambah(
                idPengiriman, idKurir, tanggal,
                latitude, longitude, status, fotoBaru, catatan);

        if (berhasil) {
            JOptionPane.showMessageDialog(this,
                "Data pengantaran berhasil disimpan.");

            kosongkanForm();

            MainFrame main = (MainFrame)
                SwingUtilities.getWindowAncestor(this);

            if (main != null) {
                main.kembaliKeKelolaPengantaran();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Data pengantaran gagal disimpan.");
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
        InputHelper.pesanError(this,
            "Gagal menyimpan data: " + e.getMessage());
    }
}

private void tampilkanHalaman(String namaHalaman) {
    MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);

    if (frame != null) {
        frame.tampilkanHalaman(namaHalaman);
    }}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PPeta = new javax.swing.JPanel();
        PTampilankanMap = new javax.swing.JPanel();
        lblPetunjukPeta = new javax.swing.JLabel();
        lblJudulPeta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        CCatatanKurir = new javax.swing.JTextField();
        LCatatanKurir = new javax.swing.JLabel();
        FBuktiFoto = new javax.swing.JTextField();
        LBuktiFoto = new javax.swing.JLabel();
        CStatus = new javax.swing.JComboBox();
        LStatus = new javax.swing.JLabel();
        LLongitude = new javax.swing.JTextField();
        LLongitudeTujuan = new javax.swing.JLabel();
        FLatitudeTujuan = new javax.swing.JTextField();
        LLatitudeTujuan = new javax.swing.JLabel();
        FTgglTugas = new javax.swing.JTextField();
        LTgglTugas = new javax.swing.JLabel();
        CKurir = new javax.swing.JComboBox();
        LKurir = new javax.swing.JLabel();
        FNomorResi = new javax.swing.JTextField();
        LPengiriman = new javax.swing.JLabel();
        LFromPengantaran = new javax.swing.JLabel();
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

        PPeta.setBackground(new java.awt.Color(255, 255, 255));
        PPeta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PPeta.setPreferredSize(new java.awt.Dimension(385, 451));

        PTampilankanMap.setBackground(new java.awt.Color(255, 255, 255));
        PTampilankanMap.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PTampilankanMap.setPreferredSize(new java.awt.Dimension(351, 384));

        javax.swing.GroupLayout PTampilankanMapLayout = new javax.swing.GroupLayout(PTampilankanMap);
        PTampilankanMap.setLayout(PTampilankanMapLayout);
        PTampilankanMapLayout.setHorizontalGroup(
            PTampilankanMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        PTampilankanMapLayout.setVerticalGroup(
            PTampilankanMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        lblPetunjukPeta.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblPetunjukPeta.setForeground(new java.awt.Color(107, 122, 153));
        lblPetunjukPeta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPetunjukPeta.setText("Klik peta untuk mengisi latitude dan longitude otomatis.");
        lblPetunjukPeta.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblJudulPeta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblJudulPeta.setForeground(new java.awt.Color(11, 31, 75));
        lblJudulPeta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJudulPeta.setText("Pilih Lokasi Tujuan di Peta");
        lblJudulPeta.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PPetaLayout = new javax.swing.GroupLayout(PPeta);
        PPeta.setLayout(PPetaLayout);
        PPetaLayout.setHorizontalGroup(
            PPetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPetaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PPetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PTampilankanMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPetunjukPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJudulPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PPetaLayout.setVerticalGroup(
            PPetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPetaLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(PTampilankanMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPetaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblPetunjukPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPetaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblJudulPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(418, 451));

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

        CCatatanKurir.setForeground(new java.awt.Color(11, 31, 75));
        CCatatanKurir.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        CCatatanKurir.addActionListener(this::CCatatanKurirActionPerformed);

        LCatatanKurir.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LCatatanKurir.setForeground(new java.awt.Color(11, 31, 75));
        LCatatanKurir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCatatanKurir.setText("Catatan Kurir");
        LCatatanKurir.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FBuktiFoto.setForeground(new java.awt.Color(11, 31, 75));
        FBuktiFoto.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FBuktiFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FBuktiFotoMouseClicked(evt);
            }
        });

        LBuktiFoto.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LBuktiFoto.setForeground(new java.awt.Color(11, 31, 75));
        LBuktiFoto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBuktiFoto.setText("Bukti Foto");
        LBuktiFoto.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        CStatus.setForeground(new java.awt.Color(11, 31, 75));
        CStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        CStatus.addActionListener(this::CStatusActionPerformed);

        LStatus.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LStatus.setForeground(new java.awt.Color(11, 31, 75));
        LStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LStatus.setText("Status");
        LStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LLongitude.setForeground(new java.awt.Color(11, 31, 75));
        LLongitude.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        LLongitude.addActionListener(this::LLongitudeActionPerformed);

        LLongitudeTujuan.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LLongitudeTujuan.setForeground(new java.awt.Color(11, 31, 75));
        LLongitudeTujuan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LLongitudeTujuan.setText("Longitude Tujuan");
        LLongitudeTujuan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FLatitudeTujuan.setForeground(new java.awt.Color(11, 31, 75));
        FLatitudeTujuan.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FLatitudeTujuan.addActionListener(this::FLatitudeTujuanActionPerformed);

        LLatitudeTujuan.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LLatitudeTujuan.setForeground(new java.awt.Color(11, 31, 75));
        LLatitudeTujuan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LLatitudeTujuan.setText("Latitude Tujuan");
        LLatitudeTujuan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FTgglTugas.setForeground(new java.awt.Color(11, 31, 75));
        FTgglTugas.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FTgglTugas.addActionListener(this::FTgglTugasActionPerformed);

        LTgglTugas.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LTgglTugas.setForeground(new java.awt.Color(11, 31, 75));
        LTgglTugas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LTgglTugas.setText("Tanggal Tugas (yyyy-MM-dd)");
        LTgglTugas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        CKurir.setForeground(new java.awt.Color(11, 31, 75));
        CKurir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        CKurir.addActionListener(this::CKurirActionPerformed);

        LKurir.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LKurir.setForeground(new java.awt.Color(11, 31, 75));
        LKurir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKurir.setText("Kurir");
        LKurir.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNomorResi.setForeground(new java.awt.Color(11, 31, 75));
        FNomorResi.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNomorResi.addActionListener(this::FNomorResiActionPerformed);

        LPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LPengiriman.setForeground(new java.awt.Color(11, 31, 75));
        LPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LPengiriman.setText("Nomor Resi");
        LPengiriman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LFromPengantaran.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        LFromPengantaran.setForeground(new java.awt.Color(11, 31, 75));
        LFromPengantaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LFromPengantaran.setText("Tambah Data Pengantaran");
        LFromPengantaran.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(CCatatanKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LCatatanKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FBuktiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LBuktiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(CStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(LLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(LLongitudeTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FLatitudeTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LLatitudeTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FTgglTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LTgglTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(CKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(FNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LFromPengantaran, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(CCatatanKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(LCatatanKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(FBuktiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(LBuktiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(CStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(LLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(LLongitudeTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(FLatitudeTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(LLatitudeTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(FTgglTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(LTgglTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(CKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(LKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(FNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(LPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LFromPengantaran, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        lblJudulHalaman.setText("Tambah Pengantaran");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(664, 664, 664)
                .addComponent(PPeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(PPeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void FNomorResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNomorResiActionPerformed
        try {
            ambilIdPengiriman();
            InputHelper.pesanInfo(this,
                "Nomor resi terdaftar dan siap ditugaskan.");
            CKurir.requestFocus();

        } catch (IllegalArgumentException e) {
            InputHelper.pesanPeringatan(this, e.getMessage());
        }
    }//GEN-LAST:event_FNomorResiActionPerformed

    private void CKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CKurirActionPerformed
        if (sedangIsiCombo) {
            return;
        }
        if (CKurir.getSelectedItem() != null) {
            FLatitudeTujuan.requestFocus();
        }
    }//GEN-LAST:event_CKurirActionPerformed

    private void FTgglTugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FTgglTugasActionPerformed
        String tanggal = util.DatePickerKalender.bukaDialog(this, false);

        if (tanggal != null) {
            FTgglTugas.setText(tanggal);
        }
    }//GEN-LAST:event_FTgglTugasActionPerformed

    private void FLatitudeTujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FLatitudeTujuanActionPerformed
        // Enter pada latitude → lanjut isi longitude
        LLongitude.requestFocus();
    }//GEN-LAST:event_FLatitudeTujuanActionPerformed

    private void LLongitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LLongitudeActionPerformed
        // Enter pada longitude → peta berpindah ke koordinat tersebut
        pindahkanPetaKeKoordinat();
    }//GEN-LAST:event_LLongitudeActionPerformed

    private void CStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CStatusActionPerformed
        if (sedangIsiCombo) {
            return;
        }
        // Pengantaran baru selalu Ditugaskan; perubahan status
        // dilakukan lewat menu Ubah Data Pengantaran.
        if (CStatus.getSelectedItem() != null
                && !"Ditugaskan".equals(CStatus.getSelectedItem())) {
            InputHelper.pesanInfo(this,
                "Pengantaran baru otomatis berstatus Ditugaskan. "
                + "Perubahan status dilakukan lewat menu "
                + "Ubah Data Pengantaran.");
            CStatus.setSelectedItem("Ditugaskan");
        }
    }//GEN-LAST:event_CStatusActionPerformed

    private void FBuktiFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FBuktiFotoMouseClicked
        pilihFotoBukti();
    }//GEN-LAST:event_FBuktiFotoMouseClicked

    private void CCatatanKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCatatanKurirActionPerformed
        BtnSimpan.doClick();
    }//GEN-LAST:event_CCatatanKurirActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        simpanDataPengantaran();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        kosongkanForm();

        MainFrame main = (MainFrame)
        SwingUtilities.getWindowAncestor(this);

    if (main != null) {
        main.kembaliKeKelolaPengantaran();
    }
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        tampilkanHalaman("menuPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuOngkirActionPerformed
        tampilkanHalaman("menuOngkir");
    }//GEN-LAST:event_BtnMenuOngkirActionPerformed

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
        tampilkanHalaman("menuUtama");
    }//GEN-LAST:event_BtnMenuUtamaActionPerformed


    private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }


    private void BtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDashboardActionPerformed
        bukaHalaman("menuAdmin");
    }//GEN-LAST:event_BtnDashboardActionPerformed

    private void BtnMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUserActionPerformed
        bukaHalaman("menuUser");
    }//GEN-LAST:event_BtnMenuUserActionPerformed

    private void BtnMenuKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuKonterActionPerformed
        bukaHalaman("menuKonter");
    }//GEN-LAST:event_BtnMenuKonterActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
        bukaHalaman("menuRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnMenuPengantaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengantaranActionPerformed
        bukaHalaman("menuPengantaran");
    }//GEN-LAST:event_BtnMenuPengantaranActionPerformed
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
    private javax.swing.JTextField CCatatanKurir;
    private javax.swing.JComboBox CKurir;
    private javax.swing.JComboBox CStatus;
    private javax.swing.JTextField FBuktiFoto;
    private javax.swing.JTextField FLatitudeTujuan;
    private javax.swing.JTextField FNomorResi;
    private javax.swing.JTextField FTgglTugas;
    private javax.swing.JLabel LBuktiFoto;
    private javax.swing.JLabel LCatatanKurir;
    private javax.swing.JLabel LFromPengantaran;
    private javax.swing.JLabel LKurir;
    private javax.swing.JLabel LLatitudeTujuan;
    private javax.swing.JTextField LLongitude;
    private javax.swing.JLabel LLongitudeTujuan;
    private javax.swing.JLabel LPengiriman;
    private javax.swing.JLabel LStatus;
    private javax.swing.JLabel LTgglTugas;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenuAdmin;
    private javax.swing.JPanel PPeta;
    private javax.swing.JPanel PTampilankanMap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblJudulPeta;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelAdmin;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JLabel lblPetunjukPeta;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}
