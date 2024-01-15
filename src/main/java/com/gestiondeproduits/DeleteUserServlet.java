package com.gestiondeproduits;

import com.gestiondeproduits.metier.Operation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "deleteUser", value = "/deleteUser")

public class DeleteUserServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(DeleteUserServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));

        Operation o = new Operation();
        AuthentificationBeans authBeans = new AuthentificationBeans();

        o.removeUser(id);
        authBeans.setUsers(o.getAll());
        req.setAttribute("modele", authBeans);
        req.getRequestDispatcher("ListUser.jsp").forward(req,resp);
    }
}
