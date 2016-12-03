package test;

public class User {
	private String id;
	private String pw;
	
	public User(String ID,String PW){
		this.id=ID;
		this.pw=PW;
		
	}
	public String getid(){
		return this.id;
		
	}
	
	public String getpw(){
		return this.pw;
	}
}
