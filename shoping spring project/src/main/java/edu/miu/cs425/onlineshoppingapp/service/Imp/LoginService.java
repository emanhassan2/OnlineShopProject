package edu.miu.cs425.onlineshoppingapp.service.Imp;

import edu.miu.cs425.onlineshoppingapp.model.LoginRequest;
import edu.miu.cs425.onlineshoppingapp.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtHelper jwtHelper;

    public String login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //TODO
        String jwt = jwtHelper.generateToken(loginRequest.getUsername());
        return jwt;
    }
}
