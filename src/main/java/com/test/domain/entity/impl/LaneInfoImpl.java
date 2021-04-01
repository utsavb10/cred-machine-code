package com.test.domain.entity.impl;

import com.test.domain.entity.Game;
import com.test.domain.entity.LaneInfo;

public class LaneInfoImpl implements LaneInfo {

	@Override
	public Lane getEmptyLane(Game g, Participant p) {
		// singleton class which is received by a factory implementation
		// return list of available lanes based on playerCount and other factors;
		return null;
	}
}
