package com.rrw.donate.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rrw.donate.entity.CompanyInfo;
import com.rrw.donate.mapper.CompanyInfoMapper;
import com.rrw.donate.service.ICompanyInfoService;
import com.rrw.donate.vo.request.RequestCompanyListVo;
import com.rrw.donate.vo.response.ResponseCompanyNameVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 21:31
 */
@Service
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper,CompanyInfo>implements ICompanyInfoService  {
    @Override
    public IPage<CompanyInfo> companyList(RequestCompanyListVo requestCompanyListVo) {
        //构造一个分页对象
        IPage<CompanyInfo> page = new Page<>(requestCompanyListVo.getDisplayStart(),requestCompanyListVo.getDisplayLength());
        //创建查询器
        QueryWrapper<CompanyInfo> queryWrapper = new QueryWrapper<>();
        //判断是否为空，为空不查询该条件，有才去查
        if (StringUtils.checkValNotNull(requestCompanyListVo.getCompanyAddress())){
            queryWrapper.like("company_address",requestCompanyListVo.getCompanyAddress());
        }
        if (StringUtils.checkValNotNull(requestCompanyListVo.getCompanyName())){
            queryWrapper.like("company_name",requestCompanyListVo.getCompanyName());
        }
        if (StringUtils.checkValNotNull(requestCompanyListVo.getCompanyLinkman())){
            queryWrapper.like("company_linkman",requestCompanyListVo.getCompanyLinkman());
        }
        return page(page, queryWrapper);
    }

    @Override
    public List<ResponseCompanyNameVo> getAllCompanyName() {
        //查询数据库中所有单位信息
        List<CompanyInfo> companyInfoList = list();
        //定义返回的数据集合
        List<ResponseCompanyNameVo> requestCompanyListVoList = new ArrayList<>();
        //将companyInfoList 复制其中的属性到  requestCompanyListVoList
        for (CompanyInfo companyInfo:companyInfoList){
            ResponseCompanyNameVo companyNameVo = new ResponseCompanyNameVo();
            //拷贝并add
            BeanUtils.copyProperties(companyInfo,companyNameVo);
            requestCompanyListVoList.add(companyNameVo);

         }
        return requestCompanyListVoList;
    }
}
