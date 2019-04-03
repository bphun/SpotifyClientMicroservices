package com.bphan.authenticationservice;

import java.util.Map;
import java.util.UUID;

import com.bphan.authenticationservice.Security.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationServiceController {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String requestMethodName(@RequestBody Map<String, Object> requestBody) {     
        AppUser u = new AppUser(UUID.randomUUID().toString(), requestBody.get("username").toString(), requestBody.get("password").toString());

        userRepository.save(u);
        userRepository.addUserWithCredentialsIfNotExist(u.getId(), u.getUsername(), u.getPassword());
       
        return "hello";
    }   
    



}