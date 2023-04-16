package com.example.swimranking.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.SwimRecord;
import com.example.swimranking.repository.SwimmingPoolRepository;
import com.example.swimranking.repository.SwimRecordRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SwimRecordService {


    private final SwimRecordRepository swimRecordRepository;


    public int getPercentileRank(SwimRecord target, List<SwimRecord> swimRecords) {


        if(target == null || swimRecords.isEmpty()) {
            
            log.info("### getPercentileRank failed : params is null");
            return 0;
        }

        double targetTime = target.getRecord();
        List<Double> recordList = new ArrayList<>();

        for(SwimRecord sr : swimRecords){
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


    public SwimRecord findSwimRecordBySwimmerId(int id) {
        return swimRecordRepository.findSwimRecordBySwimmerId(id);

    }

    public long countSwimRecord() {
        return swimRecordRepository.count();
    }

    public SwimmingPool addSwimRecord(SwimmingPool swimmingPool, SwimRecord newRecord) {

        List<SwimRecord> swimRecordList = null;

        if(swimmingPool == null) {
            log.info("### Add new SwimRecord Failed : " + swimmingPool + "is not Exist" );
        }

        try {
            swimRecordList = swimmingPool.getSwimRecord();

            if(swimRecordList != null){
                for(SwimRecord ur : swimRecordList) {
                    if(ur.getSwimmer() != null 
                    && newRecord.getSwimmer() != null 
                    && ur.getSwimmer().getId() == newRecord.getId()) {
                        log.info("### Add new SwimRecord Failed : " + newRecord.getSwimmer() + "is already Exist" );
                        return null;
                    }
                }

            }
            swimRecordList.add(newRecord);
            swimRecordRepository.saveAndFlush(newRecord);
            swimmingPool.setSwimRecord(swimRecordList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("Added SwimRecord (need to saveAndFlsuh swimming pool): " + swimmingPool);
        return swimmingPool;
    }


    // 수영장에서 swimRecord를 
    public SwimRecord saveSwimRecords(SwimRecord newRecord) {

        try {
            swimRecordRepository.saveAndFlush(newRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("save SwimRecord : " + newRecord);
        return newRecord;
    }

    
}
