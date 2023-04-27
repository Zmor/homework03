package com.homework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.homework.common.entity.User;

import java.math.BigDecimal;

//public interface UserService {
public interface UserService extends IService<User> {


    /**
     * 查询用户详情
     */
    User getUser(Integer id);

    /**
     * 减少用户balance
     */
    void reduceUserBalance(Integer id, BigDecimal amount);
}
