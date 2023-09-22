package com.trojan.controller;

import com.trojan.repository.entity.Message;
import com.trojan.repository.entity.User;
import com.trojan.repository.service.MessageMapperService;
import com.trojan.repository.service.UserMapperService;
import com.trojan.socket.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author dgj
 * @Date 2020/8/4
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {
    
    @Resource
    private MessageMapperService messageMapperService;
    
    @Resource
    private UserMapperService userMapperService;
    
    public static WebSocket webSocket = new WebSocket();
    
    @GetMapping("/sendAllWebSocket")
    @ResponseBody
    public String test() {
        System.out.println("1");
        String text = "你们好！这是websocket群体发送！";
        webSocket.sendAllMessage(text);
        return text;
    }
    
    @GetMapping("/sendOneWebSocket/{userName}")
    @ResponseBody
    public String sendOneWebSocket(@PathVariable("userName") String userName) {
        String text = userName + " 你好！ 这是websocket单人发送！" + System.currentTimeMillis();
        webSocket.sendOneMessage(userName, text);
        return text;
    }
    
    /**
     * 发送消息
     * @param message
     */
    @RequestMapping("/sendMessage")
    @ResponseBody
    public void sendMessage(@RequestBody Message message) {
        User receiver = userMapperService.findById(message.getReceiverId());
        User sender = userMapperService.findById(message.getSenderId());
        String text = receiver.getLoginName() + ":" + message.getText();
        webSocket.sendOneMessage(receiver.getLoginName(), text);
        messageMapperService.addMessage(message);
    }
    
    /**
     * 更新消息状态为已读
     * @param message
     */
    @RequestMapping("/updateMessageStatus")
    @ResponseBody
    public void updateMessageStatus(@RequestBody Message message) {
        
        messageMapperService.updateMessageStatus(message);
    }
    
    /**
     * 获取历史消息
     * @param message
     * @return
     */
    @RequestMapping("/getHistoryMessage")
    @ResponseBody
    public List<Message> getHistoryMessage(@RequestBody Message message) {
        
        List<Message> messageList = messageMapperService.getHistoryMessage(message);
        return messageList;
    }
    
}
