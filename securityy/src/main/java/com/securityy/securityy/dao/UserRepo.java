package com.securityy.securityy.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.securityy.securityy.models.User;


public interface UserRepo extends CrudRepository<User,Integer>{
    public User findByEmailAndPassword(String email,String password);

    @Query("select u from user where u.email = :email")
    public User getUserByUserName(@Param("email") String email);
}
