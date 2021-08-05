package com.rrw.donate.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rrw.donate.entity.User;
import com.rrw.donate.vo.request.RequestUserListVo;
import com.rrw.donate.vo.request.RequestUserRegisterVo;
import com.rrw.donate.vo.response.UserResponListVo;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 22:53
 */
public interface IUserService extends IService<User> {
     User getByTelephone(String telephone);
     boolean register(RequestUserRegisterVo requestUserRegisterVo);

     //返回查询用户列表
    IPage<UserResponListVo> getUserList(RequestUserListVo userListVo);
}
