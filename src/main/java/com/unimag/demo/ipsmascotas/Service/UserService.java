package com.unimag.demo.ipsmascotas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unimag.demo.ipsmascotas.Model.User;
import com.unimag.demo.ipsmascotas.Repository.UserRespository;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRespository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRespository.findByEmail(email);
    }

    public List<User> getAll() {
        return userRespository.findAll();
    }
}