/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.DBConnection;
import test.User;

/**
 *
 * @author QQ
 */
@WebServlet(name = "DisplayDataServlet", urlPatterns = {"/DisplayDataServlet"})
public class DisplayDataServlet extends HttpServlet {

    private DBConnection db = new DBConnection();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> listAll = null;
        PrintWriter out = response.getWriter();

        if (db.checkConnection() == false) {
            db.setConnection();
        }
        if (db.checkConnection()) {
            listAll = db.getList();
        }
        db.closeConnection();

        // Lỗi: lần 1 chạy hiện data, lần 2 chạy mất data
        // Dự doán là do dòng conn.Close() vì close nó giải phóng tài nguyên thằng conn và sqljdbc
        // nhưng connection vẫn còn trong pool và khác null nên load lần 2 (refresh) sẽ trả về true
        // Nên khi chạy lần 2 tạo lại thằng conn thì phải add lại jdbc (setConnection)
        // Mà servlet thì chỉ gọi tài nguyên (sqljdbc) 1 lần nên phải gọi setConnection trong getList mới được.
        // Nếu set conn = null (closeConnection) thì ko bị lỗi như trên.
        request.setAttribute("listUsers", listAll);
        RequestDispatcher rd = request.getRequestDispatcher("/listUser.jsp");
        rd.include(request, response);

        out.print("<br>");
        out.print("Database connection state: ");
        if (db.checkConnection() == true) {
            out.print("ON");
        } else {
            out.print("OFF");
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
