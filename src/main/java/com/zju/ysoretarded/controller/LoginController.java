package com.zju.ysoretarded.controller;

import com.sun.tools.javac.jvm.Code;
import com.zju.ysoretarded.result.CodeMsg;
import com.zju.ysoretarded.result.Result;
import com.zju.ysoretarded.service.MiaoshaUserService;
import com.zju.ysoretarded.util.ValidatorUtil;
import com.zju.ysoretarded.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

/**
 * @author zcz
 * @CreateTime 2020/3/3 13:17
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoshaUserService userService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(LoginVo loginVo){
        log.info(loginVo.toString() + "ZZZZ");
        //参数校验
        String inputPass =  loginVo.getPassword();
        String mobile = loginVo.getMobile();
        if(StringUtils.isEmpty(inputPass)){
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(StringUtils.isEmpty(mobile)){
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if(!ValidatorUtil.isMobile(mobile)){
            return Result.error(CodeMsg.MOBILE_ERROR);
        }

        //登录
        CodeMsg cm = userService.login(loginVo);
        if(cm.getCode() == 0){
            return Result.success(true);
        }
        else{
            return Result.error(cm);
        }
    }
}
