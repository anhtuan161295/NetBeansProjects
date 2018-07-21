package lab05;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QQ
 */
public class ConfirmationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter printWriter;
            List<String> interest = (List<String>) request.getAttribute("interest");
            String fullname = (String) request.getAttribute("fullname");
            String yearofbirth = (String) request.getAttribute("yearofbirth");
            String address = (String) request.getAttribute("address");
            String email = (String) request.getAttribute("email");
            response.setContentType("text/html");
            printWriter = response.getWriter();
            printWriter.println("<p>Full name: " + fullname);
            printWriter.println("<p>Year of birth: " + yearofbirth);
            printWriter.println("<p>Address: " + address);
            printWriter.println("<p>Email: " + email);
            printWriter.println("<p>Your interest: <br> ");
            if (interest != null) {
                for (String optionLabel : interest) {
                    printWriter.print(optionLabel);
                    printWriter.println("<br/>");
                }
            } else {
                printWriter.println("None");
            }

        } catch (Exception e) {
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
