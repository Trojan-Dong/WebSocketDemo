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
 * 好友关系
 * </p>
 *
 * @author DGJ
 * @since 2023-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("friend")
public class Friend extends Model<Friend> {

    private static final long serialVersionUID=1L;

    //主键id
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //用户id
    private Long userId;

    //好友id
    private Long friendId;

    //备注
    private String remarkName;

    //所属分组
    private Long groupId;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
