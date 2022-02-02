package com.tutorial.core.flower.repository;

import com.tutorial.core.flower.model.Flower;

import java.util.List;

public interface FlowerRepository {
    public Integer create(Flower flower);
    public List<Flower> getAll();
    public Flower getById(Integer id);
    public Flower getByName(String name);
    public void deleteById(Integer id);
}
