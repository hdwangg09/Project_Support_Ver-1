/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhomTaiKhoan;
import util.DBUtils;

/**
 *
 * @author PulpiiWangg
 */
public class NhomTaiKhoanDAO implements ICrud<String, NhomTaiKhoan> {

    List<NhomTaiKhoan> listItems;

    public NhomTaiKhoanDAO() {
        listItems = new ArrayList<>();
    }

    public NhomTaiKhoanDAO(List<NhomTaiKhoan> listItems) {
        this.listItems = listItems;
    }

    public List<NhomTaiKhoan> getListItems() {
        return listItems;
    }

    public void setListItems(List<NhomTaiKhoan> listItems) {
        this.listItems = listItems;
    }

    @Override
    public List<NhomTaiKhoan> read() {
        List<NhomTaiKhoan> listItem = new ArrayList();
        try {
            String sql = " SELECT * FROM tblNhomTaiKhoan";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nhomtk = rs.getString("nhomtk");
                String mota = rs.getString("mota");
                Boolean trangthai = rs.getBoolean("trangthai");
                listItem.add(new NhomTaiKhoan(nhomtk, mota, trangthai));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public NhomTaiKhoan details(String id) {
        try {
            String sql = "SELECT * FROM tblNhomTaiKhoan "
                    + "WHERE nhomtk = ? ";

            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nhomtk = rs.getString("nhomtk");
                String mota = rs.getString("mota");
                Boolean trangthai = rs.getBoolean("trangthai");
                return new NhomTaiKhoan(nhomtk, mota, trangthai);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(NhomTaiKhoan inputNhomTaiKhoan) {
        try {
            String sql = "INSERT INTO [dbo].[tblNhomTaiKhoan]\n"
                    + "           ([nhomtk]\n"
                    + "           ,[mota]\n"
                    + "           ,[trangthai])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, inputNhomTaiKhoan.getNhomtk());
            stmt.setString(2, inputNhomTaiKhoan.getMota());
            stmt.setBoolean(3, inputNhomTaiKhoan.isTrangthai());
            ResultSet rs = stmt.executeQuery();
            rs.next();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhomTaiKhoan inputNhomTaiKhoan) {
        try {
            String sql = "UPDATE [dbo].[tblNhomTaiKhoan]\n"
                    + "   SET [nhomtk] = ?\n"
                    + "      ,[mota] = ?\n"
                    + "      ,[trangthai] = ?\n"
                    + " WHERE nhomtk = ?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, inputNhomTaiKhoan.getMota());
            stmt.setBoolean(2, inputNhomTaiKhoan.isTrangthai());
            stmt.setString(3, inputNhomTaiKhoan.getNhomtk());
            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM [dbo].[tblNhomTaiKhoan]\n"
                    + "      WHERE nhomtk = ?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
