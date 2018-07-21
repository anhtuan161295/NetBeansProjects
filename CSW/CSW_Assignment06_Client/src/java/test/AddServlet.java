/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.Users;
import ws.UsersWS;
import ws.UsersWS_Service;

/**
 *
 * @author QQ
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersWS_Service service = new UsersWS_Service();
        UsersWS port = service.getUsersWSPort();

        Users user = new Users();
        user.setUsername(request.getParameter("user"));
        user.setPassword(request.getParameter("pwd"));
        user.setFullname(request.getParameter("fname"));
        user.setLevel(Short.parseShort(request.getParameter("level")));
        try {
            port.insert(user);
            response.sendRedirect("ListServlet");
        } catch (Exception e) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
