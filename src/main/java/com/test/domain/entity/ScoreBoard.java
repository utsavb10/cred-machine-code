package com.test.domain.entity;

import com.test.domain.entity.impl.Participant;

public interface ScoreBoard {

	String getCurrentWinner();
	Participant getNextPlayer();
	boolean addThrow(Participant p, Integer pegs);
}
