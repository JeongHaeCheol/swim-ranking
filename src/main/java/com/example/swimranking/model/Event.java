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
@Table(name="events")
@NoArgsConstructor
public class Event {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id; 

    
    private String name;

    @NotEmpty
    private String distance;

    @NotEmpty
    private String stroke;

    private boolean finCheck;


    public Event(String name, String distance, String stroke, boolean finCheck) {
        this.name = name;
        this.distance = distance;
        this.stroke = stroke;
        this.finCheck = finCheck;
    }

    

}
