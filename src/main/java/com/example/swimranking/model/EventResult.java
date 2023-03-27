package com.example.swimranking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="event_results")
@NoArgsConstructor
public class EventResult {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id; 

    /*
     * 기능 시나리오  이름으로 검색 -> 같은이름의 기록이 줄줄이 나옴
     * 추후 구별을 위한 기능이 필요 
     * 이름, 클럽명으로 pk로 하여 동명이인을 구별?  같은클럽에 같은 이름이 존재할수잇음, 클럽을 바꿀수도있음
     * 이테이블을 다른 테이블과 조인하지 않고 사용하여 기본검색으로 동명이인들이 myranking처럼 다뜨게함
     * 추후에 event별 통계를 만든다고 했을떄 event 1 vs eventResult 다 -> 
     * 대회별 기록통계
     */

    @NotEmpty
    private String name;

    @NotEmpty
    private int swimmer_id;

    @NotEmpty
    private int competition_id;

    @NotEmpty
    private int event_id;

    @NotEmpty
    private double raceTime;

    @NotEmpty
    private String raceRank;

    
}
