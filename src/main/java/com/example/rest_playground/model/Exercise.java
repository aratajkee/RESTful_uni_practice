package com.example.rest_playground.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "exercise_table")
public class Exercise {
    @Id
    @Column(name = "id_exercise")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer ID;
    @Column(name = "exercise_name")
    private String ex_name;
    @Column(name = "exercise_equipment")
    private String equipment;
    @Column(name = "exercise_repetitions")
    private Integer repetitions;

}
