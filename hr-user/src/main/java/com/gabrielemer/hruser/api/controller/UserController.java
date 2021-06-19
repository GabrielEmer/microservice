package com.gabrielemer.hruser.api.controller;

import com.gabrielemer.hruser.domain.Repository.UserRepository;
import com.gabrielemer.hruser.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @GetMapping(value = "{userId}")
  public ResponseEntity<User> findById(@PathVariable Long userId){
    Optional<User> user = userRepository.findById(userId);
    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email){
    Optional<User> user = userRepository.findByEmail(email);
    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
