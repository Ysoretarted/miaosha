package com.zju.ysoretarded.redis;

import com.zju.ysoretarded.domain.User;

/**
 * @author zcz
 * @CreateTime 2020/3/2 21:40
 */
public class UserKey extends BasePrefix {
    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

    private UserKey(String prefix){
        super(prefix);
    }
}
