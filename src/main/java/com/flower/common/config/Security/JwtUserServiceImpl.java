package com.flower.common.config.Security;

import com.flower.User.model.User;
import com.flower.User.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserServiceImpl implements UserDetailsService {
    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User user=userService.findUser(account);
        if(user==null){
            throw new UsernameNotFoundException(String.format("没有该用户 '%s'.", account));
        }
        return JwtUserFactory.create(user);
    }
}
