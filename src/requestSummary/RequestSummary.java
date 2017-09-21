package requestSummary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestSummary
 */
@WebServlet("/Labs/RequestSummary")
public class RequestSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ArrayList<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<title>Request Summary</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<div class = \"container\">");
		out.println("<h1 class = \"page-header\">Request Summary <small>Lab 2</small></h1>");
		out.println("The following "+ request.getMethod() + " request was made on " + new java.util.Date());
		
		out.println("<h3>Request Parameters</h3>");
		//Request Parameters
		out.println("<table class = \"table\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Parameter Name</th>");
		out.println("<th>Parameter Value</th>");
		out.println("</tr>");
		out.println("</thead>");
		
		for(int i = 0; i < parameterNames.size(); i++) {
			String[] values = request.getParameterValues(parameterNames.get(i));
			out.println("<tr>");
			out.print("<td>" + parameterNames.get(i) + "</td>");
			out.println("<td>");
			for(int j = 0; j < values.length; j++) {
				out.print(values[j] + " ");
			}
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<h3>Header Information</h3>");
		//Header Info
		ArrayList<String> list = Collections.list(request.getHeaderNames());
		
		out.println("<table class = \"table\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Header Field</th>");
		out.println("<th>Header Value</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tr>");

		out.println("</tr>");
		
		
		for(int i = 0; i < list.size(); i++) {
			
			out.println("<tr>");
			out.println("<td>" + list.get(i) + "</td>");
			out.println("<td>" + request.getHeader(list.get(i)) + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
