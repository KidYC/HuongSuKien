package DAO;

import java.sql.*;
import java.util.ArrayList;

import Class.NhanVien;
import Database.ConnectDB;

public class NhanVien_DAO {

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> ds = new ArrayList<>();

        String sql = "SELECT * FROM NhanVien";

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("chucVu"),
                        rs.getFloat("luong"),
                        rs.getString("sdt")
                );
                ds.add(nv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }


    public boolean themNhanVien(NhanVien nv) {

        String sql = "INSERT INTO NhanVien (maNV, tenNV, sdt, chucVu, luong) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getSdt());     
            ps.setString(4, nv.getChucVu());
            ps.setFloat(5, nv.getLuong());

            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ Trùng mã nhân viên!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean xoaNhanVien(String maNV) {

        String sql = "DELETE FROM NhanVien WHERE maNV=?";

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, maNV);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean capNhatNhanVien(NhanVien nv) {

        String sql = "UPDATE NhanVien SET tenNV=?, sdt=?, chucVu=?, luong=? WHERE maNV=?";

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getSdt());
            ps.setString(3, nv.getChucVu());
            ps.setFloat(4, nv.getLuong());
            ps.setString(5, nv.getMaNV());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public NhanVien timNhanVien(String maNV) {

        String sql = "SELECT * FROM NhanVien WHERE maNV=?";

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
ps.setString(1, maNV);

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