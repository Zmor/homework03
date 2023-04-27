package com.homework.service;

import com.homework.common.entity.Order;
import com.homework.dto.OrderForm;

public interface BusinessService {

    Boolean createOrder(OrderForm orderForm);
}
