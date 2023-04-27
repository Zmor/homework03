package com.homework.service.impl;


import com.homework.common.entity.Order;
import com.homework.common.entity.PointRecord;
import com.homework.dto.OrderForm;
import com.homework.feignClient.AccountFeignClient;
import com.homework.feignClient.OrderFeignClient;
import com.homework.service.BusinessService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private OrderFeignClient orderFeignClient;


    @GlobalTransactional(name = "order-service-group",rollbackFor = Exception.class) // 开启全局事务
    @Override
    public Boolean createOrder(OrderForm orderForm) {
        try {
            // 1、调用orderFeignClient插入订单
            Order order = new Order();
            order.setUserId(orderForm.getUserId());
            order.setOrderAmount(orderForm.getOrderAmount());
            order.setCreateTime(LocalDateTime.now());
            orderFeignClient.insertOrder(order);

            // 2、调用账户服务，支付订单
            PointRecord  pointRecord = new PointRecord();
            pointRecord.setUserId(orderForm.getUserId());
            pointRecord.setOrderId(order.getId());
            pointRecord.setChangeValue(orderForm.getOrderAmount());
            pointRecord.setCreateTime(LocalDateTime.now());
            accountFeignClient.insertPointRecord(pointRecord);

            // 3、更新订单状态，修改订单状态为已完成
            Order updateOrder = new Order();
            updateOrder.setId(order.getId());
            updateOrder.setOrderStatus(1);
            orderFeignClient.updateOrder(updateOrder);

            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
