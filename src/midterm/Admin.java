package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Midterm/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<title>Administrator</title>");
		out.println("</head>");
		out.println("<body><div class=\"container\">");

		out.println("<h1>Tutor Directory Admin Page</h1>");
		
		out.println( "<table border='1' class = \"table\">" );
		out.println( "<tr><th>First Name</th><th>Last Name</th><th>Courses</th><th><br></th></tr>" );
		for(Tutor tutor : tutors ) {
			String[] courses = tutor.getCourses();
			out.print( "<tr><td>" + tutor.getName() + "</td><td>"
					+ tutor.getEmail() + "</td><td>");
			for(String course : courses) {
				out.print(course + " ");
			}
			out.println("</td><td><a href='DeleteTutor?email=" + tutor.getEmail()
			+ "'>Delete</a>");
			out.print("</td></tr>");
		}
		out.println( "</table>" );
		
		out.println("<p><a href='Home'>Admin Log-out</a></p>");
		out.println("</div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
