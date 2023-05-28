package com.example.swimranking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.dto.CompetitionRecordDto;
import com.example.swimranking.dto.TrendChangeDto;
import com.example.swimranking.model.Competition;
import com.example.swimranking.model.Event;
import com.example.swimranking.model.CompetitionRecord;
import com.example.swimranking.repository.CompetitionRepository;
import com.example.swimranking.repository.EventRepository;
import com.example.swimranking.repository.EventRepositoryCustom;
import com.example.swimranking.repository.CompetitionRecordRepository;
import com.example.swimranking.repository.CompetitionRecordRepositoryCustom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompetitionRecordService {

    private final CompetitionRecordRepositoryCustom competitionRecordRepositoryCustom;
    private final CompetitionRecordRepository competitionRecordRepository;
    private final CompetitionRepository competitionRepository;
    private final EventRepositoryCustom eventRepositoryCustom;
    private final EventRepository eventRepository;



    public List<TrendChangeDto> getTrend(int memberId, int eventId){
        return null;
    }

    public List<CompetitionRecord> getSimple(String name) {
        return competitionRecordRepository.findByName(name);
    }

    public CompetitionRecord saveCompetitionRecord(CompetitionRecord competitionRecord) {

        try {
            competitionRecordRepository.saveAndFlush(competitionRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("save competitionRecord : " + competitionRecord);
        return competitionRecord;

    }

    public List<CompetitionRecordDto> findCompetitionRecordByName(String name) {
        return competitionRecordRepositoryCustom.findCompetitionRecordByName(name);

    }

    public Boolean SaveCompetitionRecordByRelation(CompetitionRecordDto competitionRecordDto) {

        try {
            Event event = eventRepositoryCustom.findEventByName(competitionRecordDto.getEventName());
            Competition competition = competitionRepository.findCompetitionByName(competitionRecordDto.getCompetitionName());

            CompetitionRecord saveEntity = new CompetitionRecord();
            saveEntity.setName(competitionRecordDto.getName());
            saveEntity.setAgeRange(competitionRecordDto.getAgeRange());
            saveEntity.setClub(competitionRecordDto.getClub());
            saveEntity.setRaceRank(competitionRecordDto.getRaceRank());
            saveEntity.setRaceTime(competitionRecordDto.getRaceTime());

            saveEntity.setEvent(event);
            saveEntity.setCompetition(competition);

            competitionRecordRepository.save(saveEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
