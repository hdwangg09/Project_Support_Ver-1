/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;
import model.NhaCungCap;
import model.NhomTaiKhoan;
import model.SanPham;
import util.DBUtils;

/**
 *
 * @author dell
 */
public class SanPhamDAO implements ICrud<String, SanPham> {

    List<SanPham> listItems;
    NhaCungCapDAO nccDao = new NhaCungCapDAO();
    DanhMucDAO dmDao = new DanhMucDAO();

    public SanPhamDAO() {
        listItems = new ArrayList<>();
    }

    public SanPhamDAO(List<SanPham> listItems) {
        this.listItems = listItems;
    }

    public List<SanPham> getListItems() {
        return listItems;
    }

    public void setListItems(List<SanPham> listItems) {
        this.listItems = listItems;
    }

    @Override
    public List<SanPham> read() {
        List<SanPham> listItem = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TBLSANPHAM P\n"
                    + "INNER JOIN TBLDANHMUC DM ON P.MADM = DM.MADM\n"
                    + "INNER JOIN TBLNHACUNGCAP NCC ON P.MANCC = NCC.MANCC ";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String mota = rs.getString("mota");
                int soluong = rs.getInt("soluong");
                double dongia = rs.getDouble("dongia");
                String hinhanh = rs.getString("hinhanh");
                boolean trangthai = rs.getBoolean("trangthai");

                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMadm(rs.getString("madm"));
                danhMuc.setTendm(rs.getString("tendm"));

                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMancc(rs.getString("mancc"));
                nhaCungCap.setTenncc(rs.getString("tenncc"));

                listItem.add(new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, nhaCungCap, danhMuc));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public SanPham details(String id) {
        try {
            String sql = "SELECT * FROM TBLSANPHAM P\n"
                    + "                    INNER JOIN TBLDANHMUC DM ON P.MADM = DM.MADM\n"
                    + "                    INNER JOIN TBLNHACUNGCAP NCC ON P.MANCC = NCC.MANCC \n"
                    + "					Where p.masp = ?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String mota = rs.getString("mota");
                int soluong = rs.getInt("soluong");
                double dongia = rs.getFloat("dongia");
                String hinhanh = rs.getString("hinhanh");
                boolean trangthai = rs.getBoolean("trangthai");

                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMadm(rs.getString("madm"));

                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMancc(rs.getString("mancc"));

                return new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, nhaCungCap, danhMuc);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(SanPham newItem) {
        try {
            String sql = "Insert into tblSanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc) values (?,?,?,?,?,?,?,?,?)";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, newItem.getMasp());
            stmt.setString(2, newItem.getTensp());
            stmt.setString(3, newItem.getMota());
            stmt.setInt(4, newItem.getSoluong());
            stmt.setDouble(5, newItem.getDongia());
            stmt.setString(6, newItem.getHinhanh());
            stmt.setBoolean(7, newItem.isTrangthai());
            stmt.setString(8, newItem.getDanhmuc().getMadm());
            stmt.setString(9, newItem.getNhacungcap().getMancc());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham edittedItem) {
        try {
            String sql = "Update tblSanPham Set tensp = ?, mota = ?, soluong = ?, dongia = ?, trangthai = ?, madm = ?, mancc = ? where masp = ?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, edittedItem.getTensp());
            stmt.setString(2, edittedItem.getMota());
            stmt.setInt(3, edittedItem.getSoluong());
            stmt.setDouble(4, edittedItem.getDongia());
//            stmt.setString(5, edittedItem.getHinhanh());
            stmt.setBoolean(5, edittedItem.isTrangthai());
            stmt.setString(6, edittedItem.getDanhmuc().getMadm());
            stmt.setString(7, edittedItem.getNhacungcap().getMancc());
            stmt.setString(8, edittedItem.getMasp());
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblSanPham where masp=?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<SanPham> search(String search) throws ClassNotFoundException {
        List<SanPham> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblSanPham where tensp like '%" + search + "%'";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
//            stmt.setString(1, search);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String mota = rs.getString("mota");
                int soluong = rs.getInt("soluong");
                Double dongia = rs.getDouble("dongia");
                String hinhanh = rs.getString("hinhanh");
                boolean trangthai = rs.getBoolean("trangthai");
                DanhMuc madm = dmDao.details(rs.getString("madm"));
                NhaCungCap mancc = nccDao.details(rs.getString("mancc"));
                listItem.add(new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, mancc, madm));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }
}
