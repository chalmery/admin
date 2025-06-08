package io.github.auth.service;

import io.github.auth.param.LoginParam;
import io.github.auth.result.LoginDTO;

public interface LoginService {

    LoginDTO login(LoginParam loginParam);
}
