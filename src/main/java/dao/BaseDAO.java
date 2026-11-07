package dao;

import config.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseDAO<T> {

    @FunctionalInterface
    protected interface BlokTransaksi {
        void jalankan(Connection conn) throws SQLException;
    }

    protected Connection bukaKoneksi() throws SQLException {
        Connection conn = KoneksiDatabase.getInstance().getConnection();
        if (conn == null || conn.isClosed()) {
            throw new SQLException(
                    "Koneksi database tidak tersedia. "
                    + "Pastikan MySQL berjalan dan cek config.KoneksiDatabase.");
        }
        return conn;
    }

    public abstract String namaTabel();
    protected abstract T petakanBaris(ResultSet rs) throws SQLException;

    public abstract List<T> ambilSemua() throws SQLException;

    protected List<T> daftarHasil(String sql, Object... parameter)
            throws SQLException {
        List<T> hasil = new ArrayList<>();
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ikatParameter(ps, parameter);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    hasil.add(petakanBaris(rs));
                }
            }
        }
        return hasil;
    }

    protected Optional<T> satuHasil(String sql, Object... parameter)
            throws SQLException {
        List<T> hasil = daftarHasil(sql, parameter);
        return hasil.isEmpty() ? Optional.empty() : Optional.of(hasil.get(0));
    }

    protected int skalarInt(String sql, Object... parameter)
            throws SQLException {
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ikatParameter(ps, parameter);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    protected int perintah(String sql, Object... parameter)
            throws SQLException {
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ikatParameter(ps, parameter);
            return ps.executeUpdate();
        }
    }

    protected long sisipKunciBaru(String sql, Object... parameter)
            throws SQLException {
        try (Connection conn = bukaKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            ikatParameter(ps, parameter);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        throw new SQLException(
                "Database tidak mengembalikan ID data baru untuk tabel "
                + namaTabel() + ".");
    }

    protected void ikatParameter(PreparedStatement ps, Object... parameter)
            throws SQLException {
        for (int i = 0; i < parameter.length; i++) {
            ps.setObject(i + 1, parameter[i]);
        }
    }

    protected void jalankanTransaksi(BlokTransaksi blok)
            throws SQLException {
        try (Connection conn = bukaKoneksi()) {
            boolean autocommitAwal = conn.getAutoCommit();
            conn.setAutoCommit(false);
            try {
                blok.jalankan(conn);
                conn.commit();
            } catch (SQLException | RuntimeException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(autocommitAwal);
            }
        }
    }
}
