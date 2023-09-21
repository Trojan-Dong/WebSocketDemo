package com.trojan.service;

import com.trojan.entity.User;
import com.trojan.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService implements UserMapper {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int insertSelective(User user) {
        return 0;
    }

	@Override
	public List<HashMap<String, Object>> listAllUser() {
		return userMapper.listAllUser();
	}

    @Override
    public User findById(int id) {
        User user = userMapper.findById(id);
        return user;

    }

    @Override
    public User findByLoginName(String loginName) {
        User user = userMapper.findByLoginName(loginName);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userMapper.findByEmail(email);
        return user;
    }


}
