package easyBus.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;

import easyBus.connection.ConnectionManager;
import easyBus.model.Booking;
import easyBus.model.Bus;
import easyBus.model.Passenger;

public class BookingDAO {

	String busName, fromWhere, toWhere, ticketTime, name;
	int busID, routeID, ticketNo, passID, quantity, bookingID;
	double ticketPrice;
	Date date;
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public void addBooking(Booking bean){
		//get values
		busID = bean.getBusID();
		busName = bean.getBusName();
		fromWhere = bean.getFromWhere();
		toWhere = bean.getToWhere();
		ticketTime = bean.getTicketTime();
		//name = bean.getName();
		date = bean.getDate();
		quantity = bean.getQuantity();
		passID = bean.getPassID();
		
		try {
			//step 2: create connection
			con = ConnectionManager.getConnection();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			String strdate = dateFormat.format(date);
			//step3 : create statement - using preparedStatement
			ps=con.prepareStatement("INSERT INTO booking (passID, busID, busName, fromWhere, toWhere, ticketTime, date, quantity) values(?,?,?,?,?,?,?,?)");
			
			ps.setInt(1,passID);
			//ps.setString(2,name);
			ps.setInt(2,busID);
			ps.setString(3,busName);
			ps.setString(4,fromWhere);
			ps.setString(5,toWhere);
			ps.setString(6,ticketTime);
			ps.setDate(7,(java.sql.Date.valueOf(strdate)));
			ps.setInt(8, quantity);
			//step 4: execute statement
			ps.executeUpdate();
			//step 5: close connection
			con.close();
		}
		
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
	}
	
	public static Booking getBooking(int busID) {
		
		Booking book = new Booking();
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from buses WHERE busID=?");
	
			ps.setInt(1, busID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book.setBusID(rs.getInt("busID"));
				book.setBusName(rs.getString("busName"));
				book.setRouteID(rs.getInt("routeID"));
			}
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return book;
	}
	
	public static Booking getRoute(int routeID) {
		
		Booking r = new Booking();
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from routes WHERE routeID=?");
	
			ps.setInt(1, routeID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r.setRouteID(rs.getInt("routeID"));
				r.setFromWhere(rs.getString("fromWhere"));
				r.setToWhere(rs.getString("toWhere"));
			}
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return r;
	}
	
	public static Booking getTicket(int ticketNo) {
		
		Booking t = new Booking();
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from ticket WHERE ticketNo=?");
	
			ps.setInt(1, ticketNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t.setTicketNo(rs.getInt("ticketNo"));
				t.setTicketTime(rs.getString("ticketTime"));
			}
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return t;
	}
	
	public static Booking getBookingByPassId(int passID) {
		
		Booking b = new Booking();
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from booking where passID=?");
	
			ps.setInt(1, passID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b.setBookingID(rs.getInt("bookingID"));
				b.setPassID(rs.getInt("passID"));
				b.setBusID(rs.getInt("busID"));
				b.setBusName(rs.getString("busName"));
				b.setFromWhere(rs.getString("fromWhere"));
				b.setToWhere(rs.getString("toWhere"));
				b.setTicketTime(rs.getString("ticketTime"));
				b.setDate(rs.getDate("date"));
				b.setQuantity(rs.getInt("quantity"));
			}
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return b;
	}
}
