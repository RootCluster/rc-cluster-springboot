package org.incoder.config.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Jerry xu
 * @date : 2019/10/27  13:00
 */
@Component
@Data
public class MavenDataBean {

    @Value("${env}")
    private String env;
    @Value("${os}")
    private String os;
    @Value("${os-version}")
    private String osVersion;
    @Value("${email}")
    private String email;
    @Value("${message}")
    private String message;
    @Value("${name1}")
    private String name1;
    @Value("${name2}")
    private String name2;

//    @Value("${program-language}")
//    private List<String> programLanguage;
    @Value("${program-languages}")
    private List<String> programLanguages;

    private Person person;
    private Persons persons;

    private MavenMapBean mapObject;
    private MavenMapsBean mapObjects;

    @Value("$secret}")
    private String secret;
    @Value("${number}")
    private Integer number;
    @Value("${bignumber}")
    private Long bigNumber;
    @Value("${uuid}")
    private String uuid;

    @Data
    public static class Person {
        @Value("${person.name}")
        private String name;
        @Value("${person.age}")
        private Integer age;
    }

    @Data
    public static class Persons {
        @Value("${persons.name}")
        private String name;
        @Value("${persons.age}")
        private Integer age;
    }

}
