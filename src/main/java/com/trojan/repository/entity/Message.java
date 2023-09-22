package com.trojan.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消息
 * </p>
 * @author DGJ
 * @since 2023-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("message")
public class Message extends Model<Message> {
    
    private static final long serialVersionUID = 1L;
    
    //主键id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    //登录账号
    private Long receiverId;
    
    //昵称
    private Long senderId;
    
    //密码
    private String text;
    
    //是否已读
    private Integer hasRead;
    
    //是否删除
    private Integer hasDelete;
    
    //创建时间
    private LocalDateTime createTime;
    
    //更新时间
    private LocalDateTime updateTime;
    
    
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    
}
