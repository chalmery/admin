package io.github.enums;


import lombok.Getter;

@Getter
public enum IdentityTypeEnum implements CodeDescEnum {

    PHONE(1, "手机"),
    WE_CHAT(2, "微信"),
    EMAIL(3, "邮箱"),
    COMMON(4, "账号密码"),

    ;


    private final Integer code;

    private final String desc;

    IdentityTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
