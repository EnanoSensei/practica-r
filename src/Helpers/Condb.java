package Helpers;

import java.sql.*;

public class Condb {
	
	
	public static Connection crearCon() {
		
		try {
			Connection con = null;
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
					"jdbc:postgresql://ec2-34-200-72-77.compute-1.amazonaws.com:5432/d7i4qms2hf866f",
					"vaccedvsxhxegz",
					"4caef7be3a30dcaadcb99fa9125d20c8d2802e67a180b6e7845794d84221298a");
			return con;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
}
