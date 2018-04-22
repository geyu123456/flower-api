package com.flower.common.config.Security;

import com.flower.User.model.User;
import org.apache.catalina.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {
    private JwtUserFactory(){

    }
     static  JwtUser create(User user){
        return  new JwtUser(user.getId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles()));


     }
    //将与用户类多对多的角色类的名称集合转换为 GrantedAuthority 集合
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
