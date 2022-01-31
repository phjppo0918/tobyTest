package com.tutorial.core.flower.repository;

import com.tutorial.core.flower.model.Flower;

public interface FlowerRepository {
    public Integer save(Flower flower);
    public Flower getById(Integer id);
    public Flower getByName(String name);
    public void deleteById(Integer id);
}
