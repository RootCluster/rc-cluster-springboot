package org.incoder.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 使用 MyBatis Plus 自动生成相关的文件
 * {@link : https://mp.baomidou.com/guide/generator.html}
 *
 * @author : Jerry xu
 * @date : 2019-08-08  23:20
 */
@Component
public class PlusGenerator {

    /**
     * 读取控制台内容
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // TODO Mac 写绝对路径地址【由于我这里是多module，因此后面加入 module 名称 plus，如果你是单module，就不要加】
        String projectPath = System.getProperty("user.dir") + "/springboot-mybatis";

        ///////////////////////////////////////////////////////////////////////////
        // 全局配置
        // TODO 更多配置{@link https://mp.baomidou.com/config/generator-config.html#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE}
        ///////////////////////////////////////////////////////////////////////////
        GlobalConfig gc = new GlobalConfig()
                // 文件输出路径
                .setOutputDir(projectPath + "/src/main/java")
                // 是否覆盖已有文件【默认值：false】
                .setFileOverride(true)
                // 是否打开输出目录【默认值：true】
                .setOpen(false)
                // 是否在xml中添加二级缓存配置【默认值：false】
//                .setEnableCache(true)
                // 设置作者
                .setAuthor("Jerry xu")
                // 开启 Kotlin 模式【默认值：false】
//                .setKotlin(true)
                // 开启 swagger2 模式【默认值：false】
//                .setSwagger2(true)
                // 开启 ActiveRecord 模式【默认值：false】
//                .setActiveRecord(true)
                // 开启 BaseResultMap【默认值：false】
//                .setBaseResultMap(true)
                // 开启 baseColumnList【默认值：false】
//                .setBaseColumnList(true)
                // 时间类型对应策略【默认值：TIME_PACK】
//                .setDateType(DateType.TIME_PACK)
                ///////////////////////////////////////////////////////////////////////////
                // TODO 自定义文件命名，注意 %s 会自动填充表实体属性！
                ///////////////////////////////////////////////////////////////////////////
                // 实体命名方式
//                .setEntityName("%sEntity")
                // mapper 命名方式
//                .setMapperName("%sDao")
                // Mapper xml 命名方式
//                .setXmlName("%sDao")
                // service 命名方式
//                .setServiceName("%sBusiness")
                // service impl 命名方式
//                .setServiceImplName("%sBusinessImpl")
                // controller 命名方式
//                .setControllerName("%sAction")
                // 指定生成的主键的ID类型
                .setIdType(IdType.AUTO)
                //
                ;
        mpg.setGlobalConfig(gc);

        ///////////////////////////////////////////////////////////////////////////
        // 数据源配置
        // TODO {@link https://mp.baomidou.com/config/generator-config.html#%E6%95%B0%E6%8D%AE%E6%BA%90-datasourceconfig-%E9%85%8D%E7%BD%AE}
        ///////////////////////////////////////////////////////////////////////////
        DataSourceConfig dsc = new DataSourceConfig()
                .setUrl("jdbc:mysql://localhost:3306/server_learn?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("Root,.65")
                /*.setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        if (DbColumnType.BASE_BYTE.getType().equals(fieldType)) {
                            return DbColumnType.BYTE;
                        } else if (DbColumnType.BASE_SHORT.getType().equals(fieldType)) {
                            return DbColumnType.SHORT;
                        } else if (DbColumnType.BASE_CHAR.getType().equals(fieldType)) {
                            return DbColumnType.CHARACTER;
                        } else if (DbColumnType.BASE_INT.getType().equals(fieldType)) {
                            return DbColumnType.INTEGER;
                        } else if (DbColumnType.BASE_LONG.getType().equals(fieldType)) {
                            return DbColumnType.LONG;
                        } else if (DbColumnType.BASE_FLOAT.getType().equals(fieldType)) {
                            return DbColumnType.FLOAT;
                        } else if (DbColumnType.BASE_DOUBLE.getType().equals(fieldType)) {
                            return DbColumnType.DOUBLE;
                        } else if (DbColumnType.BASE_BOOLEAN.getType().equals(fieldType)) {
                            return DbColumnType.BOOLEAN;
                        }
                        return null;
                    }
                })*/
                //
                ;
        mpg.setDataSource(dsc);

        ///////////////////////////////////////////////////////////////////////////
        // 包配置
        // TODO {@link https://mp.baomidou.com/config/generator-config.html#%E5%8C%85%E5%90%8D%E9%85%8D%E7%BD%AE}
        ///////////////////////////////////////////////////////////////////////////
        PackageConfig pc = new PackageConfig()
//                .setModuleName(scanner("连接哪个数据库"))
                // TODO 生成文件的包路径
                .setParent("org.incoder.plus")
                // 设置控制器的包名，默认为 controller
                //.setController("")
                // 设置实体的包名，默认 entity
                //.setEntity("")
                // 设置服务包名，默认 service
                //.setService("")
                // 设置服务实现包名，默认 impl
                //.setServiceImpl("")
                // 设置xml 包名，默认 mapper
                //.setXml("")
                ;
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(com.baomidou.mybatisplus.generator.config.po.TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录");
//                return false;
//            }
//        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        ///////////////////////////////////////////////////////////////////////////
        // 模板配置，Mybatis plus 默认支持Velocity引擎
        // TODO {@link https://mp.baomidou.com/config/generator-config.html#%E6%A8%A1%E6%9D%BF%E9%85%8D%E7%BD%AE}
        ///////////////////////////////////////////////////////////////////////////
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        ///////////////////////////////////////////////////////////////////////////
        // 策略配置
        // TODO {@link https://mp.baomidou.com/config/generator-config.html#%E5%85%A8%E5%B1%80%E7%AD%96%E7%95%A5-globalconfig-%E9%85%8D%E7%BD%AE}
        ///////////////////////////////////////////////////////////////////////////
        StrategyConfig strategy = new StrategyConfig()
                // 表名生成策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                .setEntityLombokModel(true)
                // 生成 RestController 控制器
                .setRestControllerStyle(true)
                // 写于父类中的公共字段
//                .setSuperEntityColumns("id", "create_time", "update_time")
                // 需要排除的表
                //.setExclude(scanner("需要排除的表名，多个英文逗号分割").split(","))
                // 需要生成的表
                .setInclude(scanner("需要生成的表名，多个英文逗号分割").split(","))
                // 驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 设置表前缀，可以再生成文件时去除掉
                .setTablePrefix("tbl_")
                // Boolean类型字段是否移除is前缀处理，默认是 false
                .setEntityBooleanColumnRemoveIsPrefix(true)
                // 自定义 mapper 父类
                // .setSuperMapperClass("com.baomidou.base.BaseMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.base.BaseService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.base.BaseServiceImpl")
                // 自定义 controller 父类
                // .setSuperControllerClass("com.baomidou.base.BaseController")
                //
                ;
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

}
