package com.example.footballmanager.config;

import com.example.footballmanager.entity.enumUser.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/user/registration/**").permitAll()
                .antMatchers("/user/registration/admin").hasAuthority(Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/player/save").hasAuthority(Role.ADMIN.name())
//                .antMatchers(HttpMethod.PUT, "/player/update/**").hasAuthority(Role.ADMIN.name())
//                .antMatchers(HttpMethod.POST, "/team/create/").hasAuthority(Role.ADMIN.name())
//                .antMatchers(HttpMethod.POST, "/coach/saveCoach/").hasAuthority(Role.ADMIN.name())
//                .antMatchers(HttpMethod.DELETE, "/").hasAuthority(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .logout().permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
