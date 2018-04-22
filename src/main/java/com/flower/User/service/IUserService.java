package com.flower.User.service;

import com.flower.User.model.User;
import com.flower.allFlowers.model.ResponseResult;

public interface IUserService {
    User findUser(String account);
    ResponseResult login(String account,String password);
}
