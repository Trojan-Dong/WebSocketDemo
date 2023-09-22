package com.trojan.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trojan.repository.entity.User;

import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 * @author DGJ
 * @since 2023-09-22
 */
public interface UserMapperService extends IService<User> {
    
    List<User> listAllUser();
    
    User findById(Long id);
    
    User findByLoginName(String loginName);
    
    User findByEmail(String email);
    
    void addUser(User user);
}
