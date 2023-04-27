package com.homework.dto;


import java.math.BigDecimal;

public class OrderForm {

    // 用户ID
    private Integer userId;

    // 订单编号
    private String orderNo;

    // 订单金额
    private BigDecimal orderAmount;


    public Integer getUserId() {
        return userId;
    }

    public void setUser_id(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
