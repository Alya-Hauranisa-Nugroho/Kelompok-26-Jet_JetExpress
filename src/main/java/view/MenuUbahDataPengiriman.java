/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.OngkirController;
import controller.PengirimanController;
import controller.KonterController;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Locale;
import model.Pengiriman;
import util.DatePickerKalender;
import util.InputHelper;

public class MenuUbahDataPengiriman extends javax.swing.JPanel {

    private final PengirimanController pengirimanController
            = new PengirimanController();
    private final KonterController konterController
            = new KonterController();
    private final OngkirController ongkirController
            = new OngkirController();

    private String noResiSaatIni;
    private int idPaketSaatIni;
 public MenuUbahDataPengiriman() {
    initComponents();

    aturComboBox();
    tampilkanDataKonter();
    tampilkanDataOngkir();
    aturInputCOD();

    InputHelper.pasangNomorHp(FNoHpPengirim);
    InputHelper.pasangNomorHp(FNoHpPenerima);

    DatePickerKalender.pasang(jTextField2);

    pantauPerubahanTeks(FBerat, this::tampilkanTotalOngkir);
    pantauPerubahanTeks(jTextField1, this::tampilkanTotalOngkir);
    jComboBox3.addItemListener(e -> tampilkanTotalOngkir());

    jComboBox4.addItemListener(e -> aturInputCOD());

    LNilaiTotalBayar.setText("-");
}

private void pantauPerubahanTeks(javax.swing.JTextField field,
        Runnable aksi) {
    field.getDocument().addDocumentListener(
            new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(
                javax.swing.event.DocumentEvent e) {
            aksi.run();
        }

        @Override
        public void removeUpdate(
                javax.swing.event.DocumentEvent e) {
            aksi.run();
        }

        @Override
        public void changedUpdate(
                javax.swing.event.DocumentEvent e) {
            aksi.run();
        }
    });
}

public void ambilDataPengiriman(String noResi) {
    noResiSaatIni = noResi;

    try {
        Pengiriman pengiriman = pengirimanController
                .detailByResi(noResi)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Data pengiriman dengan nomor resi "
                        + noResi + " tidak ditemukan!"));

        idPaketSaatIni = pengiriman.getIdPaket();

        FNamaBarang.setText(pengiriman.getNamaBarang());
        FBerat.setText(pengiriman.getBerat()
                == null ? "" : pengiriman.getBerat().toPlainString());
        CJenisBarang.setSelectedItem(pengiriman.getJenisBarang());

        FNamaPengirim.setText(pengiriman.getNamaPengirim());
        InputHelper.isiNomorHp(FNoHpPengirim,
                pengiriman.getNoTelpPengirim());
        FAlamatPengirim.setText(pengiriman.getAlamatPengirim());

        FNamaPenerima.setText(pengiriman.getNamaPenerima());
        InputHelper.isiNomorHp(FNoHpPenerima,
                pengiriman.getNoTelpPenerima());
        FAlamatPenerima.setText(pengiriman.getAlamatPenerima());

        LNomorResiOtomatis.setText(pengiriman.getNoResi());

        jComboBox1.setSelectedItem(
                pengiriman.getJenisPengiriman());

        pilihComboBoxBerdasarkanId(
                jComboBox2, pengiriman.getIdKonter());

        pilihComboBoxBerdasarkanId(
                jComboBox3, pengiriman.getIdOngkir());

        jComboBox4.setSelectedItem(
                pengiriman.getMetodeBayar());

        jTextField1.setText(
                String.valueOf(pengiriman.getCod()));

        jTextField2.setText(
                pengiriman.getBatasKirim() == null
                ? "" : pengiriman.getBatasKirim().toString());

        jComboBox5.setSelectedItem(
                pengiriman.getStatusPengiriman());

        tampilkanTotalOngkir();

    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal mengambil data pengiriman: " + e.getMessage()
        );
    }
}
private void aturComboBox() {
    CJenisBarang.removeAllItems();
    CJenisBarang.addItem("Dokumen");
    CJenisBarang.addItem("Elektronik");
    CJenisBarang.addItem("Pakaian");
    CJenisBarang.addItem("Umum");

    jComboBox1.removeAllItems();
    jComboBox1.addItem("Intracity");
    jComboBox1.addItem("Outbound");
    jComboBox1.addItem("Inbound");

    jComboBox4.removeAllItems();
    jComboBox4.addItem("Cash");
    jComboBox4.addItem("Cashless");
    jComboBox4.addItem("COD");

    jComboBox5.removeAllItems();
    jComboBox5.addItem("Diterima Konter");
    jComboBox5.addItem("Dalam Pengiriman");
    jComboBox5.addItem("Terkirim");
    jComboBox5.addItem("Gagal");
}

private void tampilkanDataKonter() {
    try {
        List<Object[]> daftarKonter =
                konterController.tampilkan();

        jComboBox2.removeAllItems();

        for (Object[] konter : daftarKonter) {
            jComboBox2.addItem(
                konter[0] + " - " + konter[1]
            );
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this, "Gagal mengambil data konter: " + e.getMessage()
        );
    }
}

private void tampilkanDataOngkir() {
    try {
        List<Object[]> daftarOngkir =
                ongkirController.tampilkan();

        jComboBox3.removeAllItems();

        for (Object[] ongkir : daftarOngkir) {
            jComboBox3.addItem(
                ongkir[0] + " - "
                + ongkir[1]
                + " sampai "
                + ongkir[2]
                + " km - Rp "
                + ongkir[3]
            );
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this, "Gagal mengambil data ongkir: " + e.getMessage()
        );
    }
}

private void pilihComboBoxBerdasarkanId(
        javax.swing.JComboBox<String> combo, int id) {

    for (int i = 0; i < combo.getItemCount(); i++) {
        String item = combo.getItemAt(i);

        if (item != null && item.startsWith(id + " -")) {
            combo.setSelectedIndex(i);
            return;
        }
    }
}
private int hitungTotalOngkir() {
    if (jComboBox3.getSelectedItem() == null) {
        return 0;
    }

    try {
        String pilihan = jComboBox3.getSelectedItem().toString();
        int idOngkir = Integer.parseInt(
                pilihan.split(" - ")[0].trim());

        BigDecimal berat = new BigDecimal(
                FBerat.getText().trim().replace(",", "."));

        if (berat.compareTo(BigDecimal.ZERO) <= 0
                || berat.compareTo(new BigDecimal("50")) > 0) {
            return 0;
        }

        Integer tarifDasar =
                ongkirController.tarifDasar(idOngkir);

        if (tarifDasar == null) {
            return 0;
        }

        BigDecimal biayaBerat =
                berat.multiply(new BigDecimal("3000"));

        return BigDecimal.valueOf(tarifDasar)
                .add(biayaBerat)
                .setScale(0, java.math.RoundingMode.CEILING)
                .intValue();

    } catch (Exception e) {
        return 0;
    }
}

private void tampilkanTotalOngkir() {
    int total = hitungTotalOngkir();

    if (total <= 0) {
        LNilaiTotalBayar.setText("-");
        return;
    }

    NumberFormat format =
        NumberFormat.getInstance(new Locale("id", "ID"));

    LNilaiTotalBayar.setText("Rp " + format.format(total));
}
private void ubahDataPengiriman() {

    if (noResiSaatIni == null || noResiSaatIni.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nomor resi tidak ditemukan!");
        return;
    }

    if (FNamaBarang.getText().trim().isEmpty()
            || FBerat.getText().trim().isEmpty()
            || FNamaPengirim.getText().trim().isEmpty()
            || FNoHpPengirim.getText().trim().isEmpty()
            || FAlamatPengirim.getText().trim().isEmpty()
            || FNamaPenerima.getText().trim().isEmpty()
            || FNoHpPenerima.getText().trim().isEmpty()
            || FAlamatPenerima.getText().trim().isEmpty()
            || jTextField2.getText().trim().isEmpty()
            || jComboBox1.getSelectedItem() == null
            || jComboBox2.getSelectedItem() == null
            || jComboBox3.getSelectedItem() == null
            || jComboBox4.getSelectedItem() == null
            || jComboBox5.getSelectedItem() == null
            || CJenisBarang.getSelectedItem() == null) {

        JOptionPane.showMessageDialog(this, "Semua data harus diisi!");
        return;
    }

    try {
        BigDecimal berat = InputHelper.ambilDesimal(FBerat,
                "Berat paket");

        if (berat.compareTo(BigDecimal.ZERO) <= 0
                || berat.compareTo(new BigDecimal("50")) > 0) {
            JOptionPane.showMessageDialog(
                this, "Berat harus lebih dari 0 kg dan maksimal 50 kg!"
            );
            return;
        }

        String noHpPengirim = FNoHpPengirim.getText().trim();
        String noHpPenerima = FNoHpPenerima.getText().trim();

        InputHelper.validasiNomorHp(noHpPengirim,
                "No. HP pengirim");
        InputHelper.validasiNomorHp(noHpPenerima,
                "No. HP penerima");

        int cod = Integer.parseInt(jTextField1.getText().trim());

        if (cod < 0) {
            JOptionPane.showMessageDialog(this, "Nilai COD tidak boleh negatif!");
            return;
        }

        int totalBiaya = hitungTotalOngkir();

        if (totalBiaya <= 0) {
            JOptionPane.showMessageDialog(
                this, "Total ongkir tidak valid. Periksa berat dan tarif!"
            );
            return;
        }

        String batasKirim = jTextField2.getText().trim();

        int idKonter = Integer.parseInt(
            jComboBox2.getSelectedItem().toString()
                    .split(" - ")[0].trim()
        );

        int idOngkir = Integer.parseInt(
            jComboBox3.getSelectedItem().toString()
                    .split(" - ")[0].trim()
        );

        boolean berhasil = pengirimanController.ubah(
            noResiSaatIni,
            jComboBox1.getSelectedItem().toString(),
            totalBiaya,
            jComboBox4.getSelectedItem().toString(),
            cod,
            batasKirim,
            jComboBox5.getSelectedItem().toString(),
            idKonter,
            String.valueOf(idOngkir),
            FNamaBarang.getText().trim(),
            berat,
            CJenisBarang.getSelectedItem().toString(),
            FNamaPengirim.getText().trim(),
            noHpPengirim,
            FAlamatPengirim.getText().trim(),
            FNamaPenerima.getText().trim(),
            noHpPenerima,
            FAlamatPenerima.getText().trim()
        );

        if (berhasil) {
            JOptionPane.showMessageDialog(
                this, "Data pengiriman berhasil diperbarui!"
            );

            tampilkanHalaman("menuKelolaPengiriman");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
            this, "Berat atau nilai COD harus berupa angka!"
        );

    } catch (IllegalArgumentException e) {

        JOptionPane.showMessageDialog(
            this, e.getMessage()
        );

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this, "Gagal mengubah data: " + e.getMessage()
        );
    }
}
private void aturInputCOD() {
    Object pilihan = jComboBox4.getSelectedItem();

    String metode = pilihan == null
            ? ""
            : pilihan.toString().trim();

    if (metode.equalsIgnoreCase("COD")) {
        jTextField1.setEnabled(true);
        jTextField1.setEditable(true);
        jTextField1.setBackground(java.awt.Color.WHITE);
    } else {
        jTextField1.setText("0");
        jTextField1.setEditable(false);
        jTextField1.setEnabled(false);
    }
}
private void tampilkanHalaman(String namaHalaman) {
    MainFrame frame = (MainFrame)
        javax.swing.SwingUtilities.getWindowAncestor(this);

    if (frame != null) {
        frame.tampilkanHalaman(namaHalaman);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnBatal = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LNilaiTotalBayar = new javax.swing.JLabel();
        LTotalBayar = new javax.swing.JLabel();
        pnlGarisTotal = new javax.swing.JPanel();
        jComboBox5 = new javax.swing.JComboBox();
        LStatus = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        LEstimasiKirim = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        LNilaiCOD = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        LMetodeBayar = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        LJarakTarif = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        LKonter = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        LJenisPengiriman = new javax.swing.JLabel();
        LNomorResiOtomatis = new javax.swing.JLabel();
        LNoResi = new javax.swing.JLabel();
        LPengiriman = new javax.swing.JLabel();
        PDataPengirim = new javax.swing.JPanel();
        FAlamatPenerima = new javax.swing.JTextField();
        LAlamatPenerima = new javax.swing.JLabel();
        FNoHpPenerima = new javax.swing.JTextField();
        LNoPenerima = new javax.swing.JLabel();
        FNamaPenerima = new javax.swing.JTextField();
        LNamaPenerima = new javax.swing.JLabel();
        FAlamatPengirim = new javax.swing.JTextField();
        LAlamatPengirim = new javax.swing.JLabel();
        FNoHpPengirim = new javax.swing.JTextField();
        LNoPengirim = new javax.swing.JLabel();
        FNamaPengirim = new javax.swing.JTextField();
        LNamaPengirim = new javax.swing.JLabel();
        lblDataPihak = new javax.swing.JLabel();
        PData = new javax.swing.JPanel();
        CJenisBarang = new javax.swing.JComboBox();
        LJenisBarang = new javax.swing.JLabel();
        FBerat = new javax.swing.JTextField();
        LBerat = new javax.swing.JLabel();
        FNamaBarang = new javax.swing.JTextField();
        LNamaBarang = new javax.swing.JLabel();
        LDataPaket = new javax.swing.JLabel();
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

        BtnBatal.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnBatal.setForeground(new java.awt.Color(11, 31, 75));
        BtnBatal.setText("Batal");
        BtnBatal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnBatal.setFocusPainted(false);
        BtnBatal.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnBatal.addActionListener(this::BtnBatalActionPerformed);

        BtnSimpan.setBackground(new java.awt.Color(255, 107, 0));
        BtnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        BtnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan.setText("Simpan");
        BtnSimpan.setBorderPainted(false);
        BtnSimpan.setFocusPainted(false);
        BtnSimpan.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnSimpan.addActionListener(this::BtnSimpanActionPerformed);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(262, 437));

        LNilaiTotalBayar.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        LNilaiTotalBayar.setForeground(new java.awt.Color(255, 107, 0));
        LNilaiTotalBayar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNilaiTotalBayar.setText("-");
        LNilaiTotalBayar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LTotalBayar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        LTotalBayar.setForeground(new java.awt.Color(11, 31, 75));
        LTotalBayar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LTotalBayar.setText("Total Bayar");
        LTotalBayar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pnlGarisTotal.setBackground(new java.awt.Color(227, 232, 242));
        pnlGarisTotal.setPreferredSize(new java.awt.Dimension(228, 1));

        javax.swing.GroupLayout pnlGarisTotalLayout = new javax.swing.GroupLayout(pnlGarisTotal);
        pnlGarisTotal.setLayout(pnlGarisTotalLayout);
        pnlGarisTotalLayout.setHorizontalGroup(
            pnlGarisTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        pnlGarisTotalLayout.setVerticalGroup(
            pnlGarisTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jComboBox5.setForeground(new java.awt.Color(11, 31, 75));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        LStatus.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LStatus.setForeground(new java.awt.Color(11, 31, 75));
        LStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LStatus.setText("Status");
        LStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTextField2.setForeground(new java.awt.Color(11, 31, 75));
        jTextField2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LEstimasiKirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LEstimasiKirim.setForeground(new java.awt.Color(11, 31, 75));
        LEstimasiKirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LEstimasiKirim.setText("Estimasi Kirim (yyyy-MM-dd)");
        LEstimasiKirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTextField1.setForeground(new java.awt.Color(11, 31, 75));
        jTextField1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LNilaiCOD.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiCOD.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiCOD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiCOD.setText("Nilai COD (Rp)");
        LNilaiCOD.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBox4.setForeground(new java.awt.Color(11, 31, 75));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        LMetodeBayar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LMetodeBayar.setForeground(new java.awt.Color(11, 31, 75));
        LMetodeBayar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LMetodeBayar.setText("Metode Pembayaran");
        LMetodeBayar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBox3.setForeground(new java.awt.Color(11, 31, 75));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        jComboBox3.addActionListener(this::jComboBox3ActionPerformed);

        LJarakTarif.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LJarakTarif.setForeground(new java.awt.Color(11, 31, 75));
        LJarakTarif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LJarakTarif.setText("Jarak Tarif");
        LJarakTarif.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBox2.setForeground(new java.awt.Color(11, 31, 75));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        LKonter.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LKonter.setForeground(new java.awt.Color(11, 31, 75));
        LKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKonter.setText("Konter");
        LKonter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBox1.setForeground(new java.awt.Color(11, 31, 75));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        LJenisPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LJenisPengiriman.setForeground(new java.awt.Color(11, 31, 75));
        LJenisPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LJenisPengiriman.setText("Jenis Pengiriman");
        LJenisPengiriman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNomorResiOtomatis.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNomorResiOtomatis.setForeground(new java.awt.Color(255, 107, 0));
        LNomorResiOtomatis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNomorResiOtomatis.setText("(dibuat otomatis)");
        LNomorResiOtomatis.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNoResi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNoResi.setForeground(new java.awt.Color(11, 31, 75));
        LNoResi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNoResi.setText("No. Resi");
        LNoResi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LPengiriman.setForeground(new java.awt.Color(11, 31, 75));
        LPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LPengiriman.setText("Data Pengiriman");
        LPengiriman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(LNilaiTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlGarisTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LEstimasiKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LNilaiCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LMetodeBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LJarakTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LJenisPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(LNomorResiOtomatis, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LNoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(LNilaiTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(LTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(pnlGarisTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(LEstimasiKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(LNilaiCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(LMetodeBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(LJarakTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(LKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(LJenisPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(LNomorResiOtomatis, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(LNoResi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PDataPengirim.setBackground(new java.awt.Color(255, 255, 255));
        PDataPengirim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PDataPengirim.setPreferredSize(new java.awt.Dimension(262, 325));

        FAlamatPenerima.setForeground(new java.awt.Color(11, 31, 75));
        FAlamatPenerima.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LAlamatPenerima.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LAlamatPenerima.setForeground(new java.awt.Color(11, 31, 75));
        LAlamatPenerima.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LAlamatPenerima.setText("Alamat Penerima");
        LAlamatPenerima.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNoHpPenerima.setForeground(new java.awt.Color(11, 31, 75));
        FNoHpPenerima.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNoHpPenerima.addActionListener(this::FNoHpPenerimaActionPerformed);

        LNoPenerima.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNoPenerima.setForeground(new java.awt.Color(11, 31, 75));
        LNoPenerima.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNoPenerima.setText("No. HP Penerima");
        LNoPenerima.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNamaPenerima.setForeground(new java.awt.Color(11, 31, 75));
        FNamaPenerima.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LNamaPenerima.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNamaPenerima.setForeground(new java.awt.Color(11, 31, 75));
        LNamaPenerima.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNamaPenerima.setText("Nama Penerima");
        LNamaPenerima.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FAlamatPengirim.setForeground(new java.awt.Color(11, 31, 75));
        FAlamatPengirim.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LAlamatPengirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LAlamatPengirim.setForeground(new java.awt.Color(11, 31, 75));
        LAlamatPengirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LAlamatPengirim.setText("Alamat Pengirim");
        LAlamatPengirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNoHpPengirim.setForeground(new java.awt.Color(11, 31, 75));
        FNoHpPengirim.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LNoPengirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNoPengirim.setForeground(new java.awt.Color(11, 31, 75));
        LNoPengirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNoPengirim.setText("No. HP Pengirim");
        LNoPengirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNamaPengirim.setForeground(new java.awt.Color(11, 31, 75));
        FNamaPengirim.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LNamaPengirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNamaPengirim.setForeground(new java.awt.Color(11, 31, 75));
        LNamaPengirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNamaPengirim.setText("Nama Pengirim");
        LNamaPengirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblDataPihak.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDataPihak.setForeground(new java.awt.Color(11, 31, 75));
        lblDataPihak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDataPihak.setText("Pengirim dan Penerima");
        lblDataPihak.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PDataPengirimLayout = new javax.swing.GroupLayout(PDataPengirim);
        PDataPengirim.setLayout(PDataPengirimLayout);
        PDataPengirimLayout.setHorizontalGroup(
            PDataPengirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PDataPengirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FAlamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LAlamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FNoHpPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNoPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FNamaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNamaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FAlamatPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LAlamatPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FNoHpPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNoPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FNamaPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNamaPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataPihak, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PDataPengirimLayout.setVerticalGroup(
            PDataPengirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(FAlamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(LAlamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(FNoHpPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(LNoPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(FNamaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(LNamaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(FAlamatPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(LAlamatPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(FNoHpPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(LNoPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(FNamaPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(LNamaPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataPengirimLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblDataPihak, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PData.setBackground(new java.awt.Color(255, 255, 255));
        PData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PData.setPreferredSize(new java.awt.Dimension(262, 189));

        CJenisBarang.setForeground(new java.awt.Color(11, 31, 75));
        CJenisBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));

        LJenisBarang.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LJenisBarang.setForeground(new java.awt.Color(11, 31, 75));
        LJenisBarang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LJenisBarang.setText("Jenis Barang");
        LJenisBarang.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FBerat.setForeground(new java.awt.Color(11, 31, 75));
        FBerat.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LBerat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LBerat.setForeground(new java.awt.Color(11, 31, 75));
        LBerat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBerat.setText("Berat (KG)");
        LBerat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNamaBarang.setForeground(new java.awt.Color(11, 31, 75));
        FNamaBarang.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LNamaBarang.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNamaBarang.setForeground(new java.awt.Color(11, 31, 75));
        LNamaBarang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNamaBarang.setText("Nama Barang");
        LNamaBarang.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LDataPaket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LDataPaket.setForeground(new java.awt.Color(11, 31, 75));
        LDataPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LDataPaket.setText("Data Paket");
        LDataPaket.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PDataLayout = new javax.swing.GroupLayout(PData);
        PData.setLayout(PDataLayout);
        PDataLayout.setHorizontalGroup(
            PDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LDataPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PDataLayout.setVerticalGroup(
            PDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(CJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(LJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(FBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(LBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(FNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(LNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PDataLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LDataPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        lblJudulHalaman.setText("Ubah Pengiriman");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(786, 786, 786)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(507, 507, 507)
                .addComponent(PDataPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(PData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(PDataPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(PData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        tampilkanTotalOngkir();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void FNoHpPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNoHpPenerimaActionPerformed

        BtnSimpan.requestFocusInWindow();
    }//GEN-LAST:event_FNoHpPenerimaActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed

       ubahDataPengiriman();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
    int pilihan = JOptionPane.showConfirmDialog(
        this,
        "Batalkan perubahan data pengiriman?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION
    );

    if (pilihan == JOptionPane.YES_OPTION) {
        tampilkanHalaman("menuKelolaPengiriman");
    }
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
        tampilkanHalaman("menuUtama");
    }//GEN-LAST:event_BtnMenuUtamaActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        tampilkanHalaman("menuPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
        tampilkanHalaman("menuRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnLihatDataPengantaranPetugasKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatDataPengantaranPetugasKonterActionPerformed
        tampilkanHalaman("menuPengantaran");
    }//GEN-LAST:event_BtnLihatDataPengantaranPetugasKonterActionPerformed

    private void BtnMenuCekTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuCekTarifActionPerformed
        tampilkanHalaman("menuCekTarif");
    }//GEN-LAST:event_BtnMenuCekTarifActionPerformed

    private void BtnLihatDafatrKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLihatDafatrKonterActionPerformed
        tampilkanHalaman("lihatDaftarKonter");
    }//GEN-LAST:event_BtnLihatDafatrKonterActionPerformed


    private void bukaHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnLihatDafatrKonter;
    private javax.swing.JButton BtnLihatDataPengantaranPetugasKonter;
    private javax.swing.JButton BtnMenuCekTarif;
    private javax.swing.JButton BtnMenuPengiriman;
    private javax.swing.JButton BtnMenuRiwayatPengiriman;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JComboBox CJenisBarang;
    private javax.swing.JTextField FAlamatPenerima;
    private javax.swing.JTextField FAlamatPengirim;
    private javax.swing.JTextField FBerat;
    private javax.swing.JTextField FNamaBarang;
    private javax.swing.JTextField FNamaPenerima;
    private javax.swing.JTextField FNamaPengirim;
    private javax.swing.JTextField FNoHpPenerima;
    private javax.swing.JTextField FNoHpPengirim;
    private javax.swing.JLabel LAlamatPenerima;
    private javax.swing.JLabel LAlamatPengirim;
    private javax.swing.JLabel LBerat;
    private javax.swing.JLabel LDataPaket;
    private javax.swing.JLabel LEstimasiKirim;
    private javax.swing.JLabel LJarakTarif;
    private javax.swing.JLabel LJenisBarang;
    private javax.swing.JLabel LJenisPengiriman;
    private javax.swing.JLabel LKonter;
    private javax.swing.JLabel LMetodeBayar;
    private javax.swing.JLabel LNamaBarang;
    private javax.swing.JLabel LNamaPenerima;
    private javax.swing.JLabel LNamaPengirim;
    private javax.swing.JLabel LNilaiCOD;
    private javax.swing.JLabel LNilaiTotalBayar;
    private javax.swing.JLabel LNoPenerima;
    private javax.swing.JLabel LNoPengirim;
    private javax.swing.JLabel LNoResi;
    private javax.swing.JLabel LNomorResiOtomatis;
    private javax.swing.JLabel LPengiriman;
    private javax.swing.JLabel LStatus;
    private javax.swing.JLabel LTotalBayar;
    private javax.swing.JPanel PData;
    private javax.swing.JPanel PDataPengirim;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenu2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblDataPihak;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblPanelRole;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JPanel pnlAvatar;
    private javax.swing.JPanel pnlGarisTotal;
    // End of variables declaration//GEN-END:variables
}
