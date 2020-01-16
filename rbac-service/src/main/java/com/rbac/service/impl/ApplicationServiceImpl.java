package com.rbac.service.impl;

import com.rbac.base.BaseService;
import com.rbac.model.Application;
import com.rbac.repository.ApplicationMapper;
import com.rbac.service.ApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 应用 服务实现类
 * </p>
 *
 * @author geekymv
 * @since 2018-05-31
 */
@Service
public class ApplicationServiceImpl extends BaseService<ApplicationMapper, Application> implements ApplicationService {

    @Transactional
    @Override
    public Application createApplication(Application application) {
        super.save(application);
        return application;
    }
}
