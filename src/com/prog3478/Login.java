package com.prog3478;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	static Players player = new Players();
	private static HttpSession sessionVariable;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		player.setPlayerName(request.getParameter("firstname"));
		player.setPlayerScore(0);
		
		if (request.getParameter("firstname") == "") {
			request.setAttribute("err", "Cannot be left empty");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (request.getParameter("firstname").length() < 3) {
			request.setAttribute("err", "Name must be greater than 2 characters");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			
			sessionVariable = request.getSession();
			if (!sessionVariable.isNew()) {
				sessionVariable.invalidate();
				sessionVariable = request.getSession();
			}
			
//			sessionVariable = request.getSession();
			sessionVariable.setAttribute("Firstname", player.getPlayerName());
			sessionVariable.setAttribute("score", player.getPlayerScore());
			makeDailyDoubles();
			request.getRequestDispatcher("gameboard.jsp").forward(request, response);
		}

	}

	public static Players getPlayer() {
		return player;
	}

	public static HttpSession getSession() {
		return sessionVariable;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	public void makeDailyDoubles() {
		String[] categories = {"videoGames", "rollerCoasters", "cellPhones", "movies", "computers"};
		int[] values = {100, 200, 300, 400, 500};
		String daily1 = null, daily2 = null;
		
		Random r = new Random();
		
		daily1 = categories[r.nextInt(5)] + values[r.nextInt(5)];
		daily2 = categories[r.nextInt(5)] + values[r.nextInt(5)];
		
		while (daily2.equals(daily1)) {
			daily2 = categories[r.nextInt(5)] + values[r.nextInt(5)];
		}
		
		sessionVariable.setAttribute("daily1", daily1);
		sessionVariable.setAttribute("daily2", daily2);
		
		System.out.println(daily1);
		System.out.println(daily2);
	}
}



