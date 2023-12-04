package com.example.rest_playground.controller;

import com.example.rest_playground.model.Exercise;
import com.example.rest_playground.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {
    public final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(@Qualifier("exerciseServiceForDB") ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

//    @PostMapping("/exercises")
//    public ResponseEntity<?> create(@RequestBody Exercise exercise) {
//        exerciseService.create(exercise);
//        return exercise != null
//                ? new ResponseEntity<>(HttpStatus.CREATED)
//                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @PostMapping("/exercises")
    public ResponseEntity<?> create(@RequestBody List <Exercise> exercises) {
        for (Exercise ex : exercises) {
            exerciseService.create(ex);
        }
        return exercises != null && !exercises.isEmpty()
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/exercises")
    public ResponseEntity<List<Exercise>> read() {
        final List<Exercise> exercises = exerciseService.readAll();
        return !exercises.isEmpty() && exercises != null
                ? new ResponseEntity<>(exercises, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/exercises/{id}")
    public ResponseEntity<Exercise> read(@PathVariable(name = "id") int id) {
        final Exercise exercise = exerciseService.read(id);
        return exercise != null
                ? new ResponseEntity<>(exercise, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/exercises/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean isDeleted = exerciseService.delete(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/exercises/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Exercise exercise) {
        final boolean isUpdated = exerciseService.update(exercise, id);
        return isUpdated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
