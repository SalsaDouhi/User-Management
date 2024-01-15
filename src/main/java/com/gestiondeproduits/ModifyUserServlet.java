package com.gestiondeproduits;

import com.gestiondeproduits.metier.Operation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "updateUser", value = "/updateUser")
public class ModifyUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.getRequestDispatcher("UpdateUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Operation o = new Operation();
        AuthentificationBeans authBeans = new AuthentificationBeans();

        o.updateUser(id, username, password);
        authBeans.setUsers(o.getAll());
        req.setAttribute("modele", authBeans);
        req.getRequestDispatcher("ListUser.jsp").forward(req,resp);

    }
}
