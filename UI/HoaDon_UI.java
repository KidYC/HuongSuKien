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

public class HoaDon_UI extends JFrame{
	private JLabel lblTitle;
	private JPanel pNorth;
	private JLabel lblMa;
	private JTextField txtMa;
	private JLabel lblNgayLap;
	private JTextField txtNgayLap;
	private JLabel lblPhuongThuc;
	private JTextField txtPhuongThuc;
	private JLabel lblTongTien;
	private JTextField txtTongTien;
	private DefaultTableModel model;
	private Component table;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnKiemTraTonKho;
	private JPanel pCen;
	private JPanel pEast;
	private JPanel pSouth;



	public HoaDon_UI() {
		setTitle("Danh Sách Hoá Đơn");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		buildUI();
		
	}
	


	public void buildUI() {
		
		Color mauNenQuan = Color.decode("#F5F5DC"); // Màu kem nhạt cho nền
		Color mauBanTrong = Color.decode("#DEB887"); // Màu gỗ sáng
		Color mauBanDay = Color.decode("#CD853F");
		Color mauBanBaoTri = Color.decode("#BCAE9E");
		Color mauChu = Color.decode("#3E2723");     // Màu nâu đậm cho chữ
		
		lblTitle = new JLabel("Danh Sách Hoá Đơn");
		lblTitle.setForeground(mauChu);
		Font fo = new Font("Arial", Font.BOLD, 30);
		lblTitle.setFont(fo);
		pNorth = new JPanel();
		pNorth.add(lblTitle);
		pNorth.setBackground(mauNenQuan);
		add(pNorth, BorderLayout.NORTH);		
		
		
		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4, b5;
		lblMa = new JLabel("Mã Hoá Đơn: ");
		txtMa = new JTextField(20);
		lblNgayLap = new JLabel("Ngày Lập Hoá Đơn: ");
		txtNgayLap = new JTextField(20);
		lblPhuongThuc = new JLabel("Phương Thức: ");
		txtPhuongThuc = new JTextField(20);
		lblTongTien = new JLabel("Đơn Giá: ");
		txtTongTien = new JTextField(20);
		String[] headers = "Mã Hoá Đơn;Ngày Lập Hoá Đơn;Phương Thức;Tổng Tiền".split(";");
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
		
		lblMa.setPreferredSize(lblNgayLap.getPreferredSize());
		lblPhuongThuc.setPreferredSize(lblNgayLap.getPreferredSize());
		lblTongTien.setPreferredSize(lblNgayLap.getPreferredSize());
		
		lblMa.setForeground(mauChu);
		txtMa.setBackground(mauBanTrong);
		lblNgayLap.setForeground(mauChu);
		txtNgayLap.setBackground(mauBanTrong);
		lblPhuongThuc.setForeground(mauChu);
		txtPhuongThuc.setBackground(mauBanTrong);
		lblTongTien.setForeground(mauChu);
		txtTongTien.setBackground(mauBanTrong);
		btnThem.setBackground(mauBanTrong);
		btnXoaTrang.setBackground(mauBanTrong);
		btnXoa.setBackground(mauBanTrong);
		btnLuu.setBackground(mauBanTrong);
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		
		b1.add(lblMa);
		b1.add(txtMa);
		b2.add(lblNgayLap);
		b2.add(txtNgayLap);
		b3.add(lblPhuongThuc);
		b3.add(txtPhuongThuc);
		b4.add(lblTongTien);
		b4.add(txtTongTien);
		b5.add(btnThem);
		b5.add(btnXoa);
		b5.add(btnXoaTrang);
		b5.add(btnLuu);

		pCen = new JPanel();
		pCen.setBackground(mauNenQuan);
		pCen.add(scroll);
		add(pCen, BorderLayout.CENTER);
		pEast = new JPanel();
		pEast.setBackground(mauNenQuan);
		pEast.add(b);
		add(pEast, BorderLayout.EAST);
		pSouth = new JPanel();
		pSouth.setBackground(mauNenQuan);
		
		
		add(pSouth, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
        new HoaDon_UI().setVisible(true);
    // ===== EVENT =====
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThem) themHoaDon();
        if (e.getSource() == btnXoa) xoaHoaDon();
        if (e.getSource() == btnXoaTrang) xoaTrang();
    }
}