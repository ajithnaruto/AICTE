package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Redundant1 {
	 public static boolean checkExistense1(long uidai) 
     {
      boolean st =true;
      try{

         Class.forName("org.postgresql.Driver");


         Connection con=DriverManager.getConnection
                        ("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","narutobby");
         PreparedStatement ps = con.prepareStatement("SELECT * FROM staff WHERE uidai = ?");
         ps.setLong(1, uidai);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
         System.out.println(e);
         e.printStackTrace();
      }
      return st;                 
  }
}

