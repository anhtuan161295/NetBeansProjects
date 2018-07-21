/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import java.util.Map;
import model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author QQ
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private String username;
    private String password;
    private Map<String, Object> session;

    //<editor-fold defaultstate="collapsed" desc="getter setter constructor">
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public LoginAction() {
    }
//</editor-fold>

    public String logout() {
        session.remove("loginUsername");
        addActionMessage("You have been successfully logged out.");
        return SUCCESS;
    }

    public String login() {
        if (username.isEmpty()) {
            addActionError("Username can't be blank.");
            return LOGIN;
        } else if (password.isEmpty()) {
            addActionError("Password can't be blank.");
            return LOGIN;
        } else {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByUsername(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    // Login success
                    session.put("loginUsername", user.getUsername());
                    return SUCCESS;
                } else {
                    // Sai password
                    addActionError("Wrong password.");
                    return LOGIN;
                }
            } else {
                // user invalid
                addActionError("User is invalid.");
                return LOGIN;
            }
        }
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
