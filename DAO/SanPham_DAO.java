package DAO;

import java.sql.*;

public class SanPham_DAO {

    private Connection con;

    public SanPham_DAO(Connection con) {
        this.con = con;
    }


    public boolean kiemTraTonKho(String maSP, int soLuongCanBan) {
        try {
            String sql = "SELECT soLuongTon FROM SanPham WHERE maSP = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int ton = rs.getInt("soLuongTon");
                return ton >= soLuongCanBan; 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean giamSoLuong(String maSP, int soLuongBan) {
        try {

            if (!kiemTraTonKho(maSP, soLuongBan)) {
                System.out.println("Không đủ tồn kho!");
                return false;
            }

            String sql = "UPDATE SanPham SET soLuongTon = soLuongTon - ? WHERE maSP = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, soLuongBan);
            ps.setString(2, maSP);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}