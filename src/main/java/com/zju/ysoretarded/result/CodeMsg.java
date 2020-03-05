package com.zju.ysoretarded.result;

import lombok.Data;

/**
 * @author zcz
 * @CreateTime 2020/2/9 23:24
 */
@Data
public class CodeMsg {


    private int code;

    private String msg;

    //通用的错误吗
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");

    //登陆模块5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "密码不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");

    //商品模块 5003XX

    //订单模块  5004XX
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
