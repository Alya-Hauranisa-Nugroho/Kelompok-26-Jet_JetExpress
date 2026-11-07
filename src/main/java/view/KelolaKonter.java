package view;

import controller.KonterController;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.InputHelper;
import util.Sesi;

public class KelolaKonter extends javax.swing.JPanel {

private final KonterController konterController = new KonterController();
private int idKonterTerpilih = -1;

public KelolaKonter() {
    initComponents();

    aturTabel();

    tampilkanDataKonter();

    jTable1.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            pilihDataKonter();
        }
    });
}
private void tambahKonter() {
    String nama = FNamaKonter.getText().trim();
    String alamat = FAlamat.getText().trim();
    String kecamatan = FKecamatan.getText().trim();
    String callCenter = FCallCenter.getText().trim();

    if (nama.isEmpty() || alamat.isEmpty()
            || kecamatan.isEmpty() || callCenter.isEmpty()) {

        JOptionPane.showMessageDialog(this,
                "Semua data konter harus diisi!");
        return;
    }

    int konfirmasi = JOptionPane.showConfirmDialog(
            this,
            "Apakah kamu yakin ingin menambahkan data konter?",
            "Konfirmasi Tambah",
            JOptionPane.YES_NO_OPTION
    );

    if (konfirmasi != JOptionPane.YES_OPTION) {
        return;
    }

    try {boolean berhasil = konterController.tambah(
                nama,
                alamat,
                kecamatan,
                callCenter
        );

        if (berhasil) {
            JOptionPane.showMessageDialog(this,
                    "Data konter berhasil ditambahkan!");

            tampilkanDataKonter();
            kosongkanForm();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Data konter gagal ditambahkan!");
        }

    } catch (IllegalArgumentException e) {
        InputHelper.pesanPeringatan(this, e.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Gagal menambahkan data konter: " + e.getMessage(),
                "Kesalahan",
                JOptionPane.ERROR_MESSAGE);
    }
}
private void kosongkanForm() {
    idKonterTerpilih = -1;

    FNamaKonter.setText("");
    FAlamat.setText("");
    FKecamatan.setText("");
    FCallCenter.setText("");

    jTable1.clearSelection();
}

public void segarkanData() {
    tampilkanDataKonter();
}

private void tampilkanDataKonter() {
    DefaultTableModel model =
            (DefaultTableModel) jTable1.getModel();

    model.setRowCount(0);

    try {
        List<Object[]> daftarKonter = konterController.tampilkan();

        for (Object[] data : daftarKonter) {
            model.addRow(data);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
                this,
                "Gagal menampilkan data konter: " + ex.getMessage(),
                "Kesalahan",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

private void pilihDataKonter() {
    int baris = jTable1.getSelectedRow();

    if (baris != -1) {
        idKonterTerpilih = Integer.parseInt(
                jTable1.getValueAt(baris, 0).toString()
        );

        FNamaKonter.setText(
                String.valueOf(jTable1.getValueAt(baris, 1))
        );

        FAlamat.setText(
                String.valueOf(jTable1.getValueAt(baris, 2))
        );

        FKecamatan.setText(
                String.valueOf(jTable1.getValueAt(baris, 3))
        );

        FCallCenter.setText(
                String.valueOf(jTable1.getValueAt(baris, 4))
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

jTable1.setAutoResizeMode(
    javax.swing.JTable.AUTO_RESIZE_OFF
);

int[] lebarKolom = {55, 190, 450, 150, 150};

for (int i = 0; i < lebarKolom.length; i++) {
    jTable1.getColumnModel()
        .getColumn(i)
        .setPreferredWidth(lebarKolom[i]);

    jTable1.getColumnModel()
        .getColumn(i)
        .setMinWidth(50);
}

javax.swing.table.DefaultTableCellRenderer rendererTengah =
    new javax.swing.table.DefaultTableCellRenderer();

rendererTengah.setHorizontalAlignment(
    javax.swing.SwingConstants.CENTER
);

jTable1.getColumnModel()
    .getColumn(0)
    .setCellRenderer(rendererTengah);

jScrollPane2.setVerticalScrollBarPolicy(
    javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
);

jScrollPane2.setHorizontalScrollBarPolicy(
    javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
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

        PTabel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        POngkir = new javax.swing.JPanel();
        BtnRefresh = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnTambahData = new javax.swing.JButton();
        FCallCenter = new javax.swing.JTextField();
        LCallCenter = new javax.swing.JLabel();
        FKecamatan = new javax.swing.JTextField();
        LKecamatan = new javax.swing.JLabel();
        FAlamat = new javax.swing.JTextField();
        LAlamat = new javax.swing.JLabel();
        FNamaKonter = new javax.swing.JTextField();
        LNamaKonter = new javax.swing.JLabel();
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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(11, 31, 75));
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
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(227, 232, 242));
        jTable1.setRowHeight(23);
        jTable1.setSelectionBackground(new java.awt.Color(255, 240, 227));
        jTable1.setSelectionForeground(new java.awt.Color(11, 31, 75));
        jScrollPane2.setViewportView(jTable1);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        BtnTambahData.setText("+ Tambah Konter");
        BtnTambahData.setBorderPainted(false);
        BtnTambahData.setFocusPainted(false);
        BtnTambahData.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnTambahData.addActionListener(this::BtnTambahDataActionPerformed);

        FCallCenter.setForeground(new java.awt.Color(11, 31, 75));
        FCallCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LCallCenter.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LCallCenter.setForeground(new java.awt.Color(11, 31, 75));
        LCallCenter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCallCenter.setText("Call Center");
        LCallCenter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FKecamatan.setForeground(new java.awt.Color(11, 31, 75));
        FKecamatan.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));

        LKecamatan.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LKecamatan.setForeground(new java.awt.Color(11, 31, 75));
        LKecamatan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LKecamatan.setText("Kecamatan");
        LKecamatan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FAlamat.setForeground(new java.awt.Color(11, 31, 75));
        FAlamat.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FAlamat.addActionListener(this::FAlamatActionPerformed);

        LAlamat.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LAlamat.setForeground(new java.awt.Color(11, 31, 75));
        LAlamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LAlamat.setText("Alamat");
        LAlamat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        FNamaKonter.setForeground(new java.awt.Color(11, 31, 75));
        FNamaKonter.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        FNamaKonter.addActionListener(this::FNamaKonterActionPerformed);

        LNamaKonter.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LNamaKonter.setForeground(new java.awt.Color(11, 31, 75));
        LNamaKonter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LNamaKonter.setText("Nama Konter");
        LNamaKonter.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
                .addGap(622, 622, 622)
                .addComponent(FCallCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(622, 622, 622)
                .addComponent(LCallCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(FKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(LKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(FAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(LAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(FNamaKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LNamaKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(FCallCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LCallCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(FKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(FAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(FNamaKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(POngkirLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LNamaKonter, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        lblJudulHalaman.setText("Kelola Konter");
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

        BtnMenuKonter.setBackground(new java.awt.Color(255, 107, 0));
        BtnMenuKonter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnMenuKonter.setForeground(new java.awt.Color(255, 255, 255));
        BtnMenuKonter.setText("Konter");
        BtnMenuKonter.setBorderPainted(false);
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

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
        tampilkanDataKonter();
        kosongkanForm();

        JOptionPane.showMessageDialog(this,
            "Data konter berhasil diperbarui!");
    }//GEN-LAST:event_BtnRefreshActionPerformed

    private void FAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAlamatActionPerformed
        FKecamatan.requestFocus();
    }//GEN-LAST:event_FAlamatActionPerformed

    private void FNamaKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNamaKonterActionPerformed
        FAlamat.requestFocus();
    }//GEN-LAST:event_FNamaKonterActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if (idKonterTerpilih == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih data konter yang ingin dihapus terlebih dahulu!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(
            this,
            "Apakah kamu yakin ingin menghapus data konter ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            boolean berhasil = konterController.hapus(idKonterTerpilih);

            if (berhasil) {
                JOptionPane.showMessageDialog(this,
                    "Data konter berhasil dihapus!");

                tampilkanDataKonter();
                kosongkanForm();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Data konter gagal dihapus!");
            }

        } catch (IllegalArgumentException e) {
            InputHelper.pesanPeringatan(this, e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal menghapus data konter. "
                + "Pastikan konter tidak sedang digunakan oleh data lain.\n"
                + e.getMessage(),
                "Kesalahan",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        if (idKonterTerpilih == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih data konter yang ingin diubah terlebih dahulu!");
            return;
        }

        String nama = FNamaKonter.getText().trim();
        String alamat = FAlamat.getText().trim();
        String kecamatan = FKecamatan.getText().trim();
        String callCenter = FCallCenter.getText().trim();

        if (nama.isEmpty() || alamat.isEmpty()
            || kecamatan.isEmpty() || callCenter.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Semua data konter harus diisi!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(
            this,
            "Apakah kamu yakin ingin mengubah data konter ini?",
            "Konfirmasi Ubah",
            JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi != JOptionPane.YES_OPTION) {
            return;
        }

        try {boolean berhasil = konterController.ubah(
                idKonterTerpilih,
                nama,
                alamat,
                kecamatan,
                callCenter
            );

            if (berhasil) {
                JOptionPane.showMessageDialog(this,
                    "Data konter berhasil diubah!");

                tampilkanDataKonter();
                kosongkanForm();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Data konter gagal diubah!");
            }

        } catch (IllegalArgumentException e) {
            InputHelper.pesanPeringatan(this, e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal mengubah data konter: " + e.getMessage(),
                "Kesalahan",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void BtnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahDataActionPerformed
        tambahKonter();
    }//GEN-LAST:event_BtnTambahDataActionPerformed

    private void BtnMenuPengantaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengantaranActionPerformed
        tampilkanHalaman("menuPengantaran");
    }//GEN-LAST:event_BtnMenuPengantaranActionPerformed

    private void BtnMenuRiwayatPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuRiwayatPengirimanActionPerformed
        tampilkanHalaman("menuRiwayat");
    }//GEN-LAST:event_BtnMenuRiwayatPengirimanActionPerformed

    private void BtnMenuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuPengirimanActionPerformed
        tampilkanHalaman("menuPengiriman");
    }//GEN-LAST:event_BtnMenuPengirimanActionPerformed

    private void BtnMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuUserActionPerformed
        tampilkanHalaman("menuUser");
    }//GEN-LAST:event_BtnMenuUserActionPerformed

    private void BtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDashboardActionPerformed
        MainFrame main = (MainFrame) javax.swing.SwingUtilities
        .getWindowAncestor(this);

        main.tampilkanHalaman("menuAdmin");
    }//GEN-LAST:event_BtnDashboardActionPerformed

    private void BtnMenuKonterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuKonterActionPerformed
        tampilkanDataKonter();
        tampilkanHalaman("menuKonter");
    }//GEN-LAST:event_BtnMenuKonterActionPerformed

    private void BtnMenuOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuOngkirActionPerformed
        tampilkanHalaman("menuOngkir");
    }//GEN-LAST:event_BtnMenuOngkirActionPerformed

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
    private javax.swing.JButton BtnTambahData;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JTextField FAlamat;
    private javax.swing.JTextField FCallCenter;
    private javax.swing.JTextField FKecamatan;
    private javax.swing.JTextField FNamaKonter;
    private javax.swing.JLabel LAlamat;
    private javax.swing.JLabel LCallCenter;
    private javax.swing.JLabel LKecamatan;
    private javax.swing.JLabel LNamaKonter;
    private javax.swing.JPanel PHeaderAdmin;
    private javax.swing.JPanel PMenuAdmin;
    private javax.swing.JPanel POngkir;
    private javax.swing.JPanel PTabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
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
