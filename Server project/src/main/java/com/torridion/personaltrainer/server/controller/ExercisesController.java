package com.torridion.personaltrainer.server.controller;


import com.torridion.personaltrainer.server.entity.Exercises;
import com.torridion.personaltrainer.server.service.ExercisesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExercisesController {

    @Autowired
    ExercisesServiceImpl service;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Exercises insertExercises(Exercises exercises){
        return service.insertResults(exercises);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean removeExercises(Long id){
        return service.removeResults(id);
    }

    @RequestMapping(value = "/getbyuser", method = RequestMethod.GET)
    @ResponseBody
    public List<Exercises> getByUserId(Long id){
        return service.getByUserId(id);
    }




}
