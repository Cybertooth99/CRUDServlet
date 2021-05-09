import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Viewuser")
public class Viewuser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>View All Users</title></head><body>");
		out.println("<center><h1>User List</h1>");
		//out.println("<a href='index.html'>Add a New Book</a><br/><br/>");
		List<User> list=UserDao.getAllUsers();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>User Id</th><th>UserName</th><th>Password</th><th>Account type</th><th>Edit</th><th>Delete</th></tr>");
		for(User e:list){
			out.print("<tr><td>"+e.getUserid()+"</td><td>"+e.getUsername()+"</td><td>"+e.getPassword()+"</td><td>"+e.getAcctype()+
					"</td><td><a href='EditUser?id="+e.getUserid()+"'>Edit</a></td><td><a href='DeleteUser?id="+e.getUserid()+
					"'>Delete</a></td></tr>");
		}
		out.print("</table><br/><br/><a href=\"user_home.html\">Back</a></center></body></html>");
		
		out.close();
	}
}
