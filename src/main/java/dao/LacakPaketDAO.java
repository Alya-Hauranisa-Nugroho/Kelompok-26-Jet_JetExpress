package dao;

import config.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LacakPaketDAO {

    public Map<String, Object> cariPaket(String nomorResi)
            throws SQLException {

        String sql = """
            SELECT pg.id_pengiriman, pg.no_resi,
                   pg.status_pengiriman, pg.batas_kirim,
                   pk.berat, pk.nama_pengirim, pk.nama_penerima
            FROM pengiriman pg
            JOIN paket pk ON pg.id_paket = pk.id_paket
            WHERE pg.no_resi = ?
            """;

        try (Connection conn =
                KoneksiDatabase.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nomorResi);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("id_pengiriman",
                            rs.getInt("id_pengiriman"));
                    data.put("no_resi", rs.getString("no_resi"));
                    data.put("berat", rs.getBigDecimal("berat"));
                    data.put("nama_pengirim",
                            rs.getString("nama_pengirim"));
                    data.put("nama_penerima",
                            rs.getString("nama_penerima"));
                    data.put("status",
                            rs.getString("status_pengiriman"));
                    data.put("estimasi", rs.getDate("batas_kirim"));
                    return data;
                }
            }
        }
        return null;
    }

    public List<Object[]> getRiwayat(int idPengiriman)
            throws SQLException {

        List<Object[]> daftarRiwayat = new ArrayList<>();

        String sql = """
            SELECT waktu_riwayat, deskripsi
            FROM riwayat_pelacakan
            WHERE id_pengiriman = ?
            ORDER BY waktu_riwayat ASC
            """;

        try (Connection conn =
                KoneksiDatabase.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPengiriman);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    daftarRiwayat.add(new Object[]{
                        rs.getTimestamp("waktu_riwayat"),
                        rs.getString("deskripsi")
                    });
                }
            }
        }
        return daftarRiwayat;
    }
}
