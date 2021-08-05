package com.rrw.donate.vo.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @description: projectList的响应
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 23:31
 */
@Getter
@Setter
public class ResponProjectListVo {
    private Integer id;
    private String companyName;
    private String projectLeader;
    private String projectName;
    private String projectDesc;
    private Integer projectStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createTime;
}
