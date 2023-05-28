package com.example.swimranking.dto;

import com.example.swimranking.model.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberResponseDto {
    private String email;
    private String nickname;

    public static MemberResponseDto of(Member payload) {
        return MemberResponseDto.builder()
                .email(payload.getEmail())
                .nickname(payload.getNickname())
                .build();
    }
}