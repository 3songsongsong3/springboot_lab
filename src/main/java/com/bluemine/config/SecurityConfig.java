package com.bluemine.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.MXBean;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/member").hasRole("USER");

        http.formLogin();
        http.csrf().disable();
        http.logout();
    }

    /*
    MemberDetailsService에서 UserDetailsService를 상속 받아 Bean으로 등록되어,
    AuthenticationManagerBuilder를 사용할 필요가 없게 됨
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 계정은 user1
        auth.inMemoryAuthentication().withUser("user1")
                //1111 패스워드 인코딩 결과
                .password("$2a$10$ahNwVDc1gQib24ph2cBd3uC9v0OGHXOiCPwTPftNpJ90khCSoPCZC")
                .roles("USER");
    }*/
}
