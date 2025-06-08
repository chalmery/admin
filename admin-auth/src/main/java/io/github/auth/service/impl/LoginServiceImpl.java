package io.github.auth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import io.github.api.UserApi;
import io.github.auth.param.LoginParam;
import io.github.auth.result.LoginDTO;
import io.github.auth.service.LoginService;
import io.github.enums.IdentityTypeEnum;
import io.github.param.UserAuthParam;
import io.github.result.UserOpenDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserApi userApi;


    public LoginDTO login(LoginParam loginParam) {
        if (ObjectUtils.isEmpty(loginParam)) {
            return null;
        }
        if (ObjectUtils.isEmpty(loginParam.getUsername()) || ObjectUtils.isEmpty(loginParam.getPassword())) {
            return null;
        }
        UserAuthParam userAuthParam = new UserAuthParam();
        userAuthParam.setIdentifier(loginParam.getUsername());
        userAuthParam.setCredential(loginParam.getPassword());
        userAuthParam.setIdentityType(IdentityTypeEnum.COMMON.getCode());

        UserOpenDTO userByAuth = userApi.getUserByAuth(userAuthParam);
        if (ObjectUtils.isEmpty(userByAuth)) {
            return null;
        }

        //第1步，先登录上
        StpUtil.login(userByAuth.getUuid());

        // 第2步，获取 Token  相关参数
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return LoginDTO.builder()
                .token(tokenInfo.getTokenValue()).build();
    }
}
