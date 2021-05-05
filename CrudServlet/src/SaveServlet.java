import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String afn=request.getParameter("afn");
		String aln=request.getParameter("aln");
		String shelfid=request.getParameter("shelfid");
		String qty=request.getParameter("qantity");
		int qantity=Integer.parseInt(qty);
		
		User e=new User();
		//e.setBookid(id);
		e.setBookname(name);
		e.setAuthfname(afn);
		e.setAuthlname(aln);
		e.setShelfid(shelfid);
		e.setQantity(qantity);
		
		int status=UserDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
