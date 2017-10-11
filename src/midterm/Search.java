package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.GuestBookEntry;


/**
 * Servlet implementation class Home
 */
@WebServlet("/Midterm/Home")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init (ServletConfig config) throws ServletException{
		super.init(config);

		ArrayList<Tutor> tutors = new ArrayList<Tutor>();
		tutors.add(new Tutor("John", "Smith", "john@smith.com", new String[] {"2011", "2012"}));
		tutors.add(new Tutor("Reggie", "Gonzolez","reg@gon.com", new String[] {"2013", "3220"}));
		tutors.add(new Tutor("Jonathan", "Sanchez", "jon@sanchez.com", new String[] {"2011"}));
		tutors.add(new Tutor("David", "Parker", "david@parker.com", new String[] {"2011", "2012", "2013"}));
		tutors.add(new Tutor("Marcus", "Jones", "marcus@jones.com", new String[] {"2011", "2012", "2013", "3220"}));

		getServletContext().setAttribute("tutors", tutors);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
		boolean isSearch = false;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<title>CSULA Computer Science Tutor Directory</title>");
		out.println("</head>");
		out.println("<body><div class=\"container\">");

		out.println("<h1>Tutor Directory Home</h1>");
		out.println("<form action = \"Home\" method = \"GET\">");
		out.println("<input type = \"text\" name = \"query\" placeholder=\"Search\">");
		out.println("<input class=\"btn btn-primary\" type=\"submit\" value=\"Search\"");
		out.println("</form>");

		if(request.getParameterValues("query") != null) {
			isSearch = true;
			if(request.getParameterValues("query")[0].equals("")) {
				isSearch = false;
			}
		}

		printTable(request, response, isSearch, tutors);
		
		out.println("<p><a href='AddTutor'>Register As A Tutor</a></p>");
		out.println("<p><a href='Admin'>Admin Log-in</a></p>");

		out.println("</div></body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void printTable(HttpServletRequest request, HttpServletResponse response, boolean isSearch,  ArrayList<Tutor> tutors) throws IOException {
		PrintWriter out = response.getWriter();

		out.println( "<table border='1' class = \"table\">" );
		out.println( "<tr><th>First Name</th><th>Last Name</th><th>Courses</th></tr>" );
		if(!isSearch) {
			for(Tutor tutor : tutors ) {
				String[] courses = tutor.getCourses();
				out.print( "<tr><td>" + tutor.getName() + "</td><td>"
						+ tutor.getEmail() + "</td><td>");
				for(String course : courses) {
					out.print(course + " ");
				}
				out.print("</td></tr>");
			}
		}
		else {
			for(Tutor tutor : tutors) {				
				if(tutor.getName().toLowerCase().contains(request.getParameterValues("query")[0].toLowerCase()) || 
						tutor.getEmail().toLowerCase().contains(request.getParameterValues("query")[0].toLowerCase()) ||
						Arrays.asList(tutor.getCourses()).contains(request.getParameterValues("query")[0]))
				{
					String[] courses = tutor.getCourses();
					out.print( "<tr><td>" + tutor.getName() + "</td><td>"
							+ tutor.getEmail() + "</td><td>");
					for(String course : courses) {
						out.print(course + " ");
					}
					out.print("</td></tr>");
				}
			}
		}
		out.println( "</table>" );
	}
}
