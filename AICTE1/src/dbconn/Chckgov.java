package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Chckgov {
	public static boolean checkg(long gov_id,String pass){
		boolean st = false;
		try{
			Class.forName("org.postgresql.Driver");
			Connection con =DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","narutobby");
			PreparedStatement ps = con.prepareStatement("Select * from govdb where gov_id=? and pass=?");
			ps.setLong(1, gov_id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
			
			}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return st;
	}

}
