/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.NhomTaiKhoan;
import model.TaiKhoan;
import util.DBUtils;

/**
 *
 * @author PulpiiWangg
 */
public class TaiKhoanDAO implements ICrud<String, TaiKhoan> {

    List<TaiKhoan> listItems;
    private DBUtils db;
    private NhomTaiKhoanDAO nhomtkDao = new NhomTaiKhoanDAO();

    public TaiKhoanDAO() {
        listItems = new ArrayList<>();
        this.db = new DBUtils();
    }

    public TaiKhoanDAO(List<TaiKhoan> listItems) {
        this.listItems = listItems;
        this.db = new DBUtils();
    }

    public List<TaiKhoan> getListItems() {
        return listItems;
    }

    public void setListItems(List<TaiKhoan> listItems) {
        this.listItems = listItems;
    }

    public DBUtils getDb() {
        return db;
    }

    public void setDb(DBUtils db) {
        this.db = db;
    }

    @Override
    public List<TaiKhoan> read() {
        List<TaiKhoan> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblTaiKhoan";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tentk = rs.getString("tentk");
                String matkhau = rs.getString("matkhau");
                boolean trangthai = rs.getBoolean("trangthai");
                String email = rs.getString("email");
                NhomTaiKhoan nhomtk = nhomtkDao.details(rs.getString("nhomtk"));
                listItem.add(new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public TaiKhoan details(String id) {
        try {
            String sql = "Select * from tblTaiKhoan "
                    + "where tentk = ? ";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tentk = rs.getString("tentk");
                String matkhau = rs.getString("matkhau");
                boolean trangthai = rs.getBoolean("trangthai");
                String email = rs.getString("email");
                NhomTaiKhoan nhomtk = nhomtkDao.details(rs.getString("nhomtk"));
                return new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(TaiKhoan inputTaiKhoan) {
        try {
            String sql = "INSERT INTO [dbo].[tblTaiKhoan]\n"
                    + "           ([tentk]\n"
                    + "           ,[matkhau]\n"
                    + "           ,[trangthai]\n"
                    + "           ,[email]\n"
                    + "           ,[nhomtk])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, inputTaiKhoan.getTentk());
            stmt.setString(2, inputTaiKhoan.getMatkhau());
            stmt.setBoolean(3, inputTaiKhoan.isTrangthai());
            stmt.setString(4, inputTaiKhoan.getEmail());
            stmt.setString(5, inputTaiKhoan.getNhomtk().getNhomtk());
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TaiKhoan inputEdittedTaiKhoan) {
        try {
            String sql = "Update tblTaiKhoan Set matkhau = ?, trangthai = ?, email = ?, nhomtk = ? where tentk = ?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, inputEdittedTaiKhoan.getMatkhau());
            stmt.setBoolean(2, inputEdittedTaiKhoan.isTrangthai());
            stmt.setString(3, inputEdittedTaiKhoan.getEmail());
            stmt.setString(4, inputEdittedTaiKhoan.getNhomtk().getNhomtk());
            stmt.setString(5, inputEdittedTaiKhoan.getTentk());
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM [dbo].[tblTaiKhoan]\n"
                    + "      WHERE tentk = ?";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TaiKhoan checkLogin(String userID, String password) {
        try {
            String sql = "SELECT * FROM [dbo].[tblTaiKhoan]\n"
                    + "WHERE tentk = ? and matkhau = ? ";
            Connection cn = DBUtils.getConnection();
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, userID);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tentk = rs.getString("tentk");
                String matkhau = rs.getString("matkhau");
                boolean trangthai = rs.getBoolean("trangthai");
                String email = rs.getString("email");
                NhomTaiKhoan nhomtk = nhomtkDao.details(rs.getString("nhomtk"));
                return new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
