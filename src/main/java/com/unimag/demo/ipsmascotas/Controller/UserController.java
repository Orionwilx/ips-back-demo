package com.unimag.demo.ipsmascotas.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimag.demo.ipsmascotas.Model.User;
import com.unimag.demo.ipsmascotas.Service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*") // Permitir cualquier origen
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody User user) {
        // Verifica que el campo 'name' esté presente en el objeto 'user'
        if (user.getName() == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "El nombre no puede ser nulo");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        // Verifica que el campo 'email' sea único
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "El email ya está registrado");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        userService.createUser(user);

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Usuario registrado exitosamente");
        response.put("usuario", user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*") // Permitir cualquier origen
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*") // Permitir cualquier origen
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }
}
