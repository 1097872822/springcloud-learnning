package com.rrw.donate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:42
 */
@Data
public class DonationInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer projectId;
    private String projectName;
    private String projectDesc;
    private Integer type;
    private String donor;
    private Integer status;
    private LocalDateTime createTime;
}
