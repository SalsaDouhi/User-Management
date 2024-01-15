package com.gestiondeproduits;

import com.gestiondeproduits.metier.Operation;
import com.gestiondeproduits.metier.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "auth", value = "/authentification")

public class AuthentificationServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AuthentificationServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Operation op = new Operation();
        UserBeans authBeans = new UserBeans();

        authBeans.setUsers(op.getAll());
        req.setAttribute("modele", authBeans);

        LOGGER.log(Level.INFO, "Username: " + op.getUser(username, password));

        if(op.getUser(username, password)){
            req.getRequestDispatcher("ListUser.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "password or username incorrecte");
            req.getRequestDispatcher("").forward(req, resp);
        }
    }
}
