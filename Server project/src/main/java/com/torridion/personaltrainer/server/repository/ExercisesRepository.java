package com.torridion.personaltrainer.server.repository;


import com.torridion.personaltrainer.server.entity.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercisesRepository extends JpaRepository <Exercises, Long>{
    List<Exercises> findByidUser(Long id);
}
