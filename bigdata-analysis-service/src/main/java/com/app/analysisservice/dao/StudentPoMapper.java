package com.app.analysisservice.dao;

import com.app.analysisservice.entity.po.StudentPo;
import com.app.analysisservice.entity.po.StudentPoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentPoMapper {

    int countByExample(StudentPoExample example);


    int deleteByExample(StudentPoExample example);


    int deleteByPrimaryKey(Integer id);


    int insert(StudentPo record);


    int insertSelective(StudentPo record);


    List<StudentPo> selectByExample(StudentPoExample example);


    StudentPo selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") StudentPo record, @Param("example") StudentPoExample example);


    int updateByExample(@Param("record") StudentPo record, @Param("example") StudentPoExample example);


    int updateByPrimaryKeySelective(StudentPo record);


    int updateByPrimaryKey(StudentPo record);

    /**
     * 插入数据返回主键Id
     */
    int insertSelectiveReturnKeyId(StudentPo record);
}