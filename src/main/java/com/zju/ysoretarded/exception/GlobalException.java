package com.zju.ysoretarded.exception;

import com.zju.ysoretarded.result.CodeMsg;

/**
 * @author zcz
 * @CreateTime 2020/3/4 21:28
 */
public class GlobalException extends RuntimeException {

    private CodeMsg cm;

    public GlobalException(CodeMsg cm){
//        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm(){
        return this.cm;
    }
}
