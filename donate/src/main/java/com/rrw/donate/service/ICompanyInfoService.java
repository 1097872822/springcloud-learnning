package com.rrw.donate.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rrw.donate.entity.CompanyInfo;
import com.rrw.donate.vo.request.RequestCompanyListVo;
import com.rrw.donate.vo.response.ResponseCompanyNameVo;

import java.util.List;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 21:30
 */
public interface ICompanyInfoService extends IService<CompanyInfo> {
    //收卷单位查询
    IPage<CompanyInfo> companyList(RequestCompanyListVo requestCompanyListVo);

    //获取收娟单位名及id
    List<ResponseCompanyNameVo> getAllCompanyName();
}
