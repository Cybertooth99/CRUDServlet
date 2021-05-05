import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validate")

public class validate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		//System.out.println(name+" "+password);
		User e = new User();
		e.setUsername(name);
		e.setPassword(password);
		
		boolean status = UserDao.auth(e);
		if(status)
		{
			out.println("Login Success.");
			//String usertype = UserDao.userType(e);
			//out.println(usertype);
			//if(usertype == "Admin")
				request.getRequestDispatcher("home.html").include(request, response);
//			else
//				request.getRequestDispatcher("user_home.html").include(request, response);
		}
		else
		{
			out.println("<p>Try Again!</p>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
		
	}	
}
