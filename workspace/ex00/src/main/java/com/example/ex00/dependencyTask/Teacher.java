package com.example.ex00.dependencyTask;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Teacher {
    private List<Class> classes;
}
