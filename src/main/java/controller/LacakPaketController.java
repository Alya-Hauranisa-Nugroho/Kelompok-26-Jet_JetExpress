package controller;

import dao.LacakPaketDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import util.InputHelper;

public class LacakPaketController {

    private final LacakPaketDAO lacakDAO;

    public LacakPaketController() {
        this.lacakDAO = new LacakPaketDAO();
    }

    public Map<String, Object> lacak(String nomorResi)
            throws SQLException {
        InputHelper.validasiNomorResi(nomorResi);
        return lacakDAO.cariPaket(nomorResi.trim().toUpperCase());
    }

    public List<Object[]> riwayat(int idPengiriman) throws SQLException {
        if (idPengiriman <= 0) {
            throw new IllegalArgumentException(
                    "Data pengiriman tidak ditemukan.");
        }
        return lacakDAO.getRiwayat(idPengiriman);
    }
}
