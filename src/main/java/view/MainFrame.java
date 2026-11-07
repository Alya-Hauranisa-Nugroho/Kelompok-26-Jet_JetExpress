package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import util.HakAkses;
import util.NavigasiHalaman;
import util.Sesi;

public class MainFrame extends JFrame implements NavigasiHalaman {

    private final CardLayout cardLayout;
    private final JPanel panelUtama;
    private HakAkses hakAkses = util.HakAkses.tanpaIzin();

    // =================================
    // FORM ADMIN
    // =================================

    private final KelolaUser formKelolaUser;
    private final KelolaKonter formKelolaKonter;
    private final KelolaOngkir formKelolaOngkir;
    private final KelolaPengiriman formKelolaPengiriman;
    private final KelolaRiwayatPelacakan formKelolaRiwayat;
    private final KelolaPengantaran formKelolaPengantaran;
    private final UbahDataKurir formUbahKurir;
    private final UbahDataPetugasKonter formUbahPetugas;
    private final TambahDataPengiriman formTambahPengiriman;
    private final UbahDataPengiriman formUbahPengiriman;
    private final TambahDataPengantaran formTambahPengantaran;
    private final UbahDataPengantaran formUbahPengantaran;
    private final MenuAdmin formMenuAdmin;

    // =================================
    // FORM PETUGAS KONTER
    // =================================

    private final MenuKelolaPengiriman formMenuKelolaPengiriman;
    private final MenuTambahDataPengiriman formMenuTambahPengiriman;
    private final MenuUbahDataPengiriman formMenuUbahPengiriman;

    // =================================
    // FORM PETUGAS KURIR
    // =================================

    private final LihatPengantaran formLihatPengantaran;
    private final UbahStatusPengantaran formUbahStatusPengantaran;
    private final LihatDaftarKonter formLihatDaftarKonter;

    // =================================
    // FORM MENU ADMIN PENDEKATAN BARU
    // =================================

    private final MenuCekTarif formMenuCekTarif;
    private final MenuKelolaKonter formMenuKelolaKonter;
    private final MenuKelolaRiwayatPelacakan formMenuKelolaRiwayat;
    private final MenuKelolaPenantaran formMenuKelolaPengantaranBaru;

    // =================================
    // CONSTRUCTOR MAIN FRAME
    // =================================

    public MainFrame() {

        setTitle("JetExpress Samarinda");

        // Ukuran JFrame
        setSize(1100, 620);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Membuat CardLayout
        cardLayout = new CardLayout();
        panelUtama = new JPanel(cardLayout);

        // =================================
        // MENU UTAMA DAN HALAMAN PUBLIK
        // =================================

        panelUtama.add(bungkusScroll(new MenuUtama()), "menuUtama");
        panelUtama.add(bungkusScroll(new Login()), "login");
        panelUtama.add(bungkusScroll(new CekTarif()), "cekTarif");
        panelUtama.add(bungkusScroll(new LacakPaket()), "lacakPaket");
        panelUtama.add(bungkusScroll(new KonterKami()), "konterKami");

        // =================================
        // MENU ADMIN
        // =================================

        formMenuAdmin = new MenuAdmin();
        panelUtama.add(bungkusScroll(formMenuAdmin), "menuAdmin");

        formKelolaUser = new KelolaUser();
        panelUtama.add(bungkusScroll(formKelolaUser), "menuUser");

        formKelolaKonter = new KelolaKonter();
        panelUtama.add(bungkusScroll(formKelolaKonter), "menuKonter");

        formKelolaOngkir = new KelolaOngkir();
        panelUtama.add(bungkusScroll(formKelolaOngkir), "menuOngkir");

        formKelolaPengiriman = new KelolaPengiriman();
        panelUtama.add(bungkusScroll(formKelolaPengiriman),"menuPengiriman");

        formKelolaRiwayat = new KelolaRiwayatPelacakan();
        panelUtama.add(bungkusScroll(formKelolaRiwayat), "menuRiwayat");
        

        formKelolaPengantaran = new KelolaPengantaran();
        panelUtama.add(bungkusScroll(formKelolaPengantaran),"menuPengantaran");

        // =================================
        // HALAMAN ADMIN PENDEKATAN MENU*
        // =================================

        formMenuCekTarif = new MenuCekTarif();
        panelUtama.add(bungkusScroll(formMenuCekTarif), "menuCekTarif");

        formMenuKelolaKonter = new MenuKelolaKonter();
        panelUtama.add(bungkusScroll(formMenuKelolaKonter),
                "menuKelolaKonter");

        formMenuKelolaRiwayat = new MenuKelolaRiwayatPelacakan();
        panelUtama.add(bungkusScroll(formMenuKelolaRiwayat),
                "menuKelolaRiwayat");

        formMenuKelolaPengantaranBaru = new MenuKelolaPenantaran();
        panelUtama.add(bungkusScroll(formMenuKelolaPengantaranBaru),
                "menuKelolaPengantaran");

        // =================================
        // FORM TAMBAH / UBAH USER
        // =================================

        panelUtama.add(bungkusScroll(new TambahDataKurir()),
                "tambahKurir");
        panelUtama.add(bungkusScroll(new TambahDataPetugasKonter()),
                "tambahPetugasKonter");

        formUbahKurir = new UbahDataKurir();
        formUbahPetugas = new UbahDataPetugasKonter();

        panelUtama.add(bungkusScroll(formUbahKurir), "ubahKurir");
        panelUtama.add(bungkusScroll(formUbahPetugas), "ubahPetugas");

        // =================================
        // FORM TAMBAH / UBAH PENGIRIMAN (ADMIN)
        // =================================

        formTambahPengiriman = new TambahDataPengiriman();
        formUbahPengiriman = new UbahDataPengiriman();

        panelUtama.add(bungkusScroll(formTambahPengiriman),
                "menuTambahPengiriman");
        panelUtama.add(bungkusScroll(formUbahPengiriman),
                "menuUbahPengiriman");

        // =================================
        // FORM TAMBAH / UBAH PENGANTARAN (ADMIN)
        // =================================

        formTambahPengantaran = new TambahDataPengantaran();
        formUbahPengantaran = new UbahDataPengantaran();

        panelUtama.add(bungkusScroll(formTambahPengantaran),
                "menuTambahPengantaran");
        panelUtama.add(bungkusScroll(formUbahPengantaran),
                "menuUbahPengantaran");

        // =================================
        // HALAMAN PETUGAS KONTER
        // =================================

        formMenuKelolaPengiriman = new MenuKelolaPengiriman();
        panelUtama.add(bungkusScroll(formMenuKelolaPengiriman),
                "menuKelolaPengiriman");

        formMenuTambahPengiriman = new MenuTambahDataPengiriman();
        panelUtama.add(bungkusScroll(formMenuTambahPengiriman),
                "menuTambahPengirimanKonter");

        formMenuUbahPengiriman = new MenuUbahDataPengiriman();
        panelUtama.add(bungkusScroll(formMenuUbahPengiriman),
                "menuUbahPengirimanKonter");

        // =================================
        // HALAMAN PETUGAS KURIR
        // =================================

        formLihatPengantaran = new LihatPengantaran();
        panelUtama.add(bungkusScroll(formLihatPengantaran),
                "lihatPengantaran");

        formUbahStatusPengantaran = new UbahStatusPengantaran();
        panelUtama.add(bungkusScroll(formUbahStatusPengantaran),
                "ubahStatusPengantaran");

        formLihatDaftarKonter = new LihatDaftarKonter();
        panelUtama.add(bungkusScroll(formLihatDaftarKonter),
                "lihatDaftarKonter");

        setContentPane(panelUtama);
        tampilkanHalaman("menuUtama");
    }


    private JScrollPane bungkusScroll(JPanel isi) {
        JScrollPane scroll = new JScrollPane(isi,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new java.awt.Color(245, 247, 251));
        return scroll;
    }

    // =================================
    // NAVIGASI HALAMAN (PUSAT SEMUA PINDAH HALAMAN)
    // =================================

    @Override
    public void tampilkanHalaman(String namaHalaman) {

        // ===== Aliaskan nama halaman generik sesuai role =====
        namaHalaman = aliaskanHalaman(namaHalaman);

        // ===== Hak akses: halaman di luar wewenang dialihkan =====
        if (!hakAkses.bolehBuka(namaHalaman)) {
            String beranda = hakAkses.halamanBeranda();

            if (!beranda.equals(namaHalaman)) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Anda tidak memiliki hak akses ke halaman "
                        + "\"" + namaHalaman + "\".\n"
                        + "Role Anda: " + hakAkses.namaRole(),
                        "Akses Ditolak",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }
            namaHalaman = beranda;
        }

        // Muat ulang data halaman tujuan sebelum tampil
        segarkanHalaman(namaHalaman);

        cardLayout.show(panelUtama, namaHalaman);

        panelUtama.revalidate();
        panelUtama.repaint();
    }


    private void segarkanHalaman(String namaHalaman) {
        switch (namaHalaman) {
            case "menuAdmin" ->
                formMenuAdmin.tampilkanStatistik();
            case "menuUser" ->
                formKelolaUser.refreshDataUser();
            case "menuKonter" ->
                formKelolaKonter.segarkanData();
            case "menuOngkir" ->
                formKelolaOngkir.segarkanData();
            case "menuPengiriman" ->
                formKelolaPengiriman.segarkanData();
            case "menuRiwayat" ->
                formKelolaRiwayat.segarkanData();
            case "menuPengantaran" ->
                formKelolaPengantaran.segarkanData();
            case "menuTambahPengiriman" ->
                formTambahPengiriman.persiapkanFormBaru();
            case "menuTambahPengantaran" ->
                formTambahPengantaran.persiapkanFormBaru();
            case "menuCekTarif" ->
                formMenuCekTarif.segarkanData();
            case "menuKelolaKonter" ->
                formMenuKelolaKonter.segarkanData();
            case "menuKelolaRiwayat" ->
                formMenuKelolaRiwayat.segarkanData();
            case "menuKelolaPengantaran" ->
                formMenuKelolaPengantaranBaru.segarkanData();
            case "menuKelolaPengiriman" ->
                formMenuKelolaPengiriman.segarkanData();
            case "menuTambahPengirimanKonter" ->
                formMenuTambahPengiriman.persiapkanFormBaru();
            case "lihatPengantaran" ->
                formLihatPengantaran.tampilDataPengantaran();
            case "lihatDaftarKonter" ->
                formLihatDaftarKonter.segarkanData();
            default -> {
            }
        }
    }

private static String aliaskanHalaman(String namaHalaman) {

    // Alias hanya berlaku untuk Petugas Konter
    if (!Sesi.getSesi().isPetugasKonter()) {
        return namaHalaman;
    }

    return switch (namaHalaman) {

        // Kelola Pengiriman Petugas Konter
        case "menuPengiriman" ->
            "menuKelolaPengiriman";

        // Riwayat Pelacakan Petugas Konter
        case "menuRiwayat" ->
            "menuKelolaRiwayat";

        // Cek Tarif Petugas Konter
        case "menuOngkir" ->
            "menuCekTarif";

        // Daftar Konter Petugas Konter
        case "menuKonter", "menuDataKonter" ->
            "menuKelolaKonter";

        // Kelola Pengantaran Petugas Konter
        case "lihatPengantaran", "menuPengantaran" ->
            "menuKelolaPengantaran";

        // Beranda Petugas Konter
        case "menuAdmin" ->
            "menuKelolaPengiriman";

        default -> namaHalaman;
    };
}


    // =================================
    // SESI LOGIN & HAK AKSES
    // =================================

    public void setHakAkses(HakAkses hakAkses) {
        this.hakAkses =
                (hakAkses == null) ? util.HakAkses.tanpaIzin()
                : hakAkses;
    }

    public void resetHakAkses() {
        this.hakAkses = util.HakAkses.tanpaIzin();
    }

    // =================================
    // DATA ADMIN
    // =================================

    public void setNamaAdmin(String nama) {
        formMenuAdmin.setNamaAdmin(nama);
    }

    // =================================
    // DATA KONTER LOGIN
    // =================================

    public void setIdKonterLogin(int idKonter) {
        formKelolaUser.setIdKonterLogin(idKonter);
    }

    public int getIdKonterLogin() {
        return Sesi.getSesi().getIdKonter();
    }

    // =================================
    // NAVIGASI KELOLA USER
    // =================================

    public void bukaUbahKurir(int idUser) {
        formUbahKurir.isiDataUser(idUser);
        tampilkanHalaman("ubahKurir");
    }


    public void bukaUbahPetugas(int idUser) {
        formUbahPetugas.isiDataUser(idUser);
        tampilkanHalaman("ubahPetugas");
    }

    public void refreshKelolaUser() {
        formKelolaUser.refreshDataUser();
    }

    // =================================
    // NAVIGASI PENGIRIMAN ADMIN
    // =================================

    public void bukaFormTambahPengiriman() {
        tampilkanHalaman("menuTambahPengiriman");
    }

    public void bukaFormUbahPengiriman(String noResi) {
        formUbahPengiriman.ambilDataPengiriman(noResi);
        tampilkanHalaman("menuUbahPengiriman");
    }

    public void kembaliKeKelolaPengiriman() {
        tampilkanHalaman("menuPengiriman");
    }

    // =================================
    // NAVIGASI PENGANTARAN ADMIN
    // =================================

    public void bukaFormTambahPengantaran() {
        tampilkanHalaman("menuTambahPengantaran");
    }

    public void bukaFormUbahPengantaran(int idPengantaran) {
        formUbahPengantaran.tampilDataPengantaran(idPengantaran);
        tampilkanHalaman("menuUbahPengantaran");
    }

    public void kembaliKeKelolaPengantaran() {
        tampilkanHalaman("menuPengantaran");
    }

    // =================================
    // NAVIGASI PENGIRIMAN PETUGAS KONTER
    // =================================

    public void bukaFormTambahPengirimanKonter() {
        tampilkanHalaman("menuTambahPengirimanKonter");
    }

    public void bukaFormUbahPengirimanKonter(String noResi) {
        formMenuUbahPengiriman.ambilDataPengiriman(noResi);
        tampilkanHalaman("menuUbahPengirimanKonter");
    }

    public void kembaliKeMenuKelolaPengiriman() {
        tampilkanHalaman("menuKelolaPengiriman");
    }

    // =================================
    // NAVIGASI PENGANTARAN PETUGAS KURIR
    // =================================

    public void bukaUbahStatusPengantaran(int idPengantaran) {
        formUbahStatusPengantaran.tampilDataPengantaran(idPengantaran);
        tampilkanHalaman("ubahStatusPengantaran");
    }

    public void kembaliLihatPengantaran() {
        tampilkanHalaman("lihatPengantaran");
    }
}
