package com.rrw.donate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rrw.donate.entity.TOrderChargingEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<TOrderChargingEntity> {
}
