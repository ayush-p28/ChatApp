package com.securityy.securityy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableMethodSecurity  bydefault true... for @PreAuthorization
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){

        // did not work for databse
        // UserDetails normUser = User.withUsername("ayu").password(passwordEncoder().encode("ayu")).roles("NORMAL").build();
        // UserDetails adminUser = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
    
        // return new InMemoryUserDetailsManager(normUser,adminUser);

        return new CustomUserDetailService();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthPro = new DaoAuthenticationProvider();
        daoAuthPro.setUserDetailsService(this.userDetailsService());
        daoAuthPro.setPasswordEncoder(passwordEncoder());
    return daoAuthPro;
    }

    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeHttpRequests()
        .requestMatchers("/home/admin").hasRole("ADMIN")
        .requestMatchers("/home/normal").hasRole("NORMAL")
        .requestMatchers("/home/public").permitAll()
        .anyRequest().authenticated()
        .and().formLogin();

        return http.build();
    }
}
