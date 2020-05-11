## spring-mybatis

当前 model 演示完成简单的用户登陆，注册功能

## 结构

```
springboot-mybatis/
  java
    ├── org.incoder/
    │   ├── mybatis/                # 使用 mybatis
    │   │   ├── controller/             # Controller 层
    │   │   ├── dao/                    # 数据操作层 DAO
    │   │   ├── domain/                 # 实体类
    │   │   └── service/                # 业务逻辑层
    │   ├── plus/                   # 使用 mybatis plus
    │   │   ├── controller/             # Controller 层【控制层，负责具体模块的业务流程控制，需要调用 service 逻辑设计层的接口来控制业务流程】
    │   │   ├── mapper/                 # 数据操作层 Mapper【方法语句是直接针对数据库操作的，主要实现一些增删改查操作，在 mybatis 中方法主要与与 xxx.xml 内相互一一映射】
    │   │   ├── entity/                 # 实体类
    │   │   └── service/                # 业务逻辑层【给 Controller 层的类提供接口进行调用。一般就是自己写的方法封装起来，就是声明一下，具体实现在 serviceImpl 中】
    │   └── MybatisApplication      # 当前模块启动类（入口）
    │── resources
    │   ├── mapper/                         # 生成的 mapper 文件
    │   ├── sql/                            # 初始化 sql 脚本
    │   ├── application.yml                 # 项目配置文件
    │   └── mybatis-generator-config.xml    # 项目配置文件
  test
    └── org.incoder/
        ├── generator               # 自动生成代码
        │   ├── MybatisGenerator        # 使用 mybatis 代码生成
        │   └── PlusGenerator           # 使用 mybatis plus 代码生成
        ├── mybatis/                # 使用 mybatis 的相关测试用例
        └── plus/                   # 使用 mybatis plus 的相关测试用例
```

## MyBatis，MyBatis SpringBoot Star，MyBatis Plus三则间的关系

1. MyBatis [网站](https://mybatis.org/mybatis-3/zh/index.html)，[项目源码](https://github.com/mybatis/mybatis-3)  
    MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生类型、接口和 Java 的 POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录
2. MyBatis SpringBoot Star [网站](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html)，[项目源码](https://github.com/mybatis/spring-boot-starter)  
    MyBatis Spring-Boot-Starter will help you use MyBatis with Spring Boot
2. MyBatis Plus [网站](https://mybatis.plus)，[项目源码](https://github.com/baomidou/mybatis-plus)  
    MyBatis-Plus 是 MyBatis 的功能强大的增强工具包，用于简化开发。该工具包为 MyBatis 提供了一些高效，有用，即用的功能，使用它可以有效地节省您的开发时间

### MyBatis在 SpringBoot 中集成使用有两种方式

#### 注解

也就是不使用配置文件，一切问题通过注解的方式完成

#### XML

XML 版本保持映射文件的老传统，接口层只需要定义空方法，系统会自动根据方法名在映射文件中找对应的 Sql

#### 两种方式选择

两种模式各有特点，注解版适合简单快速的模式，其实像现在流行的这种微服务模式，一个微服务就会对应一个自已的数据库，多表连接查询的需求会大大的降低，会越来越适合这种模式。

老传统模式比适合大型项目，可以灵活的动态生成 Sql ，方便调整 Sql ，也有痛痛快快，洋洋洒洒的写 Sql 的感觉

>项目中往往使用 mybatis 的扩展库 **mybatis plus** 来提高开发效率

## 使用步骤

1. 修改 `application.yml` 文件数据库配置
2. 执行 `init.sql` 脚本初始化数据库
3. 启动 `MybatisApplication.java` 文件

## 学习参考

* [如何优雅的适用 Mybatis](https://www.cnblogs.com/ityouknow/p/6037431.html)
* [Mybatis Plus使用指南](https://mp.baomidou.com/guide/)
