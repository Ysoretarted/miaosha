package com.zju.ysoretarded.controller;

import com.zju.ysoretarded.domain.MiaoshaUser;
import com.zju.ysoretarded.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zcz
 * @CreateTime 2020/3/3 13:17
 */
@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    MiaoshaUserService userService;

    /*@RequestMapping("/to_list")
    public String toLogin(HttpServletResponse response, Model model,
                          @CookieValue(value = MiaoshaUserService.COOKIE_NAME_TOKEN, required = false) String cookieToken,
                          @RequestParam(value = MiaoshaUserService.COOKIE_NAME_TOKEN, required = false) String paramToken) {
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return "login";
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        MiaoshaUser user = userService.getByToken(response, token);
        model.addAttribute("user", user);
        return "goods_list";
    }*/

    /**
     * 通过参数的注入   config来配置
     *    这样判断就很简洁
     * @param response
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/to_list")
    public String toLogin(HttpServletResponse response, Model model,
                    MiaoshaUser user){
        model.addAttribute("user", user);
        return "goods_list";
    }

}
