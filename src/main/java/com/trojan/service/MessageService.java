package com.trojan.service;/**
 * @Description
 * @Author dgj
 * @Date 2020/8/19
 * @Version 1.0
 */

import com.trojan.entity.Message;
import com.trojan.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MessageService
 * @Description TODO
 * @Author dgj
 * @Date 2020/8/19
 * @Version 1.0
 */
@Service
public class MessageService implements MessageMapper {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public int insert(Message record) {
        return messageMapper.insert(record);
    }

    @Override
    public int addMessage(Message record) {
        return messageMapper.insert(record);
    }

    @Override
    public void updateMessageStatus(int senderId, int receiverId) {
        messageMapper.updateMessageStatus(senderId, receiverId);
    }

    @Override
    public List<Message> getHistoryMessage(int senderId, int receiverId) {
        List<Message> messageList = messageMapper.getHistoryMessage(senderId, receiverId);
        return messageList;
    }


}
