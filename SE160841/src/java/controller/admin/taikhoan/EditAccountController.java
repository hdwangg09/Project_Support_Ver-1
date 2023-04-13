/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.taikhoan;

import dao.NhomTaiKhoanDAO;
import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.NhomTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author dell
 */
public class EditAccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rawID = request.getParameter("accountID");
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        TaiKhoan account = taiKhoanDAO.details(rawID);
//        System.out.println("account" + account.toString());

        NhomTaiKhoanDAO nhomTaiKhoanDAO = new NhomTaiKhoanDAO();
        List<NhomTaiKhoan> listRole = nhomTaiKhoanDAO.read();
        
        request.setAttribute("account", account);
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("/view/admin/account/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("accountName");
        String email = request.getParameter("accountEmail");
        String password = request.getParameter("accountPassword");
        boolean status = request.getParameter("accountStatus").equals("active") ? true : false;
        String role = request.getParameter("accountRole");

        
        TaiKhoan account = new TaiKhoan();
        account.setTentk(name);
        account.setEmail(email);
        account.setMatkhau(password);
        account.setTrangthai(status);
        
        NhomTaiKhoan nhomTaiKhoan = new NhomTaiKhoan();
        nhomTaiKhoan.setNhomtk(role);
        
        account.setNhomtk(nhomTaiKhoan);
        
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        taiKhoanDAO.update(account);
        response.sendRedirect("../admin/account");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
