package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import DAO.HoaDon_DAO;

public class HoaDon_UI extends JFrame implements ActionListener {

    private JTextField txtMa, txtNgayLap, txtPhuongThuc, txtTongTien;
    private JTextField txtMaKH, txtMaNV, txtMaBan;
    private DefaultTableModel model;
    private JTable table;
    private JButton btnThem, btnXoa, btnXoaTrang;

    public HoaDon_UI() {
        setTitle("Danh Sách Hoá Đơn");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildUI();
        loadData();
    }

    public void buildUI() {

        Color bg = Color.decode("#F5F5DC");
        Color inputColor = Color.decode("#DEB887");

        // ===== TITLE =====
        JLabel lblTitle = new JLabel("Danh Sách Hoá Đơn");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));

        JPanel pNorth = new JPanel();
        pNorth.setBackground(bg);
        pNorth.add(lblTitle);
        add(pNorth, BorderLayout.NORTH);

        // ===== INPUT PANEL =====
        Box box = Box.createVerticalBox();

        txtMa = new JTextField(15);
        txtMaKH = new JTextField(15);
        txtMaNV = new JTextField(15);
        txtMaBan = new JTextField(15);
        txtNgayLap = new JTextField(15);
        txtPhuongThuc = new JTextField(15);
        txtTongTien = new JTextField(15);

        box.add(createRow("Mã HD:", txtMa));
        box.add(createRow("Mã KH:", txtMaKH));
        box.add(createRow("Mã NV:", txtMaNV));
        box.add(createRow("Mã Bàn:", txtMaBan));
        box.add(createRow("Ngày lập:", txtNgayLap));
        box.add(createRow("Phương thức:", txtPhuongThuc));
        box.add(createRow("Tổng tiền:", txtTongTien));

        // ===== BUTTON =====
        JPanel pBtn = new JPanel();
        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        btnXoaTrang = new JButton("Xóa trắng");

        pBtn.add(btnThem);
        pBtn.add(btnXoa);
        pBtn.add(btnXoaTrang);

        box.add(pBtn);

        JPanel pEast = new JPanel();
        pEast.setBackground(bg);
        pEast.add(box);

        add(pEast, BorderLayout.EAST);

        // ===== TABLE =====
        String[] headers = {
                "Mã HD", "Mã KH", "Mã NV", "Mã Bàn",
                "Ngày lập", "Phương thức", "Tổng tiền"
        };

        model = new DefaultTableModel(headers, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        JPanel pCenter = new JPanel(new BorderLayout());
        pCenter.add(scroll);
        add(pCenter, BorderLayout.CENTER);

        // ===== EVENT =====
        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnXoaTrang.addActionListener(this);

        setVisible(true);
    }

    // Tạo dòng input gọn
    private Box createRow(String label, JTextField txt) {
        Box b = Box.createHorizontalBox();
        JLabel lbl = new JLabel(label);
        lbl.setPreferredSize(new Dimension(100, 25));
        b.add(lbl);
        b.add(txt);
        b.add(Box.createHorizontalStrut(10));
        return b;
    }

    // ===== THÊM =====
    public void themHoaDon() {
        try {
            Connection con = Database.ConnectDB.getConnection();
            HoaDon_DAO dao = new HoaDon_DAO(con);

            double tongTien = Double.parseDouble(txtTongTien.getText());

            dao.themHoaDon(
                    txtMa.getText(),
                    txtMaKH.getText(),
                    txtMaNV.getText(),
                    txtMaBan.getText(),
                    new java.sql.Timestamp(System.currentTimeMillis()),
                    txtPhuongThuc.getText(),
                    tongTien
            );

            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            loadData();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tổng tiền phải là số!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== XÓA =====
    public void xoaHoaDon() {
        try {
            Connection con = Database.ConnectDB.getConnection();
            HoaDon_DAO dao = new HoaDon_DAO(con);

            dao.xoaHoaDon(txtMa.getText());

            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            loadData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== XÓA TRẮNG =====
    public void xoaTrang() {
        txtMa.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtMaBan.setText("");
        txtNgayLap.setText("");
        txtPhuongThuc.setText("");
        txtTongTien.setText("");
    }

    // ===== LOAD DATA =====
    public void loadData() {
        try {
            model.setRowCount(0);

            Connection con = Database.ConnectDB.getConnection();
            HoaDon_DAO dao = new HoaDon_DAO(con);

            for (String[] row : dao.getAllHoaDon()) {
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        new HoaDon_UI();
    }

    // ===== EVENT =====
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThem) themHoaDon();
        if (e.getSource() == btnXoa) xoaHoaDon();
        if (e.getSource() == btnXoaTrang) xoaTrang();
    }
}