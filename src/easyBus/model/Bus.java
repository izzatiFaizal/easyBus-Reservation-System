package easyBus.model;

public class Bus {

	private int busID;
	private String plateNo;
	private String busName;
	private int routeID;
	private int ticketNo;

	public int getBusID() {
		return busID;
	}
	
	public void setBusID(int busID) {
		this.busID = busID;
	}
	
	public String getPlateNo() {
		return plateNo;
	}
	
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	
	public String getBusName() {
		return busName;
	}
	
	public void setBusName(String busName) {
		this.busName = busName;
	}
	
	public int getRouteID() {
		return routeID;
	}
	
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	
	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
}
