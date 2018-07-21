/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QQ
 */
public class FormHandlerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormHandlerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormHandlerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String fullname, yearofbirth, address, email;
        String[] selectedInterest;
        fullname = request.getParameter("fullname");
        yearofbirth = request.getParameter("yearofbirth");
        address = request.getParameter("address");
        email = request.getParameter("email");
        selectedInterest = request.getParameterValues("interest");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter;
        try {
            printWriter = response.getWriter();
            printWriter.println("<p>Your information</p>");
            printWriter.println("<p>- Full name: " + fullname + "</p>");
            printWriter.println("<p>- Address: " + address + "</p>");
            printWriter.println("<p>- Year of birth: " + yearofbirth + "</p>");
            printWriter.println("<p>- Email: " + email + "</p>");
            printWriter.print("<p>- Your interest:");
            printWriter.println("<br/>");
            if (selectedInterest != null) {
                for (String option : selectedInterest) {
                    printWriter.print(option);
                    printWriter.println("<br/>");
                }
            } else {
                printWriter.println("None");
            }
            printWriter.println("</p>");

        } catch (Exception e) {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
