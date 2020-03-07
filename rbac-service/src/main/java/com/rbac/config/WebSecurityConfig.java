package com.rbac.config;

import com.rbac.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private UserService userService;

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("*").permitAll();
//                .antMatchers("/css/**", "/dist/**", "js/**").permitAll()
//                .antMatchers("/user/**").permitAll()
//                .anyRequest().authenticated() // 需要验证
//                .and()
//                .formLogin()
//                .loginPage("/user/index") // 登录页面
//                .defaultSuccessUrl("/") // 默认登录成功后跳转页面
//                .and()
//                .sessionManagement()
//                .maximumSessions(1) // 系统中同一个帐号登录次数
//                .sessionRegistry(sessionRegistry)
//                .and().and()
//                .logout()
//                .invalidateHttpSession(true) // 使session失效
//                .clearAuthentication(true) // 清除所有的认证信息
//                .permitAll()
//                ;
    }
}
