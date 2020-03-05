package com.zju.ysoretarded.util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zcz
 * @CreateTime 2020/3/4 15:45
 */
public class ValidatorUtil {
    private static final Pattern mobile_pattren = Pattern.compile("1\\d{10}");
    public static boolean isMobile(String src){
        if(StringUtils.isEmpty(src)){
            return false;
        }
        Matcher matcher = mobile_pattren.matcher(src);
        return matcher.matches();
    }

}
