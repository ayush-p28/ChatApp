package com.securityy.securityy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.securityy.securityy.dao.UserRepo;
import com.securityy.securityy.models.User;

public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepo userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //fetching data from databse
        User user = userRep.getUserByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("could not found User");
        }


    return new CustomUserDetails(user);
    }

}
