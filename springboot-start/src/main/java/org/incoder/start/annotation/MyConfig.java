package org.incoder.start.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Jerry xu
 * @date : 2019/10/6  17:40
 */
@Configuration
public class MyConfig {

    @Bean
    public MyConfigBean getMyConfigBean() {
        return new MyConfigBean();
    }
}
