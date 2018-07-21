/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.fpt.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author QQ
 */
public class GetAllUserAction extends ActionSupport {

    List<User> list = new ArrayList<>();

    //<editor-fold defaultstate="collapsed" desc="getter setter constructor">
    public List<User> getList() {
        return list;
    }
    
    public void setList(List<User> list) {
        this.list = list;
    }
    
    public GetAllUserAction() {
    }
//</editor-fold>

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        list = userDAO.getAll();
        if (!list.isEmpty()) {
            return SUCCESS;
        }
        return ERROR;
    }

}
