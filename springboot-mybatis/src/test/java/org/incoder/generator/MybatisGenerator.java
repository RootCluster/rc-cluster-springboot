package org.incoder.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis代码生成工具.
 *
 * @author : Jerry xu
 * @date : 2020/2/28  13:22
 */
public class MybatisGenerator {

    ///////////////////////////////////////////////////////////////////////////
    // 常用配置
    ///////////////////////////////////////////////////////////////////////////

    // TODO 修改配置文件地址【当前模块名开始往后】
    private static String mybatisXmlPath = System.getProperty("user.dir") + "/springboot-mybatis/src/main/resources/mybatis-generator-config.xml";
    private static boolean overwrite = true;

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        File configFile = new File(mybatisXmlPath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

}
