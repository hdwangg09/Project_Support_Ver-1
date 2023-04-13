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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.DanhMuc;
import model.NhaCungCap;
import model.SanPham;

/**
 *
 * @author dell
 */
public class EditProductController extends HttpServlet {

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

        request.getRequestDispatcher("/view/admin/product/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productDescriptions = request.getParameter("productDescriptions");
        boolean productStatus = request.getParameter("productStatus").equals("active") ? true : false;
        String productCategory = request.getParameter("productCategory");
        String productSupplier = request.getParameter("productSupplier");

        SanPham sanPham = new SanPham();
        sanPham.setMasp(productID);
        sanPham.setTensp(productName);
        sanPham.setMota(productDescriptions);
        sanPham.setSoluong(productQuantity);
        sanPham.setDongia(productPrice);
        sanPham.setTrangthai(productStatus);
        
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setMancc(productSupplier);
        
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setMadm(productCategory);
        
        sanPham.setNhacungcap(nhaCungCap);
        sanPham.setDanhmuc(danhMuc);
        
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.update(sanPham);

        response.sendRedirect("../admin/product");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
