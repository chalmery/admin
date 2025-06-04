package io.github.sys.user.service.impl;

import io.github.sys.user.param.LoginParam;
import io.github.sys.user.result.TokenDTO;
import io.github.sys.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LoginServiceImpl implements LoginService {


    @Override
    public TokenDTO getToken(LoginParam loginParam) {

        // 验证用户名密码逻辑...


        //使用用户唯一标识生成 访问令牌和刷新令牌
        String userUuid = "userUuid";

        String accessToken = null;
        String refreshToken = null;


        return new TokenDTO(accessToken, refreshToken);
    }
}
