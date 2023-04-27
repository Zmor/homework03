package com.homework.controller;


import com.homework.common.entity.Order;
import com.homework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/insertOrder")
    public Order insertOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
//        return "success";
    }

    @PostMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
//        return "success";
    }

}
