package com.torridion.personaltrainer.server.service;

import com.torridion.personaltrainer.server.entity.Users;
import com.torridion.personaltrainer.server.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersRepository repository;

    public Users registerUser(Users user) {
        return repository.saveAndFlush(user);
    }

    public Users userLogin(Users user) {
        Users tmp = repository.findByLogin(user.getLogin());
        if(user.getPassword().equals(tmp.getPassword())) return tmp;
        return user;
    }

    public void removeUser(Long id) {
        repository.delete(id);
    }

    public Users updateUser(Users user) {
        return repository.saveAndFlush(user);
    }
}
