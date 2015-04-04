public abstract class Orang{
	private String nama;
	private int umur;
	
	public Orang(String nama , int umur){
		this.nama = nama;
		this.umur = umur;
	}
	
	public void setNama(String nama){
		this.nama = nama;
	}
	
	public void setUmur(int umur){
		this.umur = umur;
	}
	
	public String getNama(){
		return nama;
	}
	
	public int getUmur(){
		return umur;
	}
	
	public abstract String getStatus();
}