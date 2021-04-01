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
	private List<Lane> laneQuota;

	// implement player-lane based lock mechanism such that a lane is blocked by player till player completes all throws for a round
	private Map<Lane, Participant> participantLaneMap;

	@Override
	public Game startGame(List<Participant> participants) {
		this.participants = new HashSet<>();
		this.participants.addAll(participants);
		this.gameId = new Random().nextLong();
		this.scoreBoard = new ScoreInfo(participants);
		laneInfo = LaneInfoImpl.getLaneInfo();
		participantLaneMap = new HashMap<>();
		for(Lane lane : laneQuota){
			participantLaneMap.put(lane, null);
		}
		laneQuota = laneInfo.getLaneQuota(this);
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
		Lane availableLane = participantLaneMap.keySet().stream()
			.filter(lane -> null == participantLaneMap.get(lane))
			.findFirst()
			.orElse(null);

		if(null != availableLane && null != nextPlayer){
			participantLaneMap.put(availableLane, nextPlayer);
			return (nextPlayer.getUserName() + " bowl at " + availableLane.getLaneId());
		}
		return "all assigned lanes busy";
	}

	@Override
	public void addThrow(Participant p, Integer pegsDown) {
		boolean laneLockFlag = scoreBoard.addThrow(p, pegsDown);
		if(!laneLockFlag){
			unlockLane(participantLaneMap.entrySet()
				.stream()
				.filter(laneParticipantEntry -> p.getUserId().equals(laneParticipantEntry.getValue().getUserId()))
				.findFirst()
				.get()
				.getKey());
		}
	}

	@Override
	public void unlockLane(Lane lane) {
		if(null != participantLaneMap && participantLaneMap.containsKey(lane)){
			participantLaneMap.put(lane, null);
		}
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

	public List<Lane> getLaneQuota() {
		return laneQuota;
	}

	public void setLaneQuota(List<Lane> laneQuota) {
		this.laneQuota = laneQuota;
	}

	public Map<Lane, Participant> getParticipantLaneMap() {
		return participantLaneMap;
	}

	public void setParticipantLaneMap(Map<Lane, Participant> participantLaneMap) {
		this.participantLaneMap = participantLaneMap;
	}
}
