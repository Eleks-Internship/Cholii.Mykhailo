package com.torridion.personaltrainer.server.repository;


import com.torridion.personaltrainer.server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>{
    Users findByLogin(String login);
}
