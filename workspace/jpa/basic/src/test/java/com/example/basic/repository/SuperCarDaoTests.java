package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.domain.entity.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarDaoTests {

    @Autowired
    private SuperCarDAO superCarDAO;

    @Test
    public void saveTest(){
        SuperCar superCar = new SuperCar();

        superCar.setColor("red");
        superCar.setName("롤스로이스");
        superCar.setType(SuperCarType.ROLLSROYCE);
        superCar.setPrice(100000000);
        superCar.setReleaseDate(LocalDateTime.now());

        superCarDAO.save(superCar);
    }

    @Test
    public void findByIdTest(){
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(1L);
        SuperCar superCar = optionalSuperCar.orElse(new SuperCar());

        assertThat(superCar.getName()).isEqualTo("롤스로이스");
    }

    @Test
    public void updateTest(){
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(1L);
        SuperCar superCar = optionalSuperCar.orElse(new SuperCar());

        superCar.setName("메롱");
        superCarDAO.save(superCar);
    }

    @Test
    public void deleteTest(){
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(1L);
        SuperCar superCar = optionalSuperCar.orElse(new SuperCar());

        superCarDAO.delete(superCar);
    }
}
