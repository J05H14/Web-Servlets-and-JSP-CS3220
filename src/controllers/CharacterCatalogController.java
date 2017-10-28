package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CharacterCatalogController
 */
@WebServlet("/CharacterCatalogController")
public class CharacterCatalogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CharacterCatalogController() {
		super();

	}

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		BufferedReader br = null;
		ArrayList<String> chars = new ArrayList<String>();
		ArrayList<String> images = new ArrayList<String>();
		String path = "C:\\Users\\J.Lazaro\\WebWorkspace\\cs3220stu72\\SimpsonsCsv\\characters.csv";
		try{
			br = new BufferedReader (new FileReader(path));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] character = line.split(",");
				chars.add(character[0]);
				images.add(character[1]);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			chars.remove(0);
			images.remove(0);
			for(int i = 0; i < chars.size(); i++) {
				System.out.print(chars.get(i));
				System.out.print(images.get(i));
				System.out.println();
			}
			getServletContext().setAttribute("characters", chars);
			getServletContext().setAttribute("images", images);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/CharacterCatalog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
