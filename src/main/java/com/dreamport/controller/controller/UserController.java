package com.dreamport.controller.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.dreamport.annotation.OperateLog;
import com.dreamport.bo.UserBO;
import com.dreamport.common.log.LogModule;
import com.dreamport.common.log.LogType;
import com.dreamport.controller.service.UserService;
import com.dreamport.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/31.
 */
@Controller
@RequestMapping(value = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, UserBO param) {
        ModelAndView view = new ModelAndView("/users/list");
        Page<User> userPage = userService.selectUserPage(pageNo, pageSize, param);
        view.addObject("userList", userPage.getRecords());
        return view;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Integer insert(User entity) {
        return userService.insert(entity);
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    @OperateLog(module = LogModule.USER, type = LogType.ADD)
    public ModelAndView index(HttpServletRequest req) {
        ModelAndView view = new ModelAndView("/index");
        //total 是模板的全局变量，可以直接访问
        view.addObject("username", "rxb");
        return view;
    }
}
