package com.flower.common.config.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private  MyAuthenticationFailHandler accessDeniedHandler;
    @Autowired
    private  MyAuthenticationSuccessHandler authenticationSuccessHandler;


    @Override
    protected  void configure(HttpSecurity http) throws  Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/admin").permitAll()
                .antMatchers("/css/**", "/js/**", "/fonts/**").permitAll()
                .antMatchers("/total/**").access("hasRole('admin')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //定义登录页面
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/total/list")
                .and()
                .logout()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("123456").roles("admin");
    }


  @Autowired
  private UserDetailsService userDetailsService;

    @Autowired
    public  void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
