/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.LacakPaketController;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import util.TeksPetunjuk;

public class LacakPaket extends javax.swing.JPanel {

    private final LacakPaketController lacakPaketController
            = new LacakPaketController();

    public LacakPaket() {
    initComponents();
PUtama.setPreferredSize(new java.awt.Dimension(1075, 568));

    JScrollPane scrollPane = new JScrollPane(PUtama);
    scrollPane.setBorder(null);

    scrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    );

    scrollPane.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    );

    scrollPane.getVerticalScrollBar().setUnitIncrement(16);

    setLayout(new BorderLayout());
    add(scrollPane, BorderLayout.CENTER);

    TeksPetunjuk.pasang(InputNomorResi, "Masukkan nomor resi");
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PUtama = new javax.swing.JPanel();
        PRiwayat = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        LRiwayat = new javax.swing.JLabel();
        PInformasiPaket = new javax.swing.JPanel();
        BtnMenuUtama = new javax.swing.JButton();
        pnlGarisInfo = new javax.swing.JPanel();
        LNilaiEstimasiKirim = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LNilaiStatus = new javax.swing.JLabel();
        LStatus = new javax.swing.JLabel();
        LNilaiBerat = new javax.swing.JLabel();
        LBeratPaket = new javax.swing.JLabel();
        LNilaiPenerima = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LNilaiPengirim = new javax.swing.JLabel();
        LPengirim = new javax.swing.JLabel();
        LNilaiNomorResi = new javax.swing.JLabel();
        LNomorResi = new javax.swing.JLabel();
        LInformasiPaket = new javax.swing.JLabel();
        PPencarian = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        InputNomorResi = new javax.swing.JTextField();
        lblCariResi = new javax.swing.JLabel();
        PBenner = new javax.swing.JPanel();
        KalimatLacakPaketIsi = new javax.swing.JLabel();
        pnlAksenHero = new javax.swing.JPanel();
        KalimatLacakPaket = new javax.swing.JLabel();
        lblMaskotTeks = new javax.swing.JLabel();
        PNavbar = new javax.swing.JPanel();
        btnNavLogin = new javax.swing.JButton();
        btnNavKonter = new javax.swing.JButton();
        btnNavTarif = new javax.swing.JButton();
        pnlNavAktif = new javax.swing.JPanel();
        btnNavLacak = new javax.swing.JButton();
        btnNavBeranda = new javax.swing.JButton();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));

        PUtama.setBackground(new java.awt.Color(245, 247, 251));
        PUtama.setPreferredSize(new java.awt.Dimension(1075, 568));

        PRiwayat.setBackground(new java.awt.Color(255, 255, 255));
        PRiwayat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PRiwayat.setPreferredSize(new java.awt.Dimension(608, 241));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Waktu", "Deskripsi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable3.setForeground(new java.awt.Color(11, 31, 75));
        jTable3.setGridColor(new java.awt.Color(227, 232, 242));
        jTable3.setRowHeight(24);
        jTable3.setFillsViewportHeight(true);
        jTable3.setSelectionBackground(new java.awt.Color(255, 240, 227));
        jTable3.setSelectionForeground(new java.awt.Color(11, 31, 75));
        jScrollPane3.setViewportView(jTable3);

        LRiwayat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        LRiwayat.setForeground(new java.awt.Color(11, 31, 75));
        LRiwayat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LRiwayat.setText("Riwayat Pelacakan");
        LRiwayat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PRiwayatLayout = new javax.swing.GroupLayout(PRiwayat);
        PRiwayat.setLayout(PRiwayatLayout);
        PRiwayatLayout.setHorizontalGroup(
            PRiwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRiwayatLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PRiwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PRiwayatLayout.setVerticalGroup(
            PRiwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRiwayatLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PRiwayatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PInformasiPaket.setBackground(new java.awt.Color(255, 255, 255));
        PInformasiPaket.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PInformasiPaket.setPreferredSize(new java.awt.Dimension(336, 241));

        BtnMenuUtama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuUtama.setForeground(new java.awt.Color(11, 31, 75));
        BtnMenuUtama.setText("Menu Utama");
        BtnMenuUtama.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnMenuUtama.setFocusPainted(false);
        BtnMenuUtama.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnMenuUtama.addActionListener(this::BtnMenuUtamaActionPerformed);

        pnlGarisInfo.setBackground(new java.awt.Color(227, 232, 242));
        pnlGarisInfo.setPreferredSize(new java.awt.Dimension(289, 1));

        javax.swing.GroupLayout pnlGarisInfoLayout = new javax.swing.GroupLayout(pnlGarisInfo);
        pnlGarisInfo.setLayout(pnlGarisInfoLayout);
        pnlGarisInfoLayout.setHorizontalGroup(
            pnlGarisInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
        pnlGarisInfoLayout.setVerticalGroup(
            pnlGarisInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        LNilaiEstimasiKirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiEstimasiKirim.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiEstimasiKirim.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNilaiEstimasiKirim.setText("-");
        LNilaiEstimasiKirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(107, 122, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Estimasi Kirim");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiStatus.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiStatus.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNilaiStatus.setText("-");
        LNilaiStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LStatus.setForeground(new java.awt.Color(107, 122, 153));
        LStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LStatus.setText("Status");
        LStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiBerat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiBerat.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiBerat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNilaiBerat.setText("-");
        LNilaiBerat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LBeratPaket.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LBeratPaket.setForeground(new java.awt.Color(107, 122, 153));
        LBeratPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBeratPaket.setText("Berat Paket");
        LBeratPaket.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiPenerima.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiPenerima.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiPenerima.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNilaiPenerima.setText("-");
        LNilaiPenerima.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(107, 122, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Penerima");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiPengirim.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiPengirim.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiPengirim.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNilaiPengirim.setText("-");
        LNilaiPengirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LPengirim.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LPengirim.setForeground(new java.awt.Color(107, 122, 153));
        LPengirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LPengirim.setText("Pengirim");
        LPengirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiNomorResi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNilaiNomorResi.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiNomorResi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LNilaiNomorResi.setText("-");
        LNilaiNomorResi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNomorResi.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LNomorResi.setForeground(new java.awt.Color(107, 122, 153));
        LNomorResi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNomorResi.setText("Nomor Resi");
        LNomorResi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LInformasiPaket.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        LInformasiPaket.setForeground(new java.awt.Color(11, 31, 75));
        LInformasiPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LInformasiPaket.setText("Informasi Paket");
        LInformasiPaket.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PInformasiPaketLayout = new javax.swing.GroupLayout(PInformasiPaket);
        PInformasiPaket.setLayout(PInformasiPaketLayout);
        PInformasiPaketLayout.setHorizontalGroup(
            PInformasiPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(BtnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnlGarisInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LNilaiEstimasiKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LNilaiStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LNilaiBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LBeratPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LNilaiPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LNilaiPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LNilaiNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LInformasiPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PInformasiPaketLayout.setVerticalGroup(
            PInformasiPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(BtnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(pnlGarisInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(LNilaiEstimasiKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LNilaiStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(LStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(LNilaiBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(LBeratPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(LNilaiPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(LNilaiPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(LPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(LNilaiNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(LNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PInformasiPaketLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LInformasiPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PPencarian.setBackground(new java.awt.Color(255, 255, 255));
        PPencarian.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PPencarian.setPreferredSize(new java.awt.Dimension(968, 71));

        jButton1.setBackground(new java.awt.Color(255, 107, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cek Data Pengiriman");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        InputNomorResi.setForeground(new java.awt.Color(11, 31, 75));
        InputNomorResi.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        InputNomorResi.addActionListener(this::InputNomorResiActionPerformed);

        lblCariResi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCariResi.setForeground(new java.awt.Color(11, 31, 75));
        lblCariResi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCariResi.setText("Nomor Resi");
        lblCariResi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PPencarianLayout = new javax.swing.GroupLayout(PPencarian);
        PPencarian.setLayout(PPencarianLayout);
        PPencarianLayout.setHorizontalGroup(
            PPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPencarianLayout.createSequentialGroup()
                .addGap(763, 763, 763)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPencarianLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(InputNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPencarianLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblCariResi, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PPencarianLayout.setVerticalGroup(
            PPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPencarianLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPencarianLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(InputNomorResi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PPencarianLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblCariResi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PBenner.setBackground(new java.awt.Color(11, 31, 75));
        PBenner.setPreferredSize(new java.awt.Dimension(1075, 142));

        KalimatLacakPaketIsi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        KalimatLacakPaketIsi.setForeground(new java.awt.Color(184, 196, 224));
        KalimatLacakPaketIsi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        KalimatLacakPaketIsi.setText("Masukkan nomor resi untuk melihat status dan riwayat pengiriman paket Anda");
        KalimatLacakPaketIsi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        pnlAksenHero.setBackground(new java.awt.Color(255, 107, 0));
        pnlAksenHero.setPreferredSize(new java.awt.Dimension(59, 3));

        javax.swing.GroupLayout pnlAksenHeroLayout = new javax.swing.GroupLayout(pnlAksenHero);
        pnlAksenHero.setLayout(pnlAksenHeroLayout);
        pnlAksenHeroLayout.setHorizontalGroup(
            pnlAksenHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        pnlAksenHeroLayout.setVerticalGroup(
            pnlAksenHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        KalimatLacakPaket.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        KalimatLacakPaket.setForeground(new java.awt.Color(255, 255, 255));
        KalimatLacakPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        KalimatLacakPaket.setText("Lacak Paket");
        KalimatLacakPaket.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblMaskotTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaskotTeks.setForeground(new java.awt.Color(255, 255, 255));
        lblMaskotTeks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaskotTeks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JetySenyum.png"))); // NOI18N
        lblMaskotTeks.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PBennerLayout = new javax.swing.GroupLayout(PBenner);
        PBenner.setLayout(PBennerLayout);
        PBennerLayout.setHorizontalGroup(
            PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBennerLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KalimatLacakPaketIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KalimatLacakPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(lblMaskotTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        PBennerLayout.setVerticalGroup(
            PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBennerLayout.createSequentialGroup()
                .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PBennerLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(KalimatLacakPaketIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PBennerLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PBennerLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(KalimatLacakPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblMaskotTeks, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PNavbar.setBackground(new java.awt.Color(255, 255, 255));
        PNavbar.setPreferredSize(new java.awt.Dimension(1075, 51));

        btnNavLogin.setBackground(new java.awt.Color(255, 107, 0));
        btnNavLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNavLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnNavLogin.setText("Login");
        btnNavLogin.setBorderPainted(false);
        btnNavLogin.setFocusPainted(false);
        btnNavLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavLogin.addActionListener(this::btnNavLoginActionPerformed);

        btnNavKonter.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavKonter.setForeground(new java.awt.Color(11, 31, 75));
        btnNavKonter.setText("Konter Kami");
        btnNavKonter.setBorderPainted(false);
        btnNavKonter.setContentAreaFilled(false);
        btnNavKonter.setFocusPainted(false);
        btnNavKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavKonter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavKonter.addActionListener(this::btnNavKonterActionPerformed);

        btnNavTarif.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavTarif.setForeground(new java.awt.Color(11, 31, 75));
        btnNavTarif.setText("Cek Tarif");
        btnNavTarif.setBorderPainted(false);
        btnNavTarif.setContentAreaFilled(false);
        btnNavTarif.setFocusPainted(false);
        btnNavTarif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTarif.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavTarif.addActionListener(this::btnNavTarifActionPerformed);

        pnlNavAktif.setBackground(new java.awt.Color(255, 107, 0));
        pnlNavAktif.setPreferredSize(new java.awt.Dimension(76, 3));

        javax.swing.GroupLayout pnlNavAktifLayout = new javax.swing.GroupLayout(pnlNavAktif);
        pnlNavAktif.setLayout(pnlNavAktifLayout);
        pnlNavAktifLayout.setHorizontalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        pnlNavAktifLayout.setVerticalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btnNavLacak.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavLacak.setForeground(new java.awt.Color(255, 107, 0));
        btnNavLacak.setText("Lacak Paket");
        btnNavLacak.setBorderPainted(false);
        btnNavLacak.setContentAreaFilled(false);
        btnNavLacak.setFocusPainted(false);
        btnNavLacak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavLacak.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavLacak.addActionListener(this::btnNavLacakActionPerformed);

        btnNavBeranda.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavBeranda.setForeground(new java.awt.Color(11, 31, 75));
        btnNavBeranda.setText("Beranda");
        btnNavBeranda.setBorderPainted(false);
        btnNavBeranda.setContentAreaFilled(false);
        btnNavBeranda.setFocusPainted(false);
        btnNavBeranda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavBeranda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNavBeranda.addActionListener(this::btnNavBerandaActionPerformed);

        lblLogoExpress.setFont(new java.awt.Font("Segoe UI", 3, 27)); // NOI18N
        lblLogoExpress.setForeground(new java.awt.Color(11, 31, 75));
        lblLogoExpress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoExpress.setText("Express");
        lblLogoExpress.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblLogoJet.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        lblLogoJet.setForeground(new java.awt.Color(255, 107, 0));
        lblLogoJet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoJet.setText("Jet");
        lblLogoJet.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PNavbarLayout = new javax.swing.GroupLayout(PNavbar);
        PNavbar.setLayout(PNavbarLayout);
        PNavbarLayout.setHorizontalGroup(
            PNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(956, 956, 956)
                .addComponent(btnNavLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(707, 707, 707)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(615, 615, 615)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(509, 509, 509)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(btnNavLacak, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(btnNavBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PNavbarLayout.setVerticalGroup(
            PNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnNavLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavLacak, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblLogoExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PUtamaLayout = new javax.swing.GroupLayout(PUtama);
        PUtama.setLayout(PUtamaLayout);
        PUtamaLayout.setHorizontalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(PRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(PInformasiPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(PPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PUtamaLayout.setVerticalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(PRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(PInformasiPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(PPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PUtama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
private void tampilkanDataPaket(String nomorResi) {
    try {
        Map<String, Object> data = lacakPaketController.lacak(nomorResi);

        if (data == null) {
            JOptionPane.showMessageDialog(
                this,
                "Nomor resi " + nomorResi.toUpperCase()
                + " tidak terdaftar!",
                "Informasi",
                JOptionPane.INFORMATION_MESSAGE
            );

            resetData();
            return;
        }

        LNilaiNomorResi.setText(String.valueOf(data.get("no_resi")));
        LNilaiBerat.setText(data.get("berat") + " kg");
        LNilaiPenerima.setText(String.valueOf(data.get("nama_penerima")));
        LNilaiStatus.setText(String.valueOf(data.get("status")));

        Object estimasi = data.get("estimasi");

        if (estimasi != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            LNilaiEstimasiKirim.setText(format.format(estimasi));
        } else {
            LNilaiEstimasiKirim.setText("-");
        }

        int idPengiriman = ((Number) data.get("id_pengiriman")).intValue();

        tampilkanRiwayat(idPengiriman);

    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );

        resetData();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal mengambil data paket: " + e.getMessage(),
            "Kesalahan Database",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
private void tampilkanRiwayat(int idPengiriman) throws SQLException {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    model.setRowCount(0);

    List<Object[]> daftarRiwayat = lacakPaketController.riwayat(idPengiriman);

    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    for (Object[] riwayat : daftarRiwayat) {
        String waktu = "-";

        if (riwayat[0] != null) {
            waktu = format.format((Timestamp) riwayat[0]);
        }

        model.addRow(new Object[]{
            waktu,
            riwayat[1]
        });
    }
}
private void resetData() {
    LNilaiNomorResi.setText("-");
    LNilaiBerat.setText("-");
    LNilaiPenerima.setText("-");
    LNilaiStatus.setText("-");
    LNilaiEstimasiKirim.setText("-");

    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    model.setRowCount(0);
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    String nomorResi = TeksPetunjuk.ambilNilai(InputNomorResi);

    if (nomorResi.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Masukkan nomor resi terlebih dahulu!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    tampilkanDataPaket(nomorResi);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void InputNomorResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNomorResiActionPerformed
    jButton1ActionPerformed(evt);
    }//GEN-LAST:event_InputNomorResiActionPerformed

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUtamaActionPerformed
        pindahHalaman("menuUtama");
    }//GEN-LAST:event_BtnMenuUtamaActionPerformed

private void pindahHalaman(String namaHalaman) {
    MainFrame frame = (MainFrame) SwingUtilities.getWindowAncestor(this);

    if (frame != null) {
        frame.tampilkanHalaman(namaHalaman);
    } else {
        JOptionPane.showMessageDialog(
            this,
            "MainFrame belum terhubung!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
    }
}

    private void btnNavBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavBerandaActionPerformed
        pindahHalaman("menuUtama");
    }//GEN-LAST:event_btnNavBerandaActionPerformed

    private void btnNavLacakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavLacakActionPerformed
        pindahHalaman("lacakPaket");
    }//GEN-LAST:event_btnNavLacakActionPerformed

    private void btnNavTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavTarifActionPerformed
        pindahHalaman("cekTarif");
    }//GEN-LAST:event_btnNavTarifActionPerformed

    private void btnNavKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavKonterActionPerformed
        pindahHalaman("konterKami");
    }//GEN-LAST:event_btnNavKonterActionPerformed

    private void btnNavLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavLoginActionPerformed
        pindahHalaman("login");
    }//GEN-LAST:event_btnNavLoginActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JTextField InputNomorResi;
    private javax.swing.JLabel KalimatLacakPaket;
    private javax.swing.JLabel KalimatLacakPaketIsi;
    private javax.swing.JLabel LBeratPaket;
    private javax.swing.JLabel LInformasiPaket;
    private javax.swing.JLabel LNilaiBerat;
    private javax.swing.JLabel LNilaiEstimasiKirim;
    private javax.swing.JLabel LNilaiNomorResi;
    private javax.swing.JLabel LNilaiPenerima;
    private javax.swing.JLabel LNilaiPengirim;
    private javax.swing.JLabel LNilaiStatus;
    private javax.swing.JLabel LNomorResi;
    private javax.swing.JLabel LPengirim;
    private javax.swing.JLabel LRiwayat;
    private javax.swing.JLabel LStatus;
    private javax.swing.JPanel PBenner;
    private javax.swing.JPanel PInformasiPaket;
    private javax.swing.JPanel PNavbar;
    private javax.swing.JPanel PPencarian;
    private javax.swing.JPanel PRiwayat;
    private javax.swing.JPanel PUtama;
    private javax.swing.JButton btnNavBeranda;
    private javax.swing.JButton btnNavKonter;
    private javax.swing.JButton btnNavLacak;
    private javax.swing.JButton btnNavLogin;
    private javax.swing.JButton btnNavTarif;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblCariResi;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblMaskotTeks;
    private javax.swing.JPanel pnlAksenHero;
    private javax.swing.JPanel pnlGarisInfo;
    private javax.swing.JPanel pnlNavAktif;
    // End of variables declaration//GEN-END:variables
}
