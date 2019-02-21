package com.han.service.impl;

import com.han.dao.BaseDao;
import com.han.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    BaseDao baseDao;

    @Override
    public T findById(Long id) {
        return (T) baseDao.findAll();
    }
}
