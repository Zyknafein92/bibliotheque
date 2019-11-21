package com.bibliotheque.zuulserver.gateway.services;

import com.bibliotheque.zuulserver.gateway.model.User;
import com.bibliotheque.zuulserver.gateway.model.UserPrinciple;
import com.bibliotheque.zuulserver.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("wrong username or password");
        }

        return UserPrinciple.build(user);
    }
}