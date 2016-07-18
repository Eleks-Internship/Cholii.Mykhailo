package com.torridion.personaltrainer.server.service;

import com.torridion.personaltrainer.server.entity.Subscribes;
import com.torridion.personaltrainer.server.repository.SubscribesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribesServiceImpl implements SubscribesService{

    @Autowired
    SubscribesRepository repository;

    public Subscribes subscribe(Subscribes subscribe) {
        return repository.saveAndFlush(subscribe);
    }

    public boolean unsubscribe(Subscribes subscribes) {
        repository.delete(subscribes);
        return true;
    }
}
