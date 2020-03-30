package org.incoder.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author : Jerry xu
 * @since : 2020/3/29  16:26
 * 使用 @ConfigurationProperties配置属性必须是小写，单词之间用'-'连接
 */
@Configuration
@ConfigurationProperties(prefix = "map-objects")
@Data
public class MavenMapsBean {

    private Map<String, String> maps;
}
