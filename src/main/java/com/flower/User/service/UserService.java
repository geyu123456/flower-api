package com.flower.User.service;


import com.flower.User.model.User;
import com.flower.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public  User findUser(){
        return userMapper.findByAccount();
    }

}
