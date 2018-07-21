/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QQ
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getClass().getResource("employees.xml").getPath();
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        XMLActions actions = new XMLActions();
        Employee e = actions.get(path, id);
        if (e != null) {
            if (e.getPassword().equals(password)) {
                // Success
                response.sendRedirect("ViewEmployee");
            } else {
                // Wrong password
                request.setAttribute("error_MSG", "Wrong password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            // Invalid
            request.setAttribute("error_MSG", "ID invalid");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
