package easyBus.model;

import java.util.Date;

public class Booking {

	private int bookingID;
	private int ticketNo;
	private String ticketTime;
	private double ticketPrice;
	private int busID;
	private String busName;
	private int routeID;
	private String fromWhere;
	private String toWhere;
	private Date date;
	private int quantity;
	private int passID;

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
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
	
	public String getFromWhere() {
		return fromWhere;
	}
	
	public void setFromWhere(String fromWhere) {
		this.fromWhere = fromWhere;
	}
	
	public String getToWhere() {
		return toWhere;
	}
	
	public void setToWhere(String toWhere) {
		this.toWhere = toWhere;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPassID() {
		return passID;
	}

	public void setPassID(int passID) {
		this.passID = passID;
	}
}
