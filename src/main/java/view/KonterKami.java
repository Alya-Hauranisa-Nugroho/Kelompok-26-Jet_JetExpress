
package view;

import controller.KonterController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class KonterKami extends javax.swing.JPanel {
    private final KonterController konterController = new KonterController();
    public KonterKami() {
    initComponents();

    aturTabel();
    tampilkanDaftarKonter();
}
    private void tampilkanDaftarKonter() {
    DefaultTableModel model =
        (DefaultTableModel) jTable1.getModel();

    model.setRowCount(0);

    try {
        List<Object[]> daftarKonter = konterController.tampilkan();

        for (Object[] konter : daftarKonter) {
            model.addRow(konter);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal mengambil data konter: " + e.getMessage(),
            "Kesalahan Database",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
private void aturTabel() {

    DefaultTableModel model = new DefaultTableModel(
        new Object[]{
            "ID", "Nama Konter", "Alamat", "Kecamatan", "Call Center"
        }, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    jTable1.setModel(model);

    jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12));
    jTable1.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", 1, 12)
    );

    jTable1.setRowHeight(32);
    jTable1.setFillsViewportHeight(true);

    jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

    int[] lebarKolom = {50, 180, 450, 180, 150};

    for (int i = 0; i < lebarKolom.length; i++) {
        jTable1.getColumnModel().getColumn(i)
            .setPreferredWidth(lebarKolom[i]);

        jTable1.getColumnModel().getColumn(i)
            .setMinWidth(lebarKolom[i]);

        jTable1.getColumnModel().getColumn(i)
            .setMaxWidth(lebarKolom[i]);
    }

    javax.swing.table.DefaultTableCellRenderer rendererTengah =
    new javax.swing.table.DefaultTableCellRenderer();

    rendererTengah.setHorizontalAlignment(
    javax.swing.SwingConstants.CENTER
);

    jTable1.getColumnModel()
       .getColumn(0)
       .setCellRenderer(rendererTengah);

    jScrollPane1.setVerticalScrollBarPolicy(
    javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
);

    jScrollPane1.setHorizontalScrollBarPolicy(
    javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
);

    jTable1.setAutoResizeMode(
    javax.swing.JTable.AUTO_RESIZE_OFF
);
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

        PKonterKami = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        LKonter = new javax.swing.JLabel();
        PBenner = new javax.swing.JPanel();
        LKonterKamiDekripsi = new javax.swing.JLabel();
        pnlAksenHero = new javax.swing.JPanel();
        LKonterKami = new javax.swing.JLabel();
        lblMaskotTeks = new javax.swing.JLabel();
        PNavbar = new javax.swing.JPanel();
        btnNavLogin = new javax.swing.JButton();
        pnlNavAktif = new javax.swing.JPanel();
        btnNavKonter = new javax.swing.JButton();
        btnNavTarif = new javax.swing.JButton();
        btnNavLacak = new javax.swing.JButton();
        btnNavBeranda = new javax.swing.JButton();
        lblLogoExpress = new javax.swing.JLabel();
        lblLogoJet = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));
        setPreferredSize(new java.awt.Dimension(1100, 620));

        PKonterKami.setBackground(new java.awt.Color(255, 255, 255));
        PKonterKami.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        PKonterKami.setPreferredSize(new java.awt.Dimension(968, 312));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Konter", "Alamat", "Kecamatan", "Call Center"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(11, 31, 75));
        jTable1.setGridColor(new java.awt.Color(227, 232, 242));
        jTable1.setRowHeight(23);
        jTable1.setFillsViewportHeight(true);
        jTable1.setSelectionBackground(new java.awt.Color(255, 240, 227));
        jTable1.setSelectionForeground(new java.awt.Color(11, 31, 75));
        jScrollPane1.setViewportView(jTable1);

        LKonter.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        LKonter.setForeground(new java.awt.Color(11, 31, 75));
        LKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKonter.setText("Daftar Konter Kami");
        LKonter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout PKonterKamiLayout = new javax.swing.GroupLayout(PKonterKami);
        PKonterKami.setLayout(PKonterKamiLayout);
        PKonterKamiLayout.setHorizontalGroup(
            PKonterKamiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PKonterKamiLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PKonterKamiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PKonterKamiLayout.setVerticalGroup(
            PKonterKamiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PKonterKamiLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PKonterKamiLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PBenner.setBackground(new java.awt.Color(11, 31, 75));
        PBenner.setPreferredSize(new java.awt.Dimension(1075, 142));

        LKonterKamiDekripsi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        LKonterKamiDekripsi.setForeground(new java.awt.Color(184, 196, 224));
        LKonterKamiDekripsi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKonterKamiDekripsi.setText("Konter tersebar di seluruh Kota Samarinda untuk melayani Anda");
        LKonterKamiDekripsi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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

        LKonterKami.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        LKonterKami.setForeground(new java.awt.Color(255, 255, 255));
        LKonterKami.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKonterKami.setText("Konter Kami");
        LKonterKami.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
                    .addComponent(LKonterKamiDekripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LKonterKami, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(lblMaskotTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        PBennerLayout.setVerticalGroup(
            PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBennerLayout.createSequentialGroup()
                .addGroup(PBennerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(LKonterKamiDekripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(pnlAksenHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(LKonterKami, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PBennerLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblMaskotTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
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

        pnlNavAktif.setBackground(new java.awt.Color(255, 107, 0));
        pnlNavAktif.setPreferredSize(new java.awt.Dimension(77, 3));

        javax.swing.GroupLayout pnlNavAktifLayout = new javax.swing.GroupLayout(pnlNavAktif);
        pnlNavAktif.setLayout(pnlNavAktifLayout);
        pnlNavAktifLayout.setHorizontalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );
        pnlNavAktifLayout.setVerticalGroup(
            pnlNavAktifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btnNavKonter.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavKonter.setForeground(new java.awt.Color(255, 107, 0));
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

        btnNavLacak.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNavLacak.setForeground(new java.awt.Color(11, 31, 75));
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
                .addGap(712, 712, 712)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(707, 707, 707)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(615, 615, 615)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(33, 33, 33)
                .addComponent(pnlNavAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNavTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(PKonterKami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(PKonterKami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(PBenner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {
        tampilkanHalaman("menuUtama");
    }


    private void pindahHalaman(String namaHalaman) {
        MainFrame frame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.tampilkanHalaman(namaHalaman);
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
    private javax.swing.JLabel LKonter;
    private javax.swing.JLabel LKonterKami;
    private javax.swing.JLabel LKonterKamiDekripsi;
    private javax.swing.JPanel PBenner;
    private javax.swing.JPanel PKonterKami;
    private javax.swing.JPanel PNavbar;
    private javax.swing.JButton btnNavBeranda;
    private javax.swing.JButton btnNavKonter;
    private javax.swing.JButton btnNavLacak;
    private javax.swing.JButton btnNavLogin;
    private javax.swing.JButton btnNavTarif;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLogoExpress;
    private javax.swing.JLabel lblLogoJet;
    private javax.swing.JLabel lblMaskotTeks;
    private javax.swing.JPanel pnlAksenHero;
    private javax.swing.JPanel pnlNavAktif;
    // End of variables declaration//GEN-END:variables
}
