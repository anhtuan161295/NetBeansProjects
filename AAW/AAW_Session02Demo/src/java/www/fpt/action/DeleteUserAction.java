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
public class DeleteUserAction extends ActionSupport {

    private User userDelete = new User();

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        if (userDAO.deleteUser(userDelete.getUsername())) {
            return SUCCESS;
        }
        return ERROR;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter setter constructor">
    public User getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(User userDelete) {
        this.userDelete = userDelete;
    }

    public DeleteUserAction() {
    }
    //</editor-fold>

}
