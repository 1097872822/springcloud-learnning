package com.rrw.donate.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrw.donate.common.Result;
import com.rrw.donate.common.StringConsts;
import com.rrw.donate.service.IDonationProjectService;
import com.rrw.donate.service.OrderService;
import com.rrw.donate.vo.request.RequestDeleteByIdVo;
import com.rrw.donate.vo.request.RequestProjectListVo;
import com.rrw.donate.vo.response.ResponOrderListVo;
import com.rrw.donate.vo.response.ResponProjectListVo;
import com.rrw.donate.vo.response.ResponProjectNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 23:20
 */
@RestController
@RequestMapping("/donation-project/")
public class DonationProjectController {
    @Autowired
    private IDonationProjectService donationProjectService;
    @Autowired
    private OrderService orderService;
    /*
    收娟项目列表
     */
    @PostMapping("list")
    public Result list(@RequestBody RequestProjectListVo requestProjectListVo){
        IPage<ResponProjectListVo> page = donationProjectService.projectList(requestProjectListVo);
        return Result.getSuccess().setData(page);
    }

    /*
        根据companyId查询收娟项目信息
     */
    @GetMapping("queryByCompanyId/{companyId}")
    public Result queryByCompanyId(@PathVariable Integer companyId){
        List<ResponProjectNameVo> voList = donationProjectService.queryBycompanyId(companyId);
        return Result.getSuccess().setData(voList);
    }

    /*
        根据充电桩名查询电费
     */
    @GetMapping("queryBypileName/{pileName}")
    public Result queryBypileName(@PathVariable String pileName){
        List<ResponOrderListVo> orderListVos = orderService.queryBypileName(pileName);
        return Result.getSuccess().setData(orderListVos);
    }

    @DeleteMapping("deleteById")
    public Result deleteById(@RequestBody RequestDeleteByIdVo deleteVo){
        List<Integer> ids = Arrays.asList(deleteVo.getIds());
        if (ids.size() > 0 && donationProjectService.removeByIds(ids)){
            return Result.getSuccess().setMsg(StringConsts.DELETE_SUCCESS);
        }else {
            return Result.getFailure().setMsg(StringConsts.DELETE_FAIL);
        }
    }
}
