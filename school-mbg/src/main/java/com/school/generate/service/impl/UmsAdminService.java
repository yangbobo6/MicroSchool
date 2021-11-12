package com.school.generate.service.impl;

import com.school.generate.mbg.model.UmsAdmin;

import java.util.List;

public interface UmsAdminService {
    List<UmsAdmin> listAll();

    int createAdmin(UmsAdmin admin);

    int deleteAdmin(Integer id);
}
