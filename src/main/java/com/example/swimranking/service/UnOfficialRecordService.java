package com.example.swimranking.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.UnOfficialRecord;
import com.example.swimranking.repository.SwimmingPoolRepository;
import com.example.swimranking.repository.UnOfficialRecordRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UnOfficialRecordService {


    private final UnOfficialRecordRepository unOfficialRecordRepository;


    public int getPercentileRank(UnOfficialRecord target, List<UnOfficialRecord> unOfficialRecords) {


        if(target == null || unOfficialRecords.isEmpty()) {
            
            log.info("### getPercentileRank failed : params is null");
            return 0;
        }

        double targetTime = target.getRecord();
        List<Double> recordList = new ArrayList<>();

        for(UnOfficialRecord sr : unOfficialRecords){
            recordList.add(sr.getRecord());
        }

        int index = Collections.binarySearch(recordList, targetTime);

        if (index < 0) {
            log.info("### getPercentileRank failed : index is abnormal");
            return 0;
            // 찾을 수 없는 경우 처리
        }

        int percentile = (int) Math.ceil((index + 1) * 100.0 / recordList.size());
        
        return percentile;

    }


    public long countUnOfficialRecord() {
        return unOfficialRecordRepository.count();
    }



    // 수영장에서 unOfficialRecord를 
    public UnOfficialRecord saveUnOfficialRecords(UnOfficialRecord newRecord) {

        try {
            unOfficialRecordRepository.saveAndFlush(newRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("save UnOfficialRecord : " + newRecord);
        return newRecord;
    }

    
}
