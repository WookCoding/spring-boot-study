package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class SuperCarRepositoryTests {

    @Autowired
    private SuperCarRepository superCarRepository;

    @Test
    public void saveTest() {
        SuperCar superCar1 = SuperCar.builder()
                .type(SuperCarType.FERRARI)
                .name("푸로산게")
                .color("red")
                .price(111111111111.0)
                .releaseDate(LocalDateTime.now())
                .build();

        SuperCar superCar2 = SuperCar.builder()
                .type(SuperCarType.HYUNDAI)
                .name("투싼")
                .color("red")
                .price(1111111444444.0)
                .releaseDate(LocalDateTime.now())
                .build();

        SuperCar superCar3 = SuperCar.builder()
                .type(SuperCarType.BENTLEY)
                .name("gt")
                .color("white")
                .price(111111111111.0)
                .releaseDate(LocalDateTime.now())
                .build();

        List<SuperCar> superCars = new ArrayList<>(Arrays.asList(superCar1,superCar2, superCar3));

        superCarRepository.saveAll(superCars);
    }

    @Test
    public void findByNameStartingWithTest(){
        assertThat(superCarRepository.findByNameStartingWith("투")).hasSize(1);
    }

    @Test
    public void findByNameContainingTest() {
        assertThat(superCarRepository.findByNameContaining("투")).hasSize(1);
    }

    @Test
    public void findByNameEndingWithTest() {
        assertThat(superCarRepository.findByNameEndingWith("t")).hasSize(1);
    }

    @Test
    public void findByNameTest() {
        assertThat(superCarRepository.findByName("gt")).hasSize(1);
    }

    @Test
    public void findById() {
        superCarRepository.findById(1L).stream().map(SuperCar::toString).forEach(log::info);
    }

    @Test
    public void existsByIdTest() {
        assertThat(superCarRepository.existsById(1L)).isTrue();
    }

    @Test
    public void deleteByIdEqualsTest() {
        superCarRepository.deleteById(1L);
    }

    @Test
    public void test() {
    }
}
