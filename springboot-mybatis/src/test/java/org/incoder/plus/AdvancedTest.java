package org.incoder.plus;

import org.incoder.plus.mapper.StaffMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Mybatis plus 使用时的高级技巧
 *
 * @author : Jerry xu
 * @since : 2020/5/10  23:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdvancedTest {

    @Resource
    private StaffMapper staffMapper;

    ///////////////////////////////////////////////////////////////////////////
    // 逻辑删除【修改数据的状态，比如这里的：isDeleted 字段】
    // https://mybatis.plus/guide/logic-delete.html
    ///////////////////////////////////////////////////////////////////////////

    @Test
    public void deleteById() {
        int rows = staffMapper.deleteById(1L);
        System.out.println("影响行数" + rows);

        // 注意 DAO(entity)中添加了 @TableLogic 注解后，在使用 MP 相关的其他查询，修改，删除操作时会自动在语句中加上限定条件【未被删的数据】
    }

    ///////////////////////////////////////////////////////////////////////////
    // 自动填充
    // https://mybatis.plus/guide/auto-fill-metainfo.html
    // 在对应的 Entity【DAO】 中添加 @TableField 注解。可设置 fill 属性，
    // 可以是更新时填充【FieldFill.UPDATE】，可以是新增时填充【FieldFill.UPDATE】，也可以是新增更新时都填充【FieldFill.INSERT_UPDATE】
    // 要自定义逻辑填充，需要在 SpringBoot 中添加实现了 MetaObjectHandler 的 Bean，例如 MybatisMetaObjectHelp.java
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // 乐观锁
    // https://mybatis.plus/guide/optimistic-locker-plugin.html#%E4%B8%BB%E8%A6%81%E9%80%82%E7%94%A8%E5%9C%BA%E6%99%AF
    // 一些细节文档上已说明清楚，使用是请注意
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // SQL 注入
    // https://mybatis.plus/guide/sql-injector.html
    // 用于添加通用的方法
    // 实现步骤
    // 1. 创建定义方法的类
    // 2. 创建注入器
    // 3. 在 Mapper 中加入自定义方法
    ///////////////////////////////////////////////////////////////////////////

    @Test
    public void deleteAll() {
        // 这里定义的方法是物理删除，请注意，这里只是用来演示该功能
        int row = staffMapper.deleteAll();
        System.out.println("影响行" + row);
    }

}
