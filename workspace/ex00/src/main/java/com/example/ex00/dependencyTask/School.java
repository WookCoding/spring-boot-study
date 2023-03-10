package com.example.ex00.dependencyTask;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class School {
    private List<Teacher> teachers;
    private List<Student> students;
}
