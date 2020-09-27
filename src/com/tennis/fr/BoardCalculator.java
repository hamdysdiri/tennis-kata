package com.tennis.fr;

public final class BoardCalculator {

	private BoardCalculator() {

	}

	public static void recordPointnBoard(Player firstPlayer, Player secondPlayer, int setNumber) {
		firstPlayer.getPlayBoard().get(1).set(setNumber, 1);
		firstPlayer.resetScore(0);
		secondPlayer.resetScore(0);
	}
}
