package io.github.sys.user.provider;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.api.UserApi;
import io.github.enums.ArchiveEnum;
import io.github.enums.CommonEnum;
import io.github.param.UserAuthParam;
import io.github.result.UserOpenDTO;
import io.github.sys.user.dataobject.SysUser;
import io.github.sys.user.dataobject.SysUserAuth;
import io.github.sys.user.mapper.UserAuthMapper;
import io.github.sys.user.mapper.UserMapper;
import io.github.sys.user.provider.converter.UserOpenConverter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserApiImpl implements UserApi {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserOpenConverter userConverter;

    @Resource
    private UserAuthMapper userAuthMapper;

    /**
     * 根据认证类型和认证信息，拿到用户信息
     */
    @Override
    public UserOpenDTO getUserByAuth(UserAuthParam userAuthParam) {
        if (ObjectUtils.isEmpty(userAuthParam)) {
            return null;
        }
        if (StringUtils.isBlank(userAuthParam.getIdentifier()) || StringUtils.isBlank(userAuthParam.getCredential())
                || ObjectUtils.isEmpty(userAuthParam.getIdentityType())) {
            return null;
        }
        LambdaQueryWrapper<SysUserAuth> wrapper = new LambdaQueryWrapper<>(SysUserAuth.class);
        wrapper.eq(SysUserAuth::getVerified, CommonEnum.YES.getCode());
        wrapper.eq(SysUserAuth::getIdentifier, userAuthParam.getIdentifier());
        wrapper.eq(SysUserAuth::getCredential, userAuthParam.getCredential());
        wrapper.eq(SysUserAuth::getIdentityType, userAuthParam.getIdentityType());
        SysUserAuth sysUserAuth = userAuthMapper.selectOne(wrapper);
        if (ObjectUtils.isEmpty(sysUserAuth)) {
            return null;
        }
        LambdaQueryWrapper<SysUser> userWapper = new LambdaQueryWrapper<>(SysUser.class);
        userWapper.eq(SysUser::getArchive, ArchiveEnum.NO.getCode());
        userWapper.eq(SysUser::getUuid, sysUserAuth.getUuid());
        SysUser sysUser = userMapper.selectOne(userWapper);
        return userConverter.toDTO(sysUser);
    }
}
