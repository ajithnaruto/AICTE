package dbconn;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;

	public class Search  extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private PrintWriter out;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        out = response.getWriter();
	        
	       long uidai = Long.valueOf(request.getParameter("uidai"));
	        
	        if(Redundant1.checkExistense1(uidai))
	        {
	          // RequestDispatcher rs = request.getRequestDispatcher("Prestaff/detailsdisplay.html");
	          // rs.forward(request, response);
	           response.setContentType("text/html");
	             PrintWriter out = response.getWriter();
	             try{

	                Class.forName("org.postgresql.Driver");


	                Connection con=DriverManager.getConnection
	                               ("jdbc:postgresql://127.0.0.1:5432/AICTE","postgres","narutobby");
	                PreparedStatement ps = con.prepareStatement("SELECT * FROM staff WHERE uidai = ?");
	                ps.setLong(1, uidai);
	                ResultSet rs =ps.executeQuery();
	                while( rs.next()){
	               	 String Staff_Name= rs.getString("Staff_Name");
	               	 String Institution_Name= rs.getString("Institution_Name");
	               	 out.println("Faculty Name is " +Staff_Name);
	               	 out.println("Institute name is " +Institution_Name);
	               	 out.println("");
	                }
	                out.println("To Remove this faculty from your Database click here");
	                out.println("<html><body><form action='Prestaff/delete.html'><input type='submit' value='submit'/></form></body></html>");
	                 
	               
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
