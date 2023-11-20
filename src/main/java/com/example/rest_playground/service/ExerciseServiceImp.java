package com.example.rest_playground.service;

import com.example.rest_playground.model.Exercise;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExerciseServiceImp implements ExerciseService{

    private static final Map<Integer, Exercise> EX_TEMP_HOLDER = new HashMap<>();
    private static final AtomicInteger EX_TEMP_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Exercise exercise) {
        final int exID = EX_TEMP_ID_HOLDER.incrementAndGet();
        exercise.setID(exID);
        EX_TEMP_HOLDER.put(exID, exercise);
    }

    @Override
    public List<Exercise> readAll() {
        return new ArrayList<>(EX_TEMP_HOLDER.values());
    }

    @Override
    public Exercise read(int Id) {
        return EX_TEMP_HOLDER.get(Id);
    }

    @Override
    public boolean update(Exercise exercise, int ID) {
        if (EX_TEMP_HOLDER.containsKey(ID)) {
            exercise.setID(ID);
            EX_TEMP_HOLDER.put(ID,exercise);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return EX_TEMP_HOLDER.remove(id) != null;
    }
}
