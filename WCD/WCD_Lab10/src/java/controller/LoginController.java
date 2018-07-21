/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author QQ
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie ck1 = new Cookie("login_username", "");
        Cookie ck2 = new Cookie("login_password", "");

        HttpSession session = request.getSession();
        String username = request.getParameter("login_username");
        String password = request.getParameter("login_password");

        User user = new User();

        if (request.getParameter("login_remember") != "") {
            ck1.setValue(username);
            ck2.setValue(password);
            ck1.setMaxAge(30 * 60);
            ck2.setMaxAge(30 * 60);
            response.addCookie(ck1);
            response.addCookie(ck2);
        }

        try {
            user = userDAO.getUserByUsername(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    // Login thành công
                    session.setAttribute("user", user);
                    response.sendRedirect("UserController");
                } else {
                    // Sai password
                    request.setAttribute("error_msg", "Wrong password");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                // User ko tồn tại
                request.setAttribute("error_msg", "User is invalid");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
