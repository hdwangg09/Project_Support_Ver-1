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
import util.DBUtils;

/**
 *
 * @author Admin
 */
public class DanhMucDAO implements ICrud<String, DanhMuc> {

    List<DanhMuc> listItems;

    public DanhMucDAO() {
        listItems = new ArrayList<>();
    }

    public DanhMucDAO(List<DanhMuc> listItems) {
        this.listItems = listItems;
    }

    public List<DanhMuc> getListItems() {
        return listItems;
    }

    public void setListItems(List<DanhMuc> listItems) {
        this.listItems = listItems;
    }

    @Override
    public List<DanhMuc> read() {
        List<DanhMuc> listItem = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblDanhMuc";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String madm = rs.getString("madm");
                String tendm = rs.getString("tendm");
                boolean trangthai = rs.getBoolean("trangthai");
                DanhMuc item = new DanhMuc(madm, tendm, trangthai);
                listItem.add(item);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public DanhMuc details(String id) {
        DanhMuc p = new DanhMuc();
        try {
            String sql = "Select * from tblDanhMuc where madm=?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String madm = rs.getString("madm");
                String tendm = rs.getString("tendm");
                boolean trangthai = rs.getBoolean("trangthai");
                return new DanhMuc(madm, tendm, trangthai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(DanhMuc newItem) {
        try {
            String sql = "Insert into tblDanhMuc(madm, tendm, trangthai)values (?,?,?)";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);

            stmt.setString(1, newItem.getMadm());
            stmt.setString(2, newItem.getTendm());
            stmt.setBoolean(3, newItem.isTrangthai());

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblDanhMuc where madm=?";
            Connection cn = null;
            try {
                cn = DBUtils.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DanhMuc edittedItem) {
        try {
            Connection cn = null;
            try {
                cn = DBUtils.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "Update tblDanhMuc set tendm=?, trangthai=? where madm=?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, edittedItem.getTendm());
            stmt.setBoolean(2, edittedItem.isTrangthai());
            stmt.setString(3, edittedItem.getMadm());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
