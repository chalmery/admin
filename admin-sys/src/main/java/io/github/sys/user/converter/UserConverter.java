package io.github.sys.user.converter;

import io.github.sys.user.dataobject.SysUser;
import io.github.sys.user.result.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);


    @Mappings({
            @Mapping(source = "uuid", target = "uuid")
    })
    UserDTO toDTO(SysUser sysUser);
}
