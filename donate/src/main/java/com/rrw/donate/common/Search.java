package com.rrw.donate.common;

import lombok.Data;

/**
 * @description: 分页查询 搜索父类
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:26
 */
@Data
public class Search {
    //条数
    private Long displayLength;
    //页数
    private Long displayStart;
}
