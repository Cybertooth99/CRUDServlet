import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Update User Details</title></head><body><center>");
		out.println("<h1>Update User Details</h1>");
		String sid=request.getParameter("id");
		//out.print(sid);
		int id=Integer.parseInt(sid);
		//out.print(id);
		User e=UserDao.getUserById(id);
		
		out.print("<form action='EditUser2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getUserid()+"'/></td></tr>");
		out.print("<tr><td>Username:</td><td><input type='text' name='username' value='"+e.getUsername()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Account Type:</td><td><input type='text' name='acctype' value='"+e.getAcctype()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><center><input type='submit' value='Edit &amp; Save '/></center></td></tr>");
		out.print("</table>");
		out.print("</form></center></body></html>");
		
		out.close();
	}
}