package com.trojan.socket;

import com.alibaba.fastjson.JSONObject;
import com.trojan.repository.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
@Component
@ServerEndpoint("/websocket/{userName}")
//此注解相当于设置访问URL
public class WebSocket {
    
    private Session session;
    
    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
    
    private static Map<String, Session> sessionPool = new HashMap<>();
    
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userName") String userName) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(userName, session);
        log.info(userName + "【websocket消息】有新的连接，总数为:" + webSockets.size());
    }
    
    @OnClose
    public void onClose() {
        webSockets.remove(this);
        log.info("【websocket消息】连接断开，总数为:" + webSockets.size());
    }
    
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端消息:" + message);
    }
    
    // 此为广播消息
    public void sendAllMessage(String message) {
        for (WebSocket webSocket : webSockets) {
            log.info("【websocket消息】广播消息:" + message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /* *
     * @desc  单点消息发送
     * @param [id, userName, message]
     * @return void
     */
    public void sendOneMessage(String id, String userName, String message) {
        log.info("【websocket消息】单点消息:" + id + userName + message);
        log.info("sessionPool:" + sessionPool);
        Session session = sessionPool.get(userName);
        JSONObject info = new JSONObject();
        info.put(id, message);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // 此为单点消息
    public void sendOneMessage(String userName, String message) {
        log.info("【websocket消息】单点消息:" + message);
        log.info("sessionPool:" + sessionPool);
        Session session = sessionPool.get(userName);
        JSONObject info = new JSONObject();
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void sendOneMessage(String name, Message msg) {
        log.info("sendOneMessage run ");
        Session session = sessionPool.get(name);
        JSONObject info = new JSONObject();
        info.put(msg.getSenderId().toString(), msg);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(info.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
