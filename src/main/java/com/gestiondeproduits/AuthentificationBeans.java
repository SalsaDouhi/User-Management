package com.gestiondeproduits;

import com.gestiondeproduits.metier.User;

import java.util.ArrayList;

public class AuthentificationBeans {
    private User user = new User();
    public ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
