package io.github.api;

import io.github.param.UserAuthParam;
import io.github.result.UserOpenDTO;

public interface UserApi {


    /**
     * 根据认证类型和认证信息，拿到用户信息
     */
    UserOpenDTO getUserByAuth(UserAuthParam userAuthParam);


}
