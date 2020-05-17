package com.kusak.dariusz.simplejwtauthorizationproject.controller;

import com.kusak.dariusz.simplejwtauthorizationproject.entity.User;
import com.kusak.dariusz.simplejwtauthorizationproject.repository.UserRepository;
import com.kusak.dariusz.simplejwtauthorizationproject.security.AccountCredentialsVO;
import com.kusak.dariusz.simplejwtauthorizationproject.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @PostMapping("/signing")
    public ResponseEntity authenticate(@RequestBody AccountCredentialsVO data) {
        try {
            String userName = data.getUsername();
            String passwod = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, passwod));

            User user = userRepository.findByUserName(userName)
                    .orElseThrow( () ->  new UsernameNotFoundException(userName));

           String token = jwtTokenProvider.createToken(userName, user.getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", userName);
            model.put("token", token);

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
