package com.tutorial.core.flower.service;

import com.tutorial.core.flower.model.Flower;

public interface FlowerService {
    public Integer save(Flower flower);
    public Flower findByName(String name);
    public void removeById(Integer id);
}
