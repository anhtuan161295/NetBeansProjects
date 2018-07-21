/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author QQ
 */
public class LoginAction extends org.apache.struts.action.Action {

    private UserDAO userDAO = new UserDAO();

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

//        if (!username.equals("fpt") || !password.equals("123")) {
//            loginForm.setError();
//            return mapping.findForward(FAILURE);
//        }
        User user = userDAO.getUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                List<User> list = new ArrayList<>();
                list = userDAO.getAll();

                request.setAttribute("listUsers", list);
                return mapping.findForward(SUCCESS);
            }
        } else {
            loginForm.setError();
            return mapping.findForward(FAILURE);
        }
        return mapping.findForward(FAILURE);
    }
}
