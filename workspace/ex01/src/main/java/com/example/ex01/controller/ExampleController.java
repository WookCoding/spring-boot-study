package com.example.ex01.controller;

import com.example.ex01.domain.MemberVO;
import com.example.ex01.domain.ProductVO;
import com.example.ex01.domain.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public String ex01(){
        log.info("ex01..............");
        return "ex01";
    }

    @GetMapping("ex02")
    public void ex02(){
        log.info("ex02..............");
    }

    @GetMapping("ex03")
    public void ex03(HttpServletRequest request){
        String name = request.getParameter("name");
        log.info(name);
    }

    @GetMapping("ex04")
    public void ex04(@ModelAttribute("name") String name/*, Model model*/){
//        model.addAttribute("name", name);
        log.info(name);
    }

    //    이름, 나이, 성별 받고 출력
    @GetMapping("ex05")
    public void ex05(MemberVO memberVO){
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
    }

    @GetMapping("ex06")
    public void ex06(MemberVO memberVO, @RequestParam("address") String city/*, Model model*/){
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
        log.info("사는 도시 : " + city);
        /*model.addAttribute("city", city);*/
    }

    @GetMapping("ex07")
    public void ex07(String name, Integer age) {;}

//    [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.
    @GetMapping("ex08")
    public void ex08(ProductVO productVO){

    }
    @GetMapping("ex09")
    public void ex09(){;}

    @GetMapping("product")
    public String manageProduct(Model model){
        model.addAttribute(new ProductVO());
        return "/product/register";
    }

    @PostMapping("register")
    public RedirectView registerProduct(ProductVO productVO, RedirectAttributes redirectAttributes){
//        forward   : 그냥 리턴, .html로 즉시 이동
//        redirect  : RedirectView객체로 리턴, 생성자에 원하는 컨트롤러의 경로 작성, 컨트롤러에서 다시 Mapping

//        addAttribute() : URL뒤에 쿼리스트링을 붙여준다, 컨트롤러의 매개변수로 전달할 때 사용한다.

        redirectAttributes.addAttribute("productName", productVO.getProductName());
        redirectAttributes.addAttribute("productPrice", productVO.getProductPrice());
        redirectAttributes.addAttribute("productStock", productVO.getProductStock());
        redirectAttributes.addAttribute("productBrand", productVO.getProductBrand());

//        addFlashAttribute()
//        redirectAttributes.addFlashAttribute("productName", productVO.getProductName());
//        redirectAttributes.addFlashAttribute("productPrice", productVO.getProductPrice());
//        redirectAttributes.addFlashAttribute("productStock", productVO.getProductStock());
//        redirectAttributes.addFlashAttribute("productBrand", productVO.getProductBrand());
        return new RedirectView("/ex/modify");
    }
    
//  입력받은 상품명 수정 후 목록으로 출력
    @GetMapping("modify")
    public RedirectView modify(ProductVO productVO, RedirectAttributes redirectAttributes){
        productVO.setProductName("포도");
        redirectAttributes.addFlashAttribute(productVO);

        return new RedirectView("/ex/list");
    }


    @GetMapping("list")
    public String list(ProductVO productVO){
        return "/product/list";
    }


//    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력
    @GetMapping("task2")
    public String task2(Model model){
        model.addAttribute(new TaskVO());
        return "/ex/task2";
    }

    @PostMapping("task2Result")
    public RedirectView result(TaskVO taskVO, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("num",taskVO.getNum());
        redirectAttributes.addFlashAttribute("avg" , taskVO.avg());
        redirectAttributes.addFlashAttribute("total" , taskVO.total());

        return new RedirectView("/ex/resultPage");
    }

    @GetMapping("resultPage")
    public String resultPage(){
        return "ex/task2-result";
    }


//    [실습 3]
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
//
//    - login.html : 아이디와 비밀번호 입력 페이지 출력
//    - admin.html : 관리자 페이지 출력
//    - user.html : 일반 회원 페이지 출력
    @GetMapping("login")
    public void login(){
    }

    @GetMapping("loginCheck")
    public String admin(@RequestParam("identification") String identificiton){
        log.info(identificiton);
        if(identificiton.equals("admin")){
            return "ex/admin";
        }else {
            return "ex/user";
        }
    }


//    [실습 4]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html
    @GetMapping("task4")
    public void form(){;}

    @GetMapping("check")
    public String checkLate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        int time = Integer.parseInt(formatter.format(date));
        if(time > 9){
            return "ex/late";
        }else {
            return "ex/work";
        }
    }

    @GetMapping("checkLeave")
    public String checkLeave(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        int time = Integer.parseInt(formatter.format(date));
        if(time < 17){
            return "ex/getToWork";
        }else {
            return "ex/leaveWork";
        }
    }
}