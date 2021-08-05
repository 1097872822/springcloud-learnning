package com.rrw.donate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:36
 */
@Data
public class Notice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String noticeText;
    private LocalDateTime createTime;
}
