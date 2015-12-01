package mx.kiteso.KIteso.model.serial.out;

public class Status {
    public static final int STATUS_OK = 200;
    
	private int status;
	private String email;
	private String msg;
	private String redir;
	
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
	public String getRedir() {
		return this.redir;
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
	public void setRedir(String s) {
		this.redir = s;
	}
}
