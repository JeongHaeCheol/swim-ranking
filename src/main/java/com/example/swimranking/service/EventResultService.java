package com.example.swimranking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.dto.EventResultDto;
import com.example.swimranking.dto.SwimmerDto;
import com.example.swimranking.model.Competition;
import com.example.swimranking.model.Event;
import com.example.swimranking.model.EventResult;
import com.example.swimranking.model.Swimmer;
import com.example.swimranking.repository.CompetitionRepository;
import com.example.swimranking.repository.EventRepository;
import com.example.swimranking.repository.EventRepositoryCustom;
import com.example.swimranking.repository.EventResultRepository;
import com.example.swimranking.repository.EventResultRepositoryCustom;
import com.example.swimranking.repository.SwimmerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventResultService {

    private final EventResultRepositoryCustom eventResultRepositoryCustom;
    private final EventResultRepository eventResultRepository;
    private final CompetitionRepository competitionRepository;
    private final EventRepositoryCustom eventRepositoryCustom;
    private final EventRepository eventRepository;
    private final SwimmerRepository swimmerRepository;

    public List<EventResultDto> findEventResultByNameJoin(String name) {
        return eventResultRepositoryCustom.findEventResultByNameJoin(name);
    }

    public List<EventResult> getSimple(String name) {
        return eventResultRepository.findEventResultByName(name);
    }

    public EventResult saveEventResult(EventResult eventResult) {

        try {
            eventResultRepository.saveAndFlush(eventResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("save eventResult : " + eventResult);
        return eventResult;

    }

    public List<EventResultDto> findEventResultByName(String name) {
        return eventResultRepositoryCustom.findEventResultByName(name);

    }

    public Boolean SaveEventResultByRelation(EventResultDto eventResultDto) {

        try {
            Swimmer swimmer = swimmerRepository.findSwimmerById(eventResultDto.getSwimmer_id());
            Event event = eventRepositoryCustom.findEventByName(eventResultDto.getEventName());
            Competition competition = competitionRepository.findCompetitionByName(eventResultDto.getCompetitionName());

            EventResult saveEntity = new EventResult();
            saveEntity.setName(eventResultDto.getName());
            saveEntity.setAgeRange(eventResultDto.getAgeRange());
            saveEntity.setClub(eventResultDto.getClub());
            saveEntity.setRaceRank(eventResultDto.getRaceRank());
            saveEntity.setRaceTime(eventResultDto.getRaceTime());

            saveEntity.setSwimmer(swimmer);
            saveEntity.setEvent(event);
            saveEntity.setCompetition(competition);

            eventResultRepository.save(saveEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
