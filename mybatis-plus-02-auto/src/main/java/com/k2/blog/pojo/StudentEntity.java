package com.k2.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaokoen
 * @since 2022-11-30
 */
@Getter
@Setter
@TableName("student")
@ApiModel(value = "StudentEntity对象", description = "")
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("name")
    private String name;

    @TableField("claz_id")
    private String clazId;

    @TableField("dayread")
    private Boolean dayread;

    @TableField("cleader")
    private Boolean cleader;
}
