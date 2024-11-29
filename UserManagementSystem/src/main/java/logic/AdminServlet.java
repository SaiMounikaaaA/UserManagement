package logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminHome")
public class AdminServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.setContentType("text/html");

String email = request.getParameter("email");

PrintWriter out = response.getWriter();
out.print("<strong><em>Welcome,"+email+"</em></strong>");
out.print("<div style='text-align:center'><h1>Admin Home</h1>");
out.print("<a href='Users'>Show All Users Details</a><br>");
out.print("<a href='GetUserById'>Show User Details By ID</a></div>");
}

}