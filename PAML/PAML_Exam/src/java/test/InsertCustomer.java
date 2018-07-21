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
@WebServlet(name = "InsertCustomer", urlPatterns = {"/InsertCustomer"})
public class InsertCustomer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String path = getClass().getResource("Customers.xml").getPath();
        String path = "D:\\Customers.xml";
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
//        String balance = request.getParameter("balance");

        int balance2 = Integer.parseInt(request.getParameter("balance"));
        String balance3 = String.valueOf(balance2);

        Customer cus = new Customer(id, password, name, balance3);
        XMLActions actions = new XMLActions();
        if (actions.add(path, cus)) {
            // insert success
//            request.setAttribute("insert_msg", "Insert success");
            response.sendRedirect("Login.jsp");
        } else {
            // insert failed
//            request.setAttribute("insert_msg", "Insert failed");
            response.sendRedirect("Error.jsp");

        }
//        request.getRequestDispatcher("Insert.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
