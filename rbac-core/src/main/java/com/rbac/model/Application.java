package com.rbac.model;

import com.rbac.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 应用
 * </p>
 *
 * @author geekymv
 * @since 2018-05-31
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Application", description = "应用")
public class Application extends BaseModel {

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "应用密钥")
    private String appSecret;
}
