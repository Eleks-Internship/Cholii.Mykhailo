package com.torridion.personaltrainer.server.controller;

import com.torridion.personaltrainer.server.entity.Global;
import com.torridion.personaltrainer.server.service.GlobalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/global")
public class GlobalController {

    @Autowired
    GlobalServiceImpl service;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Global getStatistic(){
        return service.getStatistic();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public void updateStatistic(Global global){
        service.updateStatistic(global);
    }

}
