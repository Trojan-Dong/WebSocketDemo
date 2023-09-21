package com.trojan.controller;/**
 * @Description
 * @Author dgj
 * @Date 2020/8/4
 * @Version 1.0
 */

import com.trojan.entity.Message;
import com.trojan.socket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author dgj
 * @Date 2020/8/4
 * @Version 1.0
 */
@Controller
public class MessageController extends MainService {

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

    @RequestMapping("/sendMessage")
    @ResponseBody
    public void sendMessage(@RequestBody Map<String, Object> requsest) {
        System.out.println("request" + requsest);
        Message msg = new Message();
        Map reciver = (Map) requsest.get("reciver");
        Map sender = (Map) requsest.get("sender");
        msg.setSenderId((Integer) sender.get("id"));
        msg.setReceiverId((Integer) reciver.get("id"));
        msg.setSendtime(new Date());
        msg.setIsread(0);
        msg.setIsdelete(0);
        msg.setText((String) requsest.get("message"));
        String text = requsest.get("reciver") + ":" + requsest.get("message");
        webSocket.sendOneMessage(reciver.get("loginName").toString(), msg);
        messageService.addMessage(msg);
    }

    @RequestMapping("/updateMessageStatus")
    @ResponseBody
    public void updateMessageStatus(@RequestBody Map<String, Integer> requsest) {
        logger.debug("updateMessageStatus run" + requsest);
        int senderId = requsest.get("senderId");
        int receiverId = requsest.get("receiverId");
        messageService.updateMessageStatus(senderId, receiverId);
    }

    @RequestMapping("/getHistoryMessage")
    @ResponseBody
    public List<Message> getHistoryMessage(@RequestBody Map<String, Integer> requsest) {
        logger.debug("updateMessageStatus run" + requsest);
        int senderId = requsest.get("senderId");
        int receiverId = requsest.get("receiverId");
        List<Message> messageList = messageService.getHistoryMessage(senderId, receiverId);
        return messageList;
    }

}
