package easyBus.model;

public class Ticket {

	private int ticketNo;
	private String ticketTime;
	private double ticketPrice;
	private int busID;

	public int getTicketNo() {
		return ticketNo;
	}
	
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	
	public String getTicketTime() {
		return ticketTime;
	}
	
	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
	}
}
