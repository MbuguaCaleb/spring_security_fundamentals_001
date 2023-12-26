package com.example.spring_security_fundamentals_001.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

    //Provides the UserDetails to Spring Security
    //We can build this service to fetch our DB users for authorization
    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager();

        //Creating My User
        UserDetails userOne = User.withUsername("Caleb").password("12345").authorities("read").build();

        //Storing myUser
        userDetails.createUser(userOne);

        return userDetails;
    }


    //Remember springboot works with base64 encoded passwords
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
