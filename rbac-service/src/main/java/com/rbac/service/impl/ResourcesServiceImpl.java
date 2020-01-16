package com.rbac.service.impl;

import com.rbac.base.BaseService;
import com.rbac.model.Resources;
import com.rbac.repository.ResourcesMapper;
import com.rbac.service.ResourcesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源（菜单）表 服务实现类
 * </p>
 *
 * @author geekymv
 * @since 2018-05-31
 */
@Service
public class ResourcesServiceImpl extends BaseService<ResourcesMapper, Resources> implements ResourcesService {

}
