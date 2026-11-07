package controller;

import dao.UserDAO;
import java.sql.SQLException;
import java.util.List;
import model.User;
import util.InputHelper;
import util.Sesi;


public class LoginController {

    private final UserDAO userDAO;

    public LoginController() {
        this.userDAO = new UserDAO();
    }


    public User login(String email, String password)
            throws SQLException {
        InputHelper.validasiLogin(email, password);

        User user = userDAO.login(email.trim(), password)
                .orElseThrow(() -> new IllegalStateException(
                        "Email atau password salah!"));

        Sesi.login(user.getIdUser(), user.getNama(), user.getEmail(),
                user.getRole(), user.getIdKonter());
        return user;
    }

    public void logout() {
        Sesi.logout();
    }
}
