package UI;
import java.awt.*;
import javax.swing.*;


public class SoDoBan_UI extends JFrame{
	private JPanel pNorth;
	private JLabel lblTitle;
	private JPanel pCen;
	private JPanel pSouth;
	private JButton btnTrong;
	private JButton btnDay;
	private JButton btnBaoTri;

	public SoDoBan_UI(){
		setTitle("Sơ đồ bàn");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}
	
	public void buildUI(){
		Color mauNenQuan = Color.decode("#F5F5DC"); // Màu kem nhạt cho nền
		Color mauBanTrong = Color.decode("#DEB887"); // Màu gỗ sáng
		Color mauBanDay = Color.decode("#CD853F");
		Color mauBanBaoTri = Color.decode("#BCAE9E");
		Color mauChu = Color.decode("#3E2723");     // Màu nâu đậm cho chữ
		
		
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
		
		JButton[] ban = new JButton[10];
		String[] soBan = new String[10];
		Color[] trangThai = {mauBanTrong, mauBanDay, mauBanBaoTri};
		for(int i = 1; i <= 9; i++) {
			
			soBan[i] = "Bàn " + i;
			ban[i] = new JButton(soBan[i]);
			
			ban[i].setBackground(mauBanTrong);
			ban[i].setForeground(mauChu);
			
			pCen.add(ban[i]);
		}
		
		
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
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// GUI_UngDung frm = new GUI_UngDung();
		SoDoBan_UI frm = new SoDoBan_UI();
	}
}
