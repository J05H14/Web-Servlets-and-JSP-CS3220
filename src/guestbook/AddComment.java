package guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddComment")
public class AddComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    int idSeed = 100;

    public AddComment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // display form
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Add Comment</title></head><body>" );

        out.println( "<form action='AddComment' method='post'>" );
        out.println( "Name: <input type='text' name='name' /> <br />" );
        out.println( "<textarea name='message'></textarea> <br />" );
        out.println( "<input type='submit' name='add' value='Add' /> <br />" );
        out.println( "</form>" );

        out.println( "</body></html>" );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the user input
        String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );

        // create a new guest book entry
        GuestBookEntry entry = new GuestBookEntry( idSeed++, name, message );

        // add the new entry to the guest book
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute(
            "entries" );
        entries.add( entry );

        // send the user back to the guest book page
        response.sendRedirect( "GuestBook" );
    }

}
