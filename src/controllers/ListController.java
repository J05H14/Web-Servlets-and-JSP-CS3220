package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.Tutor;
import models.Link;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/Final/Home")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException{
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			throw new ServletException (e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Link> links = new ArrayList<Link>();	
		Connection c = null;

		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu72";
			String user="cs3220stu72";
			String password = "EEK!o0m*";

			c = DriverManager.getConnection(url, user, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM links");

			while(rs.next()) {
				Link link = new Link(rs.getString("Name"), rs.getString("Url"), rs.getInt("Upvotes") - rs.getInt("Downvotes"));
				links.add(link);
			}
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
		
		for(int i = 0; i < links.size(); i++) {
			links.get(i).setId(i);
		}

		request.setAttribute("links", links);
		request.getRequestDispatcher("/WEB-INF/Links.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
