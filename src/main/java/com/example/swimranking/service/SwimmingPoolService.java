package com.example.swimranking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.UnOfficialRecord;
import com.example.swimranking.repository.SwimmingPoolRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SwimmingPoolService {

    private final SwimmingPoolRepository swimmingPoolRepository;


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

   

    
}
