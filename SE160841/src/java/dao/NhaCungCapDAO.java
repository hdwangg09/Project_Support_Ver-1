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
import model.NhaCungCap;
import util.DBUtils;

/**
 *
 * @author dell
 */
public class NhaCungCapDAO implements ICrud<String, NhaCungCap>{
     List<NhaCungCap> listItems;

    public NhaCungCapDAO() {
        listItems = new ArrayList<>();
    }

    public NhaCungCapDAO(List<NhaCungCap> listItems) {
        this.listItems = listItems;
    }

    public List<NhaCungCap> getListItems() {
        return listItems;
    }

    public void setListItems(List<NhaCungCap> listItems) {
        this.listItems = listItems;
    }

    @Override
    public List<NhaCungCap> read() {
        List<NhaCungCap> listItem = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblNhaCungCap";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
                String diachi = rs.getString("diachi");
                boolean trangthai = rs.getBoolean("trangthai");
                NhaCungCap item = new NhaCungCap(mancc, tenncc, diachi, trangthai);
                listItem.add(item);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public NhaCungCap details(String id) {
        NhaCungCap p = new NhaCungCap();
        try {
            String sql = "Select * from tblNhaCungCap where mancc=?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
                String diachi = rs.getString("diachi");
                boolean trangthai = rs.getBoolean("trangthai");
                return new NhaCungCap(mancc, tenncc, diachi, trangthai);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(NhaCungCap newItem) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            String sql = " Insert into tblNhaCungCap (mancc, tenncc, diachi, trangthai) values(?,?,?,?)";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, newItem.getMancc());
            stmt.setString(2, newItem.getTenncc());
            stmt.setString(3, newItem.getDiachi());
            stmt.setBoolean(4, newItem.isTrangthai());
            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhaCungCap edittedItem) {
        try {
            Connection cn = null;
            try {
                cn = DBUtils.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "Update tblNhaCungCap set tenncc=?, diachi=?, trangthai=? where mancc=?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, edittedItem.getTenncc());
            stmt.setString(2, edittedItem.getDiachi());
            stmt.setBoolean(3, edittedItem.isTrangthai());
            stmt.setString(4, edittedItem.getMancc());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
 
            String sql = " DELETE FROM tblNhaCungCap WHERE mancc=? ";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate(); 
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
