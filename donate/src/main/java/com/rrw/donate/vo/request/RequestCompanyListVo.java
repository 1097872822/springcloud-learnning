package com.rrw.donate.vo.request;

import com.rrw.donate.common.Search;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 21:46
 */
@Setter
@Getter
public class RequestCompanyListVo extends Search {
    private String companyName;
    private String companyAddress;
    private String companyLinkman;
}
