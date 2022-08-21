package easyBus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import easyBus.connection.ConnectionManager;
import easyBus.model.Passenger;

public class PassengerDAO {

	static String email, password;
	String  name, ICNumber, phoneNo, confirmPw;
	int passID;
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public static Passenger login(Passenger bean){
		//get email and password
		email = bean.getEmail();
		password = bean.getPassword();
		
		String query = "select * from passenger where email='" + email + "' AND password='" + password + "'";
		
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			boolean more = rs.next();
			// if user exists set the isValid variable to true
			if (more) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String ICNumber = rs.getString("ICNumber");
				String phoneNo = rs.getString("phoneNo");
				int passID = rs.getInt("passID");
				bean.setEmail(email);
				bean.setName(name);
				bean.setICNumber(ICNumber);
				bean.setPhoneNo(phoneNo);
				bean.setPassID(passID);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		return bean;
	}
	
	//add new passenger (register)
	public void add(Passenger bean){
		
		email = bean.getEmail();
		name = bean.getName();
		ICNumber = bean.getICNumber();
		phoneNo = bean.getPhoneNo();
		password = bean.getPassword();
		confirmPw = bean.getConfirmPw();
		
		try {
			//create connection
			con = ConnectionManager.getConnection();
			//create statement
			ps=con.prepareStatement("insert into passenger(email,name,ICNumber,phoneNo,password,confirmPw)values(?,?,?,?,?,?)");
			ps.setString(1,email);
			ps.setString(2,name);
			ps.setString(3,ICNumber);
			ps.setString(4,phoneNo);
			ps.setString(5,password);
			ps.setString(6,confirmPw);
			//execute statement
			ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public static Passenger getPassenger(Passenger bean) {
		//get email
		email = bean.getEmail();
		
		String searchQuery = "select * from passenger where email='" + email + "'";
		
		try {
			//create connection
			con = ConnectionManager.getConnection();
			//create statement
			stmt = con.createStatement();
			//execute statement
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			// if user exists set the isValid variable to true
			if (more) {
				String email = rs.getString("email");
				bean.setEmail(email);
				String name = rs.getString("name");
				bean.setName(name);
				String ICNumber = rs.getString("ICNumber");
				bean.setICNumber(ICNumber);
				String phoneNo = rs.getString("phoneNo");
				bean.setPhoneNo(phoneNo);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
