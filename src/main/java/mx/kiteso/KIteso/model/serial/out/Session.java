package mx.kiteso.KIteso.model.serial.out;

public class Session {
	private String email;
	
	public Session clone() {
		Session s = new Session();
		s.email = email;
		return s;
	}
	
	//getters
	public String getEmail() {
		return this.email;
	}
	
	//setters
	public void setEmail(String s) {
		this.email = s;
	}
}
