package com.example.swimranking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swimranking.dto.RequestUnOfficialRecordDto;
import com.example.swimranking.dto.UnOfficialRecordDto;
import com.example.swimranking.model.SwimmingPool;
import com.example.swimranking.model.UnOfficialRecord;
import com.example.swimranking.service.SwimmingPoolService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SwimmingPoolController {

    private final SwimmingPoolService swimmingPoolService;



    // DTO로 변환 시켜야 GET메소드 쓰면서 Fetch Lazy하기 적합할거 같음
    // 수영장 정보가 아니라 비공식 기록 메소드로 변경예정
    // 엔티티에는 프록시가 담겨있어서 null 에러 발생할 수 있기 때문에 DTO에 담아서 보내기
    @GetMapping("/swimming-pool")
    public ResponseEntity getSwimmingPool(@RequestParam String name) {
 
        SwimmingPool result = swimmingPoolService.findSwimmingPoolByName(name);
        //result.getUnOfficialRecord();
        log.info("### TEST : " + result);

        List<UnOfficialRecordDto> list = new ArrayList<>();
        
        for(UnOfficialRecord uf : result.getUnOfficialRecord()){
            UnOfficialRecordDto ut = new UnOfficialRecordDto(uf);
            list.add(ut);
        }
 
        if(result == null) {
            return ResponseEntity.ok("result : no data");
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


    @PostMapping("/unofficial-record")
    public ResponseEntity addUnOfficialRecord(@RequestBody RequestUnOfficialRecordDto newRecordDto) {
        
        SwimmingPool result = swimmingPoolService.addUnOfficialRecord(newRecordDto.getSwimmingPoolName(), newRecordDto.getUnOfficialRecord());
 
        if(result == null) {
            ResponseEntity.ok("result : save failed");
        }
 
        return ResponseEntity.ok(result);
        
    }

    
}
