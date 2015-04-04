public class Jadwal{
	private Member penyewa;
	private boolean statusDP = false;
	protected String logBook = "LOGBOOK";
	
	public void addPenyewa(Member member){
		penyewa = member;
		logBook+= "\nmember "+penyewa.getUsername() +" telah membooking lapangan";
	}
	
	public Member getPenyewa(){
		return penyewa;
	}
	
	public String getLogBook(){
		return logBook;
	}
	
	public String toString(){
		return " ";
	}
	
	public void DP(){
		this.statusDP = true;
		logBook+= "\nmember "+penyewa.getUsername() +" telah membayar lapangan";
	}
	
	public void Batal(){
		logBook+= "\nmember "+penyewa.getUsername() +" telah membatal menyewa lapangan";
	}
}
	
	
	
		