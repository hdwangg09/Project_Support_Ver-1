/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ROG STRIX
 */
public class NhomTaiKhoan {
    private String nhomtk;
    private String mota;
    private boolean trangthai;

    public NhomTaiKhoan() {
    }

    public NhomTaiKhoan(String nhomtk, String mota, boolean trangthai) {
        this.nhomtk = nhomtk;
        this.mota = mota;
        this.trangthai = trangthai;
    }

    public String getNhomtk() {
        return nhomtk;
    }

    public void setNhomtk(String nhomtk) {
        this.nhomtk = nhomtk;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "NhomTaiKhoan{" + "nhomtk=" + nhomtk + ", mota=" + mota + ", trangthai=" + trangthai + '}';
    }
    
    
}
