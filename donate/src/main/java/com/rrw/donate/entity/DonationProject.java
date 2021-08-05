package com.rrw.donate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.lang.model.element.NestingKind;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:45
 */
@Data
public class DonationProject {
    private Integer companyId;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String projectLeader;
    private String projectName;
    private String projectDesc;
    private Integer projectStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createTime;
}
