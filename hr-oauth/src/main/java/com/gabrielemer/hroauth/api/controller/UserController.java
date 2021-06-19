package com.gabrielemer.hroauth.api.controller;

import com.gabrielemer.hroauth.domain.model.User;
import com.gabrielemer.hroauth.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email){
    try {
      User user = service.findByEmail(email);
      return ResponseEntity.ok(user);
    }catch (IllegalArgumentException exception) {
     return ResponseEntity.notFound().build();
    }
  }
}
