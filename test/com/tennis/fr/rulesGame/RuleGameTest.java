package com.tennis.fr.rulesGame;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;
import com.tennis.fr.rulesGame.Advantage;
import com.tennis.fr.rulesGame.Deuce;
import com.tennis.fr.rulesGame.Win;

class RuleGameTest {

	private Player nadal;
	private Player federer;
	private Win win;
	private Deuce deuce;
	private Advantage advantage;

	@BeforeEach
	void setUp() throws Exception {
		nadal = new Player("Nadal");
		federer = new Player("Federer");
	}

	@Test
	@DisplayName("when Player Score Four Time And NoPoint For The Other Then Game Win")
	void whenPlayerScoreFourTimeAndNoPointForTheOtherThenGameWin() {
		win = new Win();

		for (int i = 0; i < 4; i++) {
			nadal.scorePoint();
		}
		nadal.displayScore();
		win.apply(nadal, federer, 0);
		//nadal.displayBoard();
		assertEquals(StatusGame.WIN, nadal.getStatus());
		assertEquals(1, (int) nadal.getPlayBoard().get(0).get(0));
		assertEquals(0, nadal.getScore());
		assertEquals(0, federer.getScore());

	}

	@Test
	@DisplayName("when Two Player Reach Forty Then Status Deuce")
	void whenTwoPlayerReachFortyThenStatusDeuce() {
		deuce = new Deuce();

		for (int i = 0; i < 3; i++) {
			nadal.scorePoint();
			federer.scorePoint();
		}

		deuce.apply(nadal, federer, 0);
		assertEquals(StatusGame.DEUCE, nadal.getStatus());

	}

	@Test
	@DisplayName("when Two Player Reach Forty And The First One Score Then He Has Advantage")
	void whenTwoPlayerReachFortyAndTheFirstOneScoreThenHeHasAdvantage() {
		deuce = new Deuce();
		advantage = new Advantage();

		advantage = new Advantage();
		for (int i = 0; i < 3; i++) {
			nadal.scorePoint();
			federer.scorePoint();

		}
		deuce.apply(nadal, federer, 0);

		nadal.scorePoint();
		advantage.apply(nadal, federer, 0);

		assertEquals(nadal.getStatus(), StatusGame.ADVANTAGE);
	}

	@Test
	@DisplayName("when Lose Point And Player Has Advantage Then Status Deuce")
	void whenLosePointAndPlayerHasAdvantageThenStatusDeuce() {
		deuce = new Deuce();
		advantage = new Advantage();

		advantage = new Advantage();
		for (int i = 0; i < 3; i++) {
			nadal.scorePoint();
			federer.scorePoint();
		}

		deuce.apply(nadal, federer, 0);
		nadal.scorePoint();

		advantage.apply(nadal, federer, 0);
		nadal.losePoint();

		advantage.apply(nadal, federer, 0);

		assertEquals(nadal.getStatus(), StatusGame.DEUCE);

	}

	@Test
	@DisplayName("when Player Score Point And He Has Advantage Then Player Win")

	void whenPlayerScorePointAndHeHasAdvantageThenPlayerWin() {
		deuce = new Deuce();
		advantage = new Advantage();

		for (int i = 0; i < 3; i++) {
			nadal.scorePoint();
			federer.scorePoint();
		}

		deuce.apply(nadal, federer, 0);
		nadal.scorePoint();

		advantage.apply(nadal, federer, 0);
		nadal.scorePoint();

		advantage.apply(nadal, federer, 0);
		assertEquals(nadal.getStatus(), StatusGame.WIN);

	}
}
