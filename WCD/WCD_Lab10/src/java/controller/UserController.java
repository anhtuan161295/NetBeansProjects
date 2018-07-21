/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author QQ
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = null;

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        } else {
            action = null;
        }

        if (action == null) {
            // Xử lý hiển thị danh sách
            List<User> listUsers = new ArrayList<>();
            try {
                listUsers = userDAO.getAll();
            } catch (Exception e) {
            }
            request.setAttribute("listUsers", listUsers);
            request.getRequestDispatcher("/listUsers.jsp").forward(request, response);

        } else if (action.equals("Update")) {
            // Xử lý update user
            String username = request.getParameter("username");
            User user = new User();
            try {
                user = userDAO.getUserByUsername(username);
            } catch (Exception ex) {
            }
            request.setAttribute("UserInfo", user);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            // Xử lý delete
            String username = request.getParameter("username");
            User user = new User();
            try {
                user = userDAO.getUserByUsername(username);
            } catch (Exception ex) {
            }
            request.setAttribute("UserInfo", user);
            request.getRequestDispatcher("/delete.jsp").forward(request, response);
        } else if (action.equals("UpdateConfirmed")) {
            // Xử lý save update
            String username = request.getParameter("username");
            String newPass = request.getParameter("newPassword");
            String newFullName = request.getParameter("newFullname");

            User user = new User(username, newPass, newFullName, 0);
            try {
                userDAO.updateUser(user);
            } catch (Exception e) {
            }
            response.sendRedirect("UserController");
        } else if (action.equals("DeleteConfirmed")) {
            // Xử lý confirm delete
            String username = request.getParameter("username");
            try {
                userDAO.deleteUser(username);
            } catch (Exception e) {
            }
            response.sendRedirect("UserController");
        } else if (action.equals("Search")) {
            // Xử lý search tìm kiếm
            String key = request.getParameter("keywords");
            List<User> listUsers = new ArrayList<>();
            User user = null;
            try {
                user = userDAO.getUserByUsername(key);
            } catch (Exception e) {
            }
            if (user != null) {
                listUsers.add(user);
            }
            request.setAttribute("listUsers", listUsers);
            request.getRequestDispatcher("/listUsers.jsp").forward(request, response);

        } else if (action.equals("Insert")) {
            // Xứ lý insert
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            String level = request.getParameter("level");
            int level2 = 0;

            if (level.isEmpty() == false) {
                level2 = Integer.parseInt(level);
            }
            User user = new User(username, password, fullname, level2);
            try {
                userDAO.addUser(user);
            } catch (SQLException ex) {
            }
            response.sendRedirect("UserController");
        }

//        RequestDispatcher rd = request.getRequestDispatcher("/listUsers.jsp");
//        rd.include(request, response);
//        PrintWriter out = response.getWriter();
//
//        out.print("<br>");
//        out.print("Database connection state: ");
//        if (userDAO.getDBConnection().checkConnect() == true) {
//            out.print("ON");
//        } else {
//            out.print("OFF");
//        }
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
