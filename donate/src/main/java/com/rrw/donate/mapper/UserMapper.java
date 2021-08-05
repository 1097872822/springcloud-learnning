package com.rrw.donate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrw.donate.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: user持久层
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 22:50
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
