package com.rrw.donate.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rrw.donate.entity.TOrderChargingEntity;
import com.rrw.donate.mapper.OrderMapper;
import com.rrw.donate.service.OrderService;
import com.rrw.donate.vo.response.ResponOrderListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-05 22:31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, TOrderChargingEntity> implements OrderService {
    @Autowired
    private OrderService orderService;
    @Override
    public List<ResponOrderListVo> queryBypileName(String pileName) {
        QueryWrapper<TOrderChargingEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pile_name",pileName);
        queryWrapper.eq("order_flag",0);
        List<TOrderChargingEntity> tOrderChargingEntityList = list(queryWrapper);
        List<ResponOrderListVo> responOrderListVoList = new ArrayList<>();
        for (TOrderChargingEntity tOrderChargingEntity:tOrderChargingEntityList){
            ResponOrderListVo vo = new ResponOrderListVo();
            BeanUtils.copyProperties(tOrderChargingEntity,vo);
            responOrderListVoList.add(vo);
        }
        return responOrderListVoList;
    }
}
