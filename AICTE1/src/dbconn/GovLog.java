package dbconn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GovLog
 */
@WebServlet("/GovLog")
public class GovLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GovLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		long gov_id =Long.valueOf(request.getParameter("gov_id"));
		String pass = request.getParameter("pass");
		
		if(Chckgov.checkg(gov_id,pass)){
			RequestDispatcher rs = request.getRequestDispatcher("/GovHome.html");
			rs.forward(request, response);
		}
		else{
			request.getRequestDispatcher("govtlogin.html");
			out.println("Invalid id or password");
		}
	}

}
