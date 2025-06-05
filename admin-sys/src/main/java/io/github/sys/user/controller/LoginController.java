package io.github.sys.user.controller;


import io.github.result.SimpleResult;
import io.github.sys.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Resource
    private UserService userService;


    @GetMapping("/login")
    public SimpleResult<Boolean> getUserByUuid() {
        return SimpleResult.buildSuccess(Boolean.TRUE);
    }

}
