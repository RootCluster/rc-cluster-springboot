package org.incoder.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.incoder.plus.entity.Staff;
import org.incoder.plus.mapper.StaffMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyBatis Plus Mapper CRUD
 * <p>
 * SpringBootTest 注解只会加载test路径下的资源文件(即xml配置)，并不会加载main路径下的资源文件
 *
 * @author : Jerry xu
 * @date : 2019/10/28  00:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StaffPlusMapperTest {

    @Resource
    private StaffMapper staffMapper;

    /**
     * 新增用户
     */
    @Test
    public void insert() {
        Staff staff = new Staff();
        staff.setUserName("Jerry xu");
        staff.setAge(26);
        staff.setMobile("13468611234");
        staff.setCreateTime(LocalDateTime.now());
        int row = staffMapper.insert(staff);
        System.out.println("影响行数" + row);
    }

    /**
     * 根据用户主键更新用户信息
     */
    @Test
    public void update() {
        Staff staff = new Staff();
        staff.setId(1L);
        staff.setAge(27);
        staff.setUpdateTime(LocalDateTime.now());
        int row = staffMapper.updateById(staff);
        System.out.println("影响行数" + row);

        //======其他方法======
        // 根据 whereEntity 条件，更新记录
        // staffMapper.update();
    }

    /**
     * 根据用户主键删除用户【物理删除】
     */
    @Test
    public void delete() {
        Staff staff = new Staff();
        staff.setId(1L);
        int row = staffMapper.deleteById(staff);
        System.out.println("影响行数" + row);

        //======其他方法======
        // 根据传入的 Entity 实体删除
        // staffMapper.delete();
        // 根据ID 批量删除
        // staffMapper.deleteBatchIds();
        // 根据 columnMap 条件，删除记录
        // staffMapper.deleteByMap();
    }

    ///////////////////////////////////////////////////////////////////////////
    // QueryWrapper
    // LambdaQueryWrapper 防止误写，推荐
    // 创建方式
    // 1. LambdaQueryWrapper<Staff> lambda = new QueryWrapper<Staff>().lambda();
    // 2. LambdaQueryWrapper<Staff> lambdaQuery = new LambdaQueryWrapper<>();
    // 3. LambdaQueryWrapper<Staff> lambdaQueryWrapper = Wrappers.<Staff>lambdaQuery();
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 根据用户主键获取用户信息
     */
    @Test
    public void selectById() {
        Staff staff = staffMapper.selectById(1);
        System.out.println(staff);
    }

    /**
     * 批量户主键，获取信息【默认最大是 1000 条】
     * {@link com.baomidou.mybatisplus.extension.service.IService#DEFAULT_BATCH_SIZE}
     */
    @Test
    public void selectByIds() {
        List<Long> integers = Arrays.asList(1L, 2L, 3L);
        List<Staff> staffList = staffMapper.selectBatchIds(integers);
        staffList.forEach(System.out::println);
    }

    /**
     * 业务查询案例
     */
    @Test
    public void selectList() {
        // 获取用户名中包含小并且年龄小于 28 岁
        // user_name like "%小%" and age < 28
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "小")
                .lt("age", 28);

        // 用户名为王姓并且（年龄小于 30或邮箱不能为空）
        // user_name like "王%" and (age < 30 or mobile is not null)
        queryWrapper.likeRight("user_name", "王")
                .and(qw -> qw.lt("age", 30).or().isNotNull("mobile"));

        // (年龄小于 30 或邮箱不为空)并且名字为王姓【在同一级别 and 的优先级高于 or】
        // (age < 30 or email is not null) and user_name like "王%"
        queryWrapper.nested(qw -> qw.lt("age", 30).or().isNotNull("mobile"))
                .likeRight("user_name", "王");

        // 年龄为30，35，40
        // age in (30,35,40)
        queryWrapper.in("age", Arrays.asList(30, 35, 40));
        // 返回满足条件的一条语句 【last 有 SQL 注入风险】
        // limit 1
        queryWrapper.in("age", Arrays.asList(30, 35, 40)).last("limit 1");

        // 返回指定需要的列
        // 1. 返回需要的列
        queryWrapper.select("user_name", "age", "")
                .like("user_name", "小")
                .lt("age", 28);
        // 2. 排除不需要的列(create_time,update_time)
        queryWrapper.select(Staff.class, info -> !info.getColumn().equals("crete_time")
                && !info.getColumn().equals("update_time"))
                .like("user_name", "小")
                .lt("age", 28);

        // condition，条件成立，追加执行该语句，不成立不追加该语句
        String conditionString = "";
        queryWrapper.like(StringUtils.isNotColumnName(conditionString), "user_name", "王");
        List<Staff> staffList = staffMapper.selectList(queryWrapper);
        staffList.forEach(System.out::println);

        // 可以构造包含 entity 的 new QueryWrapper<User>(User)
        Staff staff = new Staff();
        staff.setUserName("Jerry");
        staff.setMobile("13678328907");
        staff.setAge(23);
        QueryWrapper<Staff> entityWrapper = new QueryWrapper<>(staff);
        List<Staff> entityUserList = staffMapper.selectList(entityWrapper);
        entityUserList.forEach(System.out::println);

        // allEq

    }

    /**
     * 根据 columnMap 条件查询信息
     */
    @Test
    public void selectByMap() {
        // K：数据库中列名，V：对应的值
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("user_name", "Jerry");
        columnMap.put("age", 20);
        List<Staff> staffList = staffMapper.selectByMap(columnMap);
        staffList.forEach(System.out::println);
    }

    /**
     * 当表字段特别多时，前台只需要返回有数据的列，其对应实体为null 的字段不会返回给客户端，而如果返回对应实体，那么为 null 的字段也会返回
     */
    @Test
    public void selectByMaps() {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "Jerry").lt("age", 24);
        List<Map<String, Object>> maps = staffMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    /**
     * <dl>
     *     <dt>链式查询 普通：{@link com.baomidou.mybatisplus.extension.service.IService#query()}</dt>
     *     <dt>LambdaQueryWrapper<T> lambda = new QueryWrapper<T>().lambda();</dt>
     *     <dt>链式查询 lambda 式：{@link com.baomidou.mybatisplus.extension.service.IService#lambdaQuery()}</dt>
     *     <dt>LambdaQueryWrapper<T> lambdaQuery = new LambdaQueryWrapper<T>();</dt>
     * </dl>
     */
    @Test
    public void lambdaQuery() {
        LambdaQueryWrapper<Staff> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(Staff::getUserName, "Jerry");
        List<Staff> userList = staffMapper.selectList(lambdaQueryWrapper);
        userList.forEach(System.out::println);

        // 等价于下面的这条链式调用返回结果
//        List<Staff> userLists = new LambdaQueryChainWrapper<>(staffMapper).like(Staff::getUserName, "Jerry").list();
//        userLists.forEach(System.out::println);

    }

}
