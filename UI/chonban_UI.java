package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class chonban_UI extends JFrame implements ActionListener{
	private JPanel pNorth;
	private JLabel lblTitle;
	private JPanel pCen;
	private JPanel pSouth;
	private JButton btnTrong;
	private JButton btnDay;
	private JButton btnBaoTri;
	private JButton ban1;
	private JButton ban2;
	private JButton ban3;
	private JButton ban4;
	private JButton ban5;
	private JButton ban6;
	private JButton ban7;
	private JButton ban8;
	private JButton ban9;
	public chonban_UI(){
		Color mauNenQuan = Color.decode("#F5F5DC"); // Màu kem nhạt cho nền
		Color mauBanTrong = Color.decode("#DEB887"); // Màu gỗ sáng
		Color mauBanDay = Color.decode("#CD853F");
		Color mauBanBaoTri = Color.decode("#BCAE9E");
		Color mauChu = Color.decode("#3E2723");     // Màu nâu đậm cho chữ
		setSize(600,600);
		
		pNorth = new JPanel();
		lblTitle = new JLabel("Sơ đồ bàn");
		Font fo = new Font("Arial", Font.BOLD, 30);
		lblTitle.setFont(fo);
		lblTitle.setForeground(mauChu);
		pNorth.add(lblTitle);
		pNorth.setBackground(mauNenQuan);
		
		add(pNorth, BorderLayout.NORTH);
		
		pCen = new JPanel();
		pCen.setLayout(new GridLayout(3, 3, 100, 100));
		pCen.setBackground(mauNenQuan);
		
		 ban1 = new JButton("Bàn 1");
		 ban2 = new JButton("Bàn 2");
		 ban3 = new JButton("Bàn 3");
		 ban4 = new JButton("Bàn 4");
		 ban5 = new JButton("Bàn 5");
		 ban6 = new JButton("Bàn 6");
		 ban7 = new JButton("Bàn 7");
		 ban8 = new JButton("Bàn 8");
		 ban9 = new JButton("Bàn 9");
		
		ban1.setBackground(mauBanTrong);
		ban2.setBackground(mauBanTrong);
		ban3.setBackground(mauBanTrong);
		ban4.setBackground(mauBanTrong);
		ban5.setBackground(mauBanTrong);
		ban6.setBackground(mauBanTrong);
		ban7.setBackground(mauBanTrong);
		ban8.setBackground(mauBanTrong);
		ban9.setBackground(mauBanTrong);
		
		pCen.add(ban1);
		pCen.add(ban2);
		pCen.add(ban3);
		pCen.add(ban4);
		pCen.add(ban5);
		pCen.add(ban6);
		pCen.add(ban7);
		pCen.add(ban8);
		pCen.add(ban9);
		
		
		
		
		add(pCen, BorderLayout.CENTER);

		pSouth = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		pSouth.setBackground(Color.decode("#F5F5DC"));

		JButton hienTrong = new JButton();
		hienTrong.setPreferredSize(new Dimension(20, 20));
		hienTrong.setBackground(mauBanTrong);
		hienTrong.setEnabled(false);
		JLabel lblTrong = new JLabel("Bàn trống");
		lblTrong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton hienDay = new JButton();
		hienDay.setPreferredSize(new Dimension(20, 20));
		hienDay.setBackground(mauBanDay);
		hienDay.setEnabled(false);
		JLabel lblDay = new JLabel("Bàn đầy"); 
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton hienBaoTri = new JButton();
		hienBaoTri.setPreferredSize(new Dimension(20, 20));
		hienBaoTri.setBackground(mauBanBaoTri);
		hienBaoTri.setEnabled(false);
		JLabel lblBaoTri = new JLabel("Bàn Bảo Trì"); 
		lblBaoTri.setFont(new Font("Tahoma", Font.PLAIN, 13));

		
		pSouth.add(hienTrong);
		pSouth.add(lblTrong);
		
		pSouth.add(hienDay);
		pSouth.add(lblDay);
		
		pSouth.add(hienBaoTri);
		pSouth.add(lblBaoTri);
		
		add(pSouth, BorderLayout.SOUTH);
		ban1.addActionListener(this);
		ban2.addActionListener(this);
		ban3.addActionListener(this);
		ban4.addActionListener(this);
		ban5.addActionListener(this);
		ban6.addActionListener(this);
		ban7.addActionListener(this);
		ban8.addActionListener(this);
		ban9.addActionListener(this);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ban1) {
			new goimon_UI(1);
		}
		else if (e.getSource()==ban2) {
			new goimon_UI(2);
		}
		else if (e.getSource()==ban3) {
			new goimon_UI(3);
		}
		else if (e.getSource()==ban4) {
			new goimon_UI(4);
		}
		else if (e.getSource()==ban5) {
			new goimon_UI(5);
		}
		else if (e.getSource()==ban6) {
			new goimon_UI(6);
		}
		else if (e.getSource()==ban7) {
			new goimon_UI(7);
		}
		else if (e.getSource()==ban8) {
			new goimon_UI(8);
		}
		else if (e.getSource()==ban9) {
			new goimon_UI(9);
		}
		
	}

	public static void main(String[] args) {
		new chonban_UI();
	}
	
}
