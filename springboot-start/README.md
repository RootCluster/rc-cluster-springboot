## spring-start

创建 springboot 项目方式
1. 官方初始化创建应用 [http://start.spring.io](http://start.spring.io/)
2. IDEA 初始化创建

## 结构

```
springboot-start/
    ├── java/org.incoder.start/
    │   ├── controller/                     # Controller 层
    │   ├── dao/                            # 数据操作层 DAO
    │   ├── domain/                         # 实体类
    │   ├── service/                        # 业务逻辑层
    │   ├── plus/                           # 使用mybatis plus
    │   └── SpringbootStartApplication      # 当前模块启动类（入口）
    └── resources
        ├── static                          # 静态文件
        ├── templates                       # 模板文件
        └── application.yml                 # 项目配置文件
```
