package com.torridion.personaltrainer.server.controller;

import com.torridion.personaltrainer.server.entity.Users;
import com.torridion.personaltrainer.server.repository.UsersRepository;
import com.torridion.personaltrainer.server.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UsersController{

    @Autowired
    private UsersServiceImpl service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Users userRegister(Users newUser){
        return service.registerUser(newUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Users userLogin(Users user){
        return service.userLogin(user);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public void userRemove(Long id){
        service.removeUser(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Users userUpdate(Users user){
        return service.updateUser(user);
    }


}
