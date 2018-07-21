/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author QQ
 */
@WebServlet(name = "ChangeLanguageServlet", urlPatterns = {"/ChangeLanguageServlet"})
public class ChangeLanguageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String lang = request.getParameter("language");
        String lang1;
        switch (lang) {
            case "vi_VN":
                lang1 = lang;
                session.setAttribute("resourseLocation", "resources.lang_vi_VN");
                break;
            default:
                lang1 = "en_US";
                session.setAttribute("resourseLocation", "resources.lang_en_US");
                break;
        }

        session.setAttribute("language", lang1);

        String[] planguage = lang1.split("_");
        String language = planguage[0];
        String country = planguage[1];

        Locale locale = new Locale(language, country);
        request.setAttribute("country", locale.getDisplayCountry());

//        ResourceBundle bundle = ResourceBundle.getBundle("resources.content", locale);
//        String url = request.getRequestURL().toString();
//        request.getRequestDispatcher(url).forward(request, response);
//        response.sendRedirect("index.jsp");
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);

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
