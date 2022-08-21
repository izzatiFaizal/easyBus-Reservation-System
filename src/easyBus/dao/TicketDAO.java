package easyBus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import easyBus.connection.ConnectionManager;
import easyBus.model.Ticket;

public class TicketDAO {

	String ticketTime;
	int ticketNo, busID;
	double ticketPrice;
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public static List<Ticket> getAllTicket() {
		List<Ticket> tics = new ArrayList<Ticket>();
		
		try {
		 con = ConnectionManager.getConnection();
		 stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("select * from ticket");
		 
		 while (rs.next()) {
			 Ticket tic = new Ticket();
			 tic.setTicketNo(rs.getInt("ticketNo"));
			 tic.setTicketTime(rs.getString("ticketTime"));
			 tics.add(tic);
		 }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return tics;
	}
}
