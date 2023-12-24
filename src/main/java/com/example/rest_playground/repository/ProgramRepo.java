package com.example.rest_playground.repository;

import com.example.rest_playground.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepo extends JpaRepository<Program, Integer> {
}
