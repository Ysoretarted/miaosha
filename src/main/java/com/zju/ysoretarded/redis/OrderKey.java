package com.zju.ysoretarded.redis;

/**
 * @author zcz
 * @CreateTime 2020/3/2 21:41
 */
public class OrderKey extends BasePrefix {

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
