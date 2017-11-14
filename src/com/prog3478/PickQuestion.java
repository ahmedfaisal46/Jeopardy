package com.prog3478;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

/**
 * Servlet implementation class PickQuestion
 */
@WebServlet("/PickQuestion")
public class PickQuestion extends HttpServlet {
	public Question question = new Question();
	public Question questions[] = new Question[25];
	
	public boolean dailyDouble;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PickQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setAttribute("value", setValue(request));
		// request.setAttribute("category", setCategory(request));

		request.setAttribute("question", determineQuestion(setValue(request), setCategory(request)));
		request.setAttribute("answer1", question.getAnswer1());
		request.setAttribute("answer2", question.getAnswer2());
		request.setAttribute("answer3", question.getAnswer3());
		request.setAttribute("answer4", question.getAnswer4());
		request.setAttribute("correctAnswer", question.getCorrectAnswer());
		request.setAttribute("value", question.getValue());
		Login.getSession().setAttribute("score", Login.getPlayer().getPlayerScore());
		
		/////////////////////////////////////////////////////
		if (dailyDouble) {
			request.setAttribute("displayRegular", "none");
			request.setAttribute("displayDaily", "inline");
		} else {
			request.setAttribute("displayRegular", "inline");
			request.setAttribute("displayDaily", "none");
		}
		dailyDouble = false;
		
		if(gameHasEnded()) {
			request.setAttribute("skiplink", "winpage.jsp");
		}
		else {
			request.setAttribute("skiplink", "gameboard.jsp");
		}

		request.getRequestDispatcher("questionselect.jsp").forward(request, response);

	}
	


	protected String setCategory(HttpServletRequest request) {
		Enumeration<String> categories = request.getParameterNames();
		Object category = categories.nextElement();
		String categoryName = (String) category;
		question.setCategory(categoryName);

		return question.getCategory();
	}

	protected int setValue(HttpServletRequest request) {
		int tempValue = Integer.parseInt(request.getParameter(setCategory(request)));

		question.setValue(tempValue);

		return question.getValue();
	}

	protected String determineQuestion(int value, String category) {
		loadQuestions();
		int determineArrayLocation = 0;

		if (value == 100 && category.contains("videoGames")) {
			determineArrayLocation = 0;
			Login.getSession().setAttribute("videoGames100", "disabled");
		}
		if (value == 200 && category.contains("videoGames")) {
			determineArrayLocation = 1;
			Login.getSession().setAttribute("videoGames200", "disabled");
		}
		if (value == 300 && category.contains("videoGames")) {
			determineArrayLocation = 2;
			Login.getSession().setAttribute("videoGames300", "disabled");
		}
		if (value == 400 && category.contains("videoGames")) {
			determineArrayLocation = 3;
			Login.getSession().setAttribute("videoGames400", "disabled");
		}
		if (value == 500 && category.contains("videoGames")) {
			determineArrayLocation = 4;
			Login.getSession().setAttribute("videoGames500", "disabled");
		}
		if (value == 100 && category.contains("rollerCoasters")) {
			determineArrayLocation = 5;
			Login.getSession().setAttribute("rollerCoasters100", "disabled");
		}
		if (value == 200 && category.contains("rollerCoasters")) {
			determineArrayLocation = 6;
			Login.getSession().setAttribute("rollerCoasters200", "disabled");
		}
		if (value == 300 && category.contains("rollerCoasters")) {
			determineArrayLocation = 7;
			Login.getSession().setAttribute("rollerCoasters300", "disabled");
		}
		if (value == 400 && category.contains("rollerCoasters")) {
			determineArrayLocation = 8;
			Login.getSession().setAttribute("rollerCoasters400", "disabled");
		}
		if (value == 500 && category.contains("rollerCoasters")) {
			determineArrayLocation = 9;
			Login.getSession().setAttribute("rollerCoasters500", "disabled");
		}
		if (value == 100 && category.contains("cellPhones")) {
			determineArrayLocation = 10;
			Login.getSession().setAttribute("cellPhones100", "disabled");
		}
		if (value == 200 && category.contains("cellPhones")) {
			determineArrayLocation = 11;
			Login.getSession().setAttribute("cellPhones200", "disabled");
		}
		if (value == 300 && category.contains("cellPhones")) {
			determineArrayLocation = 12;
			Login.getSession().setAttribute("cellPhones300", "disabled");
		}
		if (value == 400 && category.contains("cellPhones")) {
			determineArrayLocation = 13;
			Login.getSession().setAttribute("cellPhones400", "disabled");
		}
		if (value == 500 && category.contains("cellPhones")) {
			determineArrayLocation = 14;
			Login.getSession().setAttribute("cellPhones500", "disabled");
		}
		if (value == 100 && category.contains("movies")) {
			determineArrayLocation = 15;
			Login.getSession().setAttribute("movies100", "disabled");
		}
		if (value == 200 && category.contains("movies")) {
			determineArrayLocation = 16;
			Login.getSession().setAttribute("movies200", "disabled");
		}
		if (value == 300 && category.contains("movies")) {
			determineArrayLocation = 17;
			Login.getSession().setAttribute("movies300", "disabled");
		}
		if (value == 400 && category.contains("movies")) {
			determineArrayLocation = 18;
			Login.getSession().setAttribute("movies400", "disabled");
		}
		if (value == 500 && category.contains("movies")) {
			determineArrayLocation = 19;
			Login.getSession().setAttribute("movies500", "disabled");
		}
		if (value == 100 && category.contains("computers")) {
			determineArrayLocation = 20;
			Login.getSession().setAttribute("computers100", "disabled");
		}
		if (value == 200 && category.contains("computers")) {
			determineArrayLocation = 21;
			Login.getSession().setAttribute("computers200", "disabled");
		}
		if (value == 300 && category.contains("computers")) {
			determineArrayLocation = 22;
			Login.getSession().setAttribute("computers300", "disabled");
		}
		if (value == 400 && category.contains("computers")) {
			determineArrayLocation = 23;
			Login.getSession().setAttribute("computers400", "disabled");
		}
		if (value == 500 && category.contains("computers")) {
			determineArrayLocation = 24;
			Login.getSession().setAttribute("computers500", "disabled");
		}

		
		question.setQuestion(questions[determineArrayLocation].getQuestion());
		question.setAnswer1(questions[determineArrayLocation].getAnswer1());
		question.setAnswer2(questions[determineArrayLocation].getAnswer2());
		question.setAnswer3(questions[determineArrayLocation].getAnswer3());
		question.setAnswer4(questions[determineArrayLocation].getAnswer4());
		question.setCorrectAnswer(questions[determineArrayLocation].getCorrectAnswer());
		question.setValue(questions[determineArrayLocation].getValue());
	
		
		if (isDailyDouble(category + value)) {
			dailyDouble = true;
		}
		

		return question.getQuestion();

	}

	public void loadQuestions() {
		questions[0] = new Question("videoGames", 100, "When did Call of duty ww2 release?", "2004", "2005", "2017",
				"2016", "2017");
		questions[1] = new Question("videoGames", 200, "What genre is Call of duty black ops?", "Adventure", "Action",
				"Shooter", "Sports", "Shooter");
		questions[2] = new Question("videoGames", 300, "What console can The Last of Us be played on?", "PS4",
				"Xbox360", "XboxOne", "PC", "PS4");
		questions[3] = new Question("videoGames", 400, "Where can video games be purchased?", "All Listed", "BestBuy",
				"Amazon", "GameStop", "All Listed");
		questions[4] = new Question("videoGames", 500, "Which system can users modify with their own parts?", "PS4",
				"XboxOne", "PC", "PS3", "PC");
		questions[5] = new Question("rollerCoasters", 100,
				"Where in Ontario, Canada can individuals go on Roller Coasters?", "Canada's Wonderland",
				"Wasaga Beach", "Playdium", "Chuckie Cheese", "Canada's Wonderland");
		questions[6] = new Question("rollerCoasters", 200, "What is the tallest Roller Coaster in Canada called?",
				"Behemoth", "Leviathan", "Steel Dragon", "Superman", "Leviathan");
		questions[7] = new Question("rollerCoasters", 300, "When Did Canada's Wonderland Open?", "1982", "1981", "1983",
				"1984", "1981");
		questions[8] = new Question("rollerCoasters", 400, "Where in the world is the longest roller coaster?", "USA",
				"Canada", "Japan", "Mexico", "Japan");
		questions[9] = new Question("rollerCoasters", 500,
				"What direction is the normal force and force of gravity when a roller coaster is at the bottom of a loop?",
				"Up and down respectively", "Up and up respectively", "Down and up respectively",
				"Down and down respectively", "Up and down respectively");
		questions[10] = new Question("cellPhones", 100, "What is the name of the new iPhone that was released in 2007?",
				"iPhoneIX", "iPhoneX", "iPhoneV", "iPhoneVI", "iPhoneX");
		questions[11] = new Question("cellPhones", 200, "What is the display size of Sony Xperia Z6?", "5.2 inches",
				"4.8 inches", "5.1 inches", "5.0 inches", "5.2 inches");
		questions[12] = new Question("cellPhones", 300, "Which cell phone is the best selling from 2017?", "Samsung S8",
				"Sony Xperia Z6", "iPhone 6S", "OnePlus", "Samsung S8");
		questions[13] = new Question("cellPhones", 400, "Where is the Motorola Moto X Manufactured?", "China", "India",
				"USA", "Canada", "USA");
		questions[14] = new Question("cellPhones", 500,
				"Which Programming Language is the Android Operating Systems written in?", "Java", "C", "Python",
				"Ruby", "Java");
		questions[15] = new Question("movies", 100, "Which movie made the most money in 2016?",
				"Captain America: Civil War", "Frozen", "Finding Dory", "Deadpool", "Captain America: Civil War");
		questions[16] = new Question("movies", 200, "Who directed the movie IT?", "Jack Oleander", "James Batmee",
				"Andrés Muschietti", "John Kory", "Andrés Muschietti");
		questions[17] = new Question("movies", 300, "Who made Spiderman: Homecoming?", "Warner Bros", "DC", "Capcom",
				"Marvel Studios", "Marvel Studios");
		questions[18] = new Question("movies", 400, "When did the first Spiderman with Toby McGuire release?", "2002",
				"2005", "2010", "2012", "2002");
		questions[19] = new Question("movies", 500,
				"Where was the Amazon Island Location filmed for the movie Wonder Woman?", "Northern Italy",
				"Southern Italy", "Cuba", "Hawaii", "Southern Italy");
		questions[22] = new Question("computers", 100, "Who made the Linux OS?", "Microsoft", "Linus Torvalds",
				"Apple Inc", "Raspberry Pi Foundation", "Linus Torvalds");
		questions[20] = new Question("computers", 200, "How many computers were sold in 2014?", "303,000,000",
				"302,000,000", "301,000,000", "300,000,000", "302,000,000");
		questions[21] = new Question("computers", 300, "Which computer company sold the most computers in 2017?",
				"Lenovo", "Dell", "HP", "Acer", "HP");
		questions[23] = new Question("comptuers", 400, "Which year has the lowest computer sales?", "2014", "2015",
				"2017", "2016", "2017");
		questions[24] = new Question("computers", 500, "How long does the battery for Lenovo Thinkpad 25 last?",
				"13.9 hours", "12 hours", "12.6 horus", "9.7 hours", "13.9 hours");

	}

	public static boolean gameHasEnded() {
		boolean gameHasEnded = false;
		if (videoGamesHasEnded() & rollerCoastersHasEnded() & cellPhonesHasEnded() & moviesHasEnded()
				& computersHasEnded()) {
			gameHasEnded = true;
		}

		return gameHasEnded;
	}

	protected static boolean videoGamesHasEnded() {
		boolean gameHasEnded = false;
		if (Login.getSession().getAttribute("videoGames100") == "disabled"
				& Login.getSession().getAttribute("videoGames200") == "disabled"
				& Login.getSession().getAttribute("videoGames300") == "disabled"
				& Login.getSession().getAttribute("videoGames400") == "disabled"
				& Login.getSession().getAttribute("videoGames500") == "disabled") {
			gameHasEnded = true;
		}
		return gameHasEnded;
	}

	protected static boolean rollerCoastersHasEnded() {
		boolean gameHasEnded = false;
		if (Login.getSession().getAttribute("rollerCoasters100") == "disabled"
				& Login.getSession().getAttribute("rollerCoasters200") == "disabled"
				& Login.getSession().getAttribute("rollerCoasters300") == "disabled"
				& Login.getSession().getAttribute("rollerCoasters400") == "disabled"
				& Login.getSession().getAttribute("rollerCoasters500") == "disabled") {
			gameHasEnded = true;
		}
		return gameHasEnded;
	}

	protected static boolean cellPhonesHasEnded() {
		boolean gameHasEnded = false;
		if (Login.getSession().getAttribute("cellPhones100") == "disabled"
				& Login.getSession().getAttribute("cellPhones200") == "disabled"
				& Login.getSession().getAttribute("cellPhones300") == "disabled"
				& Login.getSession().getAttribute("cellPhones400") == "disabled"
				& Login.getSession().getAttribute("cellPhones500") == "disabled") {
			gameHasEnded = true;
		}
		return gameHasEnded;
	}

	protected static boolean moviesHasEnded() {
		boolean gameHasEnded = false;
		if (Login.getSession().getAttribute("movies100") == "disabled"
				& Login.getSession().getAttribute("movies200") == "disabled"
				& Login.getSession().getAttribute("movies300") == "disabled"
				& Login.getSession().getAttribute("movies400") == "disabled"
				& Login.getSession().getAttribute("movies500") == "disabled") {
			gameHasEnded = true;
		}
		return gameHasEnded;
	}

	protected static boolean computersHasEnded() {
		boolean gameHasEnded = false;
		if (Login.getSession().getAttribute("computers100") == "disabled"
				& Login.getSession().getAttribute("computers200") == "disabled"
				& Login.getSession().getAttribute("computers300") == "disabled"
				& Login.getSession().getAttribute("computers400") == "disabled"
				& Login.getSession().getAttribute("computers500") == "disabled") {
			gameHasEnded = true;
		}
		return gameHasEnded;
	}
	
	///////////////////////////////////////////////////////////////////////
	public boolean isDailyDouble(String selection) {
		String daily1 = (String) Login.getSession().getAttribute("daily1");
		String daily2 = (String) Login.getSession().getAttribute("daily2");
		
		if (selection.equals(daily1) || selection.equals(daily2)) {
			return true;
		} else {
			return false;
		}
	}
}
