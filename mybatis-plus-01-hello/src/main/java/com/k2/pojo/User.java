package com.k2.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // 对应数据库中的主键（uuid、自增id、雪花算法、redis生成id、zookeeper生成id、MongoDB的ObjectId）
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @Version    // 乐观锁的注解
    private Integer version;
    @TableLogic     // 逻辑删除
    private Integer deleted;
    // 字段自动填充策略
    @TableField(fill = FieldFill.INSERT)    // 插入时更新字段
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和修改时更新字段
    private LocalDateTime updateTime;

}
