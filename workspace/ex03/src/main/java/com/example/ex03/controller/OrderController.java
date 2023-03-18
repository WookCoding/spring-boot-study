package com.example.ex03.controller;

import com.example.ex03.domain.dao.OrderDAO;
import com.example.ex03.domain.dto.OrderDTO;
import com.example.ex03.domain.vo.OrderVO;
import com.example.ex03.domain.vo.ProductVO;
import com.example.ex03.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    //    주문
    @PostMapping("/order/order")
    @Transactional(rollbackFor = Exception.class)
    public String order(OrderVO orderVO) {
        orderService.order(orderVO);
        return "주문 완료";
    }

    //    주문내역
    @GetMapping("/order/list")
    public List<OrderDTO> showList() {
       return orderService.getList();
    }

    //    주문취소
    @DeleteMapping("/order/cancel/")
    @Transactional(rollbackFor = Exception.class)
    public String cancel(Long orderId) {
        orderService.cancel(orderId);
        return "주문 취소";
    }
}
