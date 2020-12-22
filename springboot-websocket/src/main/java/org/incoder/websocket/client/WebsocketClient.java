package org.incoder.websocket.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * WebSocket 客户端
 *
 * @author : Jerry xu
 * @date : 2020/7/14  12:56
 */
@Slf4j
public class WebsocketClient {

    private static WebSocketSession session;

    public boolean isAlive() {
        return session.isOpen();
    }

    public static void main(String[] args) {
        String url = "ws://localhost:8080/ws";
        WebSocketClient client = new StandardWebSocketClient();
        CustomerHandler handler = new CustomerHandler();
        try {
            session = client.doHandshake(handler, url).get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("连接ws服务失败", e);
        }
    }

    public void sendTextMessage(String message) {
        TextMessage textMessage = new TextMessage(message);
        try {
            session.sendMessage(textMessage);
        } catch (IOException e) {
            log.error("发送文本消息失败", e);
        }
    }
}
