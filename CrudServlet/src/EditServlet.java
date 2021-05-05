

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Update Book Details</title></head><body><center>");
		out.println("<h1>Update Book Details</h1>");
		String sid=request.getParameter("id");
		//out.print(sid);
		int id=Integer.parseInt(sid);
		//out.print(id);
		User e=UserDao.getBookById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getBookid()+"'/></td></tr>");
		out.print("<tr><td>Book Name:</td><td><input type='text' name='name' value='"+e.getBookname()+"'/></td></tr>");
		out.print("<tr><td>Aurthor First Name:</td><td><input type='text' name='afn' value='"+e.getAuthfname()+"'/></td></tr>");
		out.print("<tr><td>Aurthor Last Name:</td><td><input type='text' name='aln' value='"+e.getAuthlname()+"'/></td></tr>");
		out.print("<tr><td>Shelf Id:</td><td><input type='text' name='shelfid' value='"+e.getShelfid()+"'/></td></tr>");
		out.print("<tr><td>Qantity:</td><td><input type='text' name='qantity' value='"+e.getQantity()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><center><input type='submit' value='Edit &amp; Save '/></center></td></tr>");
		out.print("</table>");
		out.print("</form></center></body></html>");
		
		out.close();
	}
}
