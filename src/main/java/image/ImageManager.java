package image;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public final class ImageManager {

    public static final long UKURAN_MAKSIMAL_BYTES = 2L * 1024 * 1024;

    public static final String AWALAN_PATH = "image/";

    private static final String NAMA_FOLDER = "image";
    private static final String AWALAN_NAMA_BERKAS = "BUKTI-";
    private static final String[] EKSTENSI_OK = {"jpg", "jpeg", "png"};

    private ImageManager() {
    }

    public static File pilihFoto(Component induk) {
        JFileChooser pilih = new JFileChooser();
        pilih.setDialogTitle("Pilih Foto Bukti Pengantaran");
        pilih.setFileSelectionMode(JFileChooser.FILES_ONLY);
        pilih.setAcceptAllFileFilterUsed(false);
        pilih.setFileFilter(new FileNameExtensionFilter(
                "Gambar (JPG, JPEG, PNG)", EKSTENSI_OK));

        if (pilih.showOpenDialog(induk) != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        File berkas = pilih.getSelectedFile();
        try {
            validasiBerkas(berkas);
            return berkas;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(induk, e.getMessage(),
                    "Foto Tidak Valid", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public static void validasiBerkas(File berkas) {
        if (berkas == null || !berkas.isFile() || !berkas.canRead()) {
            throw new IllegalArgumentException(
                    "Berkas tidak ditemukan atau tidak dapat dibaca. "
                    + "Pilih berkas lain.");
        }

        String nama = berkas.getName().toLowerCase(Locale.ROOT);
        boolean ekstensiCocok = false;
        for (String ekstensi : EKSTENSI_OK) {
            if (nama.endsWith("." + ekstensi)) {
                ekstensiCocok = true;
                break;
            }
        }
        if (!ekstensiCocok) {
            throw new IllegalArgumentException(
                    "Jenis berkas harus JPG, JPEG, atau PNG.");
        }

        if (berkas.length() > UKURAN_MAKSIMAL_BYTES) {
            throw new IllegalArgumentException(String.format(
                    "Ukuran berkas %.2f MB melebihi batas maksimal "
                    + "2 MB. Kompres foto terlebih dahulu.",
                    berkas.length() / 1024.0 / 1024.0));
        }

        try {
            if (ImageIO.read(berkas) == null) {
                throw new IllegalArgumentException(
                        "Isi berkas bukan gambar yang valid.");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Isi berkas bukan gambar yang valid.");
        }
    }


    public static String salinKeFolderImage(File asal)
            throws IOException {
        try {
            validasiBerkas(asal);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage(), e);
        }

        File tujuan = berkasTujuanUnik(asal);
        Files.copy(asal.toPath(), tujuan.toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return AWALAN_PATH + tujuan.getName();
    }

    public static void hapusFoto(String pathBukti) {
        if (pathBukti == null || pathBukti.isBlank()) {
            return;
        }
        String nama = new File(pathBukti.trim()).getName();
        if (!nama.startsWith(AWALAN_NAMA_BERKAS)) {
            return;
        }
        File berkas = new File(folderImage(), nama);
        if (berkas.isFile()) {
            //noinspection ResultOfMethodCallIgnored
            berkas.delete();
        }
    }


    public static File folderImage() {
        File dasar = new File(System.getProperty("user.dir"));
        File folderPackage = new File(dasar,
                "src/main/java/" + NAMA_FOLDER);

        File folder = folderPackage.isDirectory()
                ? folderPackage : new File(dasar, NAMA_FOLDER);

        if (!folder.exists()) {

            folder.mkdirs();
        }
        return folder;
    }

    public static void lihatGambar(Component induk, String pathBukti) {
        if (pathBukti == null || pathBukti.isBlank()) {
            JOptionPane.showMessageDialog(induk,
                    "Data pengantaran ini belum memiliki bukti foto.",
                    "Tidak Ada Foto", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (cariBerkas(pathBukti) == null) {
            JOptionPane.showMessageDialog(induk,
                    "Berkas foto tidak ditemukan di folder image:\n"
                    + pathBukti,
                    "Foto Tidak Ditemukan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!tampilkanDialogFoto(induk, pathBukti)) {
            JOptionPane.showMessageDialog(induk,
                    "Berkas foto rusak atau bukan gambar yang valid:\n"
                    + pathBukti,
                    "Foto Tidak Dapat Dibuka",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean tampilkanPratinjau(JLabel label,
            String pathBukti) {
        if (label == null) {
            return false;
        }

        File berkas = cariBerkas(pathBukti);
        if (berkas == null) {
            label.setIcon(null);
            return false;
        }

        try {
            Image gambar = ImageIO.read(berkas);
            if (gambar == null) {
                label.setIcon(null);
                return false;
            }

            int lebarLabel = Math.max(1, label.getWidth());
            int tinggiLabel = Math.max(1, label.getHeight());

            double rasio = Math.min(
                    lebarLabel / (double) gambar.getWidth(null),
                    tinggiLabel / (double) gambar.getHeight(null));
            int lebar = Math.max(1,
                    (int) (gambar.getWidth(null) * rasio));
            int tinggi = Math.max(1,
                    (int) (gambar.getHeight(null) * rasio));

            label.setIcon(new ImageIcon(gambar.getScaledInstance(
                    lebar, tinggi, Image.SCALE_SMOOTH)));
            label.setToolTipText(berkas.getName());
            return true;

        } catch (IOException e) {
            label.setIcon(null);
            return false;
        }
    }

    public static boolean tampilkanDialogFoto(Component induk,
            String pathBukti) {
        File berkas = cariBerkas(pathBukti);
        if (berkas == null) {
            return false;
        }

        try {
            Image gambar = ImageIO.read(berkas);
            if (gambar == null) {
                return false;
            }

            double rasio = Math.min(
                    480.0 / gambar.getWidth(null),
                    360.0 / gambar.getHeight(null));
            if (rasio > 1.0) {
                rasio = 1.0;
            }
            int lebar = Math.max(1,
                    (int) (gambar.getWidth(null) * rasio));
            int tinggi = Math.max(1,
                    (int) (gambar.getHeight(null) * rasio));

            ImageIcon ikon = new ImageIcon(gambar.getScaledInstance(
                    lebar, tinggi, Image.SCALE_SMOOTH));

            JOptionPane.showMessageDialog(induk, "",
                    "Pratinjau Bukti Foto - " + berkas.getName(),
                    JOptionPane.PLAIN_MESSAGE, ikon);
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public static File cariBerkas(String pathBukti) {
        if (pathBukti == null || pathBukti.isBlank()) {
            return null;
        }

        String bersih = pathBukti.trim();
        String nama = new File(bersih).getName();

        File diImage = new File(folderImage(), nama);
        if (diImage.isFile()) {
            return diImage;
        }

        File apaAdanya = new File(bersih);
        if (apaAdanya.isFile()) {
            return apaAdanya;
        }

        File diBuktiLama = new File("bukti", nama);
        if (diBuktiLama.isFile()) {
            return diBuktiLama;
        }

        return null;
    }

    private static File berkasTujuanUnik(File asal) {
        String ekstensi = "";
        String namaAsal = asal.getName().toLowerCase(Locale.ROOT);
        int titik = namaAsal.lastIndexOf('.');
        if (titik >= 0) {
            ekstensi = namaAsal.substring(titik);
        }

        String waktu = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        File folder = folderImage();
        File tujuan;
        do {
            int acak = (int) (Math.random() * 900) + 100;
            tujuan = new File(folder, AWALAN_NAMA_BERKAS + waktu + "-"
                    + acak + ekstensi);
        } while (tujuan.exists());
        return tujuan;
    }
}
