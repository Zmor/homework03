package com.homework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.common.entity.Order;
import com.homework.mapper.OrderMapper;
import com.homework.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


    @Override
    public Order insertOrder(Order order) {
        baseMapper.insert(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        baseMapper.updateById(order);
        return order;
    }
}
