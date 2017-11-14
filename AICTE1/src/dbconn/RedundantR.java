package dbconn;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

	public class RedundantR  extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private PrintWriter out;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        out = response.getWriter();
	        
	        String inst_id = request.getParameter("inst_id");
	        
	        if(Redundant.checkExistense(inst_id))
	        {
	           RequestDispatcher rs = request.getRequestDispatcher("error.html");
	           rs.forward(request, response);
	        }
	        else
	        {
	        
	        	RequestDispatcher rs = request.getRequestDispatcher("forms/College.html");
		        rs.include(request, response);
	        }
	       
		}
	}

