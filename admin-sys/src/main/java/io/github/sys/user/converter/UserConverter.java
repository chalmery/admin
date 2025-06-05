package io.github.sys.user.converter;

import io.github.sys.user.dataobject.SysUser;
import io.github.sys.user.result.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserConverter {

    UserDTO toDTO(SysUser sysUser);
}
