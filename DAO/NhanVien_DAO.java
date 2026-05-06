package DAO;

import java.sql.*;
import java.util.ArrayList;

import Database.ConnectDB;
import Class.NhanVien;

public class NhanVien_DAO {

    public ArrayList<NhanVien> getAllNhanVien() {

        ArrayList<NhanVien> ds = new ArrayList<>();

        try {
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM NhanVien";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                String chucVu = rs.getString("chucVu");
                float luong = rs.getFloat("luong");
                String sdt = rs.getString("sdt");

                NhanVien nv = new NhanVien(maNV, tenNV, chucVu, luong, sdt);
                ds.add(nv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public boolean themNhanVien(NhanVien nv) {

        try {
            Connection con = ConnectDB.getConnection();

            String sql = "INSERT INTO NhanVien VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getChucVu());
            ps.setFloat(4, nv.getLuong());
            ps.setString(5, nv.getSdt());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean xoaNhanVien(String maNV) {

        try {
            Connection con = ConnectDB.getConnection();

            String sql = "DELETE FROM NhanVien WHERE maNV=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maNV);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean capNhatNhanVien(NhanVien nv) {

        try {
            Connection con = ConnectDB.getConnection();

            String sql = "UPDATE NhanVien SET tenNV=?, chucVu=?, luong=?, sdt=? WHERE maNV=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getChucVu());
            ps.setFloat(3, nv.getLuong());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getMaNV());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public NhanVien timNhanVien(String ma) {

        try {
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM NhanVien WHERE maNV=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ma);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("chucVu"),
                        rs.getFloat("luong"),
                        rs.getString("sdt")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}