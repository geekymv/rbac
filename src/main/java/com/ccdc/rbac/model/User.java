package com.ccdc.rbac.model;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ccdc.rbac.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


@Data
@ToString(callSuper=true)
@TableName("user")
@ApiModel
public class User extends BaseModel {

    @ApiModelProperty(value = "帐号")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String username;

}
