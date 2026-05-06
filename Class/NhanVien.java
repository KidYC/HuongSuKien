package Class;

public class NhanVien {
   private String maNV;
   private String tenNV;
   private String chucVu;
   private float luong;
   private String sdt;
public NhanVien(String maNV, String tenNV, String chucVu, float luong, String sdt) {
	
	this.maNV = maNV;
	this.tenNV = tenNV;
	this.chucVu = chucVu;
	this.luong = luong;
	this.sdt = sdt;
}
public String getMaNV() {
	return maNV;
}
public void setMaNV(String maNV) {
	this.maNV = maNV;
}
public String getTenNV() {
	return tenNV;
}
public void setTenNV(String tenNV) {
	this.tenNV = tenNV;
}
public String getChucVu() {
	return chucVu;
}
public void setChucVu(String chucVu) {
	this.chucVu = chucVu;
}
public float getLuong() {
	return luong;
}
public void setLuong(float luong) {
	this.luong = luong;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
 @Override
	public String toString() {

		return  maNV + " - " + tenNV + " - "+chucVu+"-"+luong+"-"+sdt;
	}

   
}
