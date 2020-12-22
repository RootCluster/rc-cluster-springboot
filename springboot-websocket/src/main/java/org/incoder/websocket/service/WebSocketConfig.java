package org.incoder.websocket.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author : Jerry xu
 * @date : 2020/7/14  12:52
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final CustomerWsHandler customerWsHandler;

    public WebSocketConfig(CustomerWsHandler customerWsHandler) {
        this.customerWsHandler = customerWsHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                // 配置处理器
                .addHandler(this.customerWsHandler, "/ws")
                // 解决跨域问题
                .setAllowedOrigins("*");
    }
}