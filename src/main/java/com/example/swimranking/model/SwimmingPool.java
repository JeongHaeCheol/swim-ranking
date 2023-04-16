package com.example.swimranking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name="swimming_pool")
@NoArgsConstructor
public class SwimmingPool {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(nullable = false, unique= true)
    private String name;

    private String location;

    private int poolSize;

    private int swimmerCount;

    private String url;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="swimming_pool_id")
    @OrderBy("record ASC")
    private List<SwimRecord> SwimRecord;

    
    
}
