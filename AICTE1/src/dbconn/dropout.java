package dbconn;
import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class dropout extends HttpServlet {
		private static final long serialVersionUID = 1L;
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
		}
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String connectionURL = "jdbc:postgresql://127.0.0.1:5432/AICTE";
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			try {
				Class.forName("org.postgresql.Driver");
				Connection c = DriverManager.getConnection(connectionURL, "postgres", "narutobby");
				Statement pst = c.createStatement();
			    String sql;	
			    sql= "Select ((SELECT COUNT(*) FROM student FULL OUTER JOIN bank ON student.uidai = bank.uidai where pstatus IS NULL)+(SELECT distinct COUNT(*) FROM dropoutcount))";
			    ResultSet rs = pst.executeQuery(sql);
		         while(rs.next()){
		        	long ty = rs.getLong("?column?");    
		            out.println("<html><head><title>Drop Out rate</title></head>");
					out.println("<body bgcolor=blue >");
					out.println("<center><bold><font size=26><color:red> ");
					out.println("STUDENT DROP OUTS<BR>");
		            out.println("<li>NUMBER OF STUDENTS DROPED OUT " +ty+ "");
		            out.println("</li></color></font></bold><br></center></body></html>");
		         }
		         rs.close();
		         pst.close();
		         c.close();
		       } catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		       }
		       System.out.println("Operation done successfully");
		     }
		}