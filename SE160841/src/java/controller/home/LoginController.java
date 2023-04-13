/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.home;

import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TaiKhoan;

/**
 *
 * @author PulpiiWangg
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/home/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");
//        System.out.println("userID" + userID);
//        System.out.println("password" + password);
        TaiKhoanDAO dao = new TaiKhoanDAO();
        TaiKhoan user = dao.checkLogin(userID, password);
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("LOGIN_USER", user);
            String roleID = user.getNhomtk().getNhomtk();
            System.out.println("roleID" + roleID);
            if ("admin".equals(roleID)) {
//                response.sendRedirect(ADMIN_PAGE);
            } else if ("khach".equals(roleID)) {
                response.sendRedirect("index");
            }
        }
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
