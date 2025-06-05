package io.github.sys.user.controller;


import io.github.result.SimpleResult;
import io.github.sys.user.result.UserDTO;
import io.github.sys.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/getUserByUuid")
    public SimpleResult<UserDTO> getUserByUuid(String uuid) {
        return SimpleResult.buildSuccess(userService.getUserByUuid(uuid));
    }

}
