package org.incoder.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用 @ConfigurationProperties 配置属性必须是小写，多单词之间可用'-'连接
 *
 * @author : Jerry xu
 * @since : 2020/3/29  16:26
 */
@Data
@Component
@ConfigurationProperties(prefix = "list")
public class ConfigListBean {

    /**
     * 这里不能再用 @Value("") 去加载，修饰当前的字段，
     * 必须指定其属性名和配置文件中定义的名称一致
     */
    private List<String> language;

}
