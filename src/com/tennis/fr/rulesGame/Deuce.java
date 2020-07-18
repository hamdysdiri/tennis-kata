package com.tennis.fr.rulesGame;

import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;

public class Deuce implements RuleGame {

	@Override
	public void apply(Player firstPlayer, Player secondPlayer, int numberSet) {
		if (firstPlayer.getScore() == 3 && firstPlayer.getScore() == 3) {
			firstPlayer.setStatus(StatusGame.DEUCE);
			secondPlayer.setStatus(StatusGame.DEUCE);
		}
	}

}
