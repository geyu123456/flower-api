package com.flower.mapper;

import com.flower.User.model.User;
import com.flower.common.mongodb.MyRepository;

public interface UserMapper extends MyRepository<User,Long> {
    User findByAccount(String account);
}
