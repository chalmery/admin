package io.github.sys.user.enums;

import io.github.enums.CodeDescEnum;
import lombok.Getter;


@Getter
@SuppressWarnings("unused")
public enum UserStatusEnum implements CodeDescEnum {


    NORMAL(0, "正常"),

    FREEZE(1, "冻结"),
    LOGOFF(2, "注销"),

    ;


    private final Integer code;

    private final String desc;

    UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
