package com.test.domain.entity;

import com.test.domain.entity.impl.Lane;
import com.test.domain.entity.impl.Participant;

import java.util.List;

public interface LaneInfo {

	List<Lane> getLaneQuota(Game g);
}
