package controller;

import dao.DashboardAdminDAO;
import java.sql.SQLException;
import java.util.Map;

public class DashboardController {

    private final DashboardAdminDAO dashboardDAO;

    public DashboardController() {
        this.dashboardDAO = new DashboardAdminDAO();
    }

    public Map<String, Integer> statistik() throws SQLException {
        return dashboardDAO.getStatistik();
    }

    public Map<String, Integer> pengirimanPerKonter() throws SQLException {
        return dashboardDAO.getPengirimanPerKonter();
    }
}