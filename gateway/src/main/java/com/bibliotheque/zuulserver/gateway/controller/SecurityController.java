package com.bibliotheque.zuulserver.gateway.controller;

import com.bibliotheque.zuulserver.gateway.jwt.JwtProvider;
import com.bibliotheque.zuulserver.gateway.jwt.JwtResponse;
import com.bibliotheque.zuulserver.gateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value="/login")
    public JwtResponse login (@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities());
    }


//    @RequestMapping(value = "/api/security/addUser", method = RequestMethod.POST)
//    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
//        User user = userService.createUser(userDTO);
//        if(user == null) return ResponseEntity.noContent().build();
//        return new ResponseEntity<>(user, HttpStatus.CREATED) ;
//    }
}
