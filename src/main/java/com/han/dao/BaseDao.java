package com.han.dao;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDao<T> extends CrudRepository<T,Long>, JpaSpecificationExecutor<T> {
}
