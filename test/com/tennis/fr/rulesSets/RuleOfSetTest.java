package com.tennis.fr.rulesSets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;
import com.tennis.fr.rulesGame.RuleGame;
import com.tennis.fr.rulesGame.Win;
import com.tennis.fr.rulesSets.SetWinnerWhenEcartIsMoreThanTwo;
import com.tennis.fr.rulesSets.TieBreaker;
import com.tennis.fr.rulesSets.TieBreakerWinner;

class RuleOfSetTest {

	private Player nadal;
	private Player federer;
	private RuleGame setBoardWin;
	private Win win;

	@BeforeEach
	void setUp() throws Exception {
		nadal = new Player("Nadal");
		federer = new Player("Federer");

	}

	@Test
	void whenFirstPlayerReachSetOfSixAndTheOtherPlayerHasFourOrLowerThenPlayerWinSet() {
		nadal.getPlayBoard().get(0).set(0, 6);
		federer.getPlayBoard().get(0).set(0, 4);
		setBoardWin = new SetWinnerWhenEcartIsMoreThanTwo();
		setBoardWin.apply(nadal, federer, 0);
		assertEquals(1, (int) nadal.getPlayBoard().get(1).get(0));
		assertEquals(0, (int) federer.getPlayBoard().get(1).get(0));
	}

	@Test
	void whenSecondPlayerReachSetOfSixAndTheOtherPlayerHasFourOrLowerThenPlayerWinSet() {
		nadal.getPlayBoard().get(0).set(0, 4);
		federer.getPlayBoard().get(0).set(0, 6);
		
		setBoardWin = new SetWinnerWhenEcartIsMoreThanTwo();
		setBoardWin.apply(nadal, federer, 0);

		assertEquals(1, (int) federer.getPlayBoard().get(1).get(0));
		assertEquals(0, (int) nadal.getPlayBoard().get(1).get(0));

	}

		@Test
	void whenFirstPlayerReachSetOfSixAndTheOtherPlayerHasFiveThenPlayerReachSevenFirstGameWinSet() {

		nadal.getPlayBoard().get(0).add(0, 6);
		federer.getPlayBoard().get(0).set(0, 5);
		
		win = new Win();

		for (int i = 0; i < 4; i++) {
			nadal.scorePoint();
		}
		win.apply(nadal, federer, 0);
		

		assertEquals(1, (int) nadal.getPlayBoard().get(1).get(0));
		assertEquals(0, (int) federer.getPlayBoard().get(1).get(0));
	}
		
	@Test
	void whenSecondPlayerReachSetOfSixAndTheOtherPlayerHasFiveThenPlayerHowReachSevenFirstGameWinSet() {
		nadal.getPlayBoard().get(0).add(0, 6);

		federer.getPlayBoard().get(0).set(0, 5);

		win = new Win();

		for (int i = 0; i < 4; i++) {
			federer.scorePoint();
		}
		win.apply(nadal, federer, 0);

		for (int i = 0; i < 4; i++) {
			federer.scorePoint();
		}

		win.apply(nadal, federer, 0);


		assertEquals(0, (int) nadal.getPlayBoard().get(1).get(0));
		assertEquals(1, (int) federer.getPlayBoard().get(1).get(0));
	}
	
	@Test
	void whenTwoPlayerReachSetOfSixThenRuleTieBreakActivated() {
		nadal.getPlayBoard().get(0).set(0, 6);
		federer.getPlayBoard().get(0).set(0, 6);
		setBoardWin = new TieBreaker();

		setBoardWin.apply(nadal, federer, 0);

		assertEquals(StatusGame.TIEBREAKER, nadal.getStatus());
		assertEquals(StatusGame.TIEBREAKER, federer.getStatus());

	}
	
	@Test
	void whenTieBreakActivatedAndFirstPlayerWinWithEcartOfTwoPointsThenHeWinTheSet() {
		nadal.getPlayBoard().get(0).set(0, 6);
		federer.getPlayBoard().get(0).set(0, 6);
		setBoardWin = new TieBreaker();

		setBoardWin.apply(nadal, federer, 0);

		for (int i = 0; i < 6; i++) {
			nadal.scoreTieBreaker();
		}
		for (int i = 0; i < 9; i++) {
			federer.scoreTieBreaker();
		}

		setBoardWin = new TieBreakerWinner();
		setBoardWin.apply(nadal, federer, 0);
		assertEquals(1, (int) federer.getPlayBoard().get(1).get(0));
		assertEquals(0, (int) nadal.getPlayBoard().get(1).get(0));

	}

}
