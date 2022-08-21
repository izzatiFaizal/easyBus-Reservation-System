package easyBus.model;

public class Route {

	private int routeID;
	private String fromWhere;
	private String toWhere;
	private double ticketPrice;

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
	
	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
