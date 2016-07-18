package com.torridion.personaltrainer.server.service;


import com.torridion.personaltrainer.server.entity.Users;

public interface UsersService {

    Users registerUser(Users user);
    Users userLogin(Users user);
    void removeUser(Long id);
    Users updateUser(Users user);
}
