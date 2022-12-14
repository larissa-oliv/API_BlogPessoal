package com.blogPessoal.blogPessoalLarissa.security;


import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService) ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/usuarios/logar").permitAll()
            .antMatchers("/usuarios/cadastrar").permitAll()
            .anyRequest().authenticated()
            .and().httpBasic()
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().cors()
            .and().csrf().disable();
    }

}
