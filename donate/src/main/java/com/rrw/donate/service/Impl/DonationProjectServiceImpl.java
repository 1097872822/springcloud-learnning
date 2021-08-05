package com.rrw.donate.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rrw.donate.entity.DonationProject;
import com.rrw.donate.mapper.DonationProjectMapper;
import com.rrw.donate.service.ICompanyInfoService;
import com.rrw.donate.service.IDonationProjectService;
import com.rrw.donate.vo.request.RequestProjectListVo;
import com.rrw.donate.vo.response.ResponProjectListVo;
import com.rrw.donate.vo.response.ResponProjectNameVo;
import com.rrw.donate.vo.response.ResponseCompanyNameVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 23:22
 */
@Service
public class DonationProjectServiceImpl extends ServiceImpl<DonationProjectMapper,DonationProject> implements IDonationProjectService {
    @Autowired
    private ICompanyInfoService icompanyInfoService;

    @Override
    public IPage<ResponProjectListVo> projectList(RequestProjectListVo requestProjectListVo) {
        //分页对象
        IPage<DonationProject> page = new Page<>(requestProjectListVo.getDisplayStart(),requestProjectListVo.getDisplayLength());
        //构造查询器
        QueryWrapper<DonationProject> queryWrapper = new QueryWrapper<>();
        if (StringUtils.checkValNotNull(requestProjectListVo.getProjectName())){
            queryWrapper.eq("project_name",requestProjectListVo.getProjectName());
        }
        if (StringUtils.checkValNotNull(requestProjectListVo.getProjectStatus())){
            queryWrapper.eq("project_status",requestProjectListVo.getProjectStatus());
        }
        page = page(page,queryWrapper);
        //获取所有单位信息
        List<ResponseCompanyNameVo> responProjectListVoList = icompanyInfoService.getAllCompanyName();
        //将id作为键，name值存入map中
        Map<Integer,String> nameMap = new HashMap<>();
        for (ResponseCompanyNameVo name:responProjectListVoList){
            nameMap.put(name.getId(),name.getCompanyName());
        }
        //遍历page
        return page.convert(result->{
            ResponProjectListVo responProjectListVo = new ResponProjectListVo();
            BeanUtils.copyProperties(result,responProjectListVo);
            responProjectListVo.setCompanyName(nameMap.get(result.getCompanyId()));
            return responProjectListVo;
        });
    }

    @Override
    public List<ResponProjectNameVo> queryBycompanyId(Integer companyId) {
        QueryWrapper<DonationProject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_id",companyId);
        queryWrapper.eq("project_status",0);
        List<DonationProject> donationProjectList = list(queryWrapper);
        //遍历需要的数据
        List<ResponProjectNameVo> responProjectNameVoList = new ArrayList<>();
        for (DonationProject donationProject:donationProjectList){
            ResponProjectNameVo vo = new ResponProjectNameVo();
            BeanUtils.copyProperties(donationProject,vo);
            responProjectNameVoList.add(vo);

        }
        return responProjectNameVoList;
    }
}
