/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ROG STRIX
 */
public class TaiKhoan {
    private String tentk;
    private String matkhau;
    private boolean trangthai;
    private String email;
    private NhomTaiKhoan nhomtk;

    public TaiKhoan() {
    }

    public TaiKhoan(String tentk, String matkhau, boolean trangthai, String email, NhomTaiKhoan nhomtk) {
        this.tentk = tentk;
        this.matkhau = matkhau;
        this.trangthai = trangthai;
        this.email = email;
        this.nhomtk = nhomtk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NhomTaiKhoan getNhomtk() {
        return nhomtk;
    }

    public void setNhomtk(NhomTaiKhoan nhomtk) {
        this.nhomtk = nhomtk;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tentk=" + tentk + ", matkhau=" + matkhau + ", trangthai=" + trangthai + ", email=" + email + ", nhomtk=" + nhomtk + '}';
    }

    
    
}
