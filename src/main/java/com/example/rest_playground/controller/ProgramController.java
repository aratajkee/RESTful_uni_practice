package com.example.rest_playground.controller;

import com.example.rest_playground.model.Program;
import com.example.rest_playground.service.ProgramService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping("/programs")
    public ResponseEntity<?> create(@RequestBody Program program) {
        programService.create(program);
        return program != null
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/programs")
    public ResponseEntity<List<Program>> read() {
        final List<Program> list = programService.readAll();
        return !list.isEmpty() && list != null
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/programs/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") int id) {
        final Program program = programService.read(id);
        return program != null
                ? new ResponseEntity<>(program, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/programs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean idDeleted = programService.delete(id);
        return idDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/programs/{id}")
    public ResponseEntity<?> update(@PathVariable(name  = "id") int id, @RequestBody Program program) {
        final boolean isUpdated = programService.update(program, id);
        return isUpdated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
