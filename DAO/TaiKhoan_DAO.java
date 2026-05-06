package DAO;

import java.sql.*;
import java.util.ArrayList;

import Class.TaiKhoan;
import Database.ConnectDB;

public class TaiKhoan_DAO {

    public ArrayList<TaiKhoan> getAllTaiKhoan() {

        ArrayList<TaiKhoan> ds = new ArrayList<>();

        try {
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM TaiKhoan";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String tenDN = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");

                TaiKhoan tk = new TaiKhoan(tenDN, matKhau);
                ds.add(tk);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public boolean kiemTraDangNhap(String user, String pass) {

        try {
            Connection con = ConnectDB.getConnection();

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
