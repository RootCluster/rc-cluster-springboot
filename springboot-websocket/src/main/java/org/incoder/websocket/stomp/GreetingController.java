package org.incoder.websocket.stomp;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : Jerry xu
 * @date : 2020/7/14  22:56
 */
@Controller
public class GreetingController {

    @Resource
    private SimpMessagingTemplate template;

    @MessageMapping("/greeting")
    public String handler(String greeting) {
        return "[" + LocalDateTime.now().toString() + "]:" + greeting;
    }

    /**
     * 发送消息
     *
     * @param greeting greeting
     */
    @PostMapping("/greetings")
    public void greet(String greeting) {
        String text = "[" + LocalDateTime.now().toString() + "]:" + greeting;
        template.convertAndSend("/topic/greetings", text);
    }

    /**
     * 定时推送消息
     */
    @Scheduled(fixedRate = 1000)
    public void callback() {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        template.convertAndSend("/topic/callback", "定时推送消息时间: " + df.format(new Date()));
    }

    /**
     * 广播模式
     *
     * @param requestMsg requestMsg
     * @return String
     */
    @MessageMapping("/broadcast")
    @SendTo("/topic/broadcast")
    public String broadcast(RequestMsg requestMsg) {
        //这里是有return，如果不写@SendTo默认和/topic/broadcast一样
        return "server:" + requestMsg.getBody().toString();
    }

    /**
     * 订阅模式，只是在订阅的时候触发，可以理解为：访问——>返回数据
     *
     * @param id id
     * @return String
     */
    @SubscribeMapping("/subscribe/{id}")
    public String subscribe(@DestinationVariable Long id) {
        return "success";
    }

    /**
     * 用户模式
     *
     * @param requestMsg requestMsg
     * @param principal  principal
     */
    @MessageMapping("/one")
    //@SendToUser("/queue/one") 如果存在return,可以使用这种方式
    public void one(RequestMsg requestMsg, Principal principal) {
        //这里使用的是spring的security的认证体系，所以直接使用Principal获取用户信息即可。
        //注意为什么使用queue，主要目的是为了区分广播和队列的方式。实际采用topic，也没有关系。但是为了好理解
        template.convertAndSendToUser(principal.getName(), "/queue/one", requestMsg.getBody());
    }
}
