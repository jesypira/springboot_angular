package com.pira.springboot_angular.service;

import com.pira.springboot_angular.exception.UserException;
import com.pira.springboot_angular.model.entity.ApiUser;
import com.pira.springboot_angular.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public ApiUser save(ApiUser user) {
        boolean exists = userRepository.existsByUsername(user.getUsername());
        if(exists){
            throw new UserException(user.getUsername());
        }
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiUser user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login not found.") );

        return User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
