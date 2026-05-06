package Class;

import java.time.LocalDate;

public class HoaDon {
	private String maHD;
	private LocalDate ngayLapHoaDon;
	private String phuongThuc;
	private float tongTien;
	
    public HoaDon(String maHD, LocalDate ngayLapHoaDon, String phuongThuc, float tongTien) {

		this.maHD = maHD;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.phuongThuc = phuongThuc;
		this.tongTien = tongTien;
	}
     
	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public String getPhuongThuc() {
		return phuongThuc;
	}

	public void setPhuongThuc(String phuongThuc) {
		this.phuongThuc = phuongThuc;
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
    	return maHD +"-"+ngayLapHoaDon+"-"+phuongThuc+"-"+tongTien;
    }
}
