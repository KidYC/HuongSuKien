package Class;

public class ChiTietHoaDon {
	private String maChiTietHoaDon;
	private int soLuong;
	private float donGia;
	private String trangThai;
	
	public ChiTietHoaDon(String maChiTietHoaDon, int soLuong, float donGia, String trangThai) {
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}
	

	public String getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}


	public void setMaChiTietHoaDon(String maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public float getDonGia() {
		return donGia;
	}


	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}


	public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return maChiTietHoaDon+"-"+soLuong+"-"+donGia+"-"+trangThai;
	}
	

}
