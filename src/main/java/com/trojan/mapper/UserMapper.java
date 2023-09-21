package com.trojan.mapper;

import com.trojan.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    int addUser(User user);

    int insertSelective(User user);

    List<HashMap<String,Object>> listAllUser();

    User findById(int id);

    User findByLoginName(String loginName);

    User findByEmail(String email);

}
