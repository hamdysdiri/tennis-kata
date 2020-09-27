package com.tennis.fr.rulesGame;

import com.tennis.fr.BoardCalculator;
import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;

public class Advantage implements RuleGame {

	@Override
	public void apply(Player firstPlayer, Player secondPlayer, int setNumber) {
		if (firstPlayer.getStatus() == StatusGame.DEUCE && secondPlayer.getStatus() == StatusGame.DEUCE) {
			determinePlayerTakeAdvantage(firstPlayer, secondPlayer);
		} else if (firstPlayer.getStatus() == StatusGame.ADVANTAGE
				|| secondPlayer.getStatus() == StatusGame.ADVANTAGE) {

			determinePlayerWinAfterAdvantage(firstPlayer, secondPlayer, setNumber);
		}
	}

	private void determinePlayerWinAfterAdvantage(Player firstPlayer, Player secondPlayer, int setNumber) {

		if (firstPlayer.getScore() > 4) {
			firstPlayer.setStatus(StatusGame.WIN);
			BoardCalculator.recordPointnBoard(firstPlayer, secondPlayer, setNumber);

		} else if (secondPlayer.getScore() > 4) {
			secondPlayer.setStatus(StatusGame.WIN);
			BoardCalculator.recordPointnBoard(firstPlayer, secondPlayer, setNumber);
		}
	}

	private void determinePlayerTakeAdvantage(Player firstPlayer, Player secondPlayer) {
		if (firstPlayer.getScore() > 3) {
			firstPlayer.setStatus(StatusGame.ADVANTAGE);
		} else if (secondPlayer.getScore() > 3) {
			secondPlayer.setStatus(StatusGame.ADVANTAGE);
		}
	}

}
