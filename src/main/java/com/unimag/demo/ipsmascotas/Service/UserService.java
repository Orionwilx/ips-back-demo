package com.unimag.demo.ipsmascotas.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimag.demo.ipsmascotas.Model.User;
import com.unimag.demo.ipsmascotas.Repository.UserRespository;

@Service
public class UserService {
    
    @Autowired
    private UserRespository userRespository;

    public User createUser(User user){
        return userRespository.save(user);
    }

    public Optional<User> findByEmail(String Email){
        return userRespository.findByEmail(Email);
    }
}
