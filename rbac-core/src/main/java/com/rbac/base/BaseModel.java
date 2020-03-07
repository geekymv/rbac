package com.rbac.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseModel implements Serializable {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("是否启用：1启用，0禁用，默认是1")
    @TableField("enable")
    private Integer enable;

    @ApiModelProperty("是否删除：1已删除，0正常（未删除），默认是0")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("创建时间")
    @TableField("create_at")
    private Date createAt;

    @ApiModelProperty("更新时间")
    @TableField("update_at")
    private Date updateAt;

    @ApiModelProperty("创建人ID")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty("更新人ID")
    @TableField("update_by")
    private Long updateBy;

}
