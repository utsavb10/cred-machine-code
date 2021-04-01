package com.test.domain.entity.impl;

import com.test.domain.entity.Game;
import com.test.domain.entity.LaneInfo;
import com.test.domain.entity.ScoreBoard;

import java.util.*;


public class GameImpl implements Game {

	private Long gameId;
	private Set<Participant> participants;
	private ScoreBoard scoreBoard;
	private LaneInfo laneInfo;
	private Map<Participant, Lane> participantLaneMap;

	@Override
	public Game startGame(List<Participant> participants) {
		this.participants = new HashSet<>();
		this.participants.addAll(participants);
		this.gameId = new Random().nextLong();
		this.scoreBoard = new ScoreInfo(participants);
		laneInfo = null; //Get lane info from factory method
		participantLaneMap = new HashMap<>();
		for(Participant participant : participants){
			participantLaneMap.put(participant, laneInfo.getEmptyLane(this, participant));
		}
		return this;
	}

	@Override
	public Game endGame() {
		// check if all rounds completed by all particiapnts
		return null;
	}

	@Override
	public String callNextPlayer() {
		Participant nextPlayer = scoreBoard.getNextPlayer();
		return (nextPlayer.getUserName() + " bowl at " + getParticipantLaneMap().get(nextPlayer).getLaneId());
	}

	public Long getGameId() {
		return gameId;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	@Override
	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public void setScoreBoard(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

	public LaneInfo getLaneInfo() {
		return laneInfo;
	}

	public void setLaneInfo(LaneInfo laneInfo) {
		this.laneInfo = laneInfo;
	}

	public Map<Participant, Lane> getParticipantLaneMap() {
		return participantLaneMap;
	}

	public void setParticipantLaneMap(Map<Participant, Lane> participantLaneMap) {
		this.participantLaneMap = participantLaneMap;
	}
}
