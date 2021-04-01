package com.test.domain.entity.impl;

import com.test.domain.entity.Game;
import com.test.domain.entity.LaneInfo;

import java.util.ArrayList;
import java.util.List;

public class LaneInfoImpl implements LaneInfo {

	private static LaneInfo laneInfo = null;

	public static LaneInfo getLaneInfo(){
		if(laneInfo == null){
			laneInfo = new LaneInfoImpl();
		}
		return laneInfo;
	}

	@Override
	public synchronized List<Lane> getLaneQuota(Game g) {
		// returns new List of empty adjacent lanes based on lane availability and number of players involved
		return new ArrayList<>();
	}
}
