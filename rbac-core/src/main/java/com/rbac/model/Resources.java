package com.rbac.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.rbac.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 资源（菜单）表
 * </p>
 *
 * @author geekymv
 * @since 2018-05-31
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Resources", description = "资源（菜单）")
public class Resources extends BaseModel {

    @ApiModelProperty(value = "父菜单id")
    private Long pid;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源路径")
    private String url;

    @ApiModelProperty(value = "权限")
    private String perms;

    @ApiModelProperty(value = "图标")
    private String icon;

    @TableField("app_id")
    @ApiModelProperty(value = "所属应用id")
    private String appId;


}
