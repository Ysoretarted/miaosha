package com.zju.ysoretarded.result;

import lombok.Data;

/**
 * @author zcz
 * @CreateTime 2020/2/9 23:13
 */
@Data
public class Result<T> {
    private int code;

    private String msg;

    private T data;

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg cm) {
        if (null == cm) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }
    // 成功

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }
    //失败

    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<>(cm);
    }


}
