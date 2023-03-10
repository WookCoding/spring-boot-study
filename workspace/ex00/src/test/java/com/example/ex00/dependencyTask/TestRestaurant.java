package com.example.ex00.dependencyTask;

import com.example.ex00.dependencyTask.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestRestaurant {

//    @Autowired
//    Restaurant restaurant;

      @Autowired
      School school;

      @Autowired
      Student student;

      @Autowired
      Teacher teacher;

//    @Test
//    public void test(){
//        log.info(String.valueOf(restaurant));
//    }

    @Test
    public void schoolTest(){
        log.info(String.valueOf(school));
    }

    @Test
    public void teacherTest(){
        log.info(String.valueOf(teacher));
    }

    @Test
    public void studentTest(){
        log.info(String.valueOf(student));
    }
}
