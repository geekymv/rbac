package com.ccdc.rbac.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("是否启用：1启用，0禁用，默认是1")
    private Integer enable;

    @ApiModelProperty("是否删除：1已删除，0正常（未删除），默认是0")
    private Integer isDelete;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("创建人ID")
    private String createBy;

    @ApiModelProperty("更新人ID")
    private String updateBy;
}
