package org.incoder.config.controller;

import org.incoder.config.bean.MavenDataConfig;
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
    private MavenDataConfig mavenDataConfig;

    @GetMapping(value = "/config")
    public String getConfig() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("##########################################################################\n")
                .append("# 数字，字符串，布尔配置\n")
                .append("##########################################################################\n")
                .append("env: ").append(mavenDataConfig.getDataBase().getEnv()).append("\n")
                .append("os: ").append(mavenDataConfig.getDataBase().getOs()).append("\n")
                .append("os-version: ").append(mavenDataConfig.getDataBase().getOsVersion()).append("\n")
                .append("email: ").append(mavenDataConfig.getDataBase().getEmail()).append("\n")
                .append("message: ").append(mavenDataConfig.getDataBase().getMessage()).append("\n")
                .append("name1: ").append(mavenDataConfig.getDataBase().getName1()).append("\n")
                .append("name2: ").append(mavenDataConfig.getDataBase().getName2()).append("\n")
                .append("##########################################################################\n")
                .append("# 数组（List、Set）\n")
                .append("##########################################################################\n")
//                .append("program-language: ").append(dataConfig.getDataBase().getProgramLanguage().get(0)).append(", ")
//                .append(dataConfig.getDataBase().getProgramLanguage().get(1)).append(", ")
//                .append(dataConfig.getDataBase().getProgramLanguage().get(2)).append("\n")
                .append("program-languages: ").append(mavenDataConfig.getDataBase().getProgramLanguages().get(0)).append(", ")
                .append(mavenDataConfig.getDataBase().getProgramLanguages().get(1)).append(", ")
                .append(mavenDataConfig.getDataBase().getProgramLanguages().get(2)).append("\n")
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
                .append("secret: ").append(mavenDataConfig.getDataBase().getSecret()).append("\n")
                .append("number: ").append(mavenDataConfig.getDataBase().getNumber()).append("\n")
                .append("bignumber: ").append(mavenDataConfig.getDataBase().getBigNumber()).append("\n")
                .append("uuid: ").append(mavenDataConfig.getDataBase().getUuid());
        System.out.println(buffer.toString());
        return buffer.toString();
    }
}
