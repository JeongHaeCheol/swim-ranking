package com.example.swimranking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swimranking.dto.MemberRequestDto;
import com.example.swimranking.dto.MemberResponseDto;
import com.example.swimranking.jwt.TokenDto;
import com.example.swimranking.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto requestDto) {
        log.info("### login : " + requestDto);
        return ResponseEntity.ok(authService.login(requestDto));
    }


    // @PostMapping("/refresh")
    // public ResponseEntity<TokenDto> refreshToken(@RequestBody MemberRequestDto requestDto) {
    //     return ResponseEntity.ok(authService.login(requestDto));
    // }


}
