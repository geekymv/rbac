package com.rbac.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rbac.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


@Data
@ToString(callSuper=true)
@ApiModel
@TableName("user")
public class User extends BaseModel {

    @ApiModelProperty(value = "帐号")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String username;

    @JSONField(serialize = false)
    @ApiModelProperty(value = "密码")
    private String password;

}
