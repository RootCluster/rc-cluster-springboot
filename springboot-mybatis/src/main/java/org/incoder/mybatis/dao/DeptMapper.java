package org.incoder.mybatis.dao;

import org.incoder.mybatis.bean.Dept;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dept record);

    Dept selectByPrimaryKey(Long id);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);
}