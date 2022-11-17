package com.moviedbcrud.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =new User("symoon","1234",new ArrayList<>());
        return  user;


//       UserEntity userDetails = userRepository.findByUserName(username);
//
//         if(userDetails != null){
//
//            return  new User(userDetails.getEmail(),userDetails.getPassword(),new ArrayList<>());
//        }
//        else {
//            throw  new UsernameNotFoundException("User Not Exists with the name"+username);
//        }

    }
}
