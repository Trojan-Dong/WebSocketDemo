package com.trojan.repository.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.trojan.repository.entity.User;
import com.trojan.repository.mapper.UserMapper;
import com.trojan.repository.service.UserMapperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 * @author DGJ
 * @since 2023-09-22
 */
@Service
public class UserMapperServiceImpl extends ServiceImpl<UserMapper, User> implements UserMapperService {
    
    @Override
    public List<User> listAllUser() {
        return this.list();
    }
    
    @Override
    public User findById(Long id) {
        return this.getById(id);
    }
    
    @Override
    public User findByLoginName(String loginName) {
        return this.getOne(Wrappers.lambdaQuery(User.class).eq(User::getLoginName, loginName));
    }
    
    @Override
    public User findByEmail(String email) {
        return this.getOne(Wrappers.lambdaQuery(User.class).eq(User::getLoginName, email));
    }
    
    @Override
    public void addUser(User user) {
        this.save(user);
    }
}
