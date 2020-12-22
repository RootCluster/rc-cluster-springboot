package org.incoder.websocket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

/**
 * @author : Jerry xu
 * @date : 2020/7/14  12:53
 */
@Slf4j
@Component
public class CustomerWsHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("收到消息，内容为:{}", message.getPayload());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("新建连接, id为:{}", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("关闭链接, id为:{}, 状态为:{}", session.getId(), status.getCode());
    }

    private void sendMsgToEveryone(String message) throws IOException {
//        for (WebSocketSession session : manager.all()) {
//            TextMessage textMessage = new TextMessage(message);
//            session.sendMessage(textMessage);
//        }
    }
}
