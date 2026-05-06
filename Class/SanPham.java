package Class;

public class SanPham {
	private int maSP;
	private String tenSP;
	private float gia;
	public SanPham(int maSP, String tenSP, float gia) {

		this.maSP = maSP;
		this.tenSP = tenSP;
		this.gia = gia;
	}
	public SanPham() {
		
	}
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {

		return maSP + " - " + tenSP + " - " + gia;
	}
}
