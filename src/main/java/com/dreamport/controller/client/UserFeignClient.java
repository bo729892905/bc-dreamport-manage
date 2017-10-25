package com.dreamport.controller.client;

import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ren.xiaobo on 2016/8/29.
 */
@FeignClient(name = "bs-dreamport-user")
@RequestMapping(value = "/bs-dreamport-user/v1/users")
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getById(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON})
    List<User> list(@RequestBody UserBO param);

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON})
    int insert(@RequestBody User entity);
}
