package com.sheridancollege.bouncer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheridancollege.bouncer.model.Model;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/access")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model myModel = null;
	
	@Override
	public void init() {
		myModel = new Model(); // lifecycle - get's done only once
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accessState = request.getParameter("access");
		if (accessState.equals("denied")) 
				response.sendRedirect("http://disney.com");
		else	
		{
			String myImage = myModel.imageSelector(); // gets a random image
			request.setAttribute("movie", myImage);
			myModel.registerAccess(request.getRemoteAddr()); // get IP address from request
			request.getRequestDispatcher("View.jsp").forward(request, response);
		};
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
