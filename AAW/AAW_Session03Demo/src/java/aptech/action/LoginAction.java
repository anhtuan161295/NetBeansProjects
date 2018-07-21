/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author QQ
 */
public class LoginAction extends ActionSupport implements SessionAware {
    
    private String username;
    private Map<String, Object> session;
    
    public LoginAction() {
    }
    
    public String home() {
        return SUCCESS;
    }
    
    public String logout() {
        session.remove("loginId");
        addActionMessage("You have been successfully logged out.");
        return SUCCESS;
    }
    
    public String login() {
        if (username.isEmpty()) {
            addActionError("Username can't be blank");
            return LOGIN;
        } else {
            session.put("loginId", username);
            return SUCCESS;
        }
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public Map<String, Object> getSession() {
        return session;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getter setter">
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
//</editor-fold>

}
