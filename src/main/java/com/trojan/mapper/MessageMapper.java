package com.trojan.mapper;

import com.trojan.entity.Message;

import java.util.List;

public interface MessageMapper {
    int insert(Message record);

    int addMessage(Message record);

    void updateMessageStatus(int senderId, int receiverId);

    List<Message> getHistoryMessage(int senderId, int receiverId);
}
