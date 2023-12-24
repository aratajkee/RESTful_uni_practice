package com.example.rest_playground.service;

import com.example.rest_playground.model.Program;
import com.example.rest_playground.repository.ProgramRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{

    private final ProgramRepo programRepo;

    public ProgramServiceImpl(ProgramRepo programRepo) {
        this.programRepo = programRepo;
    }

    @Override
    public void create(Program program) {
        programRepo.save(program);
    }

    @Override
    public List<Program> readAll() {
        return programRepo.findAll();
    }

    @Override
    public Program read(int Id) {
        return this.programRepo.findById(Id).isPresent()
                ? programRepo.findById(Id).get()
                : null;
    }

    @Override
    public boolean update(Program program, int id) {
        if (programRepo.findById(id).isPresent()) {
            programRepo.delete(programRepo.findById(id).get());
            programRepo.save(program);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        programRepo.delete(programRepo.findById(id).get());
        return !programRepo.findById(id).isPresent();
    }
}
