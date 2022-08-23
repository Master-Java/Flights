//package ru.example.backend.ticket.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${application.auth.basic.login}")
//    private String login;
//
//    @Value("${application.auth.basic.password}")
//    private String password;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser(login)
//                .password("{noop}" + password)
//                .roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").hasRole("USER")
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
//    }
//}