package org.incoder.plus.controller;


import org.incoder.plus.entity.Staff;
import org.incoder.plus.service.IStaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 员工信息表 前端控制器
 * </p>
 *
 * @author Jerry xu
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/staff")
public class StaffController {


    @Resource
    private IStaffService deptMapper;

    @GetMapping(value = "/{id}")
    public Staff getStaffById(@PathVariable("id") Long id) {
        return deptMapper.getById(id);
    }

    @PostMapping()
    public boolean insertStaff(@RequestBody Staff staff) {
        return deptMapper.save(staff);
    }

}

