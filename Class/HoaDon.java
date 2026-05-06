package Class;

public class HoaDon {
	private int maHD;
	private int maBan;
	private float tongTien;
	public HoaDon(int maHD, int maBan, float tongTien) {
		super();
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
    	// TODO Auto-generated method stub
    	return maHD +"-"+maBan+"-"+tongTien;
    }
}
