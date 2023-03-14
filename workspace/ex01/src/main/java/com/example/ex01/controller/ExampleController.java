package com.example.ex01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public void ex01(){
        log.info("ex01..............");
    }

    @GetMapping("ex02") //value만 쓸때는 ""로 대체 가능
    public void ex02(){
        log.info("ex02..............");
    }

    @GetMapping("ex03")
    public void ex03(HttpServletRequest request){
        String name = request.getParameter("name");
        log.info(name);
    }

    @GetMapping("ex04")
    public void ex04(String name){
        log.info(name);
    }

    //    이름, 나이 받고 출력
    @GetMapping("ex05")
    public void ex5(String name, int age){
        log.info(name);
        log.info(String.valueOf(age));
    }

}