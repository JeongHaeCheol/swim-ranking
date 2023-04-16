package com.example.swimranking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="swim_record")
@NoArgsConstructor
public class SwimRecord {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id; 

    @NotEmpty
    private String name;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="swimmer_id")
    private Swimmer swimmer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;

    //NotEmpty는 String에만 사용 null 과 ""을 다 배제하기 때문에
    @NotNull
    private double record;

    private boolean officialCheck;

    private Date measuredDate;

}
