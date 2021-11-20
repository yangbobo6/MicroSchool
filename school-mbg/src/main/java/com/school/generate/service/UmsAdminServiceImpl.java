package com.school.generate.service;

import com.school.generate.mbg.mapper.UmsAdminMapper;
import com.school.generate.mbg.model.UmsAdmin;
import com.school.generate.mbg.model.UmsAdminExample;
import com.school.generate.service.impl.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminMapper adminMapper;

    @Override
    public List<UmsAdmin> listAll() {
        return adminMapper.selectByExample(new UmsAdminExample());
    }

    @Override
    public int createAdmin(UmsAdmin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int deleteAdmin(Integer id) {
        return 0;
    }


}
