package com.tennis.fr.rulesSets;

import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;
import com.tennis.fr.rulesGame.RuleGame;

public class TieBreaker implements RuleGame {

	@Override
	public void apply(Player firstPlayer, Player secondPlayer, int setNumber) {
		if ((firstPlayer.getPlayBoard().get(0).get(setNumber) == 6
				&& secondPlayer.getPlayBoard().get(0).get(setNumber) == 6)) {
			firstPlayer.setStatus(StatusGame.TIEBREAKER);
			secondPlayer.setStatus(StatusGame.TIEBREAKER);

		}
	}

}
