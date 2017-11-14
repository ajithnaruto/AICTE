package dbconn;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;

public class stulogin extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(" uidai:"+request.getParameter("uidai"));
        System.out.println("reg_no:"+request.getParameter("reg_no"));
        
        String uidai = request.getParameter("uidai");
        long reg_no = Long.valueOf(request.getParameter("reg_no"));
      
        if(StuVal.checkUser(uidai,reg_no))
        {        	
        	RequestDispatcher rs = request.getRequestDispatcher("otpverification/entermob.jsp");
        	rs.forward(request, response);
            HttpSession session=request.getSession(); 
            session.setAttribute("uidai",uidai);  
        }
        else
        {
           System.out.println("uidai or reg_no incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("StuLogin.html");
           rs.include(request, response);
        }
    }  
	}