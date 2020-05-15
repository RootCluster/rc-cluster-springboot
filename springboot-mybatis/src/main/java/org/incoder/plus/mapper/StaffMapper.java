package org.incoder.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.incoder.plus.entity.Staff;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author Jerry xu
 * @since 2020-05-10
 */
public interface StaffMapper extends BaseMapper<Staff> {

    /**
     * 把 SQL 写在注解上的方式
     *
     * @param wrapper 条件构造器
     * @return List
     */
    @Select("select * from tbl_staff ${ew.customSqlSegment}")
    List<Staff> annotationCustomSql(@Param(Constants.WRAPPER) Wrapper<Staff> wrapper);

    /**
     * XML 的方式实现自定义查询
     *
     * @param wrapper 条件构造器
     * @return List
     */
    List<Staff> xmlCustomSql(@Param(Constants.WRAPPER) Wrapper<Staff> wrapper);

    /**
     * 多表联查分页
     *
     * @param page         page
     * @param queryWrapper 固定写法
     * @return IPage
     */
    Page<Staff> selectMultiTablePage(Page<Staff> page, @Param(Constants.WRAPPER) Wrapper<Staff> queryWrapper);

    /**
     * SQL注入的方法，如果这个方法是很多模块都需要的方法，
     * 你可以自定义 Mapper 让其需要使用该方法的继承你自定义的 Mapper
     *
     * @return 影响行数
     */
    int deleteAll();
}
