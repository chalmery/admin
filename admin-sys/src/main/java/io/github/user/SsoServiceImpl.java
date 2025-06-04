package io.github.user;

import io.github.user.api.SsoService;
import io.github.user.module.LoginParam;
import io.github.user.module.TokenDTO;
import io.github.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SsoServiceImpl implements SsoService {


    @Override
    public TokenDTO getToken(LoginParam loginParam) {

        // 验证用户名密码逻辑...


        //使用用户唯一标识生成 访问令牌和刷新令牌
        String userUuid = "userUuid";

        String accessToken = JwtUtils.generateAccessToken(userUuid);
        String refreshToken = JwtUtils.generateRefreshToken(userUuid);


        return new TokenDTO(accessToken, refreshToken);
    }
}
