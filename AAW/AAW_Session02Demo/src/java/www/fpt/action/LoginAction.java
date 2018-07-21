/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.fpt.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import model.User;

/**
 *
 * @author QQ
 */
public class LoginAction extends ActionSupport {

    private String username;
    private String password;

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
    
    public LoginAction() {
    }
//</editor-fold>

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                // Login success
                return SUCCESS;
            } else {
                // Sai password
                return ERROR;
            }
        } else {
            // user invalid
            return ERROR;
        }

    }

}
