package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TaskVO {
    private Integer num;
    private Integer kor;
    private Integer eng;
    private Integer math;


    public TaskVO() {;}

    public Integer total(){
        return  kor + eng + math;
    }

    public Double avg(){
        return  total() / 3.0;
    }
}
