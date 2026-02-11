package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.entities.Controles;
import com.nextgenretro.nextgenretro.model.repository.ControlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlesService {

    @Autowired
    private ControlesRepository controlesRepository;

   public  List<Controles> findAll(){
        return controlesRepository.findAll();
    }
}
