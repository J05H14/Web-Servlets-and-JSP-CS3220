package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Link;

/**
 * Servlet implementation class AddLinkController
 */
@WebServlet("/Final/AddLink")
public class AddLinkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLinkController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("name").equals("") || request.getParameter("url").equals("")) {
			response.sendRedirect("Home");
		}
		else {
	    	List<Link> links = (List<Link>) getServletContext().getAttribute("link");
			String inputName = request.getParameter("name");
			String inputUrl = request.getParameter("url");


			Connection c = null;

			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu72";
				String user="cs3220stu72";
				String password = "EEK!o0m*";

				c = DriverManager.getConnection(url, user, password);
				String sql = "INSERT INTO `links` (`Name`, `Url`, `Upvotes`, `Downvotes`, `id`) VALUES(?, ?, ?, ?,?)";

				c = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, inputName);
				pstmt.setString(2, inputUrl);
				pstmt.setInt(3, 0);
				pstmt.setInt(4, 0);
				pstmt.setInt(5, links.size());
				pstmt.executeUpdate();


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
			response.sendRedirect("Home");
			doGet(request, response);
		}
	}

}
