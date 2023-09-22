package com.trojan.repository.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.trojan.repository.entity.Message;
import com.trojan.repository.mapper.MessageMapper;
import com.trojan.repository.service.MessageMapperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * 消息 服务实现类
 * </p>
 * @author DGJ
 * @since 2023-09-22
 */
@Service
public class MessageMapperServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageMapperService {
    
    /**
     * 新增消息
     * @param message
     */
    @Override
    public void addMessage(Message message) {
        this.save(message);
    }
    
    /**
     * 更新消息状态为已读
     * @param message
     */
    @Override
    public void updateMessageStatus(Message message) {
        this.update(Wrappers.lambdaUpdate(Message.class)
                .set(Message::getHasRead, 1)
                .eq(Message::getSenderId, message.getSenderId())
                .eq(Message::getReceiverId, message.getReceiverId()));
    }
    
    /**
     * 获取历史消息
     * @param message
     * @return
     */
    @Override
    public List<Message> getHistoryMessage(Message message) {
        return this.list(Wrappers.lambdaQuery(Message.class)
                .eq(Message::getSenderId, message.getSenderId())
                .eq(Message::getReceiverId, message.getReceiverId())
                .or(x -> x.eq(Message::getSenderId, message.getReceiverId())
                        .eq(Message::getReceiverId, message.getSenderId())));
    }
}
