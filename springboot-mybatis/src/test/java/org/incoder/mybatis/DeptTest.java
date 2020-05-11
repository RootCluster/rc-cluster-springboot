package org.incoder.mybatis;

import org.incoder.mybatis.bean.Dept;
import org.incoder.mybatis.dao.DeptMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Jerry xu
 * @date : 2019/10/27  19:29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptTest {

    @Resource
    private DeptMapper deptMapper;

    /**
     * 新增数据
     */
    @Test
    public void insert() {
        Dept dept = new Dept();
        dept.setCreateTime(LocalDateTime.now());
        dept.setDeptName("开发部");
        int row = deptMapper.insert(dept);
        System.out.println("影响行数" + row);
    }

    /**
     * 更新数据
     */
    @Test
    public void updateByPrimaryKey() {
        Dept dept = new Dept();
        dept.setId(1L);
        dept.setDeptName("开发部-【新】");
        dept.setUpdateTime(LocalDateTime.now());
        int row = deptMapper.updateByPrimaryKey(dept);
        System.out.println("影响行数" + row);
    }

    /**
     * 删除数据
     */
    @Test
    public void deleteByPrimaryKey() {
        int row = deptMapper.deleteByPrimaryKey(0L);
        System.out.println("影响行数" + row);
    }

    /**
     * 查询数据
     */
    @Test
    public void selectByPrimaryKey() {
        Dept dept = deptMapper.selectByPrimaryKey(1L);
        System.out.println(dept);
    }

    /**
     * 查询所有数据
     */
    @Test
    public void selectAll() {
        List<Dept> deptList = deptMapper.selectAll();
        deptList.forEach(System.out::println);
    }

}
