package org.incoder.config.controller;

import org.incoder.config.bean.GradleDataConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : Jerry xu
 * @since : 2020/3/26  22:26
 */
@RestController
@RequestMapping(value = "/api")
public class ConfigController {

    @Resource
    private GradleDataConfig gradleDataConfig;

    @GetMapping(value = "/config")
    public String getConfig() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("##########################################################################\n")
                .append("# 数字，字符串，布尔配置\n")
                .append("##########################################################################\n")
                .append("env: ").append(gradleDataConfig.getDataBase().getEnv()).append("\n")
                .append("os: ").append(gradleDataConfig.getDataBase().getOs()).append("\n")
                .append("os-version: ").append(gradleDataConfig.getDataBase().getOsVersion()).append("\n")
                .append("email: ").append(gradleDataConfig.getDataBase().getEmail()).append("\n")
                .append("message: ").append(gradleDataConfig.getDataBase().getMessage()).append("\n")
                .append("name1: ").append(gradleDataConfig.getDataBase().getName1()).append("\n")
                .append("name2: ").append(gradleDataConfig.getDataBase().getName2()).append("\n")
                .append("##########################################################################\n")
                .append("# 数组（List、Set）\n")
                .append("##########################################################################\n")
//                .append("program-language: ").append(dataConfig.getDataBase().getProgramLanguage().get(0)).append(", ")
//                .append(dataConfig.getDataBase().getProgramLanguage().get(1)).append(", ")
//                .append(dataConfig.getDataBase().getProgramLanguage().get(2)).append("\n")
                .append("program-languages: ").append(gradleDataConfig.getDataBase().getProgramLanguages().get(0)).append(", ")
                .append(gradleDataConfig.getDataBase().getProgramLanguages().get(1)).append(", ")
                .append(gradleDataConfig.getDataBase().getProgramLanguages().get(2)).append("\n")
                .append("##########################################################################\n")
                .append("# 对象、Map（属性和值）\n")
                .append("##########################################################################\n")
//                .append("person: name=").append(dataConfig.getDataBase().getPerson().getName())
//                .append(", age=").append(dataConfig.getDataBase().getPerson().getAge().toString())
//                .append("persons: name=").append(dataConfig.getDataBase().getPersons().getName())
//                .append(",age=").append(dataConfig.getDataBase().getPersons().getAge())
        ;

//        Map<String, String> tempMap = dataConfig.getDataBase().getMapObject().getMap();
//        for (String key : tempMap.keySet()) {
//            buffer.append("map key=").append(key).append(",value=").append(tempMap.get(key));
//        }

        buffer.append("##########################################################################\n")
                .append("# 占位符\n")
                .append("##########################################################################\n")
                .append("secret: ").append(gradleDataConfig.getDataBase().getSecret()).append("\n")
                .append("number: ").append(gradleDataConfig.getDataBase().getNumber()).append("\n")
                .append("bignumber: ").append(gradleDataConfig.getDataBase().getBigNumber()).append("\n")
                .append("uuid: ").append(gradleDataConfig.getDataBase().getUuid());
        System.out.println(buffer.toString());
        return buffer.toString();
    }
}
