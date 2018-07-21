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
@WebServlet(name = "UpdateEmployee", urlPatterns = {"/UpdateEmployee"})
public class UpdateEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = "D:\\employees.xml";
        String id = request.getParameter("id");
        XMLActions actions = new XMLActions();
        String forward = "";

        Employee emp = actions.get(path, id);
        if (emp != null) {
            request.setAttribute("empInfo", emp);
            forward = "/update2.jsp";
        } else {
            request.setAttribute("emp_notfound", "Employee not found or invalid");
            forward = "/update1.jsp";
        }
        request.getRequestDispatcher(forward).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getClass().getResource("employees.xml").getPath();
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String role = request.getParameter("role");

        Employee emp = new Employee(id, password, name, age, gender, role);
        XMLActions actions = new XMLActions();
        if (actions.update(path, emp)) {
            // update success
            request.setAttribute("update_msg", "Update success");
        } else {
            // update failed
            request.setAttribute("update_msg", "Update failed");
        }
//        request.getRequestDispatcher("/update2.jsp").forward(request, response);
//        response.sendRedirect("ViewEmployee");
        response.sendRedirect("UpdateEmployee?id=" + id);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
