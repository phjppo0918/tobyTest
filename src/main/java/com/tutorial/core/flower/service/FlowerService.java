package com.tutorial.core.flower.service;

import com.tutorial.core.flower.model.Flower;

import java.util.List;

public interface FlowerService {
    public Integer save(Flower flower);
    public Flower findByName(String name);
    public void removeById(Integer id);
    public List<Flower> findAll();
}
