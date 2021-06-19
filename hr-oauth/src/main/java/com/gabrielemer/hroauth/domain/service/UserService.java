package com.gabrielemer.hroauth.domain.service;

import com.gabrielemer.hroauth.domain.model.User;
import com.gabrielemer.hroauth.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserFeignClient userFeignClient;

  public User findByEmail(String email){
    User user = userFeignClient.findByEmail(email).getBody();
    if (user == null) {
      throw new IllegalArgumentException("Email not found");
    }
    return user;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userFeignClient.findByEmail(username).getBody();
    if (user == null) {
      throw new UsernameNotFoundException("Email not found");
    }
    return user;
  }
}
