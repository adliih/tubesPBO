public class Member extends Orang{
	private String username, password;
	
	public Member(String username, String password, String nama, int umur){
		super(nama,umur);
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String usename){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getStatus(){
		return "Member";
	}
}