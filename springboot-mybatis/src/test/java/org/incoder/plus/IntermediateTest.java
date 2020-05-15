package org.incoder.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.incoder.plus.entity.Staff;
import org.incoder.plus.mapper.StaffMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Mybatis plus 使用时的一些进阶条件构造示例
 *
 * @author : Jerry xu
 * @since : 2020/5/10  23:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IntermediateTest {

    @Resource
    private StaffMapper staffMapper;

    /**
     * 通用 Wrapper 不能满足业务需要，需要自定义 SQL，mybatis plus version >= 3.0.7
     */
    @Test
    public void customSql() {
        List<Staff> annotationCustomSql = staffMapper.annotationCustomSql(new LambdaQueryWrapper<Staff>()
                .like(Staff::getUserName, "Jerry"));
        annotationCustomSql.forEach(System.out::println);

        List<Staff> xmlCustomSql = staffMapper.xmlCustomSql(new LambdaQueryWrapper<Staff>()
                .like(Staff::getUserName, "Jerry"));
        xmlCustomSql.forEach(System.out::println);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 分页查询
    // https://mybatis.plus/guide/page.html
    // 需要添加 PaginationInterceptor 配置到 SpringBoot 中
    // BaseMapper中提供了两个分页方法，这里是物理分页，先按照条件执行 SELECT COUNT(1)……查出总记录数，然后再分页
    // 1. selectPage
    // 2. selectMapsPage
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 单表分页
     */
    @Test
    public void selectPage() {
        Page<Staff> page = new Page<>(1, 2);
        Page<Staff> staffPage = staffMapper.selectPage(page, new LambdaQueryWrapper<Staff>().eq(Staff::getAge, 27));
        System.out.println("总记录数: " + staffPage.getTotal());
        System.out.println("总页数: " + staffPage.getPages());
        System.out.println("当前页: " + staffPage.getCurrent());
        System.out.println("当前每页查询数: " + staffPage.getSize());
        staffPage.getRecords().forEach(System.out::println);
    }

    /**
     * 自定义查询分页【多表联查】
     */
    @Test
    public void selectMultiTablePage() {
        Page<Staff> page = new Page<>(1, 2);
        Page<Staff> staffPage = staffMapper.selectMultiTablePage(page, new LambdaQueryWrapper<Staff>().eq(Staff::getAge, 27));
        System.out.println("总记录数: " + staffPage.getTotal());
        System.out.println("总页数: " + staffPage.getPages());
        System.out.println("当前页: " + staffPage.getCurrent());
        System.out.println("当前每页查询数: " + staffPage.getSize());
        staffPage.getRecords().forEach(System.out::println);
    }

}
