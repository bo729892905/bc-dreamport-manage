package com.dreamport.controller.service;

import com.dreamport.bo.UserBO;
import com.dreamport.controller.client.UserFeignClient;
import com.dreamport.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/31.
 */
@Service
public class UserService {
    private final UserFeignClient userFeignClient;

    @Autowired
    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public List<User> list(UserBO param) {
        return userFeignClient.list(param);
    }

    public int insert(User entity) {
        return userFeignClient.insert(entity);
    }
}
