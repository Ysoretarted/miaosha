package com.zju.ysoretarded.service;

import com.sun.deploy.net.HttpResponse;
import com.zju.ysoretarded.dao.MiaoshaUserDao;
import com.zju.ysoretarded.domain.MiaoshaUser;
import com.zju.ysoretarded.exception.GlobalException;
import com.zju.ysoretarded.redis.MiaoshaUserKey;
import com.zju.ysoretarded.redis.RedisService;
import com.zju.ysoretarded.result.CodeMsg;
import com.zju.ysoretarded.util.MD5Util;
import com.zju.ysoretarded.util.UUIDUtil;
import com.zju.ysoretarded.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zcz
 * @CreateTime 2020/3/4 15:58
 */
@Service
public class MiaoshaUserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    @Autowired
    RedisService redisService;

    public MiaoshaUser getById(long id) {
        return miaoshaUserDao.getById(id);
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (null == loginVo) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPassword = loginVo.getPassword();
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if (null == user) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }

        String dbPassword = user.getPassword();
        String saltDB = user.getSalt();
        String calcPassword = MD5Util.formPassToDbPass(formPassword, saltDB);
        if (!calcPassword.equals(dbPassword)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

        //生成Cookie
        String token = UUIDUtil.uuid();
        addCookie(user, token, response);
        return true;


    }

    public MiaoshaUser getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        } else {

            MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
            if (user != null) {
                addCookie(user, token, response);
            }
            return user;
        }
    }


    private void addCookie(MiaoshaUser user, String token, HttpServletResponse response) {
        redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setPath("/");
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        response.addCookie(cookie);
    }
}
