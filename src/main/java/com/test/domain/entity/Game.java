package com.test.domain.entity;

import com.test.domain.entity.impl.Lane;
import com.test.domain.entity.impl.Participant;

import java.util.List;

public interface Game {
	Integer MAX_ROUNDS = 10;
	Game startGame(List<Participant> particpants);
	Game endGame();
	ScoreBoard getScoreBoard();
	String callNextPlayer();
	void addThrow(Participant p, Integer pegsDown);
	void unlockLane(Lane lane);
}
