package com.rrw.donate.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rrw.donate.entity.DonationProject;
import com.rrw.donate.vo.request.RequestProjectListVo;
import com.rrw.donate.vo.response.ResponProjectListVo;
import com.rrw.donate.vo.response.ResponProjectNameVo;

import java.util.List;

public interface IDonationProjectService extends IService<DonationProject> {
    //查询项目列表
    IPage<ResponProjectListVo> projectList(RequestProjectListVo requestProjectListVo);

    //companyId查询项目列表
    List<ResponProjectNameVo> queryBycompanyId(Integer companyId);
}
