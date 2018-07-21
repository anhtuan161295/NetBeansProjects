/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.fpt.com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author QQ
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

//        String acc_user = "admin";
//        String acc_pass = "123";
        String user_user = "fpt";
        String user_pass = "123456";
        String admin_user = "admin";
        String admin_pass = "abcdef";
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        request.removeAttribute("rememberme");

        String remember = request.getParameter("rememberme");

        // Lưu username và password đã nhập vào session
        if (user != null && pass != null) {
            session.setAttribute("input_user", user);
            session.setAttribute("input_pass", pass);

//            PrintWriter out = response.getWriter();
//            out.print("rememer:" + remember);
        }
        // Session remember me
        if (remember == null) {
            session.setAttribute("input_remember", "false");
        } else if (remember != null) {
            session.setAttribute("input_remember", "true");
        }

        if (user.equals(user_user) && pass.equals(user_pass)) {
            session.setAttribute("user", user);
            response.sendRedirect("listUsers.jsp");
        } else if (user.equals(admin_user) && pass.equals(admin_pass)) {
            session.setAttribute("user", user);
            response.sendRedirect("listUsers.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color='red'>User name or password invalid</font>");
            rd.include(request, response);
        }

//            Cookie userName = new Cookie("input_user", user);
//            Cookie userPass = new Cookie("input_pass", pass);
//            Cookie userRemember = new Cookie("input_remember", remember);
//            userName.setMaxAge(30 * 60);
//            userPass.setMaxAge(30 * 60);
//            userRemember.setMaxAge(30 * 60);
//            response.addCookie(userName);
//            response.addCookie(userPass);
//            response.addCookie(userRemember);
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
