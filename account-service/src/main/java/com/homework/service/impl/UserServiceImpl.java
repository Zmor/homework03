package com.homework.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.common.entity.User;
import com.homework.mapper.UserMapper;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

@Service
//public class UserServiceImpl implements UserService {
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void reduceUserBalance(Integer id, BigDecimal amount) {
        User user = this.getUser(id);
        user.setBalance(user.getBalance().subtract(amount));
        baseMapper.updateById(user);
    }

}
