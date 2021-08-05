package com.rrw.donate.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IOUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.code.kaptcha.Producer;
import com.rrw.donate.common.Result;
import com.rrw.donate.common.StringConsts;
import com.rrw.donate.entity.User;
import com.rrw.donate.service.IUserService;
import com.rrw.donate.utils.FormatUtils;
import com.rrw.donate.vo.request.RequestUserListVo;
import com.rrw.donate.vo.request.RequestUserRegisterVo;
import com.rrw.donate.vo.response.UserResponListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @description: 控制层
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 22:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private Producer producer;
    @PostMapping("register")
    public Result register(@RequestBody RequestUserRegisterVo requestUserRegisterVo){
        if (!FormatUtils.isMobile(requestUserRegisterVo.getTelephone())){
            return Result.getFailure().setMsg(StringConsts.TELEPHONE_PHONE_ERROR);
        }
        User user = userService.getByTelephone(requestUserRegisterVo.getTelephone());
        if (StringUtils.checkValNotNull(user)){
            return Result.getFailure().setMsg(StringConsts.ISHAVE);
        }
       if (userService.register(requestUserRegisterVo)){
            return Result.getSuccess().setMsg(StringConsts.REGISTER_SUCCESS);
       }else {
           return Result.getFailure().setMsg(StringConsts.REGISTER_FAIL);
       }
    }

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control","no-store,no-cache");
        response.setContentType("image/jpeg");
        String text = producer.createText();
        BufferedImage img = producer.createImage(text);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(img,"jpg",out);
        IOUtils.closeQuietly(out);
    }

    @RequestMapping("/list")
    public Result getUserLis(@RequestBody RequestUserListVo userListVo){
        IPage<UserResponListVo> page =  userService.getUserList(userListVo);
        return Result.getSuccess().setData(page);
    }

}
