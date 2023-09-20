package com.security.springSecurity.configSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http     .csrf().disable()
                .authorizeRequests()
               // .antMatchers("/home","/login","/register").permitAll()
              //  .antMatchers(HttpMethod.GET,"/public/**").permitAll()
                .antMatchers(HttpMethod.GET,"/public/**").hasRole("Normal")
                .antMatchers("/user/**").hasRole("Admin")
                .anyRequest()
                .authenticated()
                .and()
                //.formLogin();
                .httpBasic();

    }
   //ROLE-High Level Overview->NORMAL :Read
    //Authority - permission->read/
    //ADMIN -Read, Write, Update
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser( "durgesh").password(this.passwordEncoder().encode("bluethink@12")).roles("Normal");
        auth.inMemoryAuthentication().withUser("kumar").password(this.passwordEncoder().encode("bluethink")).roles("Admin");
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        //return NoOpPasswordEncoder.getInstance();
        return new  BCryptPasswordEncoder(10);
    }
}
