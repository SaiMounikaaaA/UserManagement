package logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDetailsById
 */
@WebServlet("/UserById")
public class UserDetailsById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String idParam = request.getParameter("id");
        
        // Check if the id parameter is null or empty
        if (idParam == null || idParam.trim().isEmpty()) {
            response.getWriter().println("<html><body><h2>Error: User ID is required.</h2></body></html>");
            return; // Stop further execution if ID is missing
        }
		int userId = Integer.parseInt(idParam);

        // Retrieve user details from the database
        User user = UserDAO.getUserById(userId);

        // Set the response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (user != null) {
            out.println("<h2>User Details</h2>");
            out.println("<form action='updateUserDetails' method='post'>");
            out.println("ID: <input type='text' name='id' value='" + user.getUserId() + "' readonly><br>");
            out.println("Name: <input type='text' name='name' value='" + user.getName() + "'><br>");
            out.println("Username: <input type='text' name='username' value='" + user.getUsername() + "'><br>");
            out.println("Password: <input type='password' name='password' value='" + user.getPassword() + "'><br>");
            out.println("<button type='submit'>Update</button>");
            out.println("</form>");
        } else {
            out.println("<h2>User not found</h2>");
        }
    }
	}
