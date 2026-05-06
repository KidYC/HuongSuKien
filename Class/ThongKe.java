package Class;

public class ThongKe {
	private int maHD;
	private int maBan;
	private float tongTien;
	public ThongKe(int maHD, int maBan, float tongTien) {
		
		this.maHD = maHD;
		this.maBan = maBan;
		this.tongTien = tongTien;
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public int getMaBan() {
		return maBan;
	}
	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
    @Override
    public String toString() {
    	return maHD+"-"+maBan+"-"+tongTien;
    }
}
