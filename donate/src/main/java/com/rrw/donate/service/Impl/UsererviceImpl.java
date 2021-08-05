package com.rrw.donate.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rrw.donate.entity.User;
import com.rrw.donate.mapper.UserMapper;
import com.rrw.donate.service.IUserService;
import com.rrw.donate.utils.Md5Utils;
import com.rrw.donate.vo.request.RequestUserListVo;
import com.rrw.donate.vo.request.RequestUserRegisterVo;
import com.rrw.donate.vo.response.UserResponListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
/**
* @Description: 服务层
* @Author: RRW
* @Date: 2021/8/3
*/
@Service
public class UsererviceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User getByTelephone(String telephone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("telephone",telephone);
        return getOne(queryWrapper);
    }

    //用户注册
    @Override
    public boolean register (RequestUserRegisterVo requestUserRegisterVo){
        User user = new User();
        BeanUtils.copyProperties(requestUserRegisterVo,user);
        user.setType(0);
        user.setPassword(Md5Utils.hash(requestUserRegisterVo.getPassword()));
        return save(user);
    }

    @Override
    public IPage<UserResponListVo> getUserList(RequestUserListVo userListVo) {
        IPage<User> page = new Page<>(userListVo.getDisplayStart(),userListVo.getDisplayLength());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.checkValNotNull(userListVo.getEmail())){
            queryWrapper.like("email",userListVo.getEmail());
        }
        if (StringUtils.checkValNotNull(userListVo.getTelephone())){
            queryWrapper.like("telephone",userListVo.getTelephone());
        }
        if (StringUtils.checkValNotNull(userListVo.getUsername())){
            queryWrapper.like("username",userListVo.getUsername());
        }
        page = page(page,queryWrapper);
        return page.convert(user ->{
            UserResponListVo userResponListVo = new UserResponListVo();
            BeanUtils.copyProperties(user,userResponListVo);
            return userResponListVo;
        });
    }
}
