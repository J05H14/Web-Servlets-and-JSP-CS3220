package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Link;

/**
 * Servlet implementation class UpvoteController
 */
@WebServlet("/Final/Upvote")
public class UpvoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpvoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

//    public Link getLink(Integer id) {
//    	List<Link> links = (List<Link>) getServletContext().getAttribute("link");
//    	
//    	for(Link link : links) {
//    		if(link.getId() == id) {
//    			return link;
//    		}
//    	}
//    	return null;
//    }
//    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String parameter = request.getParameter("id");
		boolean isInt = true;
//		for(int i = 0; i < parameter.length(); i++) {
//			if(!(parameter.charAt(i) >= '0' && parameter.charAt(i) <= '9'))
//				isInt = false;
//		}
		if(isInt == false) {
			
		}
			
		else {
			Integer id = Integer.valueOf(request.getParameter("id"));
			//Link link = getLink(id);
			int upvotes = 0;
			System.out.println(id);
			Connection c = null;

			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu72";
				String user="cs3220stu72";
				String password = "EEK!o0m*";

				c = DriverManager.getConnection(url, user, password);
				String sql = "SELECT * FROM links WHERE id=?";

				c = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					upvotes = rs.getInt("Upvotes") + 1;
					String sql2 = "UPDATE links SET Upvotes=? WHERE id=?";
					pstmt = c.prepareStatement(sql2);
					pstmt.setInt(1, upvotes);
					pstmt.setInt(2, id);
					pstmt.executeUpdate();
				}
				System.out.println(id);

				

			}catch(SQLException e) {
				throw new ServletException(e);
			}finally{
				try {
					if(c != null)
						c.close();
				}catch(SQLException e) {
					throw new ServletException (e);
				}
			}
			
		}
		response.sendRedirect("Home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
