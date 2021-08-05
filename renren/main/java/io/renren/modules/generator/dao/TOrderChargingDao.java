package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.TOrderChargingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 充电订单
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-08-05 19:58:00
 */
@Mapper
public interface TOrderChargingDao extends BaseMapper<TOrderChargingEntity> {
	
}
