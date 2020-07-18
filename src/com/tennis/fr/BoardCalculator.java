package com.tennis.fr;

public class BoardCalculator {

	private static BoardCalculator instance = new BoardCalculator();

	public static synchronized BoardCalculator getInstance() {
		if (instance == null) {
			instance = new BoardCalculator();
		}
		return instance;
	}

	public void recordPointnBoard(Player firstPlayer, Player secondPlayer, int setNumber) {
		firstPlayer.getPlayBoard().get(1).set(setNumber, 1);
		firstPlayer.resetScore(0);
		secondPlayer.resetScore(0);
	}
}
