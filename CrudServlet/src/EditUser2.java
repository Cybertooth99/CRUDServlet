import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditUser2")
public class EditUser2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		String acctype=request.getParameter("acctype");
		
		User e=new User();
		e.setUserid(id);
		e.setUsername(name);
		e.setPassword(pass);
		e.setAcctype(acctype);
		
		int status=UserDao.updateUser(e);
		if(status>0){
			response.sendRedirect("Viewuser");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}