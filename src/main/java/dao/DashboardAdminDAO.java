
package dao;

import config.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DashboardAdminDAO {

    public Map<String, Integer> getStatistik() throws SQLException {

        String sql = """
            SELECT
                (SELECT COUNT(*) FROM paket) AS total_paket,

                (SELECT COUNT(*)
                 FROM pengiriman
                 WHERE status_pengiriman = 'Terkirim') AS total_terkirim,

                (SELECT COUNT(*)
                 FROM pengiriman
                 WHERE status_pengiriman = 'Gagal') AS total_gagal,

                (SELECT COUNT(*)
                 FROM pengiriman
                 WHERE status_pengiriman = 'Dalam Pengiriman') AS total_dalam_pengiriman
            """;

        Map<String, Integer> statistik = new HashMap<>();

        try (Connection conn = KoneksiDatabase.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                statistik.put("total_paket", rs.getInt("total_paket"));
                statistik.put("total_terkirim", rs.getInt("total_terkirim"));
                statistik.put("total_gagal", rs.getInt("total_gagal"));
                statistik.put("total_dalam_pengiriman",
                        rs.getInt("total_dalam_pengiriman"));
            }
        }

        return statistik;
    }
   public Map<String, Integer> getPengirimanPerKonter() throws SQLException {

    String sql = """
        SELECT k.nama_konter,
               COUNT(p.id_pengiriman) AS total_pengiriman
        FROM konter k
        LEFT JOIN pengiriman p
            ON p.id_konter = k.id_konter
        GROUP BY k.id_konter, k.nama_konter
        ORDER BY k.nama_konter
        """;

    Map<String, Integer> hasil = new HashMap<>();

    try (Connection conn = KoneksiDatabase.getInstance().getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            hasil.put(
                rs.getString("nama_konter"),
                rs.getInt("total_pengiriman")
            );
        }
    }

    return hasil;
}
}

