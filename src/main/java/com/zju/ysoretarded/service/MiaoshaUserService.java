package com.zju.ysoretarded.service;

import com.sun.tools.javac.jvm.Code;
import com.zju.ysoretarded.dao.MiaoshaUserDao;
import com.zju.ysoretarded.domain.MiaoshaUser;
import com.zju.ysoretarded.result.CodeMsg;
import com.zju.ysoretarded.util.MD5Util;
import com.zju.ysoretarded.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.CoderMalfunctionError;

/**
 * @author zcz
 * @CreateTime 2020/3/4 15:58
 */
@Service
public class MiaoshaUserService {

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    public MiaoshaUser getById(long id){
        return miaoshaUserDao.getById(id);
    }

    public CodeMsg login(LoginVo loginVo) {
        if(null == loginVo){
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginVo.getMobile();
        String formPassword = loginVo.getPassword();
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if(null == user){
            return CodeMsg.MOBILE_NOT_EXIST;
        }

        String dbPassword = user.getPassword();
        String saltDB = user.getSalt();
        String calcPassword = MD5Util.formPassToDbPass(formPassword, saltDB);
        if(!calcPassword.equals(dbPassword)){
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;


    }
}
