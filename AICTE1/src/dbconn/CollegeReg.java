 package dbconn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CollegeReg extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String connectionURL = "jdbc:postgresql://127.0.0.1:5432/AICTE";
		Connection connection = null;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String inst_name = req.getParameter("inst_name");
		String password = req.getParameter("password");
		String inst_id = req.getParameter("inst_id");
		String State =req.getParameter("State");
		String Zip_Code = req.getParameter("Zip_Code");
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(connectionURL, "postgres", "narutobby");
			PreparedStatement pst = connection.prepareStatement("INSERT into institution VALUES(?,?,?,?,?)");
			
			pst.setString(1,  inst_name);
			pst.setString(2,  password);
			pst.setString(3,  inst_id);
			pst.setString(4,  State);
			pst.setString(5,  Zip_Code);
			int numRowsChanged = pst.executeUpdate();
			if (numRowsChanged != 0) {
				out.println("<br>Record has been inserted");
			} else {
				out.println("failed to insert the data");
			}
			pst.close();
		} catch (ClassNotFoundException e) {
			out.println("Couldn't load database driver: " + e.getMessage());
		} catch (SQLException e) {
			out.println("SQLException caught: " + e.getMessage());
		} catch (Exception e) {
			out.println(e);
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException ignored) {
				out.println(ignored);
			}
		}

	}
	public void doGet(){
		
	}

	
}