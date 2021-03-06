package com.tennis.fr.rulesSets;

import com.tennis.fr.BoardCalculator;
import com.tennis.fr.Player;
import com.tennis.fr.rulesGame.RuleGame;

public class SetWinnerWhenEcartIsMoreThanTwo implements RuleGame {

	@Override
	public void apply(Player firstPlayer, Player secondPlayer, int setNumber) {

		if ((firstPlayer.getPlayBoard().get(0).get(setNumber) >= 6)
				&& secondPlayer.getPlayBoard().get(0).get(setNumber) <= 4) {

			BoardCalculator.recordPointnBoard(firstPlayer, secondPlayer, setNumber);

		} else if ((secondPlayer.getPlayBoard().get(0).get(setNumber) >= 6)
				&& firstPlayer.getPlayBoard().get(0).get(setNumber) <= 4) {
			BoardCalculator.recordPointnBoard(secondPlayer, firstPlayer, setNumber);

		}
	}
}
