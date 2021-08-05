package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TOrderChargingDao;
import io.renren.modules.generator.entity.TOrderChargingEntity;
import io.renren.modules.generator.service.TOrderChargingService;


@Service("tOrderChargingService")
public class TOrderChargingServiceImpl extends ServiceImpl<TOrderChargingDao, TOrderChargingEntity> implements TOrderChargingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TOrderChargingEntity> page = this.page(
                new Query<TOrderChargingEntity>().getPage(params),
                new QueryWrapper<TOrderChargingEntity>()
        );

        return new PageUtils(page);
    }

}