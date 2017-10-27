package com.dreamport.controller.client;

import com.baomidou.mybatisplus.plugins.Page;
import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ren.xiaobo on 2016/8/29.
 */
@FeignClient(name = "bs-dreamport-user")
@RequestMapping(value = "/bs-dreamport-user/v1/users")
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User selectById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON})
    Page<User> selectUserPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestBody UserBO param);

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON})
    int insert(@RequestBody User entity);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON})
    int update(@PathVariable("id") Long id, @RequestBody User entity);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int deleteById(@PathVariable("id") Long id);
}
