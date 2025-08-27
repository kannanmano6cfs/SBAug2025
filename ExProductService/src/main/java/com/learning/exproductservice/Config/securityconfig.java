package com.learning.exproductservice.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityconfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth)->auth
                .requestMatchers("/new/*").hasRole("ADMIN")
                .requestMatchers("/products").hasAnyRole("ADMIN","MEMBER")
                .requestMatchers("/product/*").hasAnyRole("ADMIN","MEMBER","USER")
                .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    //Used for User creation in InMemory Database
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user= User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
        UserDetails admin=User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build();
        UserDetails member=User.withDefaultPasswordEncoder().username("member").password("member").roles("MEMBER").build();

        return new InMemoryUserDetailsManager(user,admin,member);
    }
}
