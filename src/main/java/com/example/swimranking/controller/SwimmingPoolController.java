package com.example.swimranking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swimranking.dto.RequestSwimRecordDto;
import com.example.swimranking.dto.SwimRecordDto;
import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.UnOfficialRecord;
import com.example.swimranking.service.UnOfficialRecordService;

import io.swagger.v3.oas.annotations.Operation;

import com.example.swimranking.service.SwimmingPoolService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/swimming-pool")
@RequiredArgsConstructor
@Slf4j
public class SwimmingPoolController {

    private final SwimmingPoolService swimmingPoolService;

    private final UnOfficialRecordService swimRecordService;



    // DTO로 변환 시켜야 GET메소드 쓰면서 Fetch Lazy하기 적합할거 같음
    // 엔티티에는 프록시가 담겨있어서 null 에러 발생할 수 있기 때문에 DTO에 담아서 보내기

    @PostMapping()
    @Operation(summary = "수영장 검색")
    public ResponseEntity postSwimmingPool(@RequestBody SwimmingPool swimmingPool) {
        
        SwimmingPool result = swimmingPoolService.saveSwimmingPool(swimmingPool);
 
        if(result == null) {
            ResponseEntity.ok("result : save failed");
        }
 
        return ResponseEntity.ok(result);
        
    }




    @GetMapping("/my-percentage")
    public ResponseEntity getPercentileRank(int swimmerId, String poolName) {


        // SwimmingPool swimmingPool = swimmingPoolService.findSwimmingPoolByName(poolName);
        // List<SwimRecord> swimRecords = swimmingPool.getSwimRecord();

        // SwimRecord target = null; 

        // if(swimmingPool == null || swimRecords.isEmpty()) {
        //     log.info("### getPercentileRank failed : pool is null or record is empty");
        //        return  ResponseEntity.ok("result :  getPercentileRank failed ");

        // }

        // for(SwimRecord sr : swimRecords) {
        //     if(sr.getSwimmer() != null && sr.getSwimmer().getId() == swimmerId ) {
        //         target = sr;
        //     } 
        // }


        // int percentage = swimRecordService.getPercentileRank(target, swimRecords);
         return  ResponseEntity.ok(null);

    }

    
}
