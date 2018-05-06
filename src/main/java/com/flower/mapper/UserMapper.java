package com.flower.mapper;

import com.flower.User.model.User;
import com.flower.common.mongodb.MyRepository;

import java.util.List;

public interface UserMapper extends MyRepository<User,String> {
    User findByAccount(String account);
    List<User> findAllBy() ;
}
