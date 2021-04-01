package com.test.domain.entity;

import com.test.domain.entity.impl.Lane;
import com.test.domain.entity.impl.Participant;

public interface LaneInfo {

	Lane getEmptyLane(Game g, Participant p);
}
