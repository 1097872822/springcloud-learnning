package com.rrw.donate.vo.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-05 21:18
 */
@Getter
@Setter
public class UserResponListVo {
    private Integer id;
    private String username;
    private String telephone;
    private String sex;
    private Integer age;
    private String province;
    private String city;
    private String local;
    private String email;
    private LocalDateTime createTime;
}
