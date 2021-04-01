package com.test.domain.entity.impl;

import com.test.domain.entity.ScoreBoard;
import com.test.domain.entity.Throw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreInfo implements ScoreBoard {

//	private Long gameId;
	private Map<Participant, Throw> participantThrowMap;

	public ScoreInfo(List<Participant> participants){
		participantThrowMap = new HashMap<>();
		for(Participant participant : participants){
			participantThrowMap.put(participant, new ThrowImpl(participant));
		}
	}

	public ScoreInfo(Map<Participant, Throw> participantThrowMap) {
		this.participantThrowMap = participantThrowMap;
	}

	@Override
	public String getCurrentWinner() {
		return participantThrowMap.entrySet().stream()
			.max((o1, o2) -> (o1.getValue().getScore()-o2.getValue().getScore()))
			.get()
			.getKey()
			.getUserName();
	}

	@Override
	public Participant getNextPlayer() {
		return participantThrowMap.entrySet().stream()
			.min(this::comparePlayerTurns)
			.get()
			.getKey();
	}

	public Map<Participant, Throw> getParticipantThrowMap() {
		return participantThrowMap;
	}

	private Integer comparePlayerTurns(Map.Entry<Participant, Throw> o1, Map.Entry<Participant, Throw> o2){
		return o1.getValue().getCurrentRound() - o2.getValue().getCurrentRound();
	}
}
