package com.flower.common.mongodb;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by geyu on 18-1-11.
 */
@NoRepositoryBean
public interface MyRepository<T,ID extends Serializable> extends Repository<T,ID> {

}
