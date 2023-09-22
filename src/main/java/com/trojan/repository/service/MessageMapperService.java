package com.trojan.repository.service;

import com.trojan.repository.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 消息 服务类
 * </p>
 * @author DGJ
 * @since 2023-09-22
 */
public interface MessageMapperService extends IService<Message> {
    
    void addMessage(Message message);
    
    void updateMessageStatus(Message message);
    
    List<Message> getHistoryMessage(Message message);
}
