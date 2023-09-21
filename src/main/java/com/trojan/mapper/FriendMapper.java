package com.trojan.mapper;

import com.trojan.entity.Friend;

public interface FriendMapper {
    int insert(Friend record);

    int insertSelective(Friend record);
}