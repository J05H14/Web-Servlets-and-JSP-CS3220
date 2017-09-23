package guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Labs/GuestBook", loadOnStartup = 2)
public class GuestBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GuestBook()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        // create some test data for display
        List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
        entries.add( new GuestBookEntry( 1, "john", "hello" ) );
        entries.add( new GuestBookEntry( 2, "joe", "hi" ) );

        // stored the data somewhere that can be accessed by this servlet
        // and other servlets.
        getServletContext().setAttribute( "entries", entries );
    }

    @SuppressWarnings("unchecked")
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the data
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute(
            "entries" );
        
        boolean isSearch = false;

        // display it
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head>"
        		+ "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n" + 
        		"<title>Guest Book</title></head><body>" );

        out.println("<form action = \"GuestBook\" method = \"GET\">");
        out.println("Search <input type = \"text\" name = \"query\"><br>");
        out.println("<input class=\"btn btn-primary\" type=\"submit\" value=\"Search\">");
        
        out.println("</form>");
                

        
        if(request.getParameterValues("query") != null) {
        	isSearch = true;
            out.println(request.getParameterValues("query")[0]);
        
            if(request.getParameterValues("query")[0].equals("")) {
            	isSearch = false;
            }
        }
        
        out.println(isSearch);
        
        out.println( "<table border='1' class = \"table\">" );
        out.println( "<tr><th>Id</th><th>Name</th><th>Message</th><th><br /></th></tr>" );
        for( GuestBookEntry entry : entries )
        {
            out.println( "<tr><td>" + entry.getId() + "</td><td>"
                + entry.getName() + "</td><td>" + entry.getMessage()
                + "</td><td><a href='EditComment?id=" + entry.getId()
                + "'>Edit</a> <a href='DeleteComment?id=" + entry.getId()
                + "'>Delete</a></td></tr>" );
        }
        out.println( "</table>" );

        out.println( "<p><a href='AddComment'>Add Comment</a></p>" );
        out.println( "<p><a href='AddCommentWithCookie'>Add Comment (with Cookie)</a></p>" );
        out.println( "<p><a href='AddCommentWithSession'>Add Comment (with Session)</a></p>" );

        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
