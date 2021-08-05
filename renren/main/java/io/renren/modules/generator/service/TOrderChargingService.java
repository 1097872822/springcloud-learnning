package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.TOrderChargingEntity;

import java.util.Map;

/**
 * 充电订单
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-08-05 19:58:00
 */
public interface TOrderChargingService extends IService<TOrderChargingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

