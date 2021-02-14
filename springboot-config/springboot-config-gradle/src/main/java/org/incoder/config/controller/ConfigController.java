package org.incoder.config.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.incoder.config.bean.*;
import org.springframework.http.ResponseEntity;
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

    @Resource
    private ConfigListBean configListBean;

    @Resource
    private ConfigObjectBean configObjectBean;

    @Resource
    private ConfigMapBean configMapBean;

    @Resource
    private ConfigMapsBean configMapsBean;

    @Resource
    private ObjectMapper objectMapper;

    @GetMapping(value = "/config")
    public String getConfig() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("##########################################################################\n")
                .append("# 数字，字符串，布尔配置\n")
                .append("##########################################################################\n")
                .append("env: ").append(gradleDataConfig.getDataBase().getEnv()).append("\n")
                .append("os: ").append(gradleDataConfig.getDataBase().getCreateDate()).append("\n")
                .append("os-version: ").append(gradleDataConfig.getDataBase().getIsMac()).append("\n")
                .append("email: ").append(gradleDataConfig.getDataBase().getEmail()).append("\n")
                .append("message: ").append(gradleDataConfig.getDataBase().getMessage()).append("\n")
                .append("name1: ").append(gradleDataConfig.getDataBase().getName1()).append("\n")
                .append("name2: ").append(gradleDataConfig.getDataBase().getName2()).append("\n")
                .append("##########################################################################\n")
                .append("# 数组\n")
                .append("##########################################################################\n")
                .append("program: ")
                .append(String.join("-", configListBean.getLanguage())).append("\n")
                .append("program-languages: ")
                .append(String.join(",", gradleDataConfig.getDataBase().getProgramLanguages())).append("\n")
                .append("SpEL: ")
                .append(gradleDataConfig.getDataBase().getProgramList()).append("\n")
                .append("##########################################################################\n")
                .append("# 对象、Map（属性和值）\n")
                .append("##########################################################################\n")
                .append(gradleDataConfig.getDataBase().getName())
                .append("object：").append(configObjectBean.getName()).append(configObjectBean.getAge()).append("\n")
                .append("map-object: map=").append(configMapBean.getMap()).append("\n")
                .append("mapObjects.maps:").append(configMapsBean.getMaps()).append("\n")
                .append("##########################################################################\n")
                .append("# 占位符\n")
                .append("##########################################################################\n")
                .append("secret: ").append(gradleDataConfig.getDataBase().getSecret()).append("\n")
                .append("number: ").append(gradleDataConfig.getDataBase().getNumber()).append("\n")
                .append("bignumber: ").append(gradleDataConfig.getDataBase().getBigNumber()).append("\n")
                .append("uuid: ").append(gradleDataConfig.getDataBase().getUuid());
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    @GetMapping("/config/json")
    public ResponseEntity<Object> getConfigJson() {
        return null;
    }

}
