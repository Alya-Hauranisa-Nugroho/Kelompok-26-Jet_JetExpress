/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.SwingUtilities;
import controller.DashboardController;
import java.util.Map;
import javax.swing.JOptionPane;
import util.InputHelper;
import util.Sesi;

public class MenuAdmin extends javax.swing.JPanel {

    private final DashboardController dashboardController = new DashboardController();
    public MenuAdmin() {
        initComponents();
        tampilkanStatistik();
        tampilkanLaporanPengirimanPerKonter();
    }
    public void tampilkanStatistik() {

    try {
        Map<String, Integer> data = dashboardController.statistik();

        LNilaiTotalPaket.setText(
            String.valueOf(data.get("total_paket"))
        );

        LNilaiTerkirim.setText(
            String.valueOf(data.get("total_terkirim"))
        );

        LNilaiGagalTerkirim.setText(
            String.valueOf(data.get("total_gagal"))
        );

        LNilaiDalamPengiriman.setText(
            String.valueOf(data.get("total_dalam_pengiriman"))
        );

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal mengambil statistik: " + e.getMessage(),
            "Kesalahan Database",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
    private int jumlahUntukKonter(
        Map<String, Integer> data, String namaKonter) {

    for (Map.Entry<String, Integer> entri : data.entrySet()) {
        String namaDatabase = entri.getKey();

        if (namaDatabase != null
                && namaDatabase.trim().equalsIgnoreCase(namaKonter)) {
            return entri.getValue();
        }
    }

    return 0;
    }
    
    public void tampilkanLaporanPengirimanPerKonter() {
    try {
        Map<String, Integer> data =
                dashboardController.pengirimanPerKonter();

        String[] namaKonter = {
            "JetExpress Samarinda Kota",
            "JetExpress Samarinda Ilir",
            "JetExpress Samarinda Ulu",
            "JetExpress Samarinda Utara",
            "JetExpress Samarinda Seberang",
            "JetExpress Sungai Kunjang",
            "JetExpress Sungai Pinang",
            "JetExpress Sambutan",
            "JetExpress Loa Janan Ilir",
            "JetExpress Palaran"
        };

        javax.swing.JProgressBar[] progressBar = {
            PgSamarindaKota,
            BgSamarindaIlir,
            PgSmarindaUlu,
            PgSamarindaUtara,
            PgSamarindaSeberang,
            PgSunagiKunjang,
            PgSungaipinang,
            PgSambutan,
            PgLoaJanan,
            PgPalaran
        };

        javax.swing.JLabel[] labelJumlah = {
            LNilaiSamarindaKota,
            LNilaiSamarindaIlir,
            LNilaiSamarindaUlu,
            LNilaiSamarindaUtara,
            LNilaiSamarindaSeberang,
            LNilaiSungaiKunjang,
            LNilaiSungaiPinang,
            LNilaiSambutan,
            LNilaiLoaJanan,
            LNilaiPalaran
        };

        int[] jumlah = new int[namaKonter.length];
        int jumlahMaksimum = 0;

        for (int i = 0; i < namaKonter.length; i++) {
            jumlah[i] = jumlahUntukKonter(data, namaKonter[i]);

            if (jumlah[i] > jumlahMaksimum) {
                jumlahMaksimum = jumlah[i];
            }
        }

        int maksimumBar = Math.max(jumlahMaksimum, 1);

        for (int i = 0; i < namaKonter.length; i++) {
            progressBar[i].setMinimum(0);
            progressBar[i].setMaximum(maksimumBar);
            progressBar[i].setValue(jumlah[i]);
            progressBar[i].setStringPainted(false);

            labelJumlah[i].setText(
                String.valueOf(jumlah[i])
            );
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal memuat laporan pengiriman per konter: "
                    + e.getMessage(),
            "Kesalahan Database",
            JOptionPane.ERROR_MESSAGE
        );
    }}
    
public void setNamaAdmin(String nama) {
    LNamaAdmin.setText(nama);
}
private void tampilkanHalaman(String namaHalaman) {
    java.awt.Window window =
            SwingUtilities.getWindowAncestor(this);

    if (window instanceof MainFrame) {
        MainFrame frame = (MainFrame) window;
        frame.tampilkanHalaman(namaHalaman);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pStat3 = new javax.swing.JPanel();
        lblNote3 = new javax.swing.JLabel();
        LNilaiGagalTerkirim = new javax.swing.JLabel();
        LGagalTerkirim = new javax.swing.JLabel();
        pStat2 = new javax.swing.JPanel();
        lblNote2 = new javax.swing.JLabel();
        LNilaiTerkirim = new javax.swing.JLabel();
        LTotalTerkirim = new javax.swing.JLabel();
        pStat1 = new javax.swing.JPanel();
        lblNote1 = new javax.swing.JLabel();
        LNilaiDalamPengiriman = new javax.swing.JLabel();
        LDalamPengiriman = new javax.swing.JLabel();
        pStat0 = new javax.swing.JPanel();
        lblNote0 = new javax.swing.JLabel();
        LNilaiTotalPaket = new javax.swing.JLabel();
        LTotalPaket = new javax.swing.JLabel();
        PBenner = new javax.swing.JPanel();
        pnlAksen = new javax.swing.JPanel();
        LNamaAdmin = new javax.swing.JLabel();
        LSelamatDatang = new javax.swing.JLabel();
        lblMaskotTeks = new javax.swing.JLabel();
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
        jPanel9 = new javax.swing.JPanel();
        LLaporanPenfiriman = new javax.swing.JLabel();
        PgSamarindaKota = new javax.swing.JProgressBar();
        LSamarindaKota = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LSamarindaIlir = new javax.swing.JLabel();
        LSamarindaUlu = new javax.swing.JLabel();
        LSamarindaUtara = new javax.swing.JLabel();
        LSamarindaSeberang = new javax.swing.JLabel();
        LSungaiKunjang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LSambutan = new javax.swing.JLabel();
        LLoaJanan = new javax.swing.JLabel();
        LPalaran = new javax.swing.JLabel();
        BgSamarindaIlir = new javax.swing.JProgressBar();
        PgSmarindaUlu = new javax.swing.JProgressBar();
        PgSamarindaUtara = new javax.swing.JProgressBar();
        PgSamarindaSeberang = new javax.swing.JProgressBar();
        PgSunagiKunjang = new javax.swing.JProgressBar();
        PgSungaipinang = new javax.swing.JProgressBar();
        PgSambutan = new javax.swing.JProgressBar();
        PgLoaJanan = new javax.swing.JProgressBar();
        PgPalaran = new javax.swing.JProgressBar();
        LNilaiSamarindaKota = new javax.swing.JLabel();
        LNilaiSamarindaIlir = new javax.swing.JLabel();
        LNilaiSamarindaUtara = new javax.swing.JLabel();
        LNilaiSamarindaSeberang = new javax.swing.JLabel();
        LNilaiSungaiKunjang = new javax.swing.JLabel();
        LNilaiSungaiPinang = new javax.swing.JLabel();
        LNilaiSambutan = new javax.swing.JLabel();
        LNilaiLoaJanan = new javax.swing.JLabel();
        LNilaiSamarindaUlu = new javax.swing.JLabel();
        LNilaiPalaran = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));

        pStat3.setBackground(new java.awt.Color(255, 255, 255));
        pStat3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pStat3.setPreferredSize(new java.awt.Dimension(195, 74));

        lblNote3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNote3.setForeground(new java.awt.Color(220, 38, 38));
        lblNote3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNote3.setText("Perlu ditindaklanjuti");
        lblNote3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiGagalTerkirim.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        LNilaiGagalTerkirim.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiGagalTerkirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiGagalTerkirim.setText("-");
        LNilaiGagalTerkirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LGagalTerkirim.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LGagalTerkirim.setForeground(new java.awt.Color(107, 122, 153));
        LGagalTerkirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LGagalTerkirim.setText("Gagal");
        LGagalTerkirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pStat3Layout = new javax.swing.GroupLayout(pStat3);
        pStat3.setLayout(pStat3Layout);
        pStat3Layout.setHorizontalGroup(
            pStat3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat3Layout.createSequentialGroup()
                .addGroup(pStat3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pStat3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pStat3Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(LGagalTerkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pStat3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNote3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pStat3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LNilaiGagalTerkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pStat3Layout.setVerticalGroup(
            pStat3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(LGagalTerkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LNilaiGagalTerkirim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNote3)
                .addGap(17, 17, 17))
        );

        pStat2.setBackground(new java.awt.Color(255, 255, 255));
        pStat2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pStat2.setPreferredSize(new java.awt.Dimension(195, 74));

        lblNote2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNote2.setForeground(new java.awt.Color(22, 163, 74));
        lblNote2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNote2.setText("Berhasil sampai");
        lblNote2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiTerkirim.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        LNilaiTerkirim.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiTerkirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiTerkirim.setText("-");
        LNilaiTerkirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LTotalTerkirim.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LTotalTerkirim.setForeground(new java.awt.Color(107, 122, 153));
        LTotalTerkirim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LTotalTerkirim.setText("Terkirim");
        LTotalTerkirim.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pStat2Layout = new javax.swing.GroupLayout(pStat2);
        pStat2.setLayout(pStat2Layout);
        pStat2Layout.setHorizontalGroup(
            pStat2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LTotalTerkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pStat2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pStat2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNilaiTerkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNote2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pStat2Layout.setVerticalGroup(
            pStat2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(LTotalTerkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LNilaiTerkirim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNote2)
                .addGap(17, 17, 17))
        );

        pStat1.setBackground(new java.awt.Color(255, 255, 255));
        pStat1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pStat1.setPreferredSize(new java.awt.Dimension(195, 74));

        lblNote1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNote1.setForeground(new java.awt.Color(37, 99, 235));
        lblNote1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNote1.setText("Sedang dikirim");
        lblNote1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiDalamPengiriman.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        LNilaiDalamPengiriman.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiDalamPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiDalamPengiriman.setText("-");
        LNilaiDalamPengiriman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LDalamPengiriman.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LDalamPengiriman.setForeground(new java.awt.Color(107, 122, 153));
        LDalamPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LDalamPengiriman.setText("Dalam Proses");
        LDalamPengiriman.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pStat1Layout = new javax.swing.GroupLayout(pStat1);
        pStat1.setLayout(pStat1Layout);
        pStat1Layout.setHorizontalGroup(
            pStat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LDalamPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pStat1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pStat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNilaiDalamPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNote1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pStat1Layout.setVerticalGroup(
            pStat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(LDalamPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LNilaiDalamPengiriman)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNote1)
                .addGap(14, 14, 14))
        );

        pStat0.setBackground(new java.awt.Color(255, 255, 255));
        pStat0.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pStat0.setPreferredSize(new java.awt.Dimension(195, 74));

        lblNote0.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNote0.setForeground(new java.awt.Color(107, 122, 153));
        lblNote0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNote0.setText("Seluruh paket");
        lblNote0.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LNilaiTotalPaket.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        LNilaiTotalPaket.setForeground(new java.awt.Color(11, 31, 75));
        LNilaiTotalPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNilaiTotalPaket.setText("-");
        LNilaiTotalPaket.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LTotalPaket.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        LTotalPaket.setForeground(new java.awt.Color(107, 122, 153));
        LTotalPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LTotalPaket.setText("Total Paket");
        LTotalPaket.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pStat0Layout = new javax.swing.GroupLayout(pStat0);
        pStat0.setLayout(pStat0Layout);
        pStat0Layout.setHorizontalGroup(
            pStat0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat0Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LTotalPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pStat0Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pStat0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNilaiTotalPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNote0, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pStat0Layout.setVerticalGroup(
            pStat0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStat0Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(LTotalPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LNilaiTotalPaket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNote0)
                .addGap(14, 14, 14))
        );

        PBenner.setBackground(new java.awt.Color(11, 31, 75));
        PBenner.setPreferredSize(new java.awt.Dimension(820, 99));

        pnlAksen.setBackground(new java.awt.Color(255, 107, 0));
        pnlAksen.setPreferredSize(new java.awt.Dimension(47, 3));

        javax.swing.GroupLayout pnlAksenLayout = new javax.swing.GroupLayout(pnlAksen);
        pnlAksen.setLayout(pnlAksenLayout);
        pnlAksenLayout.setHorizontalGroup(
            pnlAksenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );
        pnlAksenLayout.setVerticalGroup(
            pnlAksenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        LNamaAdmin.setFont(new java.awt.Font("Segoe UI", 1, 31)); // NOI18N
        LNamaAdmin.setForeground(new java.awt.Color(255, 255, 255));
        LNamaAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNamaAdmin.setText("-");
        LNamaAdmin.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        LSelamatDatang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LSelamatDatang.setForeground(new java.awt.Color(184, 196, 224));
        LSelamatDatang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LSelamatDatang.setText("Selamat datang,");
        LSelamatDatang.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblMaskotTeks.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblMaskotTeks.setForeground(new java.awt.Color(255, 255, 255));
        lblMaskotTeks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaskotTeks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JetySenyum.png"))); // NOI18N
        lblMaskotTeks.setText("Maskot");
        lblMaskotTeks.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PBennerLayout = new javax.swing.GroupLayout(PBenner);
        PBenner.setLayout(PBennerLayout);
        PBennerLayout.setHorizontalGroup(
            PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBennerLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAksen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LSelamatDatang, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(lblMaskotTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        PBennerLayout.setVerticalGroup(
            PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBennerLayout.createSequentialGroup()
                .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(pnlAksen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(LSelamatDatang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(LNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PBennerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMaskotTeks))
        );

        PHeaderAdmin.setBackground(new java.awt.Color(255, 255, 255));
        PHeaderAdmin.setPreferredSize(new java.awt.Dimension(874, 51));

        lblPeranHeader.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblPeranHeader.setForeground(new java.awt.Color(107, 122, 153));
        lblPeranHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPeranHeader.setText("-");
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
        lblJudulHalaman.setText("Dashboard Admin");
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

        BtnMenuUser.setForeground(new java.awt.Color(184, 196, 224));
        BtnMenuUser.setText("User");
        BtnMenuUser.setBorderPainted(false);
        BtnMenuUser.setContentAreaFilled(false);
        BtnMenuUser.setFocusPainted(false);
        BtnMenuUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenuUser.setMargin(new java.awt.Insets(0, 17, 0, 0));
        BtnMenuUser.addActionListener(this::BtnMenuUserActionPerformed);

        BtnDashboard.setBackground(new java.awt.Color(255, 107, 0));
        BtnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        BtnDashboard.setText("Dashboard");
        BtnDashboard.setBorderPainted(false);
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
                .addGroup(PMenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(lblLogoJet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMinimumSize(new java.awt.Dimension(820, 268));
        jPanel9.setPreferredSize(new java.awt.Dimension(820, 268));

        LLaporanPenfiriman.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LLaporanPenfiriman.setText("Pengiriman Per Konter");

        PgSamarindaKota.setForeground(new java.awt.Color(255, 102, 0));
        PgSamarindaKota.setMinimumSize(new java.awt.Dimension(419, 10));
        PgSamarindaKota.setPreferredSize(new java.awt.Dimension(419, 10));

        LSamarindaKota.setText("Samarinda Kota");

        jSeparator1.setForeground(new java.awt.Color(0, 51, 153));

        LSamarindaIlir.setText("Samarinda Ilir");

        LSamarindaUlu.setText("Samarinda Ulu");

        LSamarindaUtara.setText("Samarinda Utara");

        LSamarindaSeberang.setText("Samarinda Seberang");

        LSungaiKunjang.setText("Sungai Kunjang");

        jLabel1.setText("Sungai Pinang");

        LSambutan.setText("Sambutan");

        LLoaJanan.setText("Loa Janan");

        LPalaran.setText("Palaran");

        BgSamarindaIlir.setForeground(new java.awt.Color(255, 102, 0));
        BgSamarindaIlir.setMinimumSize(new java.awt.Dimension(419, 10));
        BgSamarindaIlir.setPreferredSize(new java.awt.Dimension(419, 10));

        PgSmarindaUlu.setForeground(new java.awt.Color(255, 102, 0));

        PgSamarindaUtara.setForeground(new java.awt.Color(255, 102, 0));

        PgSamarindaSeberang.setForeground(new java.awt.Color(255, 102, 0));

        PgSunagiKunjang.setForeground(new java.awt.Color(255, 102, 0));

        PgSungaipinang.setForeground(new java.awt.Color(255, 102, 0));

        PgSambutan.setForeground(new java.awt.Color(255, 102, 0));

        PgLoaJanan.setForeground(new java.awt.Color(255, 102, 0));

        PgPalaran.setForeground(new java.awt.Color(255, 102, 0));

        LNilaiSamarindaKota.setText("-");

        LNilaiSamarindaIlir.setText("-");

        LNilaiSamarindaUtara.setText("-");

        LNilaiSamarindaSeberang.setText("-");

        LNilaiSungaiKunjang.setText("-");

        LNilaiSungaiPinang.setText("-");

        LNilaiSambutan.setText("-");

        LNilaiLoaJanan.setText("-");

        LNilaiSamarindaUlu.setText("-");

        LNilaiPalaran.setText("_");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LLaporanPenfiriman)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LSambutan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LSungaiKunjang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LSamarindaUtara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LSamarindaUlu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LSamarindaIlir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LSamarindaKota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LSamarindaSeberang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(LLoaJanan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LPalaran, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PgSamarindaKota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BgSamarindaIlir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgSmarindaUlu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgSamarindaUtara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgSamarindaSeberang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgSunagiKunjang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgSungaipinang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgSambutan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgLoaJanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PgPalaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LNilaiSamarindaIlir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiSamarindaSeberang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiLoaJanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiSambutan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiSamarindaKota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiSungaiPinang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiSungaiKunjang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiSamarindaUtara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiSamarindaUlu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNilaiPalaran, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LLaporanPenfiriman)
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(LSamarindaKota))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(PgSamarindaKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(LNilaiSamarindaKota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BgSamarindaIlir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(LNilaiSamarindaIlir)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgSmarindaUlu, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiSamarindaUlu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgSamarindaUtara, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiSamarindaUtara))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgSamarindaSeberang, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiSamarindaSeberang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgSunagiKunjang, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiSungaiKunjang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgSungaipinang, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiSungaiPinang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgSambutan, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiSambutan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgLoaJanan, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiLoaJanan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PgPalaran, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNilaiPalaran))
                        .addGap(112, 112, 112))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(LSamarindaIlir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LSamarindaUlu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LSamarindaUtara)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LSamarindaSeberang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LSungaiKunjang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LSambutan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LLoaJanan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LPalaran)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pStat0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pStat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pStat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pStat3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PHeaderAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pStat3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pStat2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pStat1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pStat0, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PMenuAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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
        tampilkanHalaman("menuPengantaran");
    }//GEN-LAST:event_BtnMenuPengantaranActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
        tampilkanHalaman("menuRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDashboardActionPerformed
        tampilkanHalaman("menuAdmin");
    }//GEN-LAST:event_BtnDashboardActionPerformed

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

    private void BtnMenuOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuOngkirActionPerformed
        tampilkanHalaman("menuOngkir");
    }//GEN-LAST:event_BtnMenuOngkirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BgSamarindaIlir;
    private javax.swing.JButton BtnDashboard;
    private javax.swing.JButton BtnMenuKonter;
    private javax.swing.JButton BtnMenuOngkir;
    private javax.swing.JButton BtnMenuPengantaran;
    private javax.swing.JButton BtnMenuPengiriman;
    private javax.swing.JButton BtnMenuRiwayatPengiriman;
    private javax.swing.JButton BtnMenuUser;
    private javax.swing.JButton BtnMenuUtama;
    private javax.swing.JLabel LDalamPengiriman;
    private javax.swing.JLabel LGagalTerkirim;
    private javax.swing.JLabel LLaporanPenfiriman;
    private javax.swing.JLabel LLoaJanan;
    private javax.swing.JLabel LNamaAdmin;
    private javax.swing.JLabel LNilaiDalamPengiriman;
    private javax.swing.JLabel LNilaiGagalTerkirim;
    private javax.swing.JLabel LNilaiLoaJanan;
    private javax.swing.JLabel LNilaiPalaran;
    private javax.swing.JLabel LNilaiSamarindaIlir;
    private javax.swing.JLabel LNilaiSamarindaKota;
    private javax.swing.JLabel LNilaiSamarindaSeberang;
    private javax.swing.JLabel LNilaiSamarindaUlu;
    private javax.swing.JLabel LNilaiSamarindaUtara;
    private javax.swing.JLabel LNilaiSambutan;
    private javax.swing.JLabel LNilaiSungaiKunjang;
    private javax.swing.JLabel LNilaiSungaiPinang;
    private javax.swing.JLabel LNilaiTerkirim;
    private javax.swing.JLabel LNilaiTotalPaket;
    private javax.swing.JLabel LPalaran;
    private javax.swing.JLabel LSamarindaIlir;
    private javax.swing.JLabel LSamarindaKota;
    private javax.swing.JLabel LSamarindaSeberang;
    private javax.swing.JLabel LSamarindaUlu;
    private javax.swing.JLabel LSamarindaUtara;
    private javax.swing.JLabel LSambutan;
    private javax.swing.JLabel LSelamatDatang;
    private javax.swing.JLabel LSungaiKunjang;
    private javax.swing.JLabel LTotalPaket;
    private javax.swing.JLabel LTotalTerkirim;
    private javax.swing.JPanel PBenner;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenuAdmin;
    private javax.swing.JProgressBar PgLoaJanan;
    private javax.swing.JProgressBar PgPalaran;
    private javax.swing.JProgressBar PgSamarindaKota;
    private javax.swing.JProgressBar PgSamarindaSeberang;
    private javax.swing.JProgressBar PgSamarindaUtara;
    private javax.swing.JProgressBar PgSambutan;
    private javax.swing.JProgressBar PgSmarindaUlu;
    private javax.swing.JProgressBar PgSunagiKunjang;
    private javax.swing.JProgressBar PgSungaipinang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblJudulHalaman;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblMaskotTeks;
    private javax.swing.JLabel lblNamaHeader;
    private javax.swing.JLabel lblNote0;
    private javax.swing.JLabel lblNote1;
    private javax.swing.JLabel lblNote2;
    private javax.swing.JLabel lblNote3;
    private javax.swing.JLabel lblPanelAdmin;
    private javax.swing.JLabel lblPeranHeader;
    private javax.swing.JPanel pStat0;
    private javax.swing.JPanel pStat1;
    private javax.swing.JPanel pStat2;
    private javax.swing.JPanel pStat3;
    private javax.swing.JPanel pnlAksen;
    private javax.swing.JPanel pnlAvatar;
    // End of variables declaration//GEN-END:variables
}
