package easyBus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import easyBus.connection.ConnectionManager;
import easyBus.model.Admin;

public class AdminDAO {

	static int adminID;
	String adminName;
	static String adminIC;
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	public static Admin login(Admin bean){
		 //get email and password
		adminID = bean.getAdminID();
		adminIC = bean.getAdminIC();

		 String query = "select * from admin where adminID='" + adminID + "' AND adminIC='" + adminIC + "'";
		 try {
			 con = ConnectionManager.getConnection();
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(query);
			 boolean more = rs.next();
			 // if user exists set the isValid variable to true
			 if (more) {
				 int adminID = rs.getInt("adminID");
				 String adminName = rs.getString("adminName");
				 bean.setAdminID(adminID);
				 bean.setAdminName(adminName);
				 bean.setValid(true);
			 }
			 // if user does not exist set the isValid variable to false
			 else if (!more) {
				 bean.setValid(false);
			 }

		 } catch (SQLException e) {
		 e.printStackTrace();
		 }

		 return bean;
		}
}
