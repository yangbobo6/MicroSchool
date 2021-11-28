package com.school.generate.controller;

import com.school.generate.mbg.model.UmsResource;
import com.school.schoolcommon.api.CommonResult;
import com.school.schoolsecurity.Component.DynamicSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 后台管理资源
* */
@Controller
@RequestMapping("/resource")
public class UmsResourceController {
    @Autowired
    private UmsResourceService umsResourceService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResource umsResource) {
        int count = resourceService.create(umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


}
