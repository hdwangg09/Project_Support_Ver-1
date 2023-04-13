/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.nhacungcap;

import dao.NhaCungCapDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NhaCungCap;

/**
 *
 * @author dell
 */
public class EditSupplierController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rawID = request.getParameter("supplierID");
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
        NhaCungCap supplier = nhaCungCapDAO.details(rawID);

        request.setAttribute("supplier", supplier);
        request.getRequestDispatcher("/view/admin/supplier/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String supplierID = request.getParameter("supplierID");
        String supplierName = request.getParameter("supplierName");
        String supplierAdress = request.getParameter("supplierAdress");
        boolean supplierStatus = request.getParameter("supplierStatus").equals("active") ? true : false;
        
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setMancc(supplierID);
        nhaCungCap.setTenncc(supplierName);
        nhaCungCap.setDiachi(supplierAdress);
        nhaCungCap.setTrangthai(supplierStatus);
        
        NhaCungCapDAO nhaCungCapDAO =  new NhaCungCapDAO();
        nhaCungCapDAO.update(nhaCungCap);
        
        response.sendRedirect("../admin/supplier");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
