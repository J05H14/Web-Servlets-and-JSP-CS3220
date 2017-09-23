package guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DeleteComment()
    {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute(
            "entries" );
        for( GuestBookEntry entry : entries )
            if( entry.getId().equals( id ) )
            {
                entries.remove( entry );
                break;
            }

        response.sendRedirect( "GuestBook" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
