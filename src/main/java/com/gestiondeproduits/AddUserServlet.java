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

@WebServlet(name = "addUser", value = "/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = new User(username, password);
        Operation op = new Operation();
        AuthentificationBeans authBeans = new AuthentificationBeans();

        op.addUser(u);
        authBeans.setUsers(op.getAll());
        req.setAttribute("modele", authBeans);
        req.getRequestDispatcher("ListUser.jsp").forward(req, resp);
    }
}
