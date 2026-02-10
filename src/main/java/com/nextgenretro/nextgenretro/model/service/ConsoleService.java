package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.entities.Consoles;
import com.nextgenretro.nextgenretro.model.repository.ConsolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ConsoleService {
    @Autowired
    private ConsolesRepository consolesRepository;

    public List<Consoles> findAll (){
        return consolesRepository.findAll();
    }
}
