package com.pm.spring.jpa.h2.service;

import com.pm.spring.jpa.h2.payload.CreatedStatMissionDTO;
import com.pm.spring.jpa.h2.model.StatMission;

public interface MissionService {
    /**
     * Creates a new mission based on the provided DTO
     * @param missionDTO the DTO containing mission details
     * @return the created mission
     */
    StatMission createMission(CreatedStatMissionDTO missionDTO);
}