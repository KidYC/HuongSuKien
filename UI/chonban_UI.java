package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import DAO.Ban_DAO;

public class chonban_UI extends JFrame implements ActionListener {
    private JPanel pNorth;
    private JLabel lblTitle;
    private JPanel pCen;
    private JPanel pSouth;
    private JButton btnTrong;
    private JButton btnDay;
    private JButton btnBaoTri;
    

    private JButton[] dsBan;
    private Connection con;
    private Ban_DAO banDAO;

    public chonban_UI() {
       
        try {
            con = Database.ConnectDB.getConnection();
            banDAO = new Ban_DAO(con);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sở dữ liệu!");
        }

       
        Color mauNenQuan = Color.decode("#F5F5DC"); 
        Color mauBanTrong = Color.decode("#DEB887"); 
        Color mauBanDay = Color.decode("#CD853F");
        Color mauBanBaoTri = Color.decode("#BCAE9E");
        Color mauChu = Color.decode("#3E2723");      
        
      
        setTitle("Sơ đồ bàn");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thêm dòng này để thoát chương trình khi bấm X
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình


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
        pCen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        dsBan = new JButton[9];
        for (int i = 0; i < 9; i++) {
            dsBan[i] = new JButton("Bàn " + (i + 1));
            dsBan[i].setFont(new Font("Arial", Font.BOLD, 14));
            dsBan[i].setBackground(mauBanTrong); 
            dsBan[i].addActionListener(this);   
            pCen.add(dsBan[i]);
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
        JLabel lblBaoTri = new JLabel("Bàn bảo trì"); 
        lblBaoTri.setFont(new Font("Tahoma", Font.PLAIN, 13));

        pSouth.add(hienTrong);
        pSouth.add(lblTrong);
        pSouth.add(hienDay);
        pSouth.add(lblDay);
        pSouth.add(hienBaoTri);
        pSouth.add(lblBaoTri);

        add(pSouth, BorderLayout.SOUTH);

        
        updateBanStates();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        for (int i = 0; i < dsBan.length; i++) {
            if (e.getSource() == dsBan[i]) {
                
                new goimon_UI(i + 1);
                break; 
            }
        }
    }

    public void updateBanStates() {
        if (banDAO == null) return;
        
        
        for (int i = 0; i < dsBan.length; i++) {
            String maBan = "BAN" + (i + 1); 
            
           
            if (banDAO.isBanTrong(maBan)) {
                dsBan[i].setBackground(Color.decode("#DEB887")); 
            } else {
                dsBan[i].setBackground(Color.decode("#CD853F"));
            }
        }
    }

    public static void main(String[] args) {
            new chonban_UI();
    }
}