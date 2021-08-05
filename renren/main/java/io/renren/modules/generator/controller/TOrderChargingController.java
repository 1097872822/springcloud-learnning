package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TOrderChargingEntity;
import io.renren.modules.generator.service.TOrderChargingService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 充电订单
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-08-05 19:58:00
 */
@RestController
@RequestMapping("generator/tordercharging")
public class TOrderChargingController {
    @Autowired
    private TOrderChargingService tOrderChargingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:tordercharging:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tOrderChargingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:tordercharging:info")
    public R info(@PathVariable("id") Long id){
		TOrderChargingEntity tOrderCharging = tOrderChargingService.getById(id);

        return R.ok().put("tOrderCharging", tOrderCharging);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:tordercharging:save")
    public R save(@RequestBody TOrderChargingEntity tOrderCharging){
		tOrderChargingService.save(tOrderCharging);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:tordercharging:update")
    public R update(@RequestBody TOrderChargingEntity tOrderCharging){
		tOrderChargingService.updateById(tOrderCharging);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:tordercharging:delete")
    public R delete(@RequestBody Long[] ids){
		tOrderChargingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
