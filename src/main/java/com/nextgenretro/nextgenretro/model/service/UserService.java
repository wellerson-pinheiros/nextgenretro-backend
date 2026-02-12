package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.entities.User;
import com.nextgenretro.nextgenretro.model.repository.UserRepository;
import com.nextgenretro.nextgenretro.model.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
            Optional<User> usuario = userRepository.findById(id);
            return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
