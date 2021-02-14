package org.incoder.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 使用 {@link org.springframework.boot.context.properties.ConfigurationProperties}配置
 * 属性必须是小写，单词之间用'-'连接
 *
 * @author : Jerry xu
 * @since : 2020/3/29  16:26
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "map-objects")
public class MavenMapsBean {

    private Map<String, String> maps;
}
