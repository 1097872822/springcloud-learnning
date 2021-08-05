package com.rrw.donate.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 分页配置类
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-03 21:28
 */
@Configuration //springboot将这个类作为配置了
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
