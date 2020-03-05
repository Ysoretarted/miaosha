package com.zju.ysoretarded.redis;

/**
 * @author zcz
 * @CreateTime 2020/3/2 21:30
 */
public interface KeyPrefix {
    int expireSeconds();

    public String getPrefix();
}
