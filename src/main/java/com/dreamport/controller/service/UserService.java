package com.dreamport.controller.service;

import com.baomidou.mybatisplus.plugins.Page;
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

    public Page<User> selectUserPage(Integer pageNo, Integer pageSize, UserBO param) {
        return userFeignClient.selectUserPage(pageNo, pageSize, param);
    }

    public int insert(User entity) {
        return userFeignClient.insert(entity);
    }

    public int update(Long id, User entity) {
        return userFeignClient.update(id, entity);
    }

    public int deleteById(Long id) {
        return userFeignClient.deleteById(id);
    }
}
