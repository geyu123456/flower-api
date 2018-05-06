package com.flower.User.service.impl;


import com.flower.User.model.User;
import com.flower.User.service.IUserService;
import com.flower.allFlowers.model.ResponseResult;
import com.flower.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUser(String account) {
        return userMapper.findByAccount(account);
    }

    @Override
    public ResponseResult login(String account, String password) {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllBy();
    }
}
