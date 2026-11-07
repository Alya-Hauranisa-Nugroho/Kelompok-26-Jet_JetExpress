package controller;

import dao.KonterDAO;
import dao.UserDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import model.User;
import util.InputHelper;
import util.KonversiWaktu;

public class UserController {

    private final UserDAO userDAO;
    private final KonterDAO konterDAO;

    public UserController() {
        this.userDAO = new UserDAO();
        this.konterDAO = new KonterDAO();
    }

    public List<Object[]> tampilkan(int idKonter) throws SQLException {
        if (idKonter <= 0) {
            throw new IllegalArgumentException(
                    "Konter belum terdeteksi. Silakan login ulang.");
        }
        return userDAO.getSemuaUser(idKonter);
    }

    public List<Object[]> daftarKonter() throws SQLException {
        return userDAO.getDaftarKonter();
    }

    public java.util.Optional<User> detail(int idUser)
            throws SQLException {
        if (idUser <= 0) {
            throw new IllegalArgumentException(
                    "ID user tidak valid.");
        }
        return userDAO.ambilById(idUser);
    }

    public boolean tambah(String nama, String email, String password,
            String noHp, String gajiTeks, String tanggalMasukTeks,
            String role, int idKonter, String shift,
            String nomorKendaraan) throws SQLException {

        if ("Kurir".equals(role)) {
            InputHelper.validasiFormKurir(nama, email, password, noHp,
                    gajiTeks, tanggalMasukTeks, nomorKendaraan, true);
        } else {
            InputHelper.validasiFormPetugasKonter(nama, email, password,
                    noHp, gajiTeks, tanggalMasukTeks, shift);
        }
        pastikanEmailBebas(email, 0);
        pastikanKonterAda(idKonter);

        User user = susunUser(0, nama, email, password, noHp, gajiTeks,
                tanggalMasukTeks, role, idKonter);
        return userDAO.tambahUser(user, shift, nomorKendaraan, null);
    }

    public boolean ubah(int idUser, String nama, String email,
            String password, String noHp, String gajiTeks,
            String tanggalMasukTeks, String role, int idKonter,
            String shift, String nomorKendaraan) throws SQLException {

        if (idUser <= 0) {
            throw new IllegalArgumentException(
                    "Tidak ada user yang dipilih.");
        }
        String passwordEfektif = password == null ? "" : password;
        if ("Kurir".equals(role)) {
            InputHelper.validasiFormKurir(nama, email, passwordEfektif,
                    noHp, gajiTeks, tanggalMasukTeks, nomorKendaraan,
                    false);
        } else {
            InputHelper.validasiFormPetugasKonter(nama, email,
                    passwordEfektif, noHp, gajiTeks, tanggalMasukTeks,
                    shift);
        }
        pastikanEmailBebas(email, idUser);
        pastikanKonterAda(idKonter);

        User user = susunUser(idUser, nama, email, null, noHp, gajiTeks,
                tanggalMasukTeks, role, idKonter);
        String passwordBaru = passwordEfektif.isBlank()
                ? null : passwordEfektif;
        return userDAO.ubahUser(idUser, user, passwordBaru, shift,
                nomorKendaraan, null);
    }

    /** Menghapus user setelah konfirmasi. */
    public boolean hapus(int idUser) throws SQLException {
        if (idUser <= 0) {
            throw new IllegalArgumentException(
                    "Pilih user yang akan dihapus terlebih dahulu.");
        }
        return userDAO.hapusUser(idUser);
    }

    private User susunUser(int idUser, String nama, String email,
            String password, String noHp, String gajiTeks,
            String tanggalMasukTeks, String role, int idKonter) {
        User user = new User();
        user.setIdUser(idUser);
        user.setNama(nama);
        user.setEmail(email);
        user.setPassword(password == null ? "" : password);
        user.setNoHp(noHp);
        user.setGaji(Integer.parseInt(gajiTeks.replace(",", "")));
        user.setTanggalMasuk(KonversiWaktu.keTanggal(tanggalMasukTeks));
        user.setRole(role);
        user.setIdKonter(idKonter);
        return user;
    }

    private void pastikanEmailBebas(String email, int kecualiIdUser)
            throws SQLException {
        if (userDAO.emailTerdaftar(email, kecualiIdUser)) {
            throw new IllegalArgumentException(
                    "Email sudah dipakai user lain. "
                    + "Gunakan email yang berbeda.");
        }
    }

    private void pastikanKonterAda(int idKonter) throws SQLException {
        if (!konterDAO.adaKonter(idKonter)) {
            throw new IllegalArgumentException(
                    "Konter yang dipilih tidak ditemukan.");
        }
    }

    public static Date keSqlDate(java.time.LocalDate tanggal) {
        return tanggal == null ? null : Date.valueOf(tanggal);
    }
}
