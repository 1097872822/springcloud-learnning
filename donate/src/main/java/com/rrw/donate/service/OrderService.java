package com.rrw.donate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rrw.donate.entity.TOrderChargingEntity;
import com.rrw.donate.vo.response.ResponOrderListVo;

import java.util.List;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-05 22:27
 */
public interface OrderService extends IService<TOrderChargingEntity> {
    //根据pile名查询订单
    List<ResponOrderListVo> queryBypileName(String pileName);
}
