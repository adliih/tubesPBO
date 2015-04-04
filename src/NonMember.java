public class NonMember extends Orang{
	
	public NonMember(String nama, int umur){
		super(nama,umur);
	}
	
	public String getStatus(){
		return "Non Member";
	}
}