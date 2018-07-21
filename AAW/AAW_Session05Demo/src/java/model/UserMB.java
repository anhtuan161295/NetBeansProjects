/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UserDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author QQ
 */
@ManagedBean
@SessionScoped
public class UserMB {

    private User user = new User();
    private User userToUpdate = new User();

    //<editor-fold defaultstate="collapsed" desc="comment">
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserToUpdate() {
        return userToUpdate;
    }

    public void setUserToUpdate(User userToUpdate) {
        this.userToUpdate = userToUpdate;
    }

    public UserMB() {
    }
//</editor-fold>

    public String insertUser() {
        UserDAO userDAO = new UserDAO();
        String result = null;
        if (userDAO.addUser(user)) {
            result = "insert_ok";
        } else {
            result = "insert_error";
        }
        user = new User();
        return result;
    }

    public List<User> listUsers() {
        UserDAO userDAO = new UserDAO();
        return userDAO.getAll();
    }

    public String deleteUser(String username) {
        UserDAO userDAO = new UserDAO();
        String result = null;
        if (userDAO.deleteUser(username)) {
            result = "delete_ok";
        } else {
            result = "delete_error";
        }
        return result;
    }

    public String updateUser(User user) {
        UserDAO userDAO = new UserDAO();
        String result = null;
        if (userDAO.updateUser(user)) {
            result = "listUser";
        } else {
            result = "update_error";
        }
        return result;
    }

    public String getUser(String username, String action) {
        User user = null;
        for (User u : listUsers()) {
            if (u.getUsername().equals(username)) {
                user = u;
            }
        }
        this.userToUpdate = user;
        return action;
    }

    public String login(User user) {
        UserDAO userDAO = new UserDAO();
        String result = null;
        User user1 = userDAO.getUserByUsername(user.getUsername());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword())) {
                result = "listUser";
            } else {
                // wrong password
                result = "login_error";
            }
        } else {
            // user invalid
            result = "login_error";
        }
        return result;
    }

    public String logout() {
        this.user = new User();
        return "login";
    }

}
