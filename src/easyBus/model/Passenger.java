package easyBus.model;

public class Passenger {

	private int passID;
	private String email;
	private String name;
	private String ICNumber;
	private String phoneNo;
	private String password;
	private String confirmPw;
	private boolean valid;
	
	public int getPassID() {
		return passID;
	}

	public void setPassID(int passID) {
		this.passID = passID;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getICNumber() {
		return ICNumber;
	}
	
	public void setICNumber(String iCNumber) {
		ICNumber = iCNumber;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPw() {
		return confirmPw;
	}
	
	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
