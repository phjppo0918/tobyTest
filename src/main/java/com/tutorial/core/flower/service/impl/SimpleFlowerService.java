package com.tutorial.core.flower.service.impl;

import com.tutorial.core.flower.model.Flower;
import com.tutorial.core.flower.repository.FlowerRepository;
import com.tutorial.core.flower.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleFlowerService implements FlowerService {

    private final FlowerRepository flowerRepository;

    @Autowired
    public SimpleFlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @Override
    public Integer save(Flower flower) {
        return flowerRepository.save(flower).getId();
    }

    @Override
    public Flower findByName(String name) {
        return flowerRepository.findByName(name).get();
    }

    @Override
    public Flower findById(Integer id) {
        return flowerRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        flowerRepository.deleteById(id);
    }

    @Override
    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }
}
