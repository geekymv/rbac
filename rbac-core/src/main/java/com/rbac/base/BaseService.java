package com.rbac.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public abstract class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl {


}
