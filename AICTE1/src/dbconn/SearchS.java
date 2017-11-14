package dbconn;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;

	public class SearchS  extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private PrintWriter out;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        out = response.getWriter();
	        
	       String uidai = request.getParameter("uidai");
	        
	        if(RedundantSt.checkExistenseSt(uidai))
	        {
	          // RequestDispatcher rs = request.getRequestDispatcher("prestudent/detailsstudentsdisplay.html");
	           //rs.forward(request, response);
	        	 
	            
	             
	             response.setContentType("text/html");
	             PrintWriter out = response.getWriter();
	             try{

	                Class.forName("org.postgresql.Driver");


	                Connection con=DriverManager.getConnection
	                               ("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","narutobby");
	                PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE uidai = ?");
	                ps.setString(1, uidai);
	                ResultSet rs =ps.executeQuery();
	                while( rs.next()){
	               	 String Sname= rs.getString("Sname");
	               	 String Instid= rs.getString("Sname");
	               	 out.println("Student name is " +Sname);
	               	 out.println("Institute id is " +Instid);
	               	out.println("<html><head><form metho='post' action='prestudent/deletestu.html'><input type='submit' value='drop out' ></form></head></html>");
	               	 
	                }
	                 
	               
	             }catch(Exception e)
	             {
	                System.out.println(e);
	                e.printStackTrace();
	             }
	                              
	         }
	       
	        
	        else{
	            out.print("Not enrolled yet");
	           
	        }
	       
		}
	}
