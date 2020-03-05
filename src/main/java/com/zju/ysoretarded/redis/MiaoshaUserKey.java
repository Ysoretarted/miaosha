package com.zju.ysoretarded.redis;

/**
 * @author zcz
 * @CreateTime 2020/3/2 21:40
 */
public class MiaoshaUserKey extends BasePrefix {
    private static final int TOKEN_EXPIRE = 3600 * 24 *2;
    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE,"token");

    private MiaoshaUserKey(int expireSeconds, String prefix){
        super(expireSeconds,prefix);
    }
}
