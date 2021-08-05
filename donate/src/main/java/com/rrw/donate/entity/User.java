package com.rrw.donate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:30
 */
//@Getter
//@Setter
//@ToString
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer type;
    private String telephone;
    private String sex;
    private Integer age;
    private String province;
    private String city;
    private String local;
    private String email;
    private LocalDateTime createTime;
}
