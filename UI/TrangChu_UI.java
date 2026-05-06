package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrangChu_UI extends JFrame {

    private JButton btnBanHang, btnNhanVien, btnSanPham, btnHoaDon, btnThongKe, btnDangXuat;
    private JLabel lblClock;

    public TrangChu_UI() {
        setTitle("Quản Lý Quán Cafe");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color mauNen = Color.decode("#F5F5DC");
        Color mauBtn = Color.decode("#DEB887");
        Color mauChu = Color.decode("#3E2723");

        JPanel mainPanel = new JPanel(new BorderLayout());

        // header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(mauNen);
        header.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblTitle = new JLabel("COFFEE CHỒN");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(mauChu);

        lblClock = new JLabel();
        lblClock.setFont(new Font("Arial", Font.PLAIN, 14));
        lblClock.setForeground(mauChu);

        header.add(lblTitle, BorderLayout.WEST);
        header.add(lblClock, BorderLayout.EAST);

        // Đồng hồ
        Timer timer = new Timer(1000, e -> {
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            java.time.format.DateTimeFormatter fmt =
                    java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss - dd/MM/yyyy");
            lblClock.setText(fmt.format(now));
        });
        timer.start();

        // menu
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBackground(mauNen);
        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Dimension size = new Dimension(150, 40);

        btnBanHang = createButton("Bán Hàng", size, mauBtn);
        btnNhanVien = createButton("Nhân Viên", size, mauBtn);
        btnSanPham = createButton("Sản Phẩm", size, mauBtn);
        btnHoaDon = createButton("Hóa Đơn", size, mauBtn);
        btnDangXuat = createButton("Đăng Xuất", size, Color.decode("#D2691E"));

        menu.add(btnBanHang);
        menu.add(Box.createVerticalStrut(10));
        menu.add(btnNhanVien);
        menu.add(Box.createVerticalStrut(10));
        menu.add(btnSanPham);
        menu.add(Box.createVerticalStrut(10));
        menu.add(btnHoaDon);    
        menu.add(Box.createVerticalStrut(20));
        menu.add(btnDangXuat);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(mauNen);

        // best seller
        JPanel bestSeller = new JPanel(new GridLayout(1, 4, 15, 15));
        bestSeller.setBorder(BorderFactory.createTitledBorder("Best seller"));
        bestSeller.setBackground(mauNen);

        bestSeller.add(createItem("Cà phê sữa", "/IMG/cf-sua.jpg"));
        bestSeller.add(createItem("Trà đào", "/IMG/tra-dao.jpg"));
        bestSeller.add(createItem("Bạc xỉu", "/IMG/bacxiu.jpg"));
        bestSeller.add(createItem("Sinh tố bơ", "/IMG/sinhtobo.jpg"));
        
        

        // thông tin quán
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout(10, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin quán"));
        infoPanel.setBackground(mauNen);

        // ảnh quán
        JLabel lblImg = new JLabel();
        lblImg.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon icon = new ImageIcon(getClass().getResource("/IMG/quan.jpg"));
        Image scaled = icon.getImage().getScaledInstance(800, 200, Image.SCALE_SMOOTH);
        lblImg.setIcon(new ImageIcon(scaled));
        
        JTextArea txtthongtinquan = new JTextArea(
                "Coffee Chồn\n" +
                "Địa chỉ: Quận X\n" +
                "Giờ hoạt động: 7:00 - 22:00\n" +
                "Liên hệ: 0123 456 789"
        );
        txtthongtinquan.setEditable(false);
        txtthongtinquan.setBackground(mauNen);
        txtthongtinquan.setFont(new Font("Arial", Font.PLAIN, 14));
        
        infoPanel.add(lblImg, BorderLayout.NORTH);
        infoPanel.add(txtthongtinquan, BorderLayout.CENTER);
        
        JPanel centerPanel = new JPanel(new BorderLayout(10,10));
        centerPanel.setBackground(mauNen);

        centerPanel.add(bestSeller, BorderLayout.NORTH);
        centerPanel.add(infoPanel, BorderLayout.CENTER);
        // ghi chú
        JTextArea txtNote = new JTextArea(3, 20);
        txtNote.setBorder(BorderFactory.createTitledBorder("Ghi chú nhanh"));
        txtNote.setLineWrap(true);

        content.add(centerPanel, BorderLayout.CENTER);
        content.add(new JScrollPane(txtNote), BorderLayout.SOUTH);

        // event
        btnBanHang.addActionListener(e -> {new chonban_UI().setVisible(true);});

        btnSanPham.addActionListener(e -> {new SanPham_UI().setVisible(true);});
        
        btnNhanVien.addActionListener(e -> {new NhanVien_UI().setVisible(true);});
        
        btnHoaDon.addActionListener(e -> {new HoaDon_UI().setVisible(true);});

        btnDangXuat.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc muốn đăng xuất?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                new DangNhap_UI().setVisible(true);
            }
        });

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(menu, BorderLayout.WEST);
        mainPanel.add(content, BorderLayout.CENTER);

        add(mainPanel);
    }

    // style button 
    private JButton createButton(String text, Dimension size, Color color) {
        JButton btn = new JButton(text);
        btn.setMaximumSize(size);
        btn.setBackground(color);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Tahoma", Font.BOLD, 13));
        return btn;
    }
    private JPanel createItem(String ten, String imgPath){
        JPanel p = new JPanel(new BorderLayout());
        
        JLabel img = new JLabel();
        img.setHorizontalAlignment(JLabel.CENTER);
        
        ImageIcon icon = new ImageIcon(getClass().getResource(imgPath));
        Image scaled = icon.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
        img.setIcon(new ImageIcon(scaled));

        JLabel name = new JLabel(ten, JLabel.CENTER);
        name.setFont(new Font("Arial", Font.BOLD, 12));

        p.add(img, BorderLayout.CENTER);
        p.add(name, BorderLayout.SOUTH);

        return p;
    }
    public static void main(String[] args) {
        new TrangChu_UI().setVisible(true);
    }
}