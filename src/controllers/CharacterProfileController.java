package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.SimpsonsCharacter;

/**
 * Servlet implementation class CharacterProfileController
 */
@WebServlet("/CharacterProfile")
public class CharacterProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@SuppressWarnings("unchecked")
	public SimpsonsCharacter getCharacter(Integer id) {
		List<SimpsonsCharacter> characters = (List<SimpsonsCharacter>) getServletContext().getAttribute("characters");
		
		for(SimpsonsCharacter character : characters) {
			if(character.getId() == id) {
				return character;
			}
		}
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		SimpsonsCharacter character = getCharacter(id);
		
		request.setAttribute("character", character);
		request.getRequestDispatcher("/WEB-INF/CharacterProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
