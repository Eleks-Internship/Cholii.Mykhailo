package com.torridion.personaltrainer.server.service;


import com.torridion.personaltrainer.server.entity.Exercises;

import java.util.List;

public interface ExercisesService {

    Exercises insertResults(Exercises exercise);
    boolean removeResults(Long id);
    List<Exercises> getByUserId(Long id);
}
