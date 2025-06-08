package io.github.enums;


import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public enum CommonEnum implements CodeDescEnum {


    NO(0, "否"),

    YES(1, "是"),

    ;


    private final Integer code;

    private final String desc;

    CommonEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CommonEnum bgCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (CommonEnum value : CommonEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
