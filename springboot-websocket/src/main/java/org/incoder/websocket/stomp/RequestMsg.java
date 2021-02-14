package org.incoder.websocket.stomp;

/**
 * @author : Jerry xu
 * @date : 2020/7/15  00:57
 */
public class RequestMsg<T> {

    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}