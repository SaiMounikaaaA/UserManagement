package logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetUserById
 */
@WebServlet("/GetUserById")
public class GetUserById extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.print("<form action='UserDetailsServlet'>");
out.print("<b>ID :</b><input type='text' placeholder='Enter ID' name='id'>");
// out.print("<input type='submit' value='Submit'>");
out.print("</form>");
}

}