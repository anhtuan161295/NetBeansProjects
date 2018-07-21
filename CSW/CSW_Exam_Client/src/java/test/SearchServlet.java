/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.Book;
import ws.BookWS;
import ws.BookWS_Service;

/**
 *
 * @author QQ
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookWS_Service service = new BookWS_Service();
        BookWS port = service.getBookWSPort();
        List<Book> list = port.all();
        request.setAttribute("list", list);
        request.getRequestDispatcher("Search.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookWS_Service service = new BookWS_Service();
        BookWS port = service.getBookWSPort();

        String searchTitle = request.getParameter("searchTitle");

        List<Book> list = port.searchLike(searchTitle);
        request.setAttribute("list", list);
        request.getRequestDispatcher("Search.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
