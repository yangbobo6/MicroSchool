package com.school.generate.mbg.mapper;

import com.school.generate.mbg.model.UmsSource;
import com.school.generate.mbg.model.UmsSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsSourceMapper {
    long countByExample(UmsSourceExample example);

    int deleteByExample(UmsSourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsSource record);

    int insertSelective(UmsSource record);

    List<UmsSource> selectByExample(UmsSourceExample example);

    UmsSource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsSource record, @Param("example") UmsSourceExample example);

    int updateByExample(@Param("record") UmsSource record, @Param("example") UmsSourceExample example);

    int updateByPrimaryKeySelective(UmsSource record);

    int updateByPrimaryKey(UmsSource record);
}