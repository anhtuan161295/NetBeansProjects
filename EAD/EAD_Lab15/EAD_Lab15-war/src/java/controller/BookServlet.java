/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.BookSB;
import entities.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QQ
 */
@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

    @EJB
    private BookSB bookSB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String action = request.getParameter("action");
        String code = request.getParameter("code");

        if (action.equals("edit")) {
            BookBean book = bookSB.edit(code);
            request.setAttribute("book", book);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            bookSB.delete(code);
            request.setAttribute("list", bookSB.getAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } else if (action.equals("list")) {
            request.setAttribute("list", bookSB.getAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String action = request.getParameter("action");
//        String code = request.getParameter("code");
//        String title = request.getParameter("title");
//        int price = Integer.parseInt(request.getParameter("price"));
//        String author = request.getParameter("author");
//        BookBean book = new BookBean(code, title, price, author);

        if (action.equals("add")) {
            String code = request.getParameter("code");
            String title = request.getParameter("title");
            int price = Integer.parseInt(request.getParameter("price"));
            String author = request.getParameter("author");
            BookBean book = new BookBean(code, title, price, author);
            bookSB.add(book);
            response.sendRedirect("BookServlet?action=list");
        } else if (action.equals("update")) {
            String code = request.getParameter("code");
            String title = request.getParameter("title");
            int price = Integer.parseInt(request.getParameter("price"));
            String author = request.getParameter("author");
            BookBean book = new BookBean(code, title, price, author);
            bookSB.update(book);
            response.sendRedirect("BookServlet?action=list");
        } else if (action.equals("search")) {
            String searchTitle = request.getParameter("searchTitle");
            request.setAttribute("list", bookSB.search(searchTitle));
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
