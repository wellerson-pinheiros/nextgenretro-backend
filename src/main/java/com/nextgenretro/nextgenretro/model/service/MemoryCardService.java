package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.entities.MemoryCard;
import com.nextgenretro.nextgenretro.model.repository.MemoryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryCardService {

    @Autowired
    private MemoryCardRepository memoryCardRepository;

    public List<MemoryCard> findAll() {
        return memoryCardRepository.findAll();
    }
}
