package com.rbac.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.rbac.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Dept", description = "部门")
public class Dept extends BaseModel {

    @TableField("app_id")
    @ApiModelProperty(value = "所属应用id")
    private String appId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;
}
