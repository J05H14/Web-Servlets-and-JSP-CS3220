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
 * Servlet implementation class Tutor
 */
@WebServlet("/Midterm/AddTutor")
public class AddTutor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<title>Register Tutor</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>Tutor Registration</h1>");
		
		out.println("<form action=\"AddTutor\" method=\"POST\">\r\n");

		String fnameError = (String) request.getAttribute("fnameError");
		if(fnameError != null) {
			out.println("<p class=\"text-danger\">" + fnameError + "</p>");
		}
		String fname = (String) request.getAttribute("fname");

		if(fname != null) {
			out.println("First Name: <strong>" + fname + "</strong><br>");
		}
		else {
			fname = request.getParameter("fname");
			if(fname == null) {
				fname = "";
			}
			out.println("First Name: <input type=\"text\" name=\"fname\" value=\"" + fname + "\"><br>");
			
		}

		String lnameError = (String) request.getAttribute("lnameError");
		if(lnameError != null) {
			out.println("<p class=\"text-danger\">" + lnameError + "</p>");
		}
		String lname = (String) request.getAttribute("lname");

		if(lname != null) {
			out.println("First Name: <strong>" + lname + "</strong><br>");
		}
		else {
			lname = request.getParameter("lname");
			if(lname == null) {
				lname = "";
			}
			out.println("Last Name: <input type=\"text\" name=\"lname\" value=\"" + lname + "\"><br>");
		}

		String emailError = (String) request.getAttribute("emailError");
		if(emailError != null) {
			out.println("<p class=\"text-danger\">" + emailError + "</p>");
		}
		String email = (String) request.getAttribute("email");

		if(email != null) {
			out.println("E-Mail: <strong>" + email + "</strong><br>");
		}
		else {
			email = request.getParameter("email");
			if(email == null) {
				email = "";
			}
			out.println("E-Mail: <input type=\"email\" name=\"email\" value=\"" + email + "\"><br>");
		}

		String checkboxError = (String) request.getAttribute("checkboxError");
		if(checkboxError != null) {
			out.println("<p class=\"text-danger\">" + checkboxError + "</p>");
		}
		String[] courses = (String[]) request.getAttribute("courses");
		if(courses != null) {
			out.print("Courses: <strong>");
			for(String course : courses) {
				out.print(course + " ");
			}
			out.print("</strong><br>");
		}
		else {
			courses = request.getParameterValues("courses");
			out.println("Courses to Tutor<ul>\r\n" + 
					"            <li>\r\n" + 
					"                <input type=\"checkbox\" name=\"courses\" value=\"2011\">\r\n" + 
					"                CS 2011\r\n" + 
					"            </li>\r\n" + 
					"            <li>\r\n" + 
					"                <input type=\"checkbox\" name=\"courses\" value=\"2012\">\r\n" + 
					"                CS 2012\r\n" + 
					"            </li>\r\n" + 
					"            <li>\r\n" + 
					"                <input type=\"checkbox\" name=\"courses\" value=\"2013\">\r\n" + 
					"                CS 2013\r\n" + 
					"            </li>\r\n" + 
					"            <li>\r\n" + 
					"                <input type=\"checkbox\" name=\"courses\" value=\"3220\">\r\n" + 
					"                CS 3220\r\n" + 
					"            </li>\r\n" + 
					"        </ul>");
		}
		
		out.println("<input class=\"btn btn-primary\" type=\"submit\" value=\"Sign-Up\">");

		out.println("</body>");
		out.println("</html>");

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String[] courses = request.getParameterValues("courses");
		
		boolean isFnameError = firstName == null || firstName.trim().length() == 0;
		boolean isLnameError = lastName == null || lastName.trim().length() == 0;
		boolean isEmailError = email == null || email.trim().length() == 0;
		boolean isCheckboxError = courses == null;

		if(!isFnameError && !isLnameError && !isEmailError && !isCheckboxError) {
			Tutor newTutor = new Tutor(firstName, lastName, email, courses);

			ArrayList<Tutor> tutors = (ArrayList<Tutor>) getServletContext().getAttribute("tutors");
			tutors.add(newTutor);

			response.sendRedirect("Home");
		}
		if(isFnameError) {
			request.setAttribute("fnameError", "You must enter your First name");
		}
		if(isLnameError) {
			request.setAttribute("lnameError", "You must enter your Last name");
		}
		if(isEmailError) {
			request.setAttribute("emailError", "You must enter your E-Mail");
		}
		if(isCheckboxError) {
			request.setAttribute("checkboxError", "You must check at least ONE box");
		}
		doGet(request, response);
	}

}
