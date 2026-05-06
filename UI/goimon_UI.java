package UI;
import javax.management.modelmbean.ModelMBean;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class goimon_UI extends JFrame implements ActionListener{
	
	
	
	private JPanel pNorth;
	private JLabel lbltieude;
	private JPanel pCen;
	private JPanel pleft;
	private JPanel pright;
	private JLabel lblds;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JLabel lblme;
	private DefaultTableModel dsmon;
	private JTable table;
	private JScrollPane sr;
	private JPanel pSouth;
	private JLabel tongtien;
	private int total = 0;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JPanel pleft1;
	private JPanel pleft2;
	private JButton btn13;
	private JButton btn14;
	private JButton btn15;
	private JButton btn16;
	private JButton btn17;
	private JButton btn18;
	private JButton btn19;
	private JButton btn20;
	private JButton btn21;
	private JButton btn22;
	private JScrollPane scroll;
	private JButton thanhtoan;
	private JPanel pSouthR;
	private int soban;
	private static final long serialVersionUID = 1L;
	
	public goimon_UI(int soBan) {
		this.soban=soBan;
		Color maunenquan = Color.decode("#F5F5DC");
		Color mauchu = Color.decode("#3E2723");
		setTitle("QLCF_UI");
		setSize(750,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		getContentPane().setBackground(maunenquan);
		
		//pNorth
		pNorth = new JPanel();
		lbltieude = new JLabel("COFFEE Chồn -Bàn"+soBan);
		lbltieude.setFont(new Font("Arial", Font.BOLD, 20));
		lbltieude.setHorizontalAlignment(JLabel.CENTER);
		pNorth.add(lbltieude);
		
		//Center
		
		pCen = new JPanel();
		pCen.setLayout(new GridLayout(1,2));
		
		pleft = new JPanel();
		pright = new JPanel();
		
		
		//pleft
		pleft.setLayout(new GridLayout(1,2));
		 pleft1 = new JPanel();
		 pleft2 = new JPanel();
		
		
		 lblme = new JLabel("Menu món");
			lblme.setFont(new Font("Arial", Font.BOLD, 20));
			btn1 = new JButton("Cà phê đen");
			btn1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn2 = new JButton("Cà phê sữa");
			btn2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn3 = new JButton("Bạc xĩu");
			btn3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn4 = new JButton("Bò húc");
			btn4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			
			btn5 = new JButton("Trà sữa việt quốc");
			btn5.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn6 = new JButton("Trà sữa lài");
			btn6.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn7 = new JButton("Trà xanh");
			btn7.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn8 = new JButton("Trà đào");
			btn8.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			
			
			btn9 = new JButton("Trà vải");
			btn9.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn10 = new JButton("Trà gừng");
			btn10.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn11 = new JButton("Trà ổi hồng");
			btn11.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			
			
			
			btn12 = new JButton("Nước cam ép");
			btn12.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn13 = new JButton("Nước chanh tươi");
			btn13.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn14 = new JButton("Soda chanh");
			btn14.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn15 = new JButton("Soda dâu");
			btn15.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			
			btn16 = new JButton("Sinh tố bơ");
			btn16.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn17 = new JButton("Sinh tố xoài");
			btn17.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn18 = new JButton("Sinh tố dâu");
			btn18.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn19 = new JButton("Nước ép cà rốt");
			btn19.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			
			
			btn20 = new JButton("Nước ép dứa");
			btn20.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn21 = new JButton("Sữa chua đá");
			btn21.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			btn22 = new JButton("Sữa chua việt quốc");
			btn22.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		styleButton(btn1);
		styleButton(btn2);
		styleButton(btn3);
		styleButton(btn4);
		styleButton(btn5);
		styleButton(btn6);
		styleButton(btn7);
		styleButton(btn8);
		styleButton(btn9);
		styleButton(btn10);
		styleButton(btn11);
		styleButton(btn12);
		styleButton(btn13);
		styleButton(btn14);
		styleButton(btn15);
		styleButton(btn16);
		styleButton(btn17);
		styleButton(btn18);
		styleButton(btn19);
		styleButton(btn20);
		styleButton(btn21);
		styleButton(btn22);
		
		
		pleft1.setLayout(new BoxLayout(pleft1,BoxLayout.Y_AXIS));
		pleft1.add(lblme);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn1);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn2);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn3);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn4);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn5);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn6);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn7);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn8);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn9);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn10);
		pleft1.add(Box.createVerticalStrut(10));
		pleft1.add(btn11);
		pleft1.add(Box.createVerticalStrut(10));
		
		
		
		pleft2.setLayout(new BoxLayout(pleft2,BoxLayout.Y_AXIS));
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn12);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn13);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn14);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn15);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn16);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn17);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn18);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn19);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn20);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn21);
		pleft2.add(Box.createVerticalStrut(10));
		pleft2.add(btn22);
		pleft2.add(Box.createVerticalStrut(10));
		
		
		
		
		
		
		
		pleft.add(pleft1);
		pleft.add(pleft2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		btn15.addActionListener(this);
		btn16.addActionListener(this);
		btn17.addActionListener(this);
		btn18.addActionListener(this);
		btn19.addActionListener(this);
		btn20.addActionListener(this);
		btn21.addActionListener(this);
		btn22.addActionListener(this);
		
		
		scroll = new JScrollPane(pleft);
		//pright
		pright.setLayout(new BorderLayout());
		lblds = new JLabel("Danh sách món đã chọn");
		lblds.setFont(new Font("Arial", Font.BOLD, 20));
		lblds.setHorizontalAlignment(JLabel.CENTER);
		pright.add(lblds,BorderLayout.NORTH);
		
		
		String[] colum = {"Tên món","Giá tiền"};
		dsmon = new DefaultTableModel(colum,0);
		table = new JTable(dsmon);
		sr = new JScrollPane(table);
		tongtien = new JLabel("Tổng tiền: 0đ");
		thanhtoan = new JButton("Thanh Toán");
		thanhtoan.addActionListener(this);
		pright.add(sr,BorderLayout.CENTER);
		
		//pSouthR
		pSouthR = new JPanel();
		
		JButton btnQuayLai = new JButton("Quay lại");

		pSouthR.add(btnQuayLai); 
		pSouthR.setLayout(new BoxLayout(pSouthR,BoxLayout.X_AXIS));
		pSouthR.add(tongtien);
		pSouthR.add(Box.createHorizontalStrut(120));
		pSouthR.add(thanhtoan);
		pright.add(pSouthR,BorderLayout.SOUTH);
		
		
		btnQuayLai.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		        new TrangChu_UI().setVisible(true);
		    }
		});
		
		
		pCen.add(scroll);
		pCen.add(pright);
		
		
		add(pNorth,BorderLayout.NORTH);
		add(pCen,BorderLayout.CENTER);
	
		pNorth.setBackground(maunenquan);
		pCen.setBackground(maunenquan);
		pleft.setBackground(maunenquan);
		pright.setBackground(maunenquan);
		pleft1.setBackground(maunenquan);
		pleft2.setBackground(maunenquan);
		lbltieude.setForeground(mauchu);
		lblme.setForeground(mauchu);
		lblds.setForeground(mauchu);
		tongtien.setForeground(mauchu);
		
		
		table.setBackground(Color.decode("#F5F5DC"));
		table.setForeground(Color.BLACK);
		table.setOpaque(true);
		sr.getViewport().setBackground(Color.decode("#F5F5DC"));

		table.getTableHeader().setBackground(Color.decode("#F5F5DC"));
		table.getTableHeader().setForeground(Color.BLACK);
		table.getTableHeader().setOpaque(true);
	

		table.setRowHeight(25);
		table.setGridColor(Color.LIGHT_GRAY);
	
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			dsmon.addRow(new Object[] {"Cà phê đen",25000});
			total= total+25000;
		}
		else if(e.getSource()==btn2) {
			dsmon.addRow(new Object[] {"Cà phê sữa",22000});
			total= total+22000;
		}
	    else if (e.getSource() == btn3) {
	        dsmon.addRow(new Object[]{"Bạc xỉu", 29000});
	        total= total+29000;
	    } 
	    else if (e.getSource() == btn4) {
	        dsmon.addRow(new Object[]{"Bò húc", 19000});
	        total= total+19000;
	    }
	    else if(e.getSource()==btn5) {
			dsmon.addRow(new Object[] {"Trà sữa việt quốc",29000});
			total= total+29000;
		}
	    else if (e.getSource() == btn6) {
	        dsmon.addRow(new Object[]{"Trà sữa lài", 35000});
	        total= total+35000;
	    } 
	    else if (e.getSource() == btn7) {
	        dsmon.addRow(new Object[]{"Trà xanh", 39000});
	        total= total+39000;
	    }
	    else if(e.getSource()==btn8) {
			dsmon.addRow(new Object[] {"Trà đào",32000});
			total= total+32000;
		}
	    else if (e.getSource() == btn9) {
	        dsmon.addRow(new Object[]{"Trà vải", 30000});
	        total= total+30000;
	    } 
	    else if (e.getSource() == btn10) {
	        dsmon.addRow(new Object[]{"Trà gừng", 22000});
	        total= total+22000;
	    }
	    else if(e.getSource()==btn11) {
			dsmon.addRow(new Object[] {"Trà ổi hồng",39000});
			total= total+39000;
		}
	    else if (e.getSource() == btn12) {
	        dsmon.addRow(new Object[]{"Nước ép cam", 20000});
	        total= total+20000;
	    } 
	    else if (e.getSource() == btn13) {
	        dsmon.addRow(new Object[]{"Nước chanh tươi", 19000});
	        total= total+19000;
	    }
	    else if(e.getSource()==btn14) {
			dsmon.addRow(new Object[] {"Soda chanh",22000});
			total= total+22000;
		}
	    else if (e.getSource() == btn15) {
	        dsmon.addRow(new Object[]{"Soda dâu", 27000});
	        total= total+27000;
	    } 
	    else if (e.getSource() == btn16) {
	        dsmon.addRow(new Object[]{"Sinh tố bơ", 32000});
	        total= total+32000;
	    }
	    else if(e.getSource()==btn17) {
			dsmon.addRow(new Object[] {"Sinh tố xoài",32000});
			total= total+32000;
		}
	    else if (e.getSource() == btn18) {
	        dsmon.addRow(new Object[]{"Sinh tố dâu", 32000});
	        total= total+32000;
	    } 
	    else if (e.getSource() == btn19) {
	        dsmon.addRow(new Object[]{"Nước ép cà rốt", 28000});
	        total= total+28000;
	    }
	    else if(e.getSource()==btn20) {
			dsmon.addRow(new Object[] {"Nước ép dứa",32000});
			total= total+32000;
		}
	    else if (e.getSource() == btn21) {
	        dsmon.addRow(new Object[]{"Sữa chua đá", 22000});
	        total= total+22000;
	    } 
	    else if (e.getSource() == btn22) {
	        dsmon.addRow(new Object[]{"Sữa chua việt quốc", 25000});
	        total= total+25000;
	    } 
	    else if (e.getSource()==thanhtoan) {
	    	    new ThanhToan_UI(dsmon,soban);
	    }
		tongtien.setText("Tổng tiền: "+ total+"đ");
		
	}
	private void styleButton(JButton btn) {
	    btn.setBackground(Color.decode("#F5F5DC")); 
	    btn.setForeground(Color.BLACK);           
	    btn.setFocusPainted(false);              
	    btn.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btn.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
	    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}
	public static void main(String [] args) {
		 //new goimon_UI();
		
	}
	

}