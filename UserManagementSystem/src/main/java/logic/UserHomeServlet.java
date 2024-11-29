package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserHomeServlet
 */
@WebServlet("/UserHome")
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		out.print("<strong><em>Welcome,"+email+"</em></strong><br>");
		
	    User u = UserDAO.getUserByEmail(email, password);
	    out.print("<form action='EditServlet'>");
		out.print("<b>ID :</b><input type='text' name='id' value='"+u.getUserId()+"'><br>");
		out.print("<b>Name :</b><input type='text' name='name' value='"+u.getName()+"'><br>");
		out.print("<b>Username :</b><input type='text' name='email' value='"+u.getUsername()+"'><br>");
		out.print("<b>Password :</b><input type='text' name='pass' value='"+u.getPassword()+"'><br>");
		out.print("<input type='submit' value='Edit details'>");
        out.print("</form>");
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}