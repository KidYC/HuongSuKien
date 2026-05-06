package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class SanPham_DAO {
	public void loadDataToTable(DefaultTableModel model) {
        try (Connection con = Database.ConnectDB.getConnection()) {
            String sql = "SELECT * FROM SanPham";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            model.setRowCount(0);
            
            while (rs.next()) {
                String ma = rs.getString("maSP");
                String ten = rs.getString("tenSP");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("donGia");
                
                Object[] row = {ma, ten, soLuong, gia};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
