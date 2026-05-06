package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import Class.TaiKhoan;
import DAO.TaiKhoan_DAO;
public class DangNhap_UI extends JFrame implements ActionListener, KeyListener {

	private JTextField txtUsername;
	private JLabel lblUsername;
	private JPasswordField txtPwd;
	private JLabel lblPwd;
	private JButton btnDN;
	private JPanel pCen;
	private JPanel pSouth;
	private JPanel pNorth;
	private JLabel lbltieude;
	private Font fo;
	
	private TaiKhoan tk;
	
	public DangNhap_UI() {
		 setTitle("Quản Lý Cafe");
	     setSize(400, 200);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     setLocationRelativeTo(null);
	     setLayout(new BorderLayout());
	     
	     
	     Color mauNen = Color.decode("#F5F5DC"); 
		 Color mauBtn = Color.decode("#DEB887"); 
		 Color mauChu = Color.decode("#3E2723");     
	     tk = new TaiKhoan("admin", "12345");
	     
	     pNorth = new JPanel();
	     lbltieude = new JLabel("Đăng Nhập");
	     fo = new Font("Time New Roman", Font.BOLD,20);
	     lbltieude.setFont(fo);
	     lbltieude.setForeground(mauChu);
	     pNorth.add(lbltieude);
	     add(pNorth, BorderLayout.NORTH);
	     pNorth.setBackground(mauNen);
	     
	     //center
	     pCen = new JPanel();
		 pCen.setLayout(new BoxLayout(pCen, BoxLayout.Y_AXIS));
	     
		 Box b = Box.createVerticalBox();
		 Box b1,b2,b3 ;
		 
		 b.add(b1 = Box.createHorizontalBox());
		 b.add(Box.createVerticalStrut(18));
	     b1.add(lblUsername = new JLabel("Tài khoản : "));
	     b1.add(txtUsername = new JTextField(15));
	     txtUsername.setMaximumSize(txtUsername.getPreferredSize());
	     
	     b.add(b2 = Box.createHorizontalBox());
		 b.add(Box.createVerticalStrut(10));
	     b2.add(lblPwd = new JLabel("Mật khẩu : "));
	     b2.add(txtPwd = new JPasswordField(15));
	     txtPwd.setMaximumSize(txtPwd.getPreferredSize());
	     
	     pCen.add(b);
	     add(pCen);
	     pCen.setBackground(mauNen);
	    //south
	     pSouth = new JPanel();
		 add(pSouth,BorderLayout.SOUTH);
	     pSouth.add(btnDN = new JButton("Đăng Nhập"));
	     btnDN.setBackground(mauBtn);
	     pSouth.setBackground(mauNen);
	     
	     lblPwd.setPreferredSize(lblUsername.getPreferredSize());
	     
	     btnDN.addActionListener(this);
	     txtUsername.addKeyListener(this);
	     txtPwd.addKeyListener(this);
	}
	  public static void main(String[] args) {
	        new DangNhap_UI().setVisible(true);
	    }
	  @Override
	  public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  XuLiDangNhap();
	  }
	  
	  public void XuLiDangNhap() {  
		  TaiKhoan_DAO dao = new TaiKhoan_DAO();

		  String tenDangNhap = txtUsername.getText();
		  String matKhau = new String(txtPwd.getPassword());
		    
		  if (dao.kiemTraDangNhap(tenDangNhap, matKhau)) {
		      new TrangChu_UI().setVisible(true);
		      dispose();
		  } else {
		      JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!");
		  }
		txtUsername.setText("");
		txtPwd.setText("");
		
		txtUsername.requestFocus();
	  }
	  
	  @Override
	  public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	  }
	  @Override
	  public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        XuLiDangNhap();
		    }
	  }
	  @Override
	  public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	  }
}
