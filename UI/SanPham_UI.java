package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAO.SanPham_DAO;

public class SanPham_UI extends JFrame implements ActionListener{
	private JLabel lblTitle;
	private JPanel pNorth;
	private JPanel pCen;
	private DefaultTableModel model;
	private JTable table;
	private JPanel pSouth;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnKiemTraTonKho;
	private JLabel lblMa;
	private JTextField txtMa;
	private JLabel lblTen;
	private JLabel lblSoLuong;
	private JTextField txtTen;
	private JTextField txtSoLuong;
	private JLabel lblDonGia;
	private JTextField txtDonGia;
	private JPanel pEast;

	public SanPham_UI() {
		setTitle("Danh Sách Sản Phẩm");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		buildUI();
		loadData();
	}
	
	public void buildUI() {
		
		Color mauNenQuan = Color.decode("#F5F5DC"); // Màu kem nhạt cho nền
		Color mauBanTrong = Color.decode("#DEB887"); // Màu gỗ sáng
		Color mauBanDay = Color.decode("#CD853F");
		Color mauBanBaoTri = Color.decode("#BCAE9E");
		Color mauChu = Color.decode("#3E2723");     // Màu nâu đậm cho chữ
		
		lblTitle = new JLabel("Danh Sách Sản Phẩm");
		lblTitle.setForeground(mauChu);
		Font fo = new Font("Arial", Font.BOLD, 30);
		lblTitle.setFont(fo);
		pNorth = new JPanel();
		pNorth.add(lblTitle);
		pNorth.setBackground(mauNenQuan);
		add(pNorth, BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4, b5;
		lblMa = new JLabel("Mã Sản Phẩm: ");
		txtMa = new JTextField(20);
		lblTen = new JLabel("Tên Sản Phẩm: ");
		txtTen = new JTextField(20);
		lblSoLuong = new JLabel("Số Lượng: ");
		txtSoLuong = new JTextField(20);
		lblDonGia = new JLabel("Đơn Giá: ");
		txtDonGia = new JTextField(20);
		String[] headers = "Mã Sản Phẩm;Tên Sản Phẩm;Số Lượng;Đơn giá".split(";");
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
		btnKiemTraTonKho = new JButton("Kiểm Tra Tồn Kho");
		
		lblMa.setPreferredSize(lblTen.getPreferredSize());
		lblSoLuong.setPreferredSize(lblDonGia.getPreferredSize());
		lblDonGia.setPreferredSize(lblDonGia.getPreferredSize());
		
		lblMa.setForeground(mauChu);
		txtMa.setBackground(mauBanTrong);
		lblTen.setForeground(mauChu);
		txtTen.setBackground(mauBanTrong);
		lblSoLuong.setForeground(mauChu);
		txtSoLuong.setBackground(mauBanTrong);
		lblDonGia.setForeground(mauChu);
		txtDonGia.setBackground(mauBanTrong);
		btnThem.setBackground(mauBanTrong);
		btnXoaTrang.setBackground(mauBanTrong);
		btnXoa.setBackground(mauBanTrong);
		btnLuu.setBackground(mauBanTrong);
		btnKiemTraTonKho.setBackground(mauBanTrong);
		
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
		b2.add(lblTen);
		b2.add(txtTen);
		b3.add(lblSoLuong);
		b3.add(txtSoLuong);
		b4.add(lblDonGia);
		b4.add(txtDonGia);
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
		
		
		pSouth.add(btnKiemTraTonKho);
		
		add(pSouth, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void loadData() {
	    SanPham_DAO dao = new SanPham_DAO();
	    dao.loadDataToTable(model); 
	}
	
	public static void main(String[] args) {
		new SanPham_UI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		
	}
	
}
