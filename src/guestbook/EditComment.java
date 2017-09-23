package guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditComment")
public class EditComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditComment()
    {
        super();
    }

    /**
     * Given an id, retrieve the GuestBookEntry.
     */
    @SuppressWarnings("unchecked")
    private GuestBookEntry getEntry( Integer id )
    {
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute(
            "entries" );

        for( GuestBookEntry entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        GuestBookEntry entry = getEntry( id );

        // form display
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Edit Comment</title></head><body>" );

        out.println( "<form action='EditComment' method='post'>" );
        out.println( "Name: <input type='text' name='name' value='"
            + entry.getName() + "' /> <br />" );
        out.println( "<textarea name='message'>" + entry.getMessage()
            + "</textarea> <br />" );
        // hidden form field
        out.println( "<input type='hidden' name='id' value='" + id
            + "' /> <br />" );
        out.println( "<input type='submit' name='save' value='Save' /><br />" );
        out.println( "</form>" );

        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        GuestBookEntry entry = getEntry( id );

        // change the entry based on user input
        entry.setName( request.getParameter( "name" ) );
        entry.setMessage( request.getParameter( "message" ) );

        // send the user back to the guest book page
        response.sendRedirect( "GuestBook" );
    }

}
