package com.school.generate.controller;

import com.school.generate.mbg.model.UmsAdmin;
import com.school.generate.service.impl.UmsAdminService;
import com.school.schoolcommon.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api(tags = "UmsController")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation("获取管理表内所有的成员信息")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsAdmin>> listAll(){
        List<UmsAdmin> list =adminService.listAll();
        return CommonResult.success(list);
    }


    @ApiOperation("插入新的成员")
    @RequestMapping(value = "insert")
    @ResponseBody
    public void createAdmin(){
        UmsAdmin umsAdmin = new UmsAdmin();
        //umsAdmin.setId(02);
        umsAdmin.setSex("m");
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setPassword("123456");
        umsAdmin.setStatus(1);
        umsAdmin.setUsername("yangbo");
        umsAdmin.setLoginTime(new Date());
        adminService.createAdmin(umsAdmin);
    }
}
