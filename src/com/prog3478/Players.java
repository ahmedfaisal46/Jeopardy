package com.prog3478;

public class Players {
	private String playerName;
	private int playerScore;

	
	public Players() {
		playerName = "";
		playerScore = 0;
	
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	public String getPlayerName() {
		return playerName;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	
}
