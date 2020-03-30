package org.incoder.mybatis.controller;

import org.incoder.mybatis.bean.Dept;
import org.incoder.mybatis.dao.DeptMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : Jerry xu
 * @since : 2020/3/30  07:58
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptMapper deptMapper;

    @GetMapping(value = "/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @PostMapping()
    public int insertDept(@RequestBody Dept dept) {
        return deptMapper.insert(dept);
    }

}
