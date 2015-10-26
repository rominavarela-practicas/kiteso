package mx.kiteso.KIteso.model;

public class Auth {
	private int status;
	private String email;
	private String msg;
	
	//getters
	public int getStatus() {
		return this.status;
	}
	public String getEmail() {
		return this.email;
	}
	public String getMsg() {
		return this.msg;
	}
	
	//setters
	public void setStatus(int i) {
		this.status = i;
	}
	public void setEmail(String s) {
		this.email = s;
	}
	public void setMsg(String s) {
		this.msg = s;
	}
}
