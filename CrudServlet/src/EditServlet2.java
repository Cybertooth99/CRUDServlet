

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String afn=request.getParameter("afn");
		String aln=request.getParameter("aln");
		String shelfid=request.getParameter("shelfid");
		String qty=request.getParameter("qantity");
		int qantity=Integer.parseInt(qty);
		
		User e=new User();
		e.setBookid(id);
		e.setBookname(name);
		e.setAuthfname(afn);
		e.setAuthlname(aln);
		e.setShelfid(shelfid);
		e.setQantity(qantity);
		
		int status=UserDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
