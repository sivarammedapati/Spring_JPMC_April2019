package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfig  extends WebSecurityConfigurerAdapter {

    //Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("abc").password("{noop}abc").authorities("User")
                .and()
                .withUser("xyz").password("{noop}xyz").authorities("User", "Manager");
    }

    //Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/home/**").permitAll()
                    .antMatchers("/accounts/**").authenticated()
                    .antMatchers("/products/**").hasAuthority("Manager")
                    .and()
                    .formLogin();

    }
}
