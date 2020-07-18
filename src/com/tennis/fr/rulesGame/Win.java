package com.tennis.fr.rulesGame;

import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;

public class Win implements RuleGame {

	@Override
	public void apply(Player firstPlayer, Player secondPlayer, int setNumber) {

		if ((firstPlayer.getScore() >= 4 || secondPlayer.getScore() >= 4)
				&& firstPlayer.getScore() - secondPlayer.getScore() >= 2) {

			firstPlayer.getPlayBoard().get(0).set(setNumber, firstPlayer.getPlayBoard().get(0).get(setNumber) + 1);
			firstPlayer.setStatus(StatusGame.WIN);
			firstPlayer.resetScore(0);
			secondPlayer.resetScore(0);
			if (firstPlayer.getPlayBoard().get(0).get(setNumber) >= 7) {
				firstPlayer.getPlayBoard().get(1).set(setNumber, 1);
			} else if (secondPlayer.getPlayBoard().get(0).get(setNumber) >= 7) {
				secondPlayer.getPlayBoard().get(1).set(setNumber, 1);
			}

		} else if ((firstPlayer.getScore() >= 4 || secondPlayer.getScore() >= 4)
				&& secondPlayer.getScore() - firstPlayer.getScore() >= 2) {

			secondPlayer.getPlayBoard().get(0).set(setNumber, secondPlayer.getPlayBoard().get(0).get(setNumber) + 1);
			secondPlayer.setStatus(StatusGame.WIN);
			firstPlayer.resetScore(0);
			secondPlayer.resetScore(0);
			
			if (firstPlayer.getPlayBoard().get(0).get(setNumber) >= 7) {
				firstPlayer.getPlayBoard().get(1).set(setNumber, 1);
			} else if (secondPlayer.getPlayBoard().get(0).get(setNumber) >= 7) {
				secondPlayer.getPlayBoard().get(1).set(setNumber, 1);
			}
		}

	}

}
