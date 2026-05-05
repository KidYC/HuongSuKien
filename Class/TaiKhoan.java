package Class;

public class TaiKhoan {
	  private String tenDangNhap;
	  private String matKhau;

	  public TaiKhoan(String user, String pass) {
	      this.tenDangNhap = user;
	      this.matKhau = pass;
	  }

	  public boolean dangNhap(String user, String pass) {
	      return tenDangNhap.equals(user) && matKhau.equals(pass);
	  }
}
