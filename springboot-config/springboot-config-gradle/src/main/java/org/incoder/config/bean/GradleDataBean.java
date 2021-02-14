package org.incoder.config.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Jerry xu
 * @date : 2019/10/27  13:00
 */
@Data
@Component
public class GradleDataBean {

    @Value("${env}")
    private String env;
    @Value("${crate-date}")
    private Integer createDate;
    @Value("${is-mac}")
    private Boolean isMac;
    @Value("${email}")
    private String email;
    @Value("${message}")
    private String message;
    @Value("${name1}")
    private String name1;
    @Value("${name2}")
    private String name2;

    @Value("${list-program-languages}")
    private List<String> programLanguages;

    /**
     * 使用el表达式，获取定义数组
     */
    @Value("#{'${el.list}'.split(',')}")
    private List<String> programList;

    @Value("${persons.name}")
    private String name;
    @Value("${persons.age}")
    private Integer age;

    @Value("${secret}")
    private String secret;
    @Value("${number}")
    private Integer number;
    @Value("${bignumber}")
    private Long bigNumber;
    @Value("${uuid}")
    private String uuid;

}
