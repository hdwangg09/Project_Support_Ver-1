/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ROG STRIX
 */
public class HoaDon {
    private String mahd;
    private Date ngaydh;
    private int trangthaixuly;
    private String makh;

    public HoaDon() {
    }

    public HoaDon(String mahd, Date ngaydh, int trangthaixuly, String makh) {
        this.mahd = mahd;
        this.ngaydh = ngaydh;
        this.trangthaixuly = trangthaixuly;
        this.makh = makh;
    }



    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgaydh() {
        return ngaydh;
    }

    public void setNgaydh(Date ngaydh) {
        this.ngaydh = ngaydh;
    }

    public int getTrangthaixuly() {
        return trangthaixuly;
    }

    public void setTrangthaixuly(int trangthaixuly) {
        this.trangthaixuly = trangthaixuly;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "mahd=" + mahd + ", ngaydh=" + ngaydh + ", trangthaixuly=" + trangthaixuly + ", makh=" + makh + '}';
    }
    
    
}
