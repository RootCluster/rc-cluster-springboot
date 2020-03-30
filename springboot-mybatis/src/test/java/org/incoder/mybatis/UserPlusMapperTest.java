package org.incoder.mybatis;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * MyBatis Plus Mapper CRUD
 *
 * @author : Jerry xu
 * @date : 2019/10/28  00:04
 */
@SpringBootTest
public class UserPlusMapperTest {

//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private DeptMapper deptMapper;

    ///////////////////////////////////////////////////////////////////////////
    // QueryWrapper
    // LambdaQueryWrapper 防止误写，推荐
    // 创建方式
    // 1. LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
    // 2. LambdaQueryWrapper<User> lambdaQuery = new LambdaQueryWrapper<>();
    // 3. LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery();
    ///////////////////////////////////////////////////////////////////////////

    @Test
    public void selectById() {
//        User user = userMapper.selectById(1);
//        System.out.println(user);
    }

    @Test
    public void selectByIds() {
        List<Long> integers = Arrays.asList(1L, 2L, 3L);
//        List<User> userList = userMapper.selectBatchIds(integers);
//        userList.forEach(System.out::println);
    }


    @Test
    public void selectList() {
//        // 获取用户名中包含小并且年龄小于 28 岁
//        // name like "%小%" and age < 28
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        queryWrapper.like("name", "小")
//                .lt("age", 28);
//
//        // 名字为王姓并且（年龄小于 30或邮箱不能为空）
//        // name like "王%" and (age < 30 or email is not null)
//        queryWrapper.likeRight("name", "王")
//                .and(qw -> qw.lt("age", 30).or().isNotNull("email"));
//
//        // (年龄小于 30 或邮箱不为空)并且名字为王姓【在同一级别 and 的优先级高于 or】
//        // (age < 30 or email is not null) and name like "王%"
//        queryWrapper.nested(qw -> qw.lt("age", 30).or().isNotNull("email"))
//                .likeRight("name", "王");
//
//        // 年龄为30，35，40
//        // age in (30,35,40)
//        queryWrapper.in("age", Arrays.asList(30, 35, 40));
//        // 返回满足条件的一条语句 【last 有 SQL 注入风险】
//        // limit 1
//        queryWrapper.in("age", Arrays.asList(30, 35, 40)).last("limit 1");
//
//        // 返回指定需要的列
//        // 1. 返回需要的列
//        queryWrapper.select("name", "age", "")
//                .like("name", "小")
//                .lt("age", 28);
//        // 2. 排除不需要的列(create_time,update_time)
//        queryWrapper.select(User.class, info -> !info.getColumn().equals("crete_time")
//                && !info.getColumn().equals("update_time"))
//                .like("name", "小")
//                .lt("age", 28);
//
//        // condition，条件成立，追加执行该语句，不成立不追加该语句
//        String conditionString = "";
//        queryWrapper.like(StringUtils.isNotColumnName(conditionString), "name", "王");
//        List<User> userList = userMapper.selectList(queryWrapper);
//        userList.forEach(System.out::println);
//
//        // 可以构造包含 entity 的 new QueryWrapper<User>(User)
//        User user = new User();
//        user.setAge(23);
//        user.setName("Jerry");
//        QueryWrapper<User> entityWrapper = new QueryWrapper<>(user);
//        List<User> entityUserList = userMapper.selectList(entityWrapper);
//        entityUserList.forEach(System.out::println);
//
//        // allEq

    }

    @Test
    public void selectByMap() {
        // K：数据库中列名，V：对应的值
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("name", "Jerry");
//        columnMap.put("age", 20);
//        List<User> userList = userMapper.selectByMap(columnMap);
//        userList.forEach(System.out::println);
    }

    /**
     * 当表字段特别多时，前台只需要返回有数据的列，其对应实体为null 的字段不会返回给客户端，而如果返回对应实体，那么为 null 的字段也会返回
     */
    @Test
    public void selectByMaps() {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "Jerry").lt("age", 24);
//        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
//        maps.forEach(System.out::println);
    }

    @Test
    public void lambdaQuery() {
//        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
//        LambdaQueryWrapper<User> lambdaQuery = new LambdaQueryWrapper<>();
//        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery();
//
//        lambdaQueryWrapper.like(User::getName, "Jerry");
//        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
//        userList.forEach(System.out::println);
//
//        // 等价于下面的这条链式调用返回结果
//        List<User> userLists = new LambdaQueryChainWrapper<User>(userMapper).like(User::getName, "Jerry").list();
//        userLists.forEach(System.out::println);

    }


    /**
     * 通用 Wrapper 不能满足业务需要，需要自定义 SQL，mybatis plus version >= 3.0.7
     */
    @Test
    public void customSql() {
//        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery();
//        lambdaQueryWrapper.like(User::getName, "Jerry");
//        List<User> userList = userMapper.selectCustomSql(lambdaQueryWrapper);
//        userList.forEach(System.out::println);
//
//        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
//        lambdaQuery.like(User::getName, "Jerry");
//        List<User> userLists = userMapper.selectCustomMapper(lambdaQueryWrapper);
//        userLists.forEach(System.out::println);
    }


}
