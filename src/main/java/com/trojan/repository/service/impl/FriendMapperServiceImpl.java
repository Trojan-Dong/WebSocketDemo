package com.trojan.repository.service.impl;

import com.trojan.repository.entity.Friend;
import com.trojan.repository.mapper.FriendMapper;
import com.trojan.repository.service.FriendMapperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 好友关系 服务实现类
 * </p>
 *
 * @author DGJ
 * @since 2023-09-22
 */
@Service
public class FriendMapperServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendMapperService {

}
