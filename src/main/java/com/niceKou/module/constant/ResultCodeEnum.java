package com.niceKou.module.constant;

public enum ResultCodeEnum {
    /**
     * 调用成功
     */
    SUCCESS("00000000", "ok"),
    /**
     * 参数校验失败
     */
    ERROR_PARAMETER("00000001", "参数校验失败"),
    /**
     * 存储过程调用失败
     */
    ERROR_SQL("00000002", "存储过程调用失败"),
    /**
     * 调用模块超时
     */
    ERROR_REQUEST_TIMEOUT("00000003", "调用模块超时！");

    private String code;

    private String name;

    ResultCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code) {
        for (ResultCodeEnum item : ResultCodeEnum.values()) {
            if (item.getCode().equals(code)) {
                return item.getName();
            }
        }
        return null;
    }

    public static ResultCodeEnum getByCode(String code) {
        for (ResultCodeEnum item : ResultCodeEnum.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
