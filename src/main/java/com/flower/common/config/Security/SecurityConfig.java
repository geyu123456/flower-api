package com.flower.common.config.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected  void configure(HttpSecurity http) throws  Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/admin","/total").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/admin/login")
                .permitAll()
                .and()
                .logout()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN");
    }



}
