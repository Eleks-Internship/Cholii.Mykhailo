package com.torridion.personaltrainer.server.controller;

import com.torridion.personaltrainer.server.entity.Subscribes;
import com.torridion.personaltrainer.server.service.SubscribesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscribes")
public class SubscribesController {

    @Autowired
    SubscribesServiceImpl service;

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    @ResponseBody
    public Subscribes subscribe(Subscribes subscribe){
        return service.subscribe(subscribe);
    }

    @RequestMapping(value = "/unsubscribe", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean unsubscribe(Subscribes subscribe){
        return service.unsubscribe(subscribe);
    }
}
