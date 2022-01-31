package com.tutorial.core.flower.service.impl;

import com.tutorial.core.flower.model.Flower;
import com.tutorial.core.flower.service.FlowerService;
import org.springframework.stereotype.Service;

@Service
public class SimpleFlowerService implements FlowerService {
    @Override
    public Integer save(Flower flower) {
        return null;
    }

    @Override
    public Flower findByName(String name) {
        return null;
    }

    @Override
    public void removeById(Integer id) {

    }
}
