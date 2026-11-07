package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class KonversiWaktu {

    private static final DateTimeFormatter FORMAT_TANGGAL =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter FORMAT_TAMPILAN =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter FORMAT_WAKTU =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMAT_WAKTU_TAMPILAN =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private KonversiWaktu() {
    }

    public static LocalDate hariIni() {
        return LocalDate.now();
    }

    public static LocalDateTime sekarang() {
        return LocalDateTime.now();
    }

    public static LocalDate keTanggal(String teks) {
        if (teks == null || teks.isBlank()) {
            return null;
        }
        return LocalDate.parse(teks.trim(), FORMAT_TANGGAL);
    }

    public static String teksTanggal(LocalDate tanggal) {
        return tanggal == null ? "" : tanggal.format(FORMAT_TANGGAL);
    }

    public static String teksTanggalTampilan(LocalDate tanggal) {
        return tanggal == null ? "" : tanggal.format(FORMAT_TAMPILAN);
    }

    public static LocalDateTime keWaktu(String teks) {
        if (teks == null || teks.isBlank()) {
            return null;
        }
        String t = teks.trim();
        if (t.length() == 16) {
            t = t + ":00";
        }
        return LocalDateTime.parse(t, FORMAT_WAKTU);
    }

    public static String teksWaktu(LocalDateTime waktu) {
        return waktu == null ? "" : waktu.format(FORMAT_WAKTU);
    }

    public static String teksWaktuTampilan(LocalDateTime waktu) {
        return waktu == null ? ""
                : waktu.format(FORMAT_WAKTU_TAMPILAN);
    }

    public static String rupiah(int nominal) {
        return "Rp" + String.format("%,d", nominal)
                .replace(",", ".");
    }
}
