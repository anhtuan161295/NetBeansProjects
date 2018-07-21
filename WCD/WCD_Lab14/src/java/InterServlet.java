/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QQ
 */
@WebServlet(urlPatterns = {"/InterServlet"})
public class InterServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] planguage = request.getParameter("language").split("_");
        String language = planguage[0];
        String country = planguage[1];
        
        Locale locale = new Locale(language, country);
        request.setAttribute("country", locale.getDisplayCountry());
        // Định dạng number
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        request.setAttribute("fnumber", numberFormat.format(1234567));
        // Định dạng currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        request.setAttribute("fcurrency", currencyFormat.format(1234567));
        // Định dạng Percent
        NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);
        request.setAttribute("fpercent", percentFormat.format(12.34));
        // Định dạng Date
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        request.setAttribute("fdate", dateFormat.format(new Date()));
        // Định dạng String
        ResourceBundle bundle = ResourceBundle.getBundle("resources.content", locale);
        request.setAttribute("fmessage", bundle.getString("lbl.welcome"));
        request.setAttribute("fuser", bundle.getString("lbl.username"));
        request.setAttribute("fpass", bundle.getString("lbl.password"));
        
        request.getRequestDispatcher("locale.jsp").forward(request, response);
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
