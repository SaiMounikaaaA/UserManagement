package logic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("Name");
        String username = request.getParameter("email");
        String password = request.getParameter("pass");
//        response.getWriter().print(id);
//        response.getWriter().print(name);
//        response.getWriter().print(username);
//        response.getWriter().print(password);

        // Create a new User object
        //User user = new User(id,name, username, password);

        // Save the user in the database
        boolean result = UserDAO.addUser(id, name, username, password);

        if (result) {
            response.getWriter().println("Registration successful!");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
        } else {
            response.getWriter().println("Registration failed.");
        }
    }
	
}