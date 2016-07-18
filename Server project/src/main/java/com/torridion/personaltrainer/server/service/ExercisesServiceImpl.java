package com.torridion.personaltrainer.server.service;


import com.torridion.personaltrainer.server.entity.Exercises;
import com.torridion.personaltrainer.server.repository.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesServiceImpl implements ExercisesService{

    @Autowired
    private ExercisesRepository repository;

    public Exercises insertResults(Exercises exercise) {
        repository.saveAndFlush(exercise);
        return exercise;
    }

    public boolean removeResults(Long id) {
        repository.delete(id);
        return true;
    }

    public List<Exercises> getByUserId(Long id) {
        return repository.findByidUser(id);
    }
}
