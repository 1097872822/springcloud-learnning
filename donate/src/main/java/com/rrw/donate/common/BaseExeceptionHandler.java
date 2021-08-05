package com.rrw.donate.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 公共异常处理类
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:17
 */
@Slf4j
@RestControllerAdvice
public class BaseExeceptionHandler {
    @ExceptionHandler
    public Result exception(Exception e){
        log.error("异常信息：{}",e.getMessage());
        return Result.getFailure().setData(e.getMessage());
    }
}
