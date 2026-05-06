package DAO;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;

public class Ban_DAO {

    private Connection con;

    public Ban_DAO(Connection con) {

        this.con = con;

    }

    public boolean isBanTrong(String maBan) {

        try {

            String sql = "SELECT trangThai FROM Ban WHERE maBan = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maBan);



            ResultSet rs = ps.executeQuery();



            if (rs.next()) {

                return rs.getBoolean("trangThai") == false;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    public boolean moBan(String maBan) {

        try {

            String sql = "UPDATE Ban SET trangThai = 1 WHERE maBan = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maBan);



            return ps.executeUpdate() > 0;



        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    public boolean traBan(String maBan) {

        try {

            String sql = "UPDATE Ban SET trangThai = 0 WHERE maBan = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maBan);



            return ps.executeUpdate() > 0;



        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

}