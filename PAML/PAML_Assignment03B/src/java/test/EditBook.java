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
import org.w3c.dom.NodeList;

@WebServlet(name = "EditBook", urlPatterns = {"/EditBook"})
public class EditBook extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/book.xml");
        XMLActions xml = new XMLActions();
        NodeList book = xml.get(path, request.getParameter("code"));
        request.setAttribute("code", request.getParameter("code"));
        request.setAttribute("title", book.item(1).getTextContent());
        request.setAttribute("price", book.item(3).getTextContent());
        request.setAttribute("author", book.item(5).getTextContent());
        request.setAttribute("edition", book.item(7).getTextContent());

        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/book.xml");
        XMLActions xml = new XMLActions();
        String update[] = {request.getParameter("title"), request.getParameter("price"),
            request.getParameter("author"), request.getParameter("edition")};
        if (xml.modify(path, request.getParameter("code"), update)) {
            request.setAttribute("booklist", xml.read(path));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
