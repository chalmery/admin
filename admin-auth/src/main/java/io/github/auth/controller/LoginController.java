package io.github.auth.controller;


import io.github.auth.param.LoginParam;
import io.github.auth.result.LoginDTO;
import io.github.auth.service.LoginService;
import io.github.result.SimpleResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Resource
    private LoginService loginService;


    @GetMapping("/login")
    public SimpleResult<LoginDTO> login(LoginParam loginParam) {
        LoginDTO login = loginService.login(loginParam);
        return SimpleResult.buildSuccess(login);
    }

}
