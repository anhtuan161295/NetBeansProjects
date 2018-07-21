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
public class AddUserAction extends ActionSupport {

    private User user = new User();

    //<editor-fold defaultstate="collapsed" desc="getter setter constructor">
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public AddUserAction() {
    }
//</editor-fold>

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        if (userDAO.addUser(user)) {
            return SUCCESS;
        }
        return ERROR;
    }

}
