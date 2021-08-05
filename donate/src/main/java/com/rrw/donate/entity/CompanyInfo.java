package com.rrw.donate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.lang.model.element.NestingKind;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:38
 */
@Data
public class CompanyInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String companyName;
    private String companyAddress;
    private String companyLinkman;
    private String companyPhone;
    private LocalDateTime createTime;
}
