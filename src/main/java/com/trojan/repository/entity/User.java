package com.trojan.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息
 * </p>
 * @author DGJ
 * @since 2023-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {
    
    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    @TableField("loginName")
    private String loginName;
    
    @TableField("nickName")
    private String nickName;
    
    //真实名称
    @TableField("realName")
    private String realName;
    
    //密码
    @TableField("password")
    private String password;
    
    //手机号
    @TableField("phone")
    private String phone;
    
    //邮箱地址
    @TableField("email")
    private String email;
    
    //账户状态
    @TableField("status")
    private String status;
    
    //注册ip
    @TableField("regIp")
    private String regIp;
    
    //重试次数
    @TableField("tryTimes")
    private Integer tryTimes;
    
    //身份证号
    @TableField("idCardNo")
    private String idCardNo;
    
    //创建时间
    private LocalDateTime createTime;
    
    //更新时间
    private LocalDateTime updateTime;
    
    
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    
}
