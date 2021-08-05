package com.rrw.donate.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 格式校验
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 23:04
 */
public class FormatUtils {
    public static boolean isMobile(String str){
        Pattern p  = null;
        Matcher m = null;
        boolean b = false;
        //验证手机号
        String s2 = "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])([7][^9])|([9][1,8,9]))[\\d]{8}$";
        if (StringUtils.checkValNotNull(str)){
            p = Pattern.compile(s2);
            m = p.matcher(str);
            b = m.matches();
        }
        return b;
    }
}
