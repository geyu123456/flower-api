package com.flower.common.config.Security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser  implements UserDetails {
    private final  String id;
    private  final String account;
    private  final  String password;
    private final Collection<? extends GrantedAuthority> authorities;


    JwtUser(String id, String account, String password, Collection<? extends GrantedAuthority> authorities){
        this.id=id;
        this.account=account;
        this.password=password;
        this.authorities = authorities;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return account;
    }

    /**
     * 账户是否未过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *账户是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
