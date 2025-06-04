package io.github.sys.user.service;

import io.github.sys.user.param.LoginParam;
import io.github.sys.user.result.TokenDTO;

public interface LoginService {


    TokenDTO getToken(LoginParam loginParam);

}
