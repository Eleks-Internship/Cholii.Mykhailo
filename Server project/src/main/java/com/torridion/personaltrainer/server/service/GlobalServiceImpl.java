package com.torridion.personaltrainer.server.service;


import com.torridion.personaltrainer.server.entity.Global;
import com.torridion.personaltrainer.server.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalServiceImpl implements GlobalService{

    @Autowired
    GlobalRepository repository;

    public Global getStatistic() {
        return repository.getOne(Short.valueOf("1"));
    }

    public void updateStatistic(Global global) {
        repository.saveAndFlush(global);
    }
}
