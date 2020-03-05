package com.zju.ysoretarded.controller;

import com.zju.ysoretarded.domain.User;
import com.zju.ysoretarded.redis.RedisService;
import com.zju.ysoretarded.redis.UserKey;
import com.zju.ysoretarded.result.CodeMsg;
import com.zju.ysoretarded.result.Result;
import com.zju.ysoretarded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zcz
 * @CreateTime 2020/2/9 22:59
 */
@RequestMapping("/Ysoretarded")
@Controller
public class DemoController {
    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "helloXX , Ysoretarded";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("成功的调用");
    }


    @RequestMapping("/helloerror")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    // 这里不能加 @ResponeBody   hello 才能代表hello.html渲染页面
    @RequestMapping("/thymeleaf")
    public String helloThymeleaf(Model model) {
        model.addAttribute("name","Thymeleaf Ysoretarded");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user =  userService.getById(1);
        return Result.success(user);
    }


    /**
     * 测试事物的完整性
     * @return
     */
    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> tx() {
        userService.tx();
        return Result.success(true);
    }


    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User user = redisService.get(UserKey.getById, "" + 1010, User.class);
        return Result.success(user);
    }


    @RequestMapping("redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user = new User();
        user.setId(123);
        user.setName("123123");
        boolean res = redisService.set(UserKey.getById, "" + 1010, user);
        return Result.success(true);
    }


}
