/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import model.User;

/**
 *
 * @author QQ
 */
public class GetUserAction extends ActionSupport {

    private String username;
    private String action;
    private User userUpdate = null;
    private User userDelete = null;

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        User user1 = userDAO.getUserByUsername(username);
        if (user1 != null) {
            switch (action) {
                case "Update":
                    userUpdate = user1;
                    return "Update";
                case "Delete":
                    userDelete = user1;
                    return "Delete";
                default:
                    return ERROR;
            }
        }
        return ERROR;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter Setter Constructor">
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public User getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(User userUpdate) {
        this.userUpdate = userUpdate;
    }

    public User getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(User userDelete) {
        this.userDelete = userDelete;
    }

    public GetUserAction() {
    }
//</editor-fold>

}
