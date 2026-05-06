package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ThanhToan_UI extends JFrame implements ActionListener{
	private JLabel lblTitle;
	private JPanel pNorth;
	private JPanel pCen;
	private JPanel pCen_North;
	private JLabel lblTitle_Cen;
	private JPanel pEast;
	private JPanel pKhachHang;
	private JPanel pThanhToan;
	private JLabel lblSDT;
	private JLabel lblTen;
	private JLabel lblGTSDT;
	private JLabel lblGTTen;
	private JLabel lblDiem;
	private JLabel lblGTDiem;
	private Box b1;
	private Box b2;
	private Box bKH1;
	private Container bKH2;
	private Box bKH3;
	private Box bTT1;
	private JLabel lblTong;
	private JLabel lblTien;
	private Box bTT2;
	private JLabel lblHinhThuc;
	private JLabel lblPhuongThuc;
	private JLabel lblTienThua;
	private JLabel lblGTTienThua;
	private Box bTT3;
	private JPanel pButton;
	private JButton btnHuy;
	private JButton btnThanhToan;
	private Box bBtn;
	private DefaultTableModel model;
	private JTable table;
	private Box bTT4;
	private JLabel lblKhachDua;
	private JLabel lblTienKhachDua;
	private JTextField txtSDT;
	private JTextField txtDiem;
	private JTextField txtTen;
	private int tongtien;
	private int tienthua;
	private int soban;

	public ThanhToan_UI(DefaultTableModel modelGoiMon,int soBan) {
		this.soban=soBan;
		Color mauNenQuan = Color.decode("#F5F5DC"); // MÃ u kem nháº¡t cho ná»�n
		Color mauBanTrong = Color.decode("#DEB887"); // MÃ u gá»— sÃ¡ng
		Color mauBanDay = Color.decode("#CD853F");
		Color mauBanBaoTri = Color.decode("#BCAE9E");
		Color mauChu = Color.decode("#3E2723"); 
		setTitle("Thanh Toán");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		   

		lblTitle = new JLabel("Thanh Toán - Bàn"+soban);
		lblTitle.setForeground(mauChu);
		Font fo = new Font("Arial", Font.BOLD, 30);
		lblTitle.setFont(fo);
		pNorth = new JPanel();
		pNorth.add(lblTitle);
		pNorth.setBackground(mauNenQuan);
		add(pNorth, BorderLayout.NORTH);
		
		//Layout Danh Sach San Pham
		pCen = new JPanel();
		pCen.setBackground(mauNenQuan);
		pCen_North = new JPanel();
		pCen_North.setBackground(mauNenQuan);
		lblTitle_Cen = new JLabel("Danh Sách Món");
		lblTitle_Cen.setForeground(mauChu);
		Font fow = new Font("Arial", Font.BOLD, 20);
		lblTitle_Cen.setFont(fow);
		pCen_North.add(lblTitle_Cen);
		pCen.add(pCen_North, BorderLayout.NORTH);
		
		String[] headers = {"STT","Tên món","Giá"};
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		for(int i =0;i<modelGoiMon.getRowCount();i++) {
			Object tenMon = modelGoiMon.getValueAt(i,0);
			Object Gia = modelGoiMon.getValueAt(i,1);
			
			model.addRow(new Object [] {i+1,tenMon,Gia});
			tongtien+=(int)modelGoiMon.getValueAt(i, 1);
		}
		
	
		
		
		
		pCen.add(scroll, BorderLayout.CENTER);
		add(pCen, BorderLayout.CENTER);
		//Layout Khach Hang Va Thanh Toan
		pEast = new JPanel();
		Box b = Box.createVerticalBox();
		pEast.setBackground(mauNenQuan);
		
		pKhachHang = new JPanel();
		pKhachHang.setBackground(mauNenQuan);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(20));
		b1.add(pKhachHang);
		pKhachHang.setBorder(BorderFactory.createTitledBorder("Khách Hàng"));
		//Táº¡o Box cho Panel KhÃ¡ch HÃ ng
		Box bKH = Box.createVerticalBox();
		
		bKH.add(bKH1 = Box.createHorizontalBox());
		bKH.add(Box.createVerticalStrut(10));
		lblSDT = new JLabel("SDT: ");
		txtSDT = new JTextField(10);
		bKH1.add(lblSDT);
		bKH1.add(txtSDT);
		
		bKH.add(bKH2 = Box.createHorizontalBox());
		bKH.add(Box.createVerticalStrut(10));
		lblTen = new JLabel("Tên: ");
		txtTen = new JTextField(10);
		bKH2.add(lblTen);
		bKH2.add(txtTen);
		
		bKH.add(bKH3 = Box.createHorizontalBox());
		bKH.add(Box.createVerticalStrut(10));
		lblDiem = new JLabel("Điểm: ");
		txtDiem = new JTextField(10);
		bKH3.add(lblDiem);
		bKH3.add(txtDiem);
		
		lblSDT.setPreferredSize(lblDiem.getPreferredSize());
		lblTen.setPreferredSize(lblDiem.getPreferredSize());
		pKhachHang.add(bKH);
		
		pThanhToan = new JPanel();
		pThanhToan.setBackground(mauNenQuan);
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(pThanhToan);
		pThanhToan.setBorder(BorderFactory.createTitledBorder("Thanh Toán"));
		
		Box bTT = Box.createVerticalBox();
		
		bTT.add(bTT1 = Box.createHorizontalBox());
		bTT.add(Box.createVerticalStrut(20));
		
		
		lblTong = new JLabel("Tổng:"+tongtien+"VND");
		
		bTT1.add(lblTong);
		
		bTT.add(bTT2 = Box.createHorizontalBox());
		bTT.add(Box.createVerticalStrut(10));
		
		lblHinhThuc = new JLabel("Hình Thức: ");
		lblPhuongThuc = new JLabel("Tiền Mặt");
		bTT2.add(lblHinhThuc);
		bTT2.add(lblPhuongThuc);
		
		bTT.add(bTT3 = Box.createHorizontalBox());
		bTT.add(Box.createVerticalStrut(10));
		
		lblKhachDua = new JLabel("Khách Đưa: ");
		lblTienKhachDua = new JLabel("200.000VND");
		bTT3.add(lblKhachDua);
		bTT3.add(lblTienKhachDua);
		
		bTT.add(bTT4 = Box.createHorizontalBox());
		bTT.add(Box.createVerticalStrut(10));
		
		tienthua= 200000-tongtien;
		lblTienThua = new JLabel("Tiền Thừa:"+tienthua+"VND");
		
		bTT4.add(lblTienThua);
		pThanhToan.add(bTT);
		
		b.add(bBtn = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		btnHuy = new JButton("Huỷ");
		btnThanhToan = new JButton("Thanh Toán");
		bBtn.add(btnHuy);
		bBtn.add(btnThanhToan);
		
		btnHuy.setBackground(mauBanTrong);
		btnThanhToan.setBackground(mauBanTrong);
		
		pEast.add(b);
		pEast.setPreferredSize(new Dimension(350, 0));
		add(pEast, BorderLayout.EAST);
		
		btnThanhToan.addActionListener(this);
		btnHuy.addActionListener(this);
		setVisible(true);
	}
	
	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		//South
		if(source.equals(btnThanhToan))
		{
			JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
//			new goimon_UI().setVisible(true);
			dispose();
		}
		
		if(source.equals(btnHuy)) {
			dispose();
//			new goimon_UI().setVisible(true);
			
		}
	}
}
