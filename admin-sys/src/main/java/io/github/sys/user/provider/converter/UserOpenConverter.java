package io.github.sys.user.provider.converter;

import io.github.result.UserOpenDTO;
import io.github.sys.user.dataobject.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserOpenConverter {

    UserOpenDTO toDTO(SysUser sysUser);
}
