package com.example.ex00.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QualifierTests {

    @Autowired /*@Qualifier("desktop")*/
            Computer computer;

    @Autowired
    Resturant resturant;

//    @Test
//    public void testComputer(){
//        log.info(String.valueOf(computer));
//    }

    @Test
    public void testResturant() {
        log.info(String.valueOf(resturant));
    }

}
