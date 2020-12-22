package org.incoder.websocket.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Stomp 协议，全称为simple text-oriented messaging protocol，即简单的面向文本的消息传递协议
 * Stomp 协议可以在任何可靠的双向流网络协议（例如TCP和WebSocket）上使用
 * 尽管协议本身是面向文本的，但是消息的主体可以是文本或二进制的
 * <p>
 * Stomp协议是基于帧的消息协议，帧以HTTP为模型，以下是帧的格式
 *
 * @author : Jerry xu
 * @date : 2020/7/14  22:53
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                // 端点名称
                .addEndpoint("/portfolio")
                // 解决跨域问题
                .setAllowedOrigins("*")
                // 使用sockJS
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry
                // 客户端名称前缀
                .setApplicationDestinationPrefixes("/app")
                // 用户名称前
                .setUserDestinationPrefix("/user")
                // 这里注册两个，主要是目的是将广播和队列分开
                .enableSimpleBroker("topic", "queue");
    }
}
