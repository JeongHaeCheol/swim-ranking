package com.example.swimranking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swimranking.dto.RequestSwimRecordDto;
import com.example.swimranking.dto.SwimRecordDto;
import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.SwimRecord;
import com.example.swimranking.service.SwimRecordService;
import com.example.swimranking.service.SwimmingPoolService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SwimmingPoolController {

    private final SwimmingPoolService swimmingPoolService;

    private final SwimRecordService swimRecordService;



    // DTO로 변환 시켜야 GET메소드 쓰면서 Fetch Lazy하기 적합할거 같음
    // 수영장 정보가 아니라 비공식 기록 메소드로 변경예정
    // 엔티티에는 프록시가 담겨있어서 null 에러 발생할 수 있기 때문에 DTO에 담아서 보내기
    @GetMapping("/swimming-pool")
    public ResponseEntity getSwimmingPool(@RequestParam String name) {
 
        SwimmingPool result = swimmingPoolService.findSwimmingPoolByName(name);
        //result.getSwimRecord();
        log.info("### TEST : " + result);

        List<SwimRecordDto> list = new ArrayList<>();
        
        if(result == null) {
            return ResponseEntity.ok("result : no data");
        }
        

        for(SwimRecord uf : result.getSwimRecord()){
            SwimRecordDto ut = new SwimRecordDto(uf);
            list.add(ut);
        }
 

        return ResponseEntity.ok(list);
    }



    @PostMapping("/swimming-pool")
    public ResponseEntity postSwimmingPool(@RequestBody SwimmingPool swimmingPool) {
        
        SwimmingPool result = swimmingPoolService.saveSwimmingPool(swimmingPool);
 
        if(result == null) {
            ResponseEntity.ok("result : save failed");
        }
 
        return ResponseEntity.ok(result);
        
    }


    @PostMapping("/swim-record")
    public ResponseEntity addSwimRecord(@RequestBody RequestSwimRecordDto newRecordDto) {
        
        // 해당하는 수영장 find
        SwimmingPool swimmingPool = swimmingPoolService.findSwimmingPoolByName(newRecordDto.getSwimmingPoolName());

        // swimRecord는 saveAndFlush했지만 swimRecord를 담은 SwimmingPool은 SaveAndFlush되지 않음
        SwimmingPool updatedSwimmingPool = swimRecordService.addSwimRecord(swimmingPool, newRecordDto.getSwimRecord());

        // SimmingPool을 saveAndFlush
        SwimmingPool result = swimmingPoolService.saveSwimmingPool(updatedSwimmingPool);

        if(result == null) {
            ResponseEntity.ok("result : save failed");
        }
 
        return ResponseEntity.ok(result);
        
    }

    @GetMapping("/my-percentage")
    public ResponseEntity getPercentileRank(int swimmerId, String poolName) {


        SwimmingPool swimmingPool = swimmingPoolService.findSwimmingPoolByName(poolName);
        List<SwimRecord> swimRecords = swimmingPool.getSwimRecord();

        SwimRecord target = null; 

        if(swimmingPool == null || swimRecords.isEmpty()) {
            log.info("### getPercentileRank failed : pool is null or record is empty");
               return  ResponseEntity.ok("result :  getPercentileRank failed ");

        }

        for(SwimRecord sr : swimRecords) {
            if(sr.getSwimmer() != null && sr.getSwimmer().getId() == swimmerId ) {
                target = sr;
            } 
        }


        int percentage = swimRecordService.getPercentileRank(target, swimRecords);
        return  ResponseEntity.ok(percentage);

    }

    
}
