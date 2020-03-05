package com.zju.ysoretarded.redis;

/**
 * @author zcz
 * @CreateTime 2020/3/2 21:31
 */
public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;
    private String prefix;

    public BasePrefix(String prefix){
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        // 默认0 永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String name = this.getClass().getSimpleName();
        System.out.println(name);
        return name + ":" + prefix;
    }
}
