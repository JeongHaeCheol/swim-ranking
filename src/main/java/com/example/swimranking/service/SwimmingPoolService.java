package com.example.swimranking.service;

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
public class SwimmingPoolService {

    private final SwimmingPoolRepository swimmingPoolRepository;

    private final UnOfficialRecordRepository unOfficialRecordRepository;



    public long countSwimmingPool() {
        return swimmingPoolRepository.count();
    }


    public SwimmingPool findSwimmingPoolByName(String name) {
        return swimmingPoolRepository.findSwimmingPoolByName(name);
    }


    public List<SwimmingPool> saveSwimmingPoolList(List<SwimmingPool> swimmingPoolList) {

        try {
            swimmingPoolRepository.saveAllAndFlush(swimmingPoolList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("save SwimmingPoolList : " + swimmingPoolList);
        return swimmingPoolList;
    }


    public SwimmingPool saveSwimmingPool(SwimmingPool swimmingPool) {
        

        try {
            swimmingPoolRepository.saveAndFlush(swimmingPool);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("save SwimmingPool : " + swimmingPool);
        return swimmingPool;
    }

    public SwimmingPool addUnOfficialRecord(String name, UnOfficialRecord newRecord) {

        SwimmingPool swimmingPool = null;
        List<UnOfficialRecord> unOfficialRecordList = null;

        try {
            swimmingPool = findSwimmingPoolByName(name);
            unOfficialRecordList = swimmingPool.getUnOfficialRecord();

            if(unOfficialRecordList != null){
                for(UnOfficialRecord ur : unOfficialRecordList) {
                    if(ur.getSwimmer() != null 
                    && newRecord.getSwimmer() != null 
                    && ur.getSwimmer().getId() == newRecord.getId()) {
                        log.info("### Add new UnOfficialRecord Failed : " + newRecord.getSwimmer() + "is already Exist" );
                        return null;
                    }
                }

            }
            unOfficialRecordList.add(newRecord);
            swimmingPool.setUnOfficialRecord(unOfficialRecordList);
            swimmingPoolRepository.saveAndFlush(swimmingPool);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        log.info("update SwimmingPool (UnOfficialRecord) : " + swimmingPool);
        return swimmingPool;
    }

    
}
