package com.rrw.donate.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rrw.donate.common.Result;
import com.rrw.donate.entity.CompanyInfo;
import com.rrw.donate.service.ICompanyInfoService;
import com.rrw.donate.vo.request.RequestCompanyListVo;
import com.rrw.donate.vo.response.ResponseCompanyNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 21:28
 */
@RestController
@RequestMapping("/company-info")
public class CompanyInfoController {

    @Autowired
    private ICompanyInfoService companyInfoService;
    @PostMapping("list")
    public Result list(@RequestBody RequestCompanyListVo requestCompanyListVo){
        IPage<CompanyInfo> page = companyInfoService.companyList(requestCompanyListVo);
        return Result.getSuccess().setData(page);
    }
    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.getSuccess().setData(companyInfoService.getById(id));
    }

    //返回所有基金项目名[外键：既选择一个基金，该基金下的所有项目（名）都返回]
    @GetMapping("getAllCompanyName")
    public Result getAllCompanyName(){
        List<ResponseCompanyNameVo> companyListVoList = companyInfoService.getAllCompanyName();
        return Result.getSuccess().setData(companyListVoList);
    }
}
