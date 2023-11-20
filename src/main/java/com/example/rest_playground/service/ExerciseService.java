package com.example.rest_playground.service;

import com.example.rest_playground.model.Exercise;

import java.util.List;

public interface ExerciseService {

    void create(Exercise exercise);

    List<Exercise> readAll();
    Exercise read(int Id);

    boolean update(Exercise exercise, int ID);

    boolean delete (int id);
}
