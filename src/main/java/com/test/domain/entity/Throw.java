package com.test.domain.entity;

import com.test.domain.entity.impl.Participant;

public interface Throw {

	Participant getParticipant();
	Integer getScore();
	Integer getCurrentRound();
	Integer getRemainingPegs();
}
