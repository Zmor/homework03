package com.homework.controller;


import com.homework.dto.OrderForm;
import com.homework.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody OrderForm orderForm) {
       Boolean res = businessService.createOrder(orderForm);

       if (res) {
           return "Order Placed Successfully";
       } else {
           return "Order Failed";
       }
    }

}
