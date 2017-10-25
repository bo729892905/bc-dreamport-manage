package com.dreamport.controller.service;

import com.dreamport.bo.UserBO;
import com.dreamport.controller.Application;
import com.dreamport.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ren.xiaobo on 2017/7/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@ActiveProfiles(value="dev")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void list() throws Exception {
        List<User> userList = userService.list(new UserBO());
        userList.forEach(user->System.out.println(user.getUsername()));
    }

}