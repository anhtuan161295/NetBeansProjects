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
import javax.servlet.http.HttpSession;

/**
 *
 * @author QQ
 */
public class LoginSES extends HttpServlet {

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
        //processRequest(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Get the session - if no session exists, create one
        HttpSession session = request.getSession(true);
        // Set some variables to the session
        // In this case username and password from the request and client
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("Thank you, " + username + ". You are now logged into the system");
            // Encodes the specified URL by including the session ID in it
            // or, if encoding is not needed, returns the URL unchanged
            String newURL = response.encodeURL("GetSession");
            // Return a <a> tag with the new url
            writer.println("Click <a href=\"" + newURL + "\">here</a> for another servlet");
            writer.println("</body></html>");
            writer.close();
        } catch (Exception e) {
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
