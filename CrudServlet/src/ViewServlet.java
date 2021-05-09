

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>View All Books</title></head><body>");
		out.println("<center><h1>Book List</h1>");
		//out.println("<a href='index.html'>Add a New Book</a><br/><br/>");
		List<User> list=UserDao.getAllBooks();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Book Id</th><th>Book Name</th><th>Aurthor First Name</th><th>Aurthor Last Name</th><th>Shelf Id</th><th>Qantity</th><th>Edit</th><th>Delete</th></tr>");
		for(User e:list){
			out.print("<tr><td>"+e.getBookid()+"</td><td>"+e.getBookname()+"</td><td>"+e.getAuthfname()+"</td><td>"+e.getAuthfname()+
					"</td><td>"+e.getShelfid()+"</td><td>"+e.getQantity()+"</td><td><a href='EditServlet?id="+e.getBookid()+
					"'>Edit</a></td><td><a href='DeleteServlet?id="+e.getBookid()+"'>Delete</a></td></tr>");
		}
		out.print("</table><br/><br/><a href=\"book_home.html\">Back</a></center></body></html>");
		
		out.close();
	}
}
