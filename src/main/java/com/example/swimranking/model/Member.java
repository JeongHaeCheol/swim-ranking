package com.example.swimranking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String club;

    @Column(nullable = false)
    private String country;


    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date birth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="swimming_pool_id", insertable = false, updatable = false)
    private SwimmingPool swimmingPool;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="member_swim_record")
    private List<UnOfficialRecord> swimRecord;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="member_competition_record")
    private List<CompetitionRecord> competitionRecord;


    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) { this.password = password; }


    @Builder
    public Member(Long id, String email, String password, String nickname, String sex, String club, String country,
            Date birth, SwimmingPool swimmingPool, List<UnOfficialRecord> swimRecord, List<CompetitionRecord> competitionRecord,
            Authority authority) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.club = club;
        this.country = country;
        this.birth = birth;
        this.swimmingPool = swimmingPool;
        this.swimRecord = swimRecord;
        this.competitionRecord = competitionRecord;
        this.authority = authority;
    }


    
    
    
    
}
