package util;

import java.awt.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class InputHelper {

    private static final String POLA_EMAIL =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private InputHelper() {
    }

    // =====================================================
    // KOTAK PESAN
    // =====================================================

    public static void pesanInfo(Component induk, String pesan) {
        JOptionPane.showMessageDialog(induk, pesan, "Informasi",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void pesanSukses(Component induk, String pesan) {
        JOptionPane.showMessageDialog(induk, pesan, "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void pesanPeringatan(Component induk, String pesan) {
        JOptionPane.showMessageDialog(induk, pesan, "Peringatan",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void pesanError(Component induk, String pesan) {
        JOptionPane.showMessageDialog(induk, pesan, "Kesalahan",
                JOptionPane.ERROR_MESSAGE);
    }

    public static boolean konfirmasi(Component induk, String pesan) {
        return JOptionPane.showConfirmDialog(induk, pesan, "Konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
    }

    public static String ambilTeks(JTextField field, String namaField) {
        String teks = field.getText() == null
                ? "" : field.getText().trim();
        if (teks.isEmpty()) {
            throw new IllegalArgumentException(
                    namaField + " wajib diisi.");
        }
        return teks;
    }

    public static String ambilTeks(JTextArea field, String namaField) {
        String teks = field.getText() == null
                ? "" : field.getText().trim();
        if (teks.isEmpty()) {
            throw new IllegalArgumentException(
                    namaField + " wajib diisi.");
        }
        return teks;
    }

    public static String teksOpsional(JTextField field) {
        return field.getText() == null ? "" : field.getText().trim();
    }

    public static String ambilDipilih(JComboBox<?> combo,
            String namaField) {
        Object pilihan = combo.getSelectedItem();
        if (pilihan == null || pilihan.toString().isBlank()) {
            throw new IllegalArgumentException(
                    namaField + " wajib dipilih.");
        }
        return pilihan.toString().trim();
    }

    public static int ambilIdCombo(JComboBox<?> combo, String namaField) {
        String pilihan = ambilDipilih(combo, namaField);
        try {
            return Integer.parseInt(
                    pilihan.split(" - ")[0].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Pilihan " + namaField + " tidak valid.");
        }
    }

    public static String ambilEmail(JTextField field) {
        String email = ambilTeks(field, "Email");
        if (!email.matches(POLA_EMAIL)) {
            throw new IllegalArgumentException(
                    "Format email tidak valid. Contoh: nama@email.com");
        }
        return email;
    }

    public static String ambilTelepon(JTextField field, String namaField) {
        String nomor = ambilTeks(field, namaField);
        String bersih = nomor.replaceAll("[\\s-]", "");
        validasiNomorHp(bersih, namaField);
        return bersih;
    }

    private static final String KUNCI_FILTER_NOMOR_HP =
            "jetexpress.filterNomorHp";

    public static void pasangNomorHp(JTextField field) {
        // Isi awalan dulu, baru pasang filter agar tidak terhalang
        field.setText("08");

        FilterNomorHp filter = new FilterNomorHp();
        if (field.getDocument()
                instanceof javax.swing.text.AbstractDocument dokumen) {
            dokumen.setDocumentFilter(filter);
        }
        field.putClientProperty(KUNCI_FILTER_NOMOR_HP, filter);
    }

    public static void isiNomorHp(JTextField field, String nilai) {
        FilterNomorHp filter =
                (FilterNomorHp) field
                        .getClientProperty(KUNCI_FILTER_NOMOR_HP);
        String isi = (nilai == null || nilai.isBlank())
                ? "08" : nilai.trim();

        if (filter != null) {
            filter.setModeProgram(true);
        }
        try {
            field.setText(isi);
        } finally {
            if (filter != null) {
                filter.setModeProgram(false);
            }
        }
    }

    public static void validasiNomorHp(String nomor, String namaField) {
        if (!nomor.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(
                    namaField + " hanya boleh berisi angka "
                    + "(tanpa huruf, simbol, atau spasi).");
        }
        if (!nomor.startsWith("08")) {
            throw new IllegalArgumentException(
                    namaField + " wajib diawali angka 08 "
                    + "(contoh: 081234567890).");
        }
        if (nomor.length() < 10 || nomor.length() > 13) {
            throw new IllegalArgumentException(
                    namaField + " harus terdiri dari 10-13 digit angka "
                    + "sesuai format nomor Indonesia.");
        }
    }

    public static int ambilAngka(JTextField field, String namaField) {
        String teks = ambilTeks(field, namaField);
        try {
            return Integer.parseInt(teks.replace(",", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    namaField + " harus berupa angka yang valid.");
        }
    }

    public static int ambilAngka(JTextField field, String namaField,
            int minimum, int maksimum) {
        int nilai = ambilAngka(field, namaField);
        if (nilai < minimum || nilai > maksimum) {
            throw new IllegalArgumentException(
                    namaField + " harus antara " + minimum
                    + " sampai " + maksimum + ".");
        }
        return nilai;
    }

    public static BigDecimal ambilDesimal(JTextField field,
            String namaField) {
        String teks = ambilTeks(field, namaField);
        try {
            return new BigDecimal(teks.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    namaField + " harus berupa angka desimal "
                    + "yang valid (contoh: 1.75).");
        }
    }

    public static LocalDate ambilTanggal(JTextField field,
            String namaField) {
        String teks = ambilTeks(field, namaField);
        try {
            return LocalDate.parse(teks);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    namaField + " harus berformat tahun-bulan-tanggal "
                    + "(contoh: 2026-09-02).");
        }
    }

    public static String ambilPassword(JPasswordField field,
            String namaField, int panjangMinimal) {
        char[] isi = field.getPassword();
        String password = isi == null ? "" : new String(isi).trim();
        if (password.isEmpty()) {
            throw new IllegalArgumentException(
                    namaField + " wajib diisi.");
        }
        if (password.length() < panjangMinimal) {
            throw new IllegalArgumentException(
                    namaField + " minimal " + panjangMinimal
                    + " karakter.");
        }
        return password;
    }

    public static void validasiLogin(String email, String password) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email wajib diisi.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password wajib diisi.");
        }
        if (!email.matches(POLA_EMAIL)) {
            throw new IllegalArgumentException(
                    "Format email tidak valid. Contoh: nama@email.com");
        }
    }

    public static void validasiFormKurir(String nama, String email,
            String password, String noHp, String gajiTeks,
            String tanggalMasuk, String nomorKendaraan, boolean passwordWajib) {
        wajib(nama, "Nama");
        wajib(email, "Email");
        if (!email.matches(POLA_EMAIL)) {
            throw new IllegalArgumentException(
                    "Format email tidak valid. Contoh: nama@email.com");
        }
        if (passwordWajib
                || (password != null && !password.isBlank())) {
            wajibMinimal(password, "Password", 6);
        }
        wajib(noHp, "Nomor HP");
        validasiNomorHp(noHp.replaceAll("[\\s-]", ""), "Nomor HP");
        wajib(gajiTeks, "Gaji");
        angkaValid(gajiTeks, "Gaji");
        if (Integer.parseInt(gajiTeks.replace(",", "")) < 0) {
            throw new IllegalArgumentException("Gaji tidak boleh negatif.");
        }
        wajib(tanggalMasuk, "Tanggal Masuk");
        tanggalValid(tanggalMasuk, "Tanggal Masuk");
        wajib(nomorKendaraan, "Nomor Kendaraan");
    }

    public static void validasiFormPetugasKonter(String nama,
            String email, String password, String noHp, String gajiTeks,
            String tanggalMasuk, String shift) {
        wajib(nama, "Nama");
        wajib(email, "Email");
        if (!email.matches(POLA_EMAIL)) {
            throw new IllegalArgumentException(
                    "Format email tidak valid. Contoh: nama@email.com");
        }
        if (password != null && !password.isBlank()) {
            wajibMinimal(password, "Password", 6);
        }
        wajib(noHp, "Nomor HP");
        validasiNomorHp(noHp.replaceAll("[\\s-]", ""), "Nomor HP");
        wajib(gajiTeks, "Gaji");
        angkaValid(gajiTeks, "Gaji");
        wajib(tanggalMasuk, "Tanggal Masuk");
        tanggalValid(tanggalMasuk, "Tanggal Masuk");
        if (!java.util.List.of("Pagi", "Siang", "Malam").contains(shift)) {
            throw new IllegalArgumentException(
                    "Shift kerja hanya boleh Pagi, Siang, atau Malam.");
        }
    }

    public static void validasiFormKonter(String nama, String alamat,
            String kecamatan, String callCenter) {
        wajib(nama, "Nama konter");
        wajib(alamat, "Alamat konter");
        wajib(kecamatan, "Kecamatan");
        wajib(callCenter, "Call center");
        String nomor = callCenter.replaceAll("[\\s-]", "");
        if (!nomor.matches("^[0-9]{8,15}$")) {
            throw new IllegalArgumentException(
                    "Call center harus 8-15 digit angka "
                    + "(contoh: 0541741201).");
        }
    }

    public static void validasiFormOngkir(String jarakMinTeks,
            String jarakMaxTeks, String tarifTeks) {
        wajib(jarakMinTeks, "Jarak minimum");
        wajib(jarakMaxTeks, "Jarak maksimum");
        wajib(tarifTeks, "Tarif dasar");
        int min = angkaValid(jarakMinTeks, "Jarak minimum");
        int maks = angkaValid(jarakMaxTeks, "Jarak maksimum");
        int tarif = angkaValid(tarifTeks, "Tarif dasar");
        if (min < 0) {
            throw new IllegalArgumentException(
                    "Jarak minimum tidak boleh negatif.");
        }
        if (maks < min) {
            throw new IllegalArgumentException(
                    "Jarak maksimum tidak boleh lebih kecil "
                    + "dari jarak minimum.");
        }
        if (tarif < 0) {
            throw new IllegalArgumentException(
                    "Tarif dasar tidak boleh negatif.");
        }
    }

    public static void validasiFormPengiriman(String namaBarang,
            String beratTeks, String jenisBarang, String namaPengirim,
            String hpPengirim, String alamatPengirim, String namaPenerima,
            String hpPenerima, String alamatPenerima, String jenisPengiriman,
            String metodeBayar, String codTeks, String batasKirim,
            int idKonter, int idOngkir) {
        wajib(namaBarang, "Nama barang");
        wajib(beratTeks, "Berat");
        desimalValid(beratTeks, "Berat");
        BigDecimal berat = new BigDecimal(beratTeks.replace(",", "."));
        if (berat.signum() <= 0) {
            throw new IllegalArgumentException(
                    "Berat paket harus lebih dari 0 KG.");
        }
        if (berat.doubleValue() > 50) {
            throw new IllegalArgumentException(
                    "Berat paket maksimal 50 KG.");
        }
        wajib(jenisBarang, "Jenis barang");
        wajib(namaPengirim, "Nama pengirim");
        wajib(hpPengirim, "No. telepon pengirim");
        validasiNomorHp(hpPengirim.replaceAll("[\\s-]", ""),
                "No. telepon pengirim");
        wajib(alamatPengirim, "Alamat pengirim");
        wajib(namaPenerima, "Nama penerima");
        wajib(hpPenerima, "No. telepon penerima");
        validasiNomorHp(hpPenerima.replaceAll("[\\s-]", ""),
                "No. telepon penerima");
        wajib(alamatPenerima, "Alamat penerima");
        if (!java.util.List.of("Intracity", "Outbound", "Inbound")
                .contains(jenisPengiriman)) {
            throw new IllegalArgumentException(
                    "Jenis pengiriman hanya boleh Intracity, "
                    + "Outbound, atau Inbound.");
        }
        if (!java.util.List.of("Cash", "Cashless", "COD")
                .contains(metodeBayar)) {
            throw new IllegalArgumentException(
                    "Metode bayar hanya boleh Cash, Cashless, atau COD.");
        }
        if ("COD".equals(metodeBayar)) {
            wajib(codTeks, "Nominal COD");
            int cod = angkaValid(codTeks, "Nominal COD");
            if (cod <= 0) {
                throw new IllegalArgumentException(
                        "Nominal COD harus lebih dari 0 "
                        + "untuk metode COD.");
            }
        }
        wajib(batasKirim, "Batas kirim");
        tanggalValid(batasKirim, "Batas kirim");
        if (idKonter <= 0) {
            throw new IllegalArgumentException(
                    "Konter asal paket wajib dipilih.");
        }
        if (idOngkir <= 0) {
            throw new IllegalArgumentException(
                    "Rentang jarak (ongkir) wajib dipilih.");
        }
    }
    
    public static void validasiFormPengantaran(int idPengiriman,
            int idKurir, String tanggalTeks, BigDecimal latitude,
            BigDecimal longitude, String status) {
        if (idPengiriman <= 0) {
            throw new IllegalArgumentException(
                    "Nomor resi pengiriman wajib dipilih.");
        }
        if (idKurir <= 0) {
            throw new IllegalArgumentException("Kurir wajib dipilih.");
        }
        wajib(tanggalTeks, "Tanggal penugasan");
        tanggalValid(tanggalTeks, "Tanggal penugasan");
        ValidasiKoordinat.validasi(latitude, longitude);
        if (!java.util.List.of("Ditugaskan", "Dalam Perjalanan",
                "Berhasil", "Gagal").contains(status)) {
            throw new IllegalArgumentException(
                    "Status pengantaran tidak valid.");
        }
    }

    public static void validasiBuktiFoto(String status,
            boolean adaFoto) {
        boolean wajibFoto = "Berhasil".equals(status)
                || "Gagal".equals(status);
        if (wajibFoto && !adaFoto) {
            throw new IllegalArgumentException(
                    "Bukti foto wajib dipilih untuk pengantaran "
                    + "berstatus " + status + ". Klik kolom Bukti Foto "
                    + "untuk memilih gambar.");
        }
    }

    public static void validasiFormUbahStatusPengantaran(String status,
            boolean adaFoto, String catatan) {
        if (!java.util.List.of("Ditugaskan", "Dalam Perjalanan",
                "Berhasil", "Gagal").contains(status)) {
            throw new IllegalArgumentException(
                    "Status pengantaran tidak valid.");
        }
        validasiBuktiFoto(status, adaFoto);
        if ("Gagal".equals(status)
                && (catatan == null || catatan.isBlank())) {
            throw new IllegalArgumentException(
                    "Catatan wajib diisi untuk pengantaran gagal, "
                    + "agar penyebab kegagalan tercatat.");
        }
    }

    public static void validasiFormRiwayat(String deskripsi,
            String waktuTeks, int idPengiriman) {
        wajib(deskripsi, "Deskripsi riwayat");
        if (deskripsi.length() > 50) {
            throw new IllegalArgumentException(
                    "Deskripsi riwayat maksimal 50 karakter.");
        }
        wajib(waktuTeks, "Waktu riwayat");
        waktuValid(waktuTeks, "Waktu riwayat");
        if (idPengiriman <= 0) {
            throw new IllegalArgumentException(
                    "Nomor resi pengiriman wajib dipilih.");
        }
    }

    public static void validasiCekTarif(String beratTeks) {
        wajib(beratTeks, "Berat paket");
        desimalValid(beratTeks, "Berat paket");
        BigDecimal berat = new BigDecimal(beratTeks.replace(",", "."));
        if (berat.signum() <= 0) {
            throw new IllegalArgumentException(
                    "Berat paket harus lebih dari 0 KG.");
        }
        if (berat.doubleValue() > 50) {
            throw new IllegalArgumentException(
                    "Berat paket maksimal 50 KG.");
        }
    }
    
    public static void validasiNomorResi(String nomorResi) {
        wajib(nomorResi, "Nomor resi");
        if (!nomorResi.toUpperCase().matches("^JE[A-Z0-9]{8}$")) {
            throw new IllegalArgumentException(
                    "Nomor resi harus berformat JE + 8 karakter "
                    + "(contoh: JE24423415).");
        }
    }

    private static void wajib(String nilai, String namaField) {
        if (nilai == null || nilai.isBlank()) {
            throw new IllegalArgumentException(
                    namaField + " wajib diisi.");
        }
    }

    private static void wajibMinimal(String nilai, String namaField,
            int panjangMinimal) {
        wajib(nilai, namaField);
        if (nilai.length() < panjangMinimal) {
            throw new IllegalArgumentException(
                    namaField + " minimal " + panjangMinimal
                    + " karakter.");
        }
    }

    private static int angkaValid(String teks, String namaField) {
        try {
            return Integer.parseInt(teks.replace(",", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    namaField + " harus berupa angka yang valid.");
        }
    }

    private static void desimalValid(String teks, String namaField) {
        try {
            new BigDecimal(teks.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    namaField + " harus berupa angka desimal "
                    + "yang valid (contoh: 1.75).");
        }
    }

    private static void tanggalValid(String teks, String namaField) {
        try {
            LocalDate.parse(teks.trim());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    namaField + " harus berformat tahun-bulan-tanggal "
                    + "(contoh: 2026-09-02).");
        }
    }

    private static void waktuValid(String teks, String namaField) {
        String t = teks.trim();
        try {

            if (t.length() == 19) {
                java.time.LocalDateTime.parse(
                        t, java.time.format.DateTimeFormatter
                                .ofPattern("yyyy-MM-dd HH:mm:ss"));
            } else if (t.length() == 16) {
                java.time.LocalDateTime.parse(
                        t, java.time.format.DateTimeFormatter
                                .ofPattern("yyyy-MM-dd HH:mm"));
            } else {
                LocalDate tanggal = LocalDate.parse(
                        t.substring(0, 10));
                LocalTime.now();
                if (t.length() < 10) {
                    throw new DateTimeParseException(
                            "waktu tidak lengkap", t, 0);
                }
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    namaField + " harus berformat "
                    + "tahun-bulan-tanggal jam:menit:detik "
                    + "(contoh: 2026-09-02 08:15:21).");
        }
    }
}
