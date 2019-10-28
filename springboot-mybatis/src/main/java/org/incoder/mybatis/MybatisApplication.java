package org.incoder.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动入口
 *
 * @author : Jerry xu
 * @date : 2019-10-26  13:40
 */
@SpringBootApplication
@MapperScan("org.incoder.mybatis")
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
