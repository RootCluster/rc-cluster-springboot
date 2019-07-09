package org.incoder.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringbootStartApplication
 *
 * @author : Jerry xu
 * @date : 2019-06-20  23:40
 */
@SpringBootApplication
public class SpringbootStartApplication {

    public static void main(String[] args) {
        System.out.println("项目启动加载类" + SpringbootStartApplication.class.getClassLoader());
        SpringApplication.run(SpringbootStartApplication.class, args);
    }

}
