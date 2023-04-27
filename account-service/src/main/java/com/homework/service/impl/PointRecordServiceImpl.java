package com.homework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.common.entity.PointRecord;
import com.homework.common.entity.User;
import com.homework.mapper.PointRecordMapper;
import com.homework.service.PointRecordService;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;

@Service
public class PointRecordServiceImpl extends ServiceImpl<PointRecordMapper, PointRecord> implements PointRecordService {

    @Autowired
    private UserService userService;

    @Transient
    @Override
    public PointRecord insertPointRecord(PointRecord pointRecord) {
        try {
            // 检查账户余额
            User user = userService.getUser(pointRecord.getUserId());
            // 检查用户是否存在
            if (user == null || !user.getId().equals(pointRecord.getUserId())) {
                throw new RuntimeException("用户不存在");
            }

            // 比较pointRecord.getChangeValue()和user.getBalance()，它们类型都是BigDecimal
            if (pointRecord.getChangeValue().compareTo(user.getBalance()) > 0) {
                throw new RuntimeException("余额不足");
            }

            // 更新用户余额
            userService.reduceUserBalance(user.getId(), pointRecord.getChangeValue());

            // 插入pointRecord
            PointRecord insertPointRecord = new PointRecord();
            insertPointRecord.setUserId(pointRecord.getUserId());
            insertPointRecord.setOrderId(Math.toIntExact(pointRecord.getOrderId()));
            insertPointRecord.setChangeValue(pointRecord.getChangeValue());
            insertPointRecord.setCreateTime(LocalDateTime.now());
            baseMapper.insert(insertPointRecord);
            return pointRecord;
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}