package logic;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyLoginServlet
 */
@WebServlet("/LoginServlet")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
        session.setAttribute("pass", pass); 
		//check if email is admin@myweb.com and pass is admin@123
		if(email.equals("admin@myweb.com") && pass.equals("Admin@123")) {
//			response.getWriter().append("Login Success!");
			//forwarding to  admin home page-2 step process
			//1.create a request dispatcher object
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome");
			//2.forward to that rd object
			rd.forward(request, response);
		}else if(UserDAO.validateUser(email, pass)){
			 RequestDispatcher rd = request.getRequestDispatcher("UserHome");
	            rd.forward(request, response);
		}
		else {
			response.getWriter().append("Login Failed!<br>Try Again...");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
}