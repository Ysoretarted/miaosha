package com.zju.ysoretarded.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zcz
 * @CreateTime 2020/3/4 15:53
 */
@Data
public class MiaoshaUser {
    private Long id;
    private String nickName;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;


}
