package com.tennis.fr.rulesGame;

import com.tennis.fr.Player;

public interface RuleGame {
	void apply(Player firstPlayer, Player secondPlayer, int setNumber);

}
