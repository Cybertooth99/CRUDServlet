import java.util.*;
import java.sql.*;

public class UserDao {

	public static Connection getConnection(){
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","Admin@2021");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static boolean auth(User e)
	{
		boolean status = false;
		try
		{
			//System.out.println("check1");
			Connection con = UserDao.getConnection();
			//System.out.println("check1");
			PreparedStatement ps = con.prepareStatement("select * from login where email=? and pass=?");
			//ps.setInt(1,e.getUserid());
			ps.setString(1,e.getUsername());  
			ps.setString(2, e.getPassword()); 
			//ps.setString(3,e.getAcctype());
		              
			ResultSet rs=ps.executeQuery();  
			status=rs.next();   
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return status;
	}
//	public static String userType(User e)
//	{
//		String usertype="";
//		try 
//		{
//			Connection con = UserDao.getConnection();
//			PreparedStatement ps = con.prepareStatement("select acc_type from login where email=? and pass=?");
//			ps.setString(1,e.getUsername());  
//			ps.setString(2, e.getPassword()); 
//			ResultSet rs = ps.executeQuery();
//			if(rs.next())
//				usertype=rs.getString(1);
//		}
//		catch(Exception ex){ex.printStackTrace();}
//		
//		return usertype;
//	}
	
	public static int save(User e){
		int status=0;
		try{
			Connection con=UserDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into books(book_name,aurthor_first_name,aurthor_last_name,shelf_id,quantity) values (?,?,?,?,?)");
			//ps.setInt(1,e.getBookid());
			ps.setString(1,e.getBookname());
			ps.setString(2,e.getAuthfname());
			ps.setString(3,e.getAuthlname());
			ps.setString(4,e.getShelfid());
			ps.setInt(5,e.getQantity());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(User e){
		int status=0;
		try{
			Connection con=UserDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update books set book_name=?,aurthor_first_name=?,aurthor_last_name=?,shelf_id=?, quantity=? where book_id=?");
			//ps.setInt(1,e.getBookid());
			ps.setString(1,e.getBookname());
			ps.setString(2,e.getAuthfname());
			ps.setString(3,e.getAuthlname());
			ps.setString(4,e.getShelfid());
			ps.setInt(5,e.getQantity());
			ps.setInt(6,e.getBookid());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=UserDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from books where book_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static User getBookById(int id){
		User e=new User();
		
		try{
			Connection con=UserDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books where book_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setBookid(rs.getInt(1));
				e.setBookname(rs.getString(2));
				e.setAuthfname(rs.getString(3));
				e.setAuthlname(rs.getString(4));
				e.setShelfid(rs.getString(5));
				e.setQantity(rs.getInt(6));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<User> getAllBooks(){
		List<User> list=new ArrayList<User>();
		
		try{
			Connection con=UserDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User e=new User();
				e.setBookid(rs.getInt(1));
				e.setBookname(rs.getString(2));
				e.setAuthfname(rs.getString(3));
				e.setAuthlname(rs.getString(4));
				e.setShelfid(rs.getString(5));
				e.setQantity(rs.getInt(6));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
