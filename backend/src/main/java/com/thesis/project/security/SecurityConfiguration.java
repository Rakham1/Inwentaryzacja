package com.thesis.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@ComponentScan
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private MySuccessHandler mySuccessHandler;

    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .formLogin()
                    .loginProcessingUrl("/login")
                    .failureUrl("/login")
                    .successHandler(mySuccessHandler)
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .logout();
    }

}
