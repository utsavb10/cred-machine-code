package com.test.domain.entity;

import com.test.domain.entity.impl.Participant;

public interface Throw {

	Throw addThrow(Integer pegsDown);
	Participant getParticipant();
	Integer getScore();
	Integer getCurrentRound();
	Integer getThrowCount();
	Integer getRemainingPegs();
}
