package com.rrw.donate.vo.request;

import lombok.Data;

/**
 * @description: 用户注册Vo
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 23:00
 */
@Data
public class RequestUserRegisterVo {
    private String username;
    private String password;
    private String telephone;
    private String sex;
    private Integer age;
    private String province;
    private String city;
    private String local;
    private String email;
}
