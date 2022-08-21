package easyBus.model;

public class Admin {

	private int adminID;
	private String adminName;
	private String adminIC;
	private boolean valid;
	
	public int getAdminID() {
		return adminID;
	}
	
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getAdminIC() {
		return adminIC;
	}
	
	public void setAdminIC(String adminIC) {
		this.adminIC = adminIC;
	}

	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
