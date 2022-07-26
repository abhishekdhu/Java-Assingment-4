import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class StudentDAO extends GenericServlet{
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		out.println("<html>");
		out.println("<body>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek","root","Password@123");
			System.out.println(con);
			Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from STUDENTS");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>USN</th><th>NAME</th><th>AGE</th><th>ADDRESS</th><tr>");  
            while (rs.next()) 
            {  
                int n = rs.getInt("USN");  
                String nm = rs.getString("NAME");  
                int s = rs.getInt("AGE");
                String add = rs.getString("ADDRESS");
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>"+ add +"</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();    
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}