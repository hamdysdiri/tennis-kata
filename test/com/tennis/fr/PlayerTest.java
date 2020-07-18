package com.tennis.fr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tennis.fr.Player;
import com.tennis.fr.StatusGame;

class PlayerTest {
	private Player nadal;

	@BeforeEach
	void setUp() throws Exception {
		nadal = new Player("Nadal");
	}

	@Test
	void whenMatchBeginsThenScoreIsZero() {
		assertEquals(0, nadal.getScore());
		assertEquals(StatusGame.ZERO, nadal.getStatus());
	}

	@Test
	void whenScorePointThenScoreChange() {
		int initialScore = nadal.getScore();
		nadal.scorePoint();
		assertEquals(StatusGame.FIFTEEN, nadal.getStatus());
		assertNotEquals(initialScore, nadal.getScore());
	}
}
