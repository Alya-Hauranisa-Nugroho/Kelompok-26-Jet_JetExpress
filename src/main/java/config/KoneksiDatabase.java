package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class KoneksiDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/jetexpress?useSSL=false&serverTimezone=Asia/Jakarta";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final KoneksiDatabase INSTANCE = new KoneksiDatabase();

    private KoneksiDatabase() { }

    public static KoneksiDatabase getInstance() { return INSTANCE; }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void testConnection() throws SQLException {
        try (Connection connection = getInstance().getConnection()) {
            if (!connection.isValid(3)) throw new SQLException("Koneksi database tidak valid.");
        }
    }
}
