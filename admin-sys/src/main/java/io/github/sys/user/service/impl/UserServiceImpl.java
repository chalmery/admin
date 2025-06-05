package io.github.sys.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.enums.ArchiveEnum;
import io.github.sys.user.converter.UserConverter;
import io.github.sys.user.dataobject.SysUser;
import io.github.sys.user.mapper.UserMapper;
import io.github.sys.user.result.UserDTO;
import io.github.sys.user.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

//    @Resource
//    private UserConverter userConverter;

    private static final UserConverter userConverter = UserConverter.INSTANCE;


    @Override
    public UserDTO getUserByUuid(String uuid) {

        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>(SysUser.class);
        wrapper.eq(SysUser::getArchive, ArchiveEnum.NO.getCode());
        wrapper.eq(SysUser::getUuid, uuid);
        SysUser sysUser = userMapper.selectOne(wrapper);
        return userConverter.toDTO(sysUser);
    }
}
