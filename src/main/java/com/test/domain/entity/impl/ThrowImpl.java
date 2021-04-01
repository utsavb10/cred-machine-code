package com.test.domain.entity.impl;

import com.test.domain.entity.Throw;

public class ThrowImpl implements Throw {
	private Participant participant;
	private Integer currentScore;
	private Integer currentRound;
	private Throw prevThrow;
	private Integer retryCount;
	private Integer remainingPegs;

	public ThrowImpl(Participant participant){
		this.prevThrow = null;
		this.participant = participant;
		currentRound = 1;
		currentScore = 0;
		retryCount = 0;
		remainingPegs = 10;
	}

	public ThrowImpl(Throw prevThrow){
		this.prevThrow = prevThrow;
		this.participant = prevThrow.getParticipant();
	}

	@Override
	public Participant getParticipant() {
		return participant;
	}

	@Override
	public Integer getScore() {
		return currentScore;
	}

	@Override
	public Integer getCurrentRound() {
		return currentRound;
	}

	@Override
	public Integer getRemainingPegs() {
		return null;
	}


	public Integer getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(Integer currentScore) {
		this.currentScore = currentScore;
	}

	public void setCurrentRound(Integer currentRound) {
		this.currentRound = currentRound;
	}

	public Throw getPrevThrow() {
		return prevThrow;
	}

	public void setPrevThrow(Throw prevThrow) {
		this.prevThrow = prevThrow;
	}

	public void setRemainingPegs(Integer remainingPegs) {
		this.remainingPegs = remainingPegs;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
}
