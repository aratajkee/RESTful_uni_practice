package com.example.rest_playground.repository;

import com.example.rest_playground.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepo extends JpaRepository<Exercise, Integer> {
}
