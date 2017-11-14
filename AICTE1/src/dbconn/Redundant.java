package dbconn;
import java.sql.*;

public class Redundant
 {
     public static boolean checkExistense(String inst_id) 
     {
      boolean st =false;
      try{

         Class.forName("org.postgresql.Driver");


         Connection con=DriverManager.getConnection
                        ("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","narutobby");
         PreparedStatement ps = con.prepareStatement("SELECT * FROM institution WHERE inst_id=?");
         ps.setString(1, inst_id);
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