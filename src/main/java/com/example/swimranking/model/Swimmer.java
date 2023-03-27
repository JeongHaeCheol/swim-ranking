package com.example.swimranking.model;

import java.util.Date;

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

// Table: swimmers

// id (primary key)
// name
// date_of_birth
// gender
// country
// Table: competitions

// id (primary key)
// name
// location
// date
// type (e.g. Olympic Games, World Championships, National Championships)
// Table: events

// id (primary key)
// name
// distance
// stroke (e.g. freestyle, breaststroke, butterfly, backstroke, individual medley)
// Table: results

// id (primary key)
// swimmer_id (foreign key to swimmers table)
// competition_id (foreign key to competitions table)
// event_id (foreign key to events table)
// time (in seconds)
// place (e.g. 1st place, 2nd place, etc.)

@Getter
@Setter
@ToString
@Entity
@Table(name="swimmers")
@NoArgsConstructor
public class Swimmer {


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id; 

    @NotEmpty
    private String name;
    private Date birth;

    private String club;

    @NotEmpty
    private String gender;
    private String country;
}
