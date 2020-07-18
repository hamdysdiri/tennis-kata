package com.tennis.fr.rulesSets;

import com.tennis.fr.BoardCalculator;
import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;
import com.tennis.fr.rulesGame.RuleGame;

public class TieBreakerWinner implements RuleGame {

	@Override
	public void apply(Player firstPlayer, Player secondPlayer, int setNumber) {
		BoardCalculator boardCalculator = BoardCalculator.getInstance();
		if (firstPlayer.getStatus() == StatusGame.TIEBREAKER) {
			if (firstPlayer.getTieBreakerScore() - secondPlayer.getTieBreakerScore() >= 2
					&& firstPlayer.getPlayBoard().get(0).get(setNumber) >= 6) {
				boardCalculator.recordPointnBoard(firstPlayer, secondPlayer, setNumber);

			} else if (secondPlayer.getTieBreakerScore() - firstPlayer.getTieBreakerScore() >= 2
					&& secondPlayer.getPlayBoard().get(0).get(setNumber) >= 6) {
				boardCalculator.recordPointnBoard(secondPlayer, firstPlayer, setNumber);

			}
		}
	}

}
