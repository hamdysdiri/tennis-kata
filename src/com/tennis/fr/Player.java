package com.tennis.fr;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private int score;
	private StatusGame status;
	List<List<Integer>> playBoard = new ArrayList<List<Integer>>();

	private int tieBreakerScore;

	public Player(String name) {
		super();
		this.name = name;
		this.score = 0;
		status = StatusGame.ZERO;
		for (int i = 0; i < 2; i++) {
			playBoard.add(new ArrayList<Integer>());
			playBoard.get(i).add(0, 0);
			playBoard.get(i).add(0, 0);
			playBoard.get(i).add(0, 0);
			playBoard.get(i).add(0, 0);
			playBoard.get(i).add(0, 0);

		}

		this.tieBreakerScore = 0;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void resetScore(int score) {
		assert score == 0 : "you should score point, no cheating";
		if (score == 0) {
			this.score = score;
		}
	}

	public StatusGame getStatus() {
		return status;
	}

	public void setStatus(StatusGame status) {
		this.status = status;
	}

	public List<List<Integer>> getPlayBoard() {
		return playBoard;
	}

	public void setPlayBoard(List<List<Integer>> playBoard) {
		this.playBoard = playBoard;
	}

	public int getTieBreakerScore() {
		return tieBreakerScore;
	}

	public void scoreTieBreaker() {
		this.tieBreakerScore = getTieBreakerScore() + 1;
	}

	public void scorePoint() {
		this.score = getScore() + 1;

		switch (getScore()) {
		case 0:
			this.status = StatusGame.ZERO;
			break;
		case 1:
			this.status = StatusGame.FIFTEEN;
			break;
		case 2:
			this.status = StatusGame.THIRTY;
			break;
		case 3:
			this.status = StatusGame.FORTY;
			break;
		}
	}

	public void losePoint() {
		if (getScore() != 0 && getStatus() == StatusGame.ADVANTAGE) {
			this.score = getScore() - 1;
			setStatus(StatusGame.DEUCE);
		}
	}

	public void displayScore() {
		System.out.println(getName() + " " + getStatus());
	}

	public void displayBoard() {
		System.out.println(getName() + " " + getPlayBoard().get(0) + " "
				+ getPlayBoard().get(1).stream().mapToInt(Integer::intValue).sum());
	}

}
