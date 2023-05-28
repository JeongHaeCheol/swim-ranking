package com.example.swimranking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swimranking.dto.ChangePasswordRequestDto;
import com.example.swimranking.dto.MemberRequestDto;
import com.example.swimranking.dto.MemberResponseDto;
import com.example.swimranking.model.Member;
import com.example.swimranking.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("")
    @Operation(summary = "현재 로그인한 멤버의 ID 리턴")
    public ResponseEntity<Long> getMyMemberIdByEmail(){

        String email = memberService.getMyInfoBySecurity().getEmail();
        Member member = memberService.findByEmail(email);
        
        if(member == null) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(member.getId());
    }


    @GetMapping("/me")
    @Operation(summary = "현재 로그인한 멤버 정보 리턴", description = "이메일과 닉네임 정보")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        MemberResponseDto memberResponseDto = memberService.getMyInfoBySecurity();
        System.out.println(memberResponseDto.getNickname());
        return ResponseEntity.ok((memberResponseDto));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }

    @PostMapping("/nickname")
    @Operation(summary = "닉네임 변경")
    public ResponseEntity<MemberResponseDto> setMemberNickname(@RequestBody MemberRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberNickname(request.getEmail(), request.getNickname()));
    }

    @PostMapping("/password")
    @Operation(summary = "패스워드 변경")
    public ResponseEntity<MemberResponseDto> setMemberPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberPassword(request.getEmail() ,request.getExPassword(), request.getNewPassword()));
    }

}
