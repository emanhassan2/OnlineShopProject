package edu.miu.cs425.onlineshoppingapp.controller;

import edu.miu.cs425.onlineshoppingapp.model.LoginRequest;
import edu.miu.cs425.onlineshoppingapp.service.Imp.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = {"/login"})
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("")
    public String login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

}
