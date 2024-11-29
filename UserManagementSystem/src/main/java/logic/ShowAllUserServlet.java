package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowAllUsersServlet
 */
@WebServlet("/Users")
public class ShowAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.getAttribute("email");
		session.getAttribute("pass");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    String email = (String) session.getAttribute("email");
		out.print("<strong><em>Welcome,"+email+"</em></strong><br>");
		out.print("<table border = 1><tr><td>ID</td><td>Name</td><td>Username</td><td>Password</td><td>Delete Users</td></tr>");
        List<User> user = UserDAO.getAllUsersDetails();

        for (User users : user) {
            out.print("<tr>");
            out.print("<td>" + users.getUserId() + "</td>");
            out.print("<td>" +users.getName()+"</td>");
            out.print("<td>" + users.getUsername() + "</td>");
            out.print("<td>" + users.getPassword() + "</td>");
            out.print("<td><a href=DeleteUser?id="+users.getUserId()+">Delete</a></td>");
            out.print("</tr>");
        }
//        System.out.println(users);
        out.print("</table>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}