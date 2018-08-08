package servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servletapp.Crud;
/**
 * Servlet implementation class ListAll
 */
@WebServlet(name = "ListAll",
urlPatterns = {"/ListAll"})
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("HomePage");

			
		}
		else {

		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body align=\"center\">");
		Crud.listAllPlayers(out);
	
		out.println("<br> <br> <a href=\"createplayer.html\">Create Player</a>");
		out.println("<a href=\"retrieveplayer.html\">Retrieve Player</a>");
		out.println("<a href=\"deleteplayer.html\">Delete Player</a>");
		out.println("<a href=\"updateplayer.html\">Update Player</a>");
	
		
		out.println("</body></html>");
	}
	}
}
