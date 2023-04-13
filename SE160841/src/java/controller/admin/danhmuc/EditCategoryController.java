/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.danhmuc;

import dao.DanhMucDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DanhMuc;

/**
 *
 * @author dell
 */
public class EditCategoryController extends HttpServlet {

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        String rawID = request.getParameter("categoryID");
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        DanhMuc category = danhMucDAO.details(rawID);
        
        request.setAttribute("category", category);
        request.getRequestDispatcher("/view/admin/category/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        String categoryID = request.getParameter("categoryID");
        String categoryName = request.getParameter("categoryName");
        boolean status = request.getParameter("categoryStatus").equals("active") ? true : false;
        
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setMadm(categoryID);
        danhMuc.setTendm(categoryName);
        danhMuc.setTrangthai(status);
        
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        danhMucDAO.update(danhMuc);
        
        response.sendRedirect("../admin/category");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
