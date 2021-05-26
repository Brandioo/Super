package com.travelagency.tirana.service;

import java.util.ArrayList;


import com.travelagency.tirana.model.User;
import com.travelagency.tirana.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if (user !=null) {
            return new User(user.getEmail(), user.getPassword());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
