package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.entities.User;
import com.nextgenretro.nextgenretro.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
