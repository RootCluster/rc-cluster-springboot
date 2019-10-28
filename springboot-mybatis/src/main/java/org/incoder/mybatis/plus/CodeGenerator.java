package org.incoder.mybatis.plus;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.incoder.mybatis.config.DataBaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 使用 MyBatis Plus 自动生成相关的文件
 *
 * @author : Jerry xu
 * @link: https://mp.baomidou.com/guide/generator.html#使用教程
 * @date : 2019-08-08  23:20
 */
@Component
public class CodeGenerator {

    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.driver-class-name}")
    private static String driverClassName;
    @Value("${spring.datasource.username}")
    private static String username;
    @Value("${spring.datasource.password}")
    private static String password;
    @Value("${test.name}")
    private static String name;

    @Autowired
    static
    DataBaseBean baseBean;

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        System.out.println(name);
        System.out.println(baseBean.getDriverClassName());
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String projectPath = System.getProperty("user.dir");

        ///////////////////////////////////////////////////////////////////////////
        // 全局配置
        ///////////////////////////////////////////////////////////////////////////
        GlobalConfig gc = new GlobalConfig()
                // 文件输出路径
                .setOutputDir(projectPath + "/src/main/java")
                // 设置作者
                .setAuthor("Jerry xu")
                .setOpen(false)
                // 是否生成 kotlin 代码
                //.setKotlin(true)
                //.setFileOverride(false)
                //.setSwagger2(true)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                //.setEntityName("%sEntity");
                //.setMapperName("%sDao")
                //.setXmlName("%sDao")
                //.setServiceName("MP%sService")
                //.setServiceImplName("%sServiceDiy")
                //.setControllerName("%sAction")
                ;
        mpg.setGlobalConfig(gc);

        ///////////////////////////////////////////////////////////////////////////
        // 数据源配置
        ///////////////////////////////////////////////////////////////////////////
        DataSourceConfig dsc = new DataSourceConfig()
                //.setSchemaName("public")
                .setUrl(url)
                .setDriverName(driverClassName)
                .setUsername(username)
                .setPassword(password)
                //.setTypeConvert(new MySqlTypeConvert() {
                //    // 自定义数据库表字段类型转换【可选】
                //    @Override
                //    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //        System.out.println("转换类型：" + fieldType);
                //        // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                //        //    return DbColumnType.BOOLEAN;
                //        // }
                //        return super.processTypeConvert(globalConfig, fieldType);
                //    }
                //})
                ;
        mpg.setDataSource(dsc);

        ///////////////////////////////////////////////////////////////////////////
        // 包配置
        ///////////////////////////////////////////////////////////////////////////
        PackageConfig pc = new PackageConfig()
                .setModuleName(scanner("连接哪个数据库"))
                // 生成文件的包路径
                .setParent("com.incoder.mybatis")
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
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" /*+ pc.getModuleName()*/
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }

        });
        /*cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
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
                .setSuperEntityColumns("id", "create_time", "update_time")
                // 需要排除的表
                //.setExclude(scanner("需要排除的表名，多个英文逗号分割").split(","))
                // 需要生成的表
                .setInclude(scanner("需要生成的表名，多个英文逗号分割").split(","))
                // 驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 设置表前缀，可以再生成文件时去除掉
                .setTablePrefix(pc.getModuleName() + "_")
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
                ;
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
