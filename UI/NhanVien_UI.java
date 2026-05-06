package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Class.NhanVien;
import DAO.NhanVien_DAO;

public class NhanVien_UI extends JFrame{
	private JLabel lblTitle;
	private JPanel pNorth;
	private JLabel lblMa;
	private JLabel lblTen;
	private JTextField txtMa;
	private JTextField txtTen;
	private JLabel lblChucVu;
	private JTextField txtChucVu;
	private JLabel lblLuong;
	private JTextField txtLuong;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private JButton btnKiemTraTonKho;
	private JButton btnXoa;
	private JPanel pCen;
	private JPanel pEast;
	private JPanel pSouth;
	private NhanVien_DAO dao = new NhanVien_DAO();
	private JButton btnQuaylai;
	
	public NhanVien_UI() {
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
		
		lblTitle = new JLabel("Danh Sách Nhân Viên");
		lblTitle.setForeground(mauChu);
		Font fo = new Font("Arial", Font.BOLD, 30);
		lblTitle.setFont(fo);
		pNorth = new JPanel();
		pNorth.add(lblTitle);
		pNorth.setBackground(mauNenQuan);
		add(pNorth, BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1, b2, b3, b4, b5, b6;
		lblMa = new JLabel("Mã Nhân Viên: ");
		txtMa = new JTextField(20);
		lblTen = new JLabel("Tên: ");
		txtTen = new JTextField(20);
		lblChucVu = new JLabel("Chức vụ: ");
		txtChucVu = new JTextField(20);
		lblLuong = new JLabel("Lương: ");
		txtLuong = new JTextField(20);
		lblSDT = new JLabel("Số Điện Thoại: ");
		txtSDT = new JTextField(20);
		
		String[] headers = "Mã Nhân Viên;Tên;Chức Vụ;Lương;Số Điện Thoại".split(";");
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
//		btnKiemTraTonKho = new JButton("Kiểm Tra Tồn Kho");
		
		lblMa.setPreferredSize(lblSDT.getPreferredSize());
		lblTen.setPreferredSize(lblSDT.getPreferredSize());
		lblChucVu.setPreferredSize(lblSDT.getPreferredSize());
		lblLuong.setPreferredSize(lblSDT.getPreferredSize());
		
		lblMa.setForeground(mauChu);
		txtMa.setBackground(mauBanTrong);
		lblTen.setForeground(mauChu);
		txtTen.setBackground(mauBanTrong);
		lblChucVu.setForeground(mauChu);
		txtChucVu.setBackground(mauBanTrong);
		lblLuong.setForeground(mauChu);
		txtLuong.setBackground(mauBanTrong);
		lblSDT.setForeground(mauChu);
		txtSDT.setBackground(mauBanTrong);
		btnThem.setBackground(mauBanTrong);
		btnXoaTrang.setBackground(mauBanTrong);
		btnXoa.setBackground(mauBanTrong);
		btnLuu.setBackground(mauBanTrong);
//		btnKiemTraTonKho.setBackground(mauBanTrong);
		
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
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		
		b1.add(lblMa);
		b1.add(txtMa);
		b2.add(lblTen);
		b2.add(txtTen);
		b3.add(lblChucVu);
		b3.add(txtChucVu);
		b4.add(lblLuong);
		b4.add(txtLuong);
		b5.add(lblSDT);
		b5.add(txtSDT);
		b6.add(btnThem);
		b6.add(btnXoa);
		b6.add(btnXoaTrang);
		b6.add(btnLuu);

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
		
		// thêm nhân viên
		btnThem.addActionListener(e -> {
		    try {
		        NhanVien nv = new NhanVien(
		            txtMa.getText(),
		            txtTen.getText(),
		            txtChucVu.getText(),
		            Float.parseFloat(txtLuong.getText()),
		            txtSDT.getText()
		        );

		        if (dao.themNhanVien(nv)) {
		            JOptionPane.showMessageDialog(this, "Thêm thành công!");
		            loadData();
		        } else {
		            JOptionPane.showMessageDialog(this, "Thêm thất bại!");
		        }
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, "Lỗi dữ liệu!");
		    }
		});
		
		//xóa nhân viên
		btnXoa.addActionListener(e -> {
		    int row = table.getSelectedRow();

		    if (row == -1) {
		        JOptionPane.showMessageDialog(this, "Chọn nhân viên cần xóa!");
		        return;
		    }

		    String maNV = model.getValueAt(row, 0).toString();

		    int confirm = JOptionPane.showConfirmDialog(
		            this,
		            "Bạn có chắc muốn xóa nhân viên này?",
		            "Xác nhận",
		            JOptionPane.YES_NO_OPTION
		    );

		    if (confirm == JOptionPane.YES_OPTION) {
		        if (dao.xoaNhanVien(maNV)) {
		            JOptionPane.showMessageDialog(this, "Xóa thành công!");
		            loadData();
		        } else {
		            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
		        }
		    }
		});
		
		btnQuaylai = new JButton("Quay lại");
		btnQuaylai.setBackground(mauBanTrong);
		pSouth.add(btnQuaylai);
		
		btnQuaylai.addActionListener(e -> {
		    new TrangChu_UI().setVisible(true);
		    dispose(); // đóng màn hình hiện tại
		});
		
		add(pSouth, BorderLayout.SOUTH);
		setVisible(true);
	}
	// loadData
	public void loadData() {
	    model.setRowCount(0); // xóa dữ liệu cũ

	    for (NhanVien nv : dao.getAllNhanVien()) {
	        model.addRow(new Object[]{
	                nv.getMaNV(),
	                nv.getTenNV(),
	                nv.getChucVu(),
	                nv.getLuong(),
	                nv.getSdt()
	        });
	    }
	}
	
	public static void main(String[] args) {
		new NhanVien_UI();
	}
}
