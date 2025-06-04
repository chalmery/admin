package io.github.user.api;

import io.github.user.module.LoginParam;
import io.github.user.module.TokenDTO;

public interface SsoService {


    TokenDTO getToken(LoginParam loginParam);

}
