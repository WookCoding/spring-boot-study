package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {

    public List<SuperCar> findByNameStartingWith(String name);
    public List<SuperCar> findByNameContaining(String name);
    public List<SuperCar> findByNameEndingWith(String name);
    public List<SuperCar> findByName(String name);

}
