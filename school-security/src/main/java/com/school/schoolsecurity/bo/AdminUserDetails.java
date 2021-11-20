package com.school.schoolsecurity.bo;


import com.school.generate.mbg.model.UmsAdmin;
import com.school.generate.mbg.model.UmsSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 *  2021年11/19
 *  后台管理员以及自己能访问的权限地址   url表示  /.../...
 */
public class AdminUserDetails implements UserDetails {
    //后台用户
    private UmsAdmin umsAdmin;
    //拥有的资源表
    private List<UmsSource> sourceList;

    public AdminUserDetails (UmsAdmin umsAdmin,List<UmsSource> umsSourceList){
        this.umsAdmin = umsAdmin;
        this.sourceList = umsSourceList;
    }

    //用户的权限集， 默认需要添加ROLE_ 前缀
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return sourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId()+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
