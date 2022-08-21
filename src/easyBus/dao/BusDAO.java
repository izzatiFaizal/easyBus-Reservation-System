package easyBus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import easyBus.connection.ConnectionManager;
import easyBus.model.Bus;
import easyBus.model.Route;

public class BusDAO {

	String plateNo, busName;
	int busID, routeID, ticketNo;
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public void addBus(Bus bean){
		//get values
		plateNo = bean.getPlateNo();
		busName = bean.getBusName();
		routeID = bean.getRouteID();
		ticketNo = bean.getTicketNo();
		
		try {
			//step 2: create connection
			con = ConnectionManager.getConnection();
			//step3 : create statement - using preparedStatement
			ps=con.prepareStatement("INSERT INTO buses (plateNo, busName, routeID, ticketNo) VALUES (?,?,?,?)");

			ps.setString(1,plateNo);
			ps.setString(2,busName);
			ps.setInt(3,routeID);
			ps.setInt(4,ticketNo);
			//step 4: execute statement
			ps.executeUpdate();
			//step 5: close connection
			con.close();
		}
		
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
	}
	
	//delete bus
	public void deleteBus(int busID) {
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("delete from buses where busID=?");
			ps.setInt(1, busID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Bus getBusById(int busID) {
		
		Bus bus = new Bus();
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from buses where busID=?");
	
			ps.setInt(1, busID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bus.setBusID(rs.getInt("busID"));
				bus.setPlateNo(rs.getString("plateNo"));
				bus.setBusName(rs.getString("busName"));
				bus.setRouteID(rs.getInt("routeID"));
				bus.setTicketNo(rs.getInt("ticketNo"));
			}
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return bus;
	}
	
	public void updateBus(Bus bean) {
		busID = bean.getBusID();
		plateNo = bean.getPlateNo();
		busName = bean.getBusName();
		routeID = bean.getRouteID();
		ticketNo = bean.getTicketNo();
		
		String searchQuery = "UPDATE buses SET plateNo= '" + plateNo + "', busName='" +
		busName + "', routeID='" + routeID + "', ticketNo='" + ticketNo + "' WHERE busID= '" + busID + "'";
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(searchQuery);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
