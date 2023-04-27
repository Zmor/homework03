package com.homework.feignClient;


import com.homework.common.entity.PointRecord;
import com.homework.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "service-account")
public interface AccountFeignClient {

//    @GetMapping("/account/getUser")
//    User getUser(Integer userId);

    @PostMapping("/account/insertPointRecord")
    PointRecord insertPointRecord(@RequestBody PointRecord pointRecord);


}
