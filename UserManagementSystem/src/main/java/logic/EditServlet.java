package logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.setContentType("text/html");
int id = Integer.parseInt(request.getParameter("userId"));
String name = request.getParameter("name");
String username = request.getParameter("email");
String password = request.getParameter("pass");
PrintWriter out = response.getWriter();

boolean u = UserDAO.updateUsers(id,name,username, password);

if(u) {
out.print("<h3>Updated Succesfully</h3>");
}else{
out.print("<h3>Not Updated</h3>");
}

}


}