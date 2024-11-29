package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDetailsServlet
 */
@WebServlet("/UserDetailsServlet")
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		int id = Integer.parseInt(request.getParameter("userId"));
		PrintWriter out = response.getWriter();
		
		UserDAO userdao = new UserDAO();
		List<User> ul = UserDAO.getAllUsersDetails();
		User u = UserDAO.getUserById(id);
		if (u != null) {
			out.print("<div style='float:center;'>");
			
			out.print("<table border=1><tr><th>UserId</th><th>Name</th><th>Email</th><th>Password</th></tr>");
			out.print("<tr>");
			out.print("<td>" + u.getUserId() + "</td>");
			out.print("<td>" + u.getName() + "</td>");
			out.print("<td>" + u.getUsername() + "</td>");
			out.print("<td>" + u.getPassword() + "</td>");
			out.print("</tr>");
			out.print("</table>");
			out.print("</div >");
		}else {
			out.print("<i>User doesn,t exit with this Id</i>");
		}
	}
	}