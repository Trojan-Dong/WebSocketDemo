package com.trojan.controller;/**
 * @Description
 * @Author dgj
 * @Date 2020/8/19
 * @Version 1.0
 */

import com.trojan.service.MessageService;
import com.trojan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @ClassName MainService
 * @Description TODO
 * @Author dgj
 * @Date 2020/8/19
 * @Version 1.0
 */
public abstract class MainService {
    public Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    public UserService userService = new UserService();
    @Resource
    public MessageService messageService = new MessageService();
}
