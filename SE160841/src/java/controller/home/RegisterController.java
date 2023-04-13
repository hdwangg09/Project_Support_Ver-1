/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NhomTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author dell
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/home/register.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean status = true;
        System.out.println("email" + email);
        System.out.println("username"+ username);
        System.out.println("password"+ password);
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setEmail(email);
        taiKhoan.setMatkhau(password);
        taiKhoan.setTentk(username);
        
        NhomTaiKhoan nhomTaiKhoan = new NhomTaiKhoan();
        nhomTaiKhoan.setNhomtk("khach");
        
        taiKhoan.setNhomtk(nhomTaiKhoan);
//        
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        taiKhoanDAO.create(taiKhoan);
        response.sendRedirect("login");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
