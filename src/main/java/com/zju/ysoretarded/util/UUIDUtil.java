package com.zju.ysoretarded.util;

import java.util.UUID;

/**
 * @author zcz
 * @CreateTime 2020/3/5 10:48
 */
public class UUIDUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
