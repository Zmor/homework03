package com.homework;


import com.homework.common.entity.PointRecord;
import com.homework.common.entity.User;
import com.homework.service.PointRecordService;
import com.homework.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyControllerTest {
    private static final Logger log = LoggerFactory.getLogger(MyControllerTest.class);


    @LocalServerPort
    private int port;


    @Autowired
    private UserService userService;

    @Autowired
    private PointRecordService pointRecordService;

    @Test
    public void testPointRecordService(){
        try {
            PointRecord pointRecord = new PointRecord();
            pointRecord.setUserId(12);
            pointRecord.setOrderId(3);
            pointRecord.setChangeValue(new BigDecimal("2.5"));
            pointRecord.setCreateTime(LocalDateTime.now());
            PointRecord res = pointRecordService.insertPointRecord(pointRecord);

            System.out.println(res);
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            log.error(e.toString());
        }
    }

    @Test
    public void testUserService(){
        User user = userService.getUser(12);

        System.out.println(user.toString());
        log.info("Object info: {}", user.getId() + " " + user.getUsername() + " " + user.getEmail()  + " " + user.getBalance() + " " + user.getCreateTime() + " " + user.getUpdateTime());
    }
}
