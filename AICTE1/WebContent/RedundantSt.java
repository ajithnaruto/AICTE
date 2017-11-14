package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RedundantSt {
	 public static boolean checkExistenseSt(String uidai) 
     {
      boolean st =false;
      try{

         Class.forName("org.postgresql.Driver");


         Connection con=DriverManager.getConnection
                        ("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","amba");
         PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE uidai = ?");
         ps.setString(1, uidai);
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
	 