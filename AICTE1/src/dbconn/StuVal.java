package dbconn;
import java.sql.*;

public class StuVal
 {
     public static boolean checkUser(String uidai,long reg_no) 
     {
      boolean st =false;
      try{

         Class.forName("org.postgresql.Driver");


         Connection con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","narutobby");
         PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE uidai=? and reg_no=?");
         ps.setString(1, uidai);
         ps.setLong(2, reg_no);
         
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