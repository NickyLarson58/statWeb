package com.pm.spring.jpa.h2.controller;

import com.pm.spring.jpa.h2.model.Adresses;
import com.pm.spring.jpa.h2.model.Missions;
import com.pm.spring.jpa.h2.model.StatMission;
import com.pm.spring.jpa.h2.repository.MissionsRepository;
import com.pm.spring.jpa.h2.repository.StatMissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MissionsController {

    @Autowired
    StatMissionRepository statMissionRepository;

    @Autowired
    MissionsRepository missionRepository;

    @GetMapping("/missions")
    public ResponseEntity<List<Missions>> getAllMissions() {
        try {
            List<Missions> missions = missionRepository.findAll();
            if (missions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(missions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/missions/{id}")
    public ResponseEntity<Missions> getMissionById(@PathVariable("id") long id) {
        Optional<Missions> missionData = missionRepository.findById(id);

        if (missionData.isPresent()) {
            return new ResponseEntity<>(missionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/missions/{id}")
    public ResponseEntity<HttpStatus> deleteMission(@PathVariable("id") long id) {
        try {
            missionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/missions")
    public ResponseEntity<HttpStatus> deleteAllMissions() {
        try {
            missionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/missions/stat")
    public ResponseEntity<List<StatMission>> getAllStatMissions() {
        try {
            List<StatMission> missions = statMissionRepository.findAll();
            if (missions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(missions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/missions/{id}/stat")
    public ResponseEntity<StatMission> getStatMissionById(@PathVariable("id") long id) {
        Optional<StatMission> missionData = statMissionRepository.findById(id);
        return missionData.map(mission -> new ResponseEntity<>(mission, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/missions/stat")
    public ResponseEntity<StatMission> createStatMission(@RequestBody StatMission mission) {
        try {
            StatMission _mission = statMissionRepository.save(mission);
            return new ResponseEntity<>(_mission, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/missions/{id}/stat")
    public ResponseEntity<StatMission> updateStatMission(@PathVariable("id") long id, @RequestBody StatMission mission) {
        Optional<StatMission> missionData = statMissionRepository.findById(id);

        if (missionData.isPresent()) {
            StatMission _mission = missionData.get();
            _mission.setDate_mission(mission.getDate_mission());
            _mission.setLieu_mission(mission.getLieu_mission());
            _mission.setMission(mission.getMission());
            _mission.setCommerce(mission.getCommerce());
            _mission.setDuree_mission(mission.getDuree_mission());
            return new ResponseEntity<>(statMissionRepository.save(_mission), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/missions/{id}/stat")
    public ResponseEntity<HttpStatus> deleteStatMission(@PathVariable("id") long id) {
        try {
            statMissionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/missions/stat")
    public ResponseEntity<HttpStatus> deleteAllStatMissions() {
        try {
            statMissionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}