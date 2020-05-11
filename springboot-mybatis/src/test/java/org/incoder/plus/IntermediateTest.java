package org.incoder.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
}
