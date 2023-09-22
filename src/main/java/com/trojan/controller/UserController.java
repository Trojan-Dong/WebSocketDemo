package com.trojan.controller;

import com.trojan.repository.entity.User;
import com.trojan.repository.service.UserMapperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dgj
 * @describe 用户相关操作
 * @date 2019年9月9日
 */
@Controller
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private UserMapperService userMapperService;
    
    /* *
     * @desc
     * @param []
     * @return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     */
    @RequestMapping("/listAllUser")
    @ResponseBody
    public List<User> listAllUser() {
        return userMapperService.listAllUser();
    }
    
    /**
     * 根据id查找用户
     * @return
     */
    @RequestMapping("/findUserById")
    @ResponseBody
    public User findUserById(Long id) {
        User user = userMapperService.findById(id);
        return user;
    }
    
    /**
     * 添加新用户
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(@RequestBody User user) {
        assert userMapperService.findByEmail(user.getEmail()) == null : "邮箱地址已被注册";
        userMapperService.addUser(user);
    }
    
    /**
     * 用户登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public User login(HttpServletRequest request, @RequestBody Map<String, String> userInfo) {
        String loginName = userInfo.get("loginName");
        String password = userInfo.get("password");
        User user = userMapperService.findByLoginName(loginName);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("用户名和密码不匹配");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        User sessionUser = (User) session.getAttribute("user");
        log.debug(sessionUser.toString());
        log.debug("login end");
        return user;
    }
    
    /**
     * 用户登出
     */
    @RequestMapping("/logout")
    @ResponseBody
    public void logout(HttpServletRequest request, String loginName) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
    }
    
    @RequestMapping("/loginCheck")
    @ResponseBody
    public User loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userInfo = (User) session.getAttribute("user");
        User user = null;
        if (userInfo != null) {
            user = userMapperService.findById(userInfo.getId());
            session.setAttribute("user", user);
            log.debug("用户" + user.getLoginName() + "已登录");
            return user;
        } else {
            return null;
        }
        
        
    }
}
