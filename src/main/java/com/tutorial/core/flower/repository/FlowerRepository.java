package com.tutorial.core.flower.repository;

import com.tutorial.core.flower.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {
    public Optional<Flower> findByName(String name);
}
