package dbconn;
   
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String connectionURL = "jdbc:postgresql://127.0.0.1:5432/AICTE";
		Connection connection = null;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String staff_name = req.getParameter("staff_name");
		long uidai = Long.valueOf(req.getParameter("uidai"));
		String gender = req.getParameter("gender");
		String mail_id = req.getParameter("mail_id");
		long acc_no = Long.valueOf(req.getParameter("acc_no"));
		long contact_no = Long.valueOf(req.getParameter("contact_no"));
		long joined_year = Long.valueOf(req.getParameter("joined_year"));
		String type_of_staff = req.getParameter("type_of_staff");
		String institution_name = req.getParameter("institution_name");
		String qualification = req.getParameter("qualification");
		String salary_credited = req.getParameter("salary_credited");
		String dob = req.getParameter("dob");
		
		try {
		
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(connectionURL, "postgres", "kishore");
			PreparedStatement pst = connection.prepareStatement("INSERT into staff VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, staff_name);
			pst.setLong(8,  uidai);
			pst.setString(2, gender);
			pst.setString(3, mail_id);
			pst.setLong(9,  acc_no);
			pst.setLong(10,  contact_no);
			pst.setLong(11,  joined_year);
			pst.setString(4, type_of_staff);
			pst.setString(5	, institution_name);
			pst.setString(6,qualification);
			pst.setString(7,salary_credited);
			pst.setString(12, dob);
		
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

	
}


