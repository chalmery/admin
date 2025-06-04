package io.github.user;

import io.github.common.result.SimpleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录相关
 */
@RestController
@RequestMapping("/api/userSso")
@Slf4j
public class UserSsoController {


    @PostMapping("/refresh-token")
    public SimpleResult<?> refreshToken() {


    }
}
