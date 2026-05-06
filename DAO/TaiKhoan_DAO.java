package DAO;

import java.sql.*;
import java.util.ArrayList;

import Database.ConnectDB;
import Class.TaiKhoan;

public class TaiKhoan_DAO {

    public ArrayList<TaiKhoan> getallTaiKhoan() {

        ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();

        try {
        	Connection con = Database.ConnectDB.getConnection();

            String sql = "SELECT * FROM TaiKhoan";
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String tenDangNhap = rs.getString(1);
                String matKhau = rs.getString(2);

                TaiKhoan tk = new TaiKhoan(tenDangNhap, matKhau);
                dstk.add(tk);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dstk;
    }
    public boolean kiemTraDangNhap(String user, String pass) {

        try {
        	Connection con = Database.ConnectDB.getConnection();

            String sql = "SELECT * FROM TaiKhoan WHERE tenDangNhap=? AND matKhau=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            return rs.next(); 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}