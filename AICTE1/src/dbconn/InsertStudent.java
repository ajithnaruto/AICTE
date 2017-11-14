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

public class InsertStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String connectionURL = "jdbc:postgresql://127.0.0.1:5432/AICTE";
		Connection connection = null;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String sname = req.getParameter("sname");
		long instid = Long.valueOf(req.getParameter("instid"));
		long uidai = Long.valueOf(req.getParameter("uidai"));
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String mail = req.getParameter("mail");
		long contact_no = Long.valueOf(req.getParameter("contact_no"));
		String year_passed_out = req.getParameter("year_passed_out");
		String enrolled = req.getParameter("enrolled");
		long reg_no = Long.valueOf(req.getParameter("reg_no"));
		String level = req.getParameter("level");

		try {

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(connectionURL, "postgres", "narutobby");
			PreparedStatement pst = connection.prepareStatement("INSERT into student VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, sname);
			pst.setLong(2, instid);
			pst.setLong(3, uidai);
			pst.setString(9, dob);
			pst.setString(4, gender);
			pst.setString(5, mail);
			pst.setLong(6, contact_no);
			pst.setString(7, year_passed_out);
			pst.setString(8, enrolled);
			pst.setLong(10, reg_no);
			pst.setString(11, level);

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