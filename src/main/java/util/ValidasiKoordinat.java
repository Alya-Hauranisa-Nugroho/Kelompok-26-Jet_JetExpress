package util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public final class ValidasiKoordinat {

    private ValidasiKoordinat() {
    }

    public static BigDecimal parseLatitude(String teks) {
        if (teks == null || teks.isBlank()) {
            return null;
        }
        BigDecimal nilai = parseDesimal(teks, "Latitude");
        if (nilai.compareTo(new BigDecimal("-90")) < 0
                || nilai.compareTo(new BigDecimal("90")) > 0) {
            throw new IllegalArgumentException(
                    "Latitude harus berada antara -90 sampai 90.");
        }
        return nilai;
    }

    public static BigDecimal parseLongitude(String teks) {
        if (teks == null || teks.isBlank()) {
            return null;
        }
        BigDecimal nilai = parseDesimal(teks, "Longitude");
        if (nilai.compareTo(new BigDecimal("-180")) < 0
                || nilai.compareTo(new BigDecimal("180")) > 0) {
            throw new IllegalArgumentException(
                    "Longitude harus berada antara -180 sampai 180.");
        }
        return nilai;
    }

    public static void validasi(BigDecimal latitude, BigDecimal longitude) {
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException(
                    "Lokasi tujuan belum dipilih. "
                    + "Klik atau geser titik pada peta terlebih dahulu.");
        }
        validasi(latitude.doubleValue(), longitude.doubleValue());
    }

    public static void validasi(double latitude, double longitude) {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException(
                    "Latitude harus berada antara -90 sampai 90.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException(
                    "Longitude harus berada antara -180 sampai 180.");
        }
    }

    private static BigDecimal parseDesimal(String teks, String nama) {
        try {
            return new BigDecimal(teks.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    nama + " harus berupa angka desimal yang valid.");
        }
    }

    public static String formatTampilan(BigDecimal latitude,
            BigDecimal longitude) {
        if (latitude == null || longitude == null) {
            return "-";
        }
        return "(" + latitude.toPlainString() + ", "
                + longitude.toPlainString() + ")";
    }

    public static boolean isDesimal(String teks) {
        try {
            new BigDecimal(teks.trim().replace(",", "."));
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }
}
