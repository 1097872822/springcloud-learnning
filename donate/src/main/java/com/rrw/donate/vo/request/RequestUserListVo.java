package com.rrw.donate.vo.request;

import com.rrw.donate.common.Search;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-05 21:16
 */
@Getter
@Setter
public class RequestUserListVo extends Search {
    private String email;
    private String telephone;
    private String username;
}
