package com.amadeus.amadeus.Services;

import com.amadeus.amadeus.Models.User;
import com.amadeus.amadeus.Repository.UserRepository;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
        public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
            User user = userRepository.findByUsername(username).orElse(null);
            if(user==null){
                throw new UsernameNotFoundException("User not exists by Username");
            }
               
            Set<GrantedAuthority> authorities = user.getRoles().stream()
                    .map((role) -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toSet());
            return new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorities);
        }
}

