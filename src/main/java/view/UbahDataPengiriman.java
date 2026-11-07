/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.KonterController;
import controller.OngkirController;
import controller.PengirimanController;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import model.Ongkir;
import model.Pengiriman;
import util.DatePickerKalender;
import util.InputHelper;
import util.KonversiWaktu;

public class UbahDataPengiriman extends javax.swing.JPanel {

    private final PengirimanController pengirimanController
            = new PengirimanController();
    private final KonterController konterController
            = new KonterController();
    private final OngkirController ongkirController
            = new OngkirController();

    private String noResiSaatIni;
    private int idPaketSaatIni;

    private List<Ongkir> daftarOngkir = List.of();
    
    public UbahDataPengiriman() {
    initComponents();

    aturComboBox();
    tampilkanDataKonter();
    tampilkanDataOngkir();
    aturInputCOD();

    DatePickerKalender.pasang(jTextField2);

    InputHelper.pasangNomorHp(FNoHpPengirim);
    InputHelper.pasangNomorHp(FNoHpPenerima);

    LNilaiTotalBayar.setText("-");

    BtnDashboard.addActionListener(evt ->
            tampilkanHalaman("menuAdmin"));
    BtnMenuOngkir.addActionListener(evt ->
            tampilkanHalaman("menuOngkir"));
    BtnMenuKonter.addActionListener(evt ->
            tampilkanHalaman("menuKonter"));
    BtnMenuPengantaran.addActionListener(evt ->
            tampilkanHalaman("menuPengantaran"));
    BtnMenuPengiriman.addActionListener(evt ->
            tampilkanHalaman("menuPengiriman"));
    BtnMenuRiwayatPengiriman.addActionListener(evt ->
            tampilkanHalaman("menuRiwayat"));
    BtnMenuUser.addActionListener(evt ->
            tampilkanHalaman("menuUser"));
}

public void ambilDataPengiriman(String noResi) {
    noResiSaatIni = noResi;

    try {
        Pengiriman data = pengirimanController.detailByResi(noResi)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Data pengiriman dengan nomor resi "
                        + noResi + " tidak ditemukan!"));

        idPaketSaatIni = data.getIdPaket();

        FNamaBarang.setText(data.getNamaBarang());
        FBerat.setText(data.getBerat() == null
                ? "" : data.getBerat().toPlainString());
        CJenisBarang.setSelectedItem(data.getJenisBarang());

        FNamaPengirim.setText(data.getNamaPengirim());
        InputHelper.isiNomorHp(FNoHpPengirim,
                data.getNoTelpPengirim());
        FAlamatPengirim.setText(data.getAlamatPengirim());

        FNamaPenerima.setText(data.getNamaPenerima());
        InputHelper.isiNomorHp(FNoHpPenerima,
                data.getNoTelpPenerima());
        FAlamatPenerima.setText(data.getAlamatPenerima());

        LNomorResiOtomatis.setText(data.getNoResi());

        jComboBox1.setSelectedItem(data.getJenisPengiriman());

        pilihComboBoxBerdasarkanId(jComboBox2, data.getIdKonter());
        pilihComboBoxBerdasarkanIdOngkir(jComboBox3, data.getIdOngkir());

        jComboBox4.setSelectedItem(data.getMetodeBayar());

        jTextField1.setText(String.valueOf(data.getCod()));

        jTextField2.setText(
                KonversiWaktu.teksTanggal(data.getBatasKirim()));

        jComboBox5.setSelectedItem(data.getStatusPengiriman());

        tampilkanTotalOngkir();

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
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
        List<Object[]> daftarKonter = konterController.tampilkan();

        jComboBox2.removeAllItems();

        for (Object[] baris : daftarKonter) {
            jComboBox2.addItem(baris[0] + " - " + baris[1]);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Gagal mengambil data konter: " + e.getMessage()
        );
    }
}

private void tampilkanDataOngkir() {
    try {
        daftarOngkir = ongkirController.semuaModel();

        jComboBox3.removeAllItems();

        for (Ongkir ongkir : daftarOngkir) {
            jComboBox3.addItem(ongkir.teksCombo());
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Gagal mengambil data ongkir: " + e.getMessage()
        );
    }
}

private void pilihComboBoxBerdasarkanId(javax.swing.JComboBox<String> combo,
        int id) {
    for (int i = 0; i < combo.getItemCount(); i++) {
        if (combo.getItemAt(i).startsWith(id + " - ")) {
            combo.setSelectedIndex(i);
            return;
        }
    }
}

private void pilihComboBoxBerdasarkanIdOngkir(
        javax.swing.JComboBox<String> combo, int idOngkir) {
    for (int i = 0; i < daftarOngkir.size(); i++) {
        if (daftarOngkir.get(i).getIdOngkir() == idOngkir) {
            combo.setSelectedIndex(i);
            return;
        }
    }
}

private int hitungTotalOngkir() {
    try {
        int indeks = jComboBox3.getSelectedIndex();

        if (indeks < 0 || indeks >= daftarOngkir.size()
                || FBerat.getText().trim().isEmpty()) {
            return 0;
        }

        BigDecimal berat = new BigDecimal(
                FBerat.getText().trim().replace(",", ".")
        );

        if (berat.compareTo(BigDecimal.ZERO) <= 0
                || berat.compareTo(new BigDecimal("50")) > 0) {
            return 0;
        }
        
        java.util.Map<String, Object> rincian =
                ongkirController.hitungTarif(
                        daftarOngkir.get(indeks).teksCombo(),
                        berat.toPlainString());

        return ((Number) rincian.get("total_biaya")).intValue();

    } catch (Exception e) {
        return 0;
    }
}

private void tampilkanTotalOngkir() {
    int total = hitungTotalOngkir();

    if (total > 0) {
        LNilaiTotalBayar.setText(KonversiWaktu.rupiah(total));
    } else {
        LNilaiTotalBayar.setText("-");
    }
}

private void ubahDataPengiriman() {

    if (noResiSaatIni == null || noResiSaatIni.trim().isEmpty()) {
        InputHelper.pesanPeringatan(this,
            "Tidak ada pengiriman yang dipilih. "
            + "Buka lewat menu Kelola Pengiriman.");
        return;
    }

    // Validasi input kosong
    if (FNamaBarang.getText().trim().isEmpty()
            || FBerat.getText().trim().isEmpty()
            || FNamaPengirim.getText().trim().isEmpty()
            || FNoHpPengirim.getText().trim().isEmpty()
            || FAlamatPengirim.getText().trim().isEmpty()
            || FNamaPenerima.getText().trim().isEmpty()
            || FNoHpPenerima.getText().trim().isEmpty()
            || FAlamatPenerima.getText().trim().isEmpty()
            || jTextField2.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(this,
                "Semua data wajib diisi!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (jComboBox2.getSelectedItem() == null
            || jComboBox3.getSelectedItem() == null) {

        JOptionPane.showMessageDialog(this,
                "Data konter atau ongkir belum tersedia!");
        return;
    }

    try {
        String namaBarang = InputHelper.ambilTeks(FNamaBarang,
                "Nama barang");
        BigDecimal berat = InputHelper.ambilDesimal(FBerat, "Berat");
        String jenisBarang = InputHelper.ambilDipilih(CJenisBarang,
                "Jenis barang");

        String namaPengirim = InputHelper.ambilTeks(FNamaPengirim,
                "Nama pengirim");
        String noHpPengirim = InputHelper.ambilTelepon(FNoHpPengirim,
                "No. HP pengirim");
        String alamatPengirim = InputHelper.ambilTeks(FAlamatPengirim,
                "Alamat pengirim");

        String namaPenerima = InputHelper.ambilTeks(FNamaPenerima,
                "Nama penerima");
        String noHpPenerima = InputHelper.ambilTelepon(FNoHpPenerima,
                "No. HP penerima");
        String alamatPenerima = InputHelper.ambilTeks(FAlamatPenerima,
                "Alamat penerima");

        String jenisPengiriman = InputHelper.ambilDipilih(jComboBox1,
                "Jenis pengiriman");
        String metodeBayar = InputHelper.ambilDipilih(jComboBox4,
                "Metode bayar");
        String status = InputHelper.ambilDipilih(jComboBox5,
                "Status pengiriman");

        int idKonter = InputHelper.ambilIdCombo(jComboBox2, "Konter");
        int idOngkir = daftarOngkir.get(
                jComboBox3.getSelectedIndex()).getIdOngkir();

        int cod = InputHelper.ambilAngka(jTextField1, "Nominal COD");

        if (cod < 0) {
            JOptionPane.showMessageDialog(this,
                    "Nilai COD tidak boleh negatif!");
            return;
        }

        if (!metodeBayar.equals("COD") && cod != 0) {
            JOptionPane.showMessageDialog(this,
                    "Nilai COD hanya boleh diisi jika metode "
                    + "pembayaran COD!");
            return;
        }

        String batasKirim = InputHelper.ambilTeks(jTextField2,
                "Batas kirim");

        int totalBiaya = hitungTotalOngkir();

        if (totalBiaya <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Total biaya belum dapat dihitung. Periksa "
                    + "berat paket dan pilihan jarak!");
            return;
        }
        
        boolean berhasil = pengirimanController.ubah(
                noResiSaatIni, jenisPengiriman, totalBiaya,
                metodeBayar, cod, batasKirim, status, idKonter,
                String.valueOf(idOngkir),
                namaBarang, berat, jenisBarang,
                namaPengirim, noHpPengirim, alamatPengirim,
                namaPenerima, noHpPenerima, alamatPenerima);

        if (berhasil) {
            JOptionPane.showMessageDialog(this,
                "Data pengiriman berhasil diperbarui!");

            kosongkanForm();
            tampilkanHalaman("menuPengiriman");
        } else {
            JOptionPane.showMessageDialog(this,
                "Data pengiriman tidak berhasil diperbarui.");
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (Exception e) {
        InputHelper.pesanError(this,
                "Gagal mengubah data pengiriman: " + e.getMessage());
    }
}

private void kosongkanForm() {
    noResiSaatIni = null;
    idPaketSaatIni = 0;

    FNamaBarang.setText("");
    FBerat.setText("");

    FNamaPengirim.setText("");
    InputHelper.isiNomorHp(FNoHpPengirim, "08");
    FAlamatPengirim.setText("");

    FNamaPenerima.setText("");
    InputHelper.isiNomorHp(FNoHpPenerima, "08");
    FAlamatPenerima.setText("");

    jTextField1.setText("");
    jTextField2.setText("");

    CJenisBarang.setSelectedIndex(0);
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(-1);
    jComboBox3.setSelectedIndex(-1);
    jComboBox4.setSelectedIndex(0);
    jComboBox5.setSelectedIndex(0);

    LNomorResiOtomatis.setText("-");
    LNilaiTotalBayar.setText("-");
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
        jTextField1.setText("");
    } else {
        jTextField1.setText("0");
        jTextField1.setEditable(false);
        jTextField1.setEnabled(false);
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
        jComboBox5.addActionListener(this::jComboBox5ActionPerformed);

        LStatus.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LStatus.setForeground(new java.awt.Color(11, 31, 75));
        LStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LStatus.setText("Status");
        LStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTextField2.setForeground(new java.awt.Color(11, 31, 75));
        jTextField2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        LEstimasiKirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LEstimasiKirim.setForeground(new java.awt.Color(11, 31, 75));
        LEstimasiKirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LEstimasiKirim.setText("Estimasi Kirim (yyyy-MM-dd)");
        LEstimasiKirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTextField1.setForeground(new java.awt.Color(11, 31, 75));
        jTextField1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        LNilaiCOD.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiCOD.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiCOD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiCOD.setText("Nilai COD (Rp)");
        LNilaiCOD.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBox4.setForeground(new java.awt.Color(11, 31, 75));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        jComboBox4.addActionListener(this::jComboBox4ActionPerformed);

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
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        LKonter.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LKonter.setForeground(new java.awt.Color(11, 31, 75));
        LKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKonter.setText("Konter");
        LKonter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBox1.setForeground(new java.awt.Color(11, 31, 75));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

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
        FAlamatPenerima.addActionListener(this::FAlamatPenerimaActionPerformed);

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
        FNamaPenerima.addActionListener(this::FNamaPenerimaActionPerformed);

        LNamaPenerima.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNamaPenerima.setForeground(new java.awt.Color(11, 31, 75));
        LNamaPenerima.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNamaPenerima.setText("Nama Penerima");
        LNamaPenerima.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FAlamatPengirim.setForeground(new java.awt.Color(11, 31, 75));
        FAlamatPengirim.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FAlamatPengirim.addActionListener(this::FAlamatPengirimActionPerformed);

        LAlamatPengirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LAlamatPengirim.setForeground(new java.awt.Color(11, 31, 75));
        LAlamatPengirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LAlamatPengirim.setText("Alamat Pengirim");
        LAlamatPengirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNoHpPengirim.setForeground(new java.awt.Color(11, 31, 75));
        FNoHpPengirim.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNoHpPengirim.addActionListener(this::FNoHpPengirimActionPerformed);

        LNoPengirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNoPengirim.setForeground(new java.awt.Color(11, 31, 75));
        LNoPengirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNoPengirim.setText("No. HP Pengirim");
        LNoPengirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNamaPengirim.setForeground(new java.awt.Color(11, 31, 75));
        FNamaPengirim.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNamaPengirim.addActionListener(this::FNamaPengirimActionPerformed);

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
        CJenisBarang.addActionListener(this::CJenisBarangActionPerformed);

        LJenisBarang.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LJenisBarang.setForeground(new java.awt.Color(11, 31, 75));
        LJenisBarang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LJenisBarang.setText("Jenis Barang");
        LJenisBarang.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FBerat.setForeground(new java.awt.Color(11, 31, 75));
        FBerat.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FBerat.addActionListener(this::FBeratActionPerformed);

        LBerat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LBerat.setForeground(new java.awt.Color(11, 31, 75));
        LBerat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBerat.setText("Berat (KG)");
        LBerat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNamaBarang.setForeground(new java.awt.Color(11, 31, 75));
        FNamaBarang.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNamaBarang.addActionListener(this::FNamaBarangActionPerformed);

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

        BtnMenuPengiriman.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuPengiriman.setText("Pengiriman");
        BtnMenuPengiriman.setBorderPainted(false);
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
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        tampilkanTotalOngkir();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void FNoHpPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNoHpPenerimaActionPerformed
        FAlamatPenerima.requestFocus();
    }//GEN-LAST:event_FNoHpPenerimaActionPerformed

    private void FNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNamaBarangActionPerformed
        FBerat.requestFocus();
    }//GEN-LAST:event_FNamaBarangActionPerformed

    private void FBeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FBeratActionPerformed
        tampilkanTotalOngkir();
        CJenisBarang.requestFocus();
    }//GEN-LAST:event_FBeratActionPerformed

    private void CJenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJenisBarangActionPerformed
        FNamaPengirim.requestFocus();
    }//GEN-LAST:event_CJenisBarangActionPerformed

    private void FNamaPengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNamaPengirimActionPerformed
        FNoHpPengirim.requestFocus();
    }//GEN-LAST:event_FNamaPengirimActionPerformed

    private void FNoHpPengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNoHpPengirimActionPerformed
        FAlamatPengirim.requestFocus();
    }//GEN-LAST:event_FNoHpPengirimActionPerformed

    private void FAlamatPengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAlamatPengirimActionPerformed
        FNamaPenerima.requestFocus();
    }//GEN-LAST:event_FAlamatPengirimActionPerformed

    private void FNamaPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNamaPenerimaActionPerformed
        FNoHpPenerima.requestFocus();
    }//GEN-LAST:event_FNamaPenerimaActionPerformed

    private void FAlamatPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAlamatPenerimaActionPerformed
        jTextField2.requestFocus();
    }//GEN-LAST:event_FAlamatPenerimaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedItem() != null) {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if (jComboBox2.getSelectedItem() != null) {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        aturInputCOD();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jComboBox5.requestFocus();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        String tanggal = util.DatePickerKalender.bukaDialog(this, false);

        if (tanggal != null) {
            jTextField2.setText(tanggal);
            jComboBox4.requestFocus();
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        if (jComboBox5.getSelectedItem() != null) {
            BtnSimpan.requestFocus();
        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        ubahDataPengiriman();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        int pilihan = JOptionPane.showConfirmDialog(this,
            "Batalkan perubahan data pengiriman?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION);

        if (pilihan == JOptionPane.YES_OPTION) {
            kosongkanForm();
            tampilkanHalaman("menuPengiriman");
        }
    }//GEN-LAST:event_BtnBatalActionPerformed

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

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        bukaHalaman("menuPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuOngkirActionPerformed
        bukaHalaman("menuOngkir");
    }//GEN-LAST:event_BtnMenuOngkirActionPerformed

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
    private javax.swing.JPanel PMenuAdmin;
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
    private javax.swing.JLabel lblPanelAdmin;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JPanel pnlAvatar;
    private javax.swing.JPanel pnlGarisTotal;
    // End of variables declaration//GEN-END:variables
}
