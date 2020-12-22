package org.incoder.websocket.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * 处理服务端的发送的消息
 *
 * @author : Jerry xu
 * @date : 2020/7/14  12:57
 */
@Slf4j
public class CustomerHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("收到消息，内容为:{}", message.getPayload());
    }
}