//package com.travelagency.tirana.service;
//
//import java.util.ArrayList;
//
//import com.travelagency.tirana.repository.UserRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    public JwtUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        //your custom model
//        com.travelagency.tirana.model.User user = userRepository.findByEmail(email);
//
//        if (user !=null) {
//            // returns interface model
//            return new User(user.getEmail(), user.getPassword(),
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
//    }
//}
