package DAO;

import java.sql.*;

public class ChiTietHoaDon_DAO {

    private Connection con;

    public ChiTietHoaDon_DAO(Connection con) {
        this.con = con;
    }
    public boolean themChiTiet(String maCTHD, String maHD, String maSP, int soLuong, double donGia) {
        try {

            double thanhTien = soLuong * donGia;

            String sql = "INSERT INTO ChiTietHoaDon VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maCTHD);
            ps.setString(2, maHD);
            ps.setString(3, maSP);
            ps.setInt(4, soLuong);
            ps.setDouble(5, donGia);
            ps.setDouble(6, thanhTien);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public double tinhTongTien(String maHD) {
        try {
            String sql = "SELECT SUM(thanhTien) AS tong FROM ChiTietHoaDon WHERE maHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("tong");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean xoaChiTiet(String maCTHD) {
        try {
            String sql = "DELETE FROM ChiTietHoaDon WHERE maCTHD = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maCTHD);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}