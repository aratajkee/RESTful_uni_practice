package com.example.rest_playground.service;

import com.example.rest_playground.model.Program;

import java.util.List;

public interface ProgramService {

    void create(Program program);

    List<Program> readAll();
    Program read(int Id);

    boolean update(Program program, int id);

    boolean delete (int id);
}
