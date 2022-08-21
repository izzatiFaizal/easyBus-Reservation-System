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

public class RouteDAO {

	String fromWhere, toWhere;
	int routeID;
	double ticketPrice;
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public void addRoute(Route bean){
		//get values
		fromWhere = bean.getFromWhere();
		toWhere = bean.getToWhere();
		ticketPrice = bean.getTicketPrice();
		
		try {
			//step 2: create connection
			con = ConnectionManager.getConnection();
			//step3 : create statement - using preparedStatement
			ps=con.prepareStatement("INSERT INTO routes (fromWhere, toWhere, ticketPrice) VALUES (?,?,?)");

			ps.setString(1,fromWhere);
			ps.setString(2,toWhere);
			ps.setDouble(3,ticketPrice);
			//step 4: execute statement
			ps.executeUpdate();
			//step 5: close connection
			con.close();
		}
		
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
	}
	
	public static List<Route> getAllRoute() {
		List<Route> rts = new ArrayList<Route>();
		
		try {
		 con = ConnectionManager.getConnection();
		 stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("select * from routes order by routeID");
		 
		 while (rs.next()) {
			 Route route = new Route();
			 route.setRouteID(rs.getInt("routeID"));
			 route.setFromWhere(rs.getString("fromWhere"));
			 route.setToWhere(rs.getString("toWhere"));
			 route.setTicketPrice(rs.getDouble("ticketPrice"));
			 rts.add(route);
		 }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return rts;
	}
	
	//delete route
	public void deleteRoute(int routeID) {
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("delete from routes where routeID=?");
			ps.setInt(1, routeID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Route getRouteById(int routeID) {
		
		Route route = new Route();
		
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from routes where routeID=?");
	
			ps.setInt(1, routeID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				route.setRouteID(rs.getInt("routeID"));
				route.setFromWhere(rs.getString("fromWhere"));
				route.setToWhere(rs.getString("toWhere"));
				route.setTicketPrice(rs.getDouble("ticketPrice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return route;
	}
	
	public void updateRoute(Route bean) {
		routeID = bean.getRouteID();
		fromWhere = bean.getFromWhere();
		toWhere = bean.getToWhere();
		ticketPrice = bean.getTicketPrice();
		
		String searchQuery = "UPDATE routes SET fromWhere='" + fromWhere + "', toWhere='" + toWhere + "', ticketPrice='" + ticketPrice + "' WHERE routeID= '" + routeID + "'";

		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(searchQuery);
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public static List<Route> getRouteId() {
		List<Route> rts = new ArrayList<Route>();
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select routeID, fromWhere, toWhere FROM routes where routeID=?");

			while (rs.next()) {
				Route route = new Route();
				route.setRouteID(rs.getInt("routeID"));
				route.setFromWhere(rs.getString("fromWhere"));
				route.setToWhere(rs.getString("toWhere"));
				route.setTicketPrice(rs.getDouble("ticketPrice"));
				rts.add(route);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rts;
	}
}
