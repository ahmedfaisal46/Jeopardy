package com.prog3478;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

/**
 * Servlet implementation class Answer
 */
@WebServlet("/Answer")
public class Answer extends HttpServlet {
	PickQuestion pickquestion = new PickQuestion();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		///////////////////////////////////////////////////////////////////////////////////////
		if (isValueValid(request.getParameter("value"))) {
			int questionValue = Integer.parseInt(request.getParameter("value"));
			String chosenAnswer = request.getParameter("answer");
			String correctAnswer = request.getParameter("correctAnswer");
			int playerScore = Login.getPlayer().getPlayerScore();
	
			/*if (chosenAnswer == null) {
				System.out.println("Select radio button please");
				request.setAttribute("err", "select an answer or skip this question");
				request.getRequestDispatcher("questionselect.jsp").forward(request, response);
			}*/
			if (chosenAnswer.trim().equals(correctAnswer.trim())) {
				playerScore += questionValue;
				Login.getPlayer().setPlayerScore(playerScore);
				Login.getSession().setAttribute("score", Login.getPlayer().getPlayerScore());
				if (!PickQuestion.gameHasEnded()) {
					request.getRequestDispatcher("gameboard.jsp").forward(request, response);
				}
			} else if (!chosenAnswer.trim().equals(correctAnswer.trim())) {
				playerScore -= questionValue;
				Login.getPlayer().setPlayerScore(playerScore);
				Login.getSession().setAttribute("score", Login.getPlayer().getPlayerScore());
				request.setAttribute("err", "You are wrong");
				if (!PickQuestion.gameHasEnded()) {
					request.getRequestDispatcher("gameboard.jsp").forward(request, response);
				}
			}
			if (PickQuestion.gameHasEnded()) {
				Login.getPlayer().setPlayerScore(playerScore);
				if (Login.getPlayer().getPlayerScore() > 0) {
					request.setAttribute("result", "Congratulations, You have won");
					request.setAttribute("Firstname", Login.getPlayer().getPlayerName());
					request.setAttribute("score", Login.getPlayer().getPlayerScore());
					request.getRequestDispatcher("winpage.jsp").forward(request, response);
				} else if (Login.getPlayer().getPlayerScore() < 0) {
					request.setAttribute("result",
							"You have lost. You owe us " + ((-1) * Login.getPlayer().getPlayerScore()) + " dollars");
					request.setAttribute("Firstname", Login.getPlayer().getPlayerName());
					request.setAttribute("score", Login.getPlayer().getPlayerScore());
					request.getRequestDispatcher("winpage.jsp").forward(request, response);
				} else if (Login.getPlayer().getPlayerScore() == 0) {
					request.setAttribute("result", "You didn't win anything.");
					request.setAttribute("Firstname", Login.getPlayer().getPlayerName());
					request.setAttribute("score", Login.getPlayer().getPlayerScore());
					request.getRequestDispatcher("winpage.jsp").forward(request, response);
				}
				
			}

		} else {
			request.setAttribute("question", getJSPvariables(request)[0]);
			request.setAttribute("answer1", getJSPvariables(request)[1]);
			request.setAttribute("answer2", getJSPvariables(request)[2]);
			request.setAttribute("answer3", getJSPvariables(request)[3]);
			request.setAttribute("answer4", getJSPvariables(request)[4]);
			request.setAttribute("correctAnswer", getJSPvariables(request)[5]);
			
			request.setAttribute("displayRegular", "none");
			request.setAttribute("displayDaily", "inline");
			
			request.setAttribute("inputError", "You have entered an invalid input.");
			
			request.setAttribute("skiplink", "gameboard.jsp");
			
			request.getRequestDispatcher("questionselect.jsp").forward(request, response);
		}

	}
	
	public boolean isValueValid(String valueFromBoard) {
		try {
			int value =  Integer.parseInt(valueFromBoard);
			int playerScore = Login.getPlayer().getPlayerScore();
			
			if (playerScore < 1000 && value > 1000) {
				return false;
			}

			if (value <= 0) {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * values[0] = question
	 * values[1] = answer1
	 * values[2] = answer2
	 * values[3] = answer3
	 * values[4] = answer4
	 * values[5] = correctAnswer
	 */
	public String[] getJSPvariables(HttpServletRequest request) {
		String[] values = request.getParameter("variables").split(",");
		return values;
	}
}
