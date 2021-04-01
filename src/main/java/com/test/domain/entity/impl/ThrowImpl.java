package com.test.domain.entity.impl;

import com.test.domain.entity.Throw;

public class ThrowImpl implements Throw {
	private Participant participant;
	private Integer currentScore;
	private Integer currentRound;
	private Throw prevThrow;
	private Integer throwCount;
	private Integer remainingPegs;

	public ThrowImpl(Participant participant){
		this.prevThrow = null;
		this.participant = participant;
		currentRound = 1;
		currentScore = 0;
		throwCount = 0;
		remainingPegs = 10;
	}

	public ThrowImpl(Throw prevThrow, Integer pegsDown){
		this.prevThrow = prevThrow;
		this.participant = prevThrow.getParticipant();
		if(prevThrow.getThrowCount() == 0){
			throwCount++;
			remainingPegs = 10 - pegsDown;
		} else {
			throwCount = prevThrow.getThrowCount() + 1;
			remainingPegs = prevThrow.getRemainingPegs() - pegsDown;
		}
		if(remainingPegs < 0) { //error
		}
		currentScore = prevThrow.getScore() + pegsDown;
		if(remainingPegs == 0 && throwCount==1){
			currentScore += 10;
		} else if(remainingPegs == 0 && throwCount==2){
			currentScore += 5;
		}

		if( (remainingPegs == 0 || throwCount==2 ) && currentRound < 10){
			currentRound += prevThrow.getCurrentRound();
			remainingPegs = 10;
			throwCount = 0;
		} else if(currentRound == 10){
			if(throwCount == 1 && remainingPegs == 0){
				throwCount = 2;
				remainingPegs = 10;
			} else if(throwCount == 2 && remainingPegs == 0){
				remainingPegs = 10;
			} else if(throwCount == 3){
				currentRound++;
			}
		}
	}

	@Override
	public Throw addThrow(Integer pegsDown) {
		return new ThrowImpl(this, pegsDown);
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

	public Integer getThrowCount() {
		return throwCount;
	}

	public void setThrowCount(Integer throwCount) {
		this.throwCount = throwCount;
	}
}
