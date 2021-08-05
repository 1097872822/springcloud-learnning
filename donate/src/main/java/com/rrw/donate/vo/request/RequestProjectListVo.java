package com.rrw.donate.vo.request;

import com.rrw.donate.common.Search;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: projectList请求
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 23:29
 */
@Setter
@Getter
public class RequestProjectListVo extends Search {
    private String projectName;
    private Integer projectStatus;
}
