package UI;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    }
}
