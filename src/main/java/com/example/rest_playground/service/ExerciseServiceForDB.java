package com.example.rest_playground.service;

import com.example.rest_playground.model.Exercise;
import com.example.rest_playground.repository.ExerciseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceForDB implements ExerciseService{
    private ExerciseRepo exerciseRepo;
    public ExerciseServiceForDB(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @Override
    public void create(Exercise exercise) {
        exerciseRepo.save(exercise);
    }

    @Override
    public List<Exercise> readAll() {
        return exerciseRepo.findAll();
    }

    @Override
    public Exercise read(int Id) {
        return exerciseRepo.findById(Id).isPresent()
                ? exerciseRepo.findById(Id).get()
                : null;
    }

    @Override
    public boolean update(Exercise exercise, int ID) {
        if (exerciseRepo.findById(ID).isPresent()) {
            exerciseRepo.delete(exerciseRepo.findById(ID).get());
            exerciseRepo.save(exercise);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        exerciseRepo.delete(exerciseRepo.findById(id).get());
        return !exerciseRepo.findById(id).isPresent();
    }
}
