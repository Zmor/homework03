package com.homework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.homework.common.entity.Order;

public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     *
     * @return
     */
    Order insertOrder(Order order);

    Order updateOrder(Order order);
}
