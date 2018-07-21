package lab05;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QQ
 */
public class ForwardServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String fullname, yearofbirth, address, email;
        String[] selectedInterest;
        fullname = request.getParameter("fullname");
        yearofbirth = request.getParameter("yearofbirth");
        address = request.getParameter("address");
        email = request.getParameter("email");
        selectedInterest = request.getParameterValues("interest");
        ArrayList<String> selectedInterestLabels = null;

        fullname = request.getParameter("fullname");
        yearofbirth = request.getParameter("yearofbirth");
        address = request.getParameter("address");
        email = request.getParameter("email");
        selectedInterest = request.getParameterValues("interest");
        if (selectedInterest != null) {
            selectedInterestLabels = new ArrayList<String>(selectedInterest.length);
            for (String selectedOption : selectedInterest) {
                if (selectedOption.equals("Shopping")) {
                    selectedInterestLabels.add("Shopping");
                } else if (selectedOption.equals("Watching Films")) {
                    selectedInterestLabels.add("Watching Films");
                } else if (selectedOption.equals("Sporting")) {
                    selectedInterestLabels.add("Sporting");
                }
            }
        }
        request.setAttribute("fullname", fullname);
        request.setAttribute("yearofbirth", yearofbirth);
        request.setAttribute("address", address);
        request.setAttribute("email", email);
        request.setAttribute("interest", selectedInterestLabels);
        try {
            request.getRequestDispatcher("/ConfirmationServlet").forward(request, response);
        } catch (Exception e) {
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
