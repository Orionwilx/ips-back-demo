package com.unimag.demo.ipsmascotas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unimag.demo.ipsmascotas.Model.User;
import java.util.Optional;


public interface UserRespository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
} 
