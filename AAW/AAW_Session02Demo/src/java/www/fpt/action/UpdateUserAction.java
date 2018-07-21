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
public class UpdateUserAction extends ActionSupport {

    private User userUpdate = new User();

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        if (userDAO.updateUser(userUpdate)) {
            return SUCCESS;
        }
        return ERROR;
    }

    //<editor-fold defaultstate="collapsed" desc="getter setter constructor">
    public User getUserUpdate() {
        return userUpdate;
    }
    
    public void setUserUpdate(User userUpdate) {
        this.userUpdate = userUpdate;
    }
    
    public UpdateUserAction() {
    }
//</editor-fold>
}
