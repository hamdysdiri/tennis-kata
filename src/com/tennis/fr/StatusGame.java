package com.tennis.fr;

public enum StatusGame {
	TIEBREAKER("Tie breaker"), ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), ADVANTAGE("Adv"), WIN("Win"), DEUCE(
			"Deuce");

	private String expectedStatus;

	private StatusGame(String expectedStatus) {
		this.expectedStatus = expectedStatus;
	}

	public void printStatus() {
		System.out.println(expectedStatus);
	}

}
