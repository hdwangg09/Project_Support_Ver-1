/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.sanpham;

import dao.DanhMucDAO;
import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DanhMuc;
import model.NhaCungCap;
import model.SanPham;

/**
 *
 * @author dell
 */
public class DetailsProductController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String rawID = request.getParameter("productID");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        SanPham product = sanPhamDAO.details(rawID);

        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
        List<NhaCungCap> listSupplier = nhaCungCapDAO.read();

        DanhMucDAO danhMucDAO = new DanhMucDAO();
        List<DanhMuc> listCategory = danhMucDAO.read();

        request.setAttribute("product", product);
        request.setAttribute("listSupplier", listSupplier);
        request.setAttribute("listCategory", listCategory);

        request.getRequestDispatcher("/view/admin/product/details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
