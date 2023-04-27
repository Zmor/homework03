package com.homework.feignClient;


import com.homework.common.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @PostMapping("/order/insertOrder")
    Order insertOrder(@RequestBody Order order);


    @PostMapping("/order/updateOrder")
    Order updateOrder(@RequestBody Order order);

}
