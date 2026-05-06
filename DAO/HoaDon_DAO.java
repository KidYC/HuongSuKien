package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDon_DAO {

    private Connection con;

    public HoaDon_DAO(Connection con) {
        this.con = con;
    }

  
    public boolean themHoaDon(String maHD, String maKH, String maNV, String maBan,
                              Timestamp ngayLap, String phuongThuc, double tongTien) {
        try {
            String sql = "INSERT INTO HoaDon VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maHD);
            ps.setString(2, maKH);
            ps.setString(3, maNV);
            ps.setString(4, maBan);
            ps.setTimestamp(5, ngayLap);
            ps.setString(6, phuongThuc);
            ps.setDouble(7, tongTien);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   
    public List<String[]> getAllHoaDon() {
        List<String[]> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM HoaDon";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String[] hd = new String[7];

                hd[0] = rs.getString("maHoaDon");
                hd[1] = rs.getString("maKH");
                hd[2] = rs.getString("maNV");
                hd[3] = rs.getString("maBan");
                hd[4] = rs.getString("ngayLapHoaDon");
                hd[5] = rs.getString("phuongThucThanhToan");
                hd[6] = String.valueOf(rs.getDouble("tongTien"));

                list.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public boolean xoaHoaDon(String maHD) {
        try {
            String sql = "DELETE FROM HoaDon WHERE maHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maHD);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🟡 4. Cập nhật hóa đơn
    public boolean capNhatHoaDon(String maHD, String phuongThuc, double tongTien) {
        try {
            String sql = "UPDATE HoaDon SET phuongThucThanhToan = ?, tongTien = ? WHERE maHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, phuongThuc);
            ps.setDouble(2, tongTien);
            ps.setString(3, maHD);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}