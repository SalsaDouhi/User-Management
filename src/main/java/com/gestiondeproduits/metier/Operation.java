package com.gestiondeproduits.metier;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Operation {
    ArrayList<User> listUser = new ArrayList<>();
    public void addUser(User user){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit","root","");
            PreparedStatement pr = conn.prepareStatement("insert into user values(NULL, ?, ?)");
            pr.setString(1,user.getUsername());
            pr.setString(2,user.getPassword());
            pr.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUser(int id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit","root","");
            PreparedStatement pr = conn.prepareStatement("delete from user where id=?");
            pr.setInt(1, id);
            pr.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(int id, String username, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit","root","");
            PreparedStatement pr = conn.prepareStatement("UPDATE `user` SET `username`=?,`password`=? WHERE id=?");
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setInt(3, id);
            pr.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getUser(String username, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit","root","");
            PreparedStatement pr = conn.prepareStatement("select * from user where username=? and password=?");
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet res = pr.executeQuery();
            return res.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> getAll(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit","root","");
            PreparedStatement pr = conn.prepareStatement("select * from user");
            ResultSet res = pr.executeQuery();
            while(res.next()){
                User user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                listUser.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listUser;
    }
}
