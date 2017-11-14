package dbconn;
import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String inst_id,String password) 
     {
      boolean st =false;
      try{

         Class.forName("org.postgresql.Driver");


         Connection con=DriverManager.getConnection
                        ("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","narutobby");
         PreparedStatement ps = con.prepareStatement("SELECT * FROM institution WHERE inst_id=? and password=?");
         ps.setString(1, inst_id);
         ps.setString(2, password);
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