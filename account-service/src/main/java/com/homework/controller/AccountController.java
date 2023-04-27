package com.homework.controller;


import com.homework.common.entity.PointRecord;
import com.homework.common.entity.User;
import com.homework.service.PointRecordService;
import com.homework.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private UserService userService;

    @Autowired
    private PointRecordService pointRecordService;

    @GetMapping("/getUser")
    public User getUser(Integer userId) {
        return userService.getUser(userId);
    }

    @GlobalTransactional
    @PostMapping("/insertPointRecord")
    public PointRecord insertPointRecord(@RequestBody PointRecord pointRecord) {
        return pointRecordService.insertPointRecord(pointRecord);
    }

}
