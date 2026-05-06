package Class;

public class Ban {
	private int maBan;
	private String trangThai;
	private int soCho;
	
	
	public Ban(int maBan, String trangThai, int soCho) {
		this.maBan = maBan;
		this.trangThai = trangThai;
		this.soCho = soCho;
	}
	


	public int getMaBan() {
		return maBan;
	}



	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}



	public String getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}



	public int getSoCho() {
		return soCho;
	}



	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return maBan + "-"+trangThai+"-"+soCho;
	}
    
}
