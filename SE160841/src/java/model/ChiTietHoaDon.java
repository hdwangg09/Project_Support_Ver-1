/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ROG STRIX
 */
public class ChiTietHoaDon {
    private String mahd;
    private String masp;
    private int soluong;
    private float donggia;
    private float khuyenmai;
    private float giatri;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String mahd, String masp, int soluong, float donggia, float khuyenmai, float giatri) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.donggia = donggia;
        this.khuyenmai = khuyenmai;
        this.giatri = giatri;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDonggia() {
        return donggia;
    }

    public void setDonggia(float donggia) {
        this.donggia = donggia;
    }

    public float getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(float khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public float getGiatri() {
        return giatri;
    }

    public void setGiatri(float giatri) {
        this.giatri = giatri;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "mahd=" + mahd + ", masp=" + masp + ", soluong=" + soluong + ", donggia=" + donggia + ", khuyenmai=" + khuyenmai + ", giatri=" + giatri + '}';
    }
    
    
}
