package org.incoder.mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Jerry xu
 * @date : 2019/10/27  12:59
 */
@Configuration
public class DataBaseConfig {

    @Bean
    public DataBaseBean getDataBase() {
        return new DataBaseBean();
    }
}
