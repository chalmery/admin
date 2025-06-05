package io.github.sys.user.service;

import io.github.sys.user.result.UserDTO;

public interface UserService {


    UserDTO getUserByUuid(String uuid);


}
