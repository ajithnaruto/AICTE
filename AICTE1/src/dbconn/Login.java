package dbconn;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String inst_id = request.getParameter("inst_id");
		String password = request.getParameter("password");
		 if(Validate.checkUser(inst_id , password)) {
			out.print("Welcome, " + inst_id);
			HttpSession session = request.getSession(true); // reuse existing
															// session if exist
															// or create one
			session.setAttribute("inst_id", inst_id);
			session.setMaxInactiveInterval(30); // 30 seconds
			response.sendRedirect("dashboard.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("institution.html");
			out.println("<font color=red>Either Institution_ID or password is wrong.</font>");
			rd.include(request, response);
		} 
	}
}