package org.incoder.config.util;

import org.incoder.config.bean.GradleDataConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author : Jerry xu
 * @date : 2020/7/15  22:19
 */
@Component
public class ConfigUtil {

    @Resource
    private GradleDataConfig gradleData;

    private static GradleDataConfig gradleDataConfig;

    @PostConstruct
    public void init() {
        gradleDataConfig = this.gradleData;
    }

    public static void main(String[] args) {
        String buffer = "##########################################################################\n" +
                "# 数字，字符串，布尔配置\n" +
                "##########################################################################\n" +
                "env: " + gradleDataConfig.getDataBase().getEnv() + "\n" +
//                "os: " + gradleDataConfig.getDataBase().getOs() + "\n" +
//                "os-version: " + gradleDataConfig.getDataBase().getOsVersion() + "\n" +
                "email: " + gradleDataConfig.getDataBase().getEmail() + "\n" +
                "message: " + gradleDataConfig.getDataBase().getMessage() + "\n" +
                "name1: " + gradleDataConfig.getDataBase().getName1() + "\n" +
                "name2: " + gradleDataConfig.getDataBase().getName2() + "\n" +
                "##########################################################################\n" +
                "# 数组（List、Set）\n" +
                "##########################################################################\n" +
//                .append("program-language: ").append(dataConfig.getDataBase().getProgramLanguage().get(0)).append(", ")
//                .append(dataConfig.getDataBase().getProgramLanguage().get(1)).append(", ")
//                .append(dataConfig.getDataBase().getProgramLanguage().get(2)).append("\n")
                "program-languages: " + gradleDataConfig.getDataBase().getProgramLanguages().get(0) + ", " +
                gradleDataConfig.getDataBase().getProgramLanguages().get(1) + ", " +
                gradleDataConfig.getDataBase().getProgramLanguages().get(2) + "\n" +
                "##########################################################################\n" +
                "# 对象、Map（属性和值）\n" +
                "##########################################################################\n" +
//                .append("person: name=").append(dataConfig.getDataBase().getPerson().getName())
//                .append(", age=").append(dataConfig.getDataBase().getPerson().getAge().toString())
//                .append("persons: name=").append(dataConfig.getDataBase().getPersons().getName())
//                .append(",age=").append(dataConfig.getDataBase().getPersons().getAge())
                //        Map<String, String> tempMap = dataConfig.getDataBase().getMapObject().getMap();
//        for (String key : tempMap.keySet()) {
//            buffer.append("map key=").append(key).append(",value=").append(tempMap.get(key));
//        }
                "##########################################################################\n" +
                "# 占位符\n" +
                "##########################################################################\n" +
                "secret: " + gradleDataConfig.getDataBase().getSecret() + "\n" +
                "number: " + gradleDataConfig.getDataBase().getNumber() + "\n" +
                "bignumber: " + gradleDataConfig.getDataBase().getBigNumber() + "\n" +
                "uuid: " + gradleDataConfig.getDataBase().getUuid();
        System.out.println(buffer);
    }
}
