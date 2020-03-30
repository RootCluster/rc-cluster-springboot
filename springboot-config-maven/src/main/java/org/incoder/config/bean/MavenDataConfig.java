package org.incoder.config.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Jerry xu
 * @date : 2019/10/27  12:59
 */
@Configuration
public class MavenDataConfig {

    @Bean
    public MavenDataBean getDataBase() {
        return new MavenDataBean();
    }
}
